package fishsim.entities;

import java.awt.Color;

import engine.entity.Entity;
import fishsim.board.Board;

public class FishingRod extends Entity {

	public FishingHook hook;
	public FishingLine line;
	public Fisher player;

	public FishingRod(int x, int y, Board board, Fisher player) {
		super(x - 2, y - 2, 2, 10);

		this.hook = new FishingHook(this.x, this.y - height, board, 10);
		this.player = player;
		this.line = new FishingLine(this, hook);

		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0xff000000;
		}

		hook.throwHook(50);
	}

	public void initRod(Board board) {
		board.entities.add(hook);
		board.entities.add(line);
	}

	@Override
	public void update() {
	}

	public class FishingHook extends Entity {

		private double startX, startY;
		private double xSpeed, ySpeed;
		private double time, deltaTime = 0.01; // in seconds
		private FishingRod rod;
		private Board board;

		private double minU, maxU, angle, U;
		int minS = 87, maxS = 9;

		public FishingHook(int x, int y, Board board, double angle) {
			super(x, y, 2, 2);
			this.angle = angle;
			this.board = board;

			minS = (int) x - minS;
			maxS = (int) x - maxS;

			minU = Math.sqrt((minS * 9.8) / Math.sin(2 * angle));
			maxU = Math.sqrt((maxS * 9.8) / Math.sin(2 * angle));
		}

		private void throwHook(double speed) {
			if (speed > maxU)
				speed = maxU;
			if (speed < minU)
				speed = minU;

			U = speed;

			startX = x;
			startY = y;
			hook.xSpeed = speed * Math.cos(angle * (Math.PI / 180));
			hook.ySpeed = speed * Math.sin(angle * (Math.PI / 180));
		}

		private double getRange() {
			return (Math.pow(U, 2) * Math.sin(2 * angle)) / 9.8;
		}

		private double getEndTimeOfFlight() {
			return ((2 * U * Math.sin(angle))) / 9.8;
		}

		@Override
		public void update() {
			if (y < 64) {
				x = (int) (startX - (xSpeed * time));
				y = (int) (startY - ((ySpeed * time) - (0.5 * 9.8 * Math.pow(time, 2))));
			}

			time += deltaTime;
		}

	}

	public class FishingLine extends Entity {
		
		FishingRod rod;
		FishingHook hook;

		public FishingLine(FishingRod rod, FishingHook hook) {
			super(rod.x, rod.y, (rod.x - hook.x) + 1, 1, Color.BLACK);
			
			this.rod = rod;
			this.hook = hook;
		}

		@Override
		public void update() {
			x = rod.x;
			y = rod.y;
			width = (rod.x - hook.x);
		}

	}

}
