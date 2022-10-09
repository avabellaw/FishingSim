package fishsim.entities;

import java.awt.Color;

import engine.core.graphics.Display;
import engine.entity.Entity;
import fishsim.board.Board;
import fishsim.graphics.StaticSprites;

public class FishingRod extends Entity {

	public FishingHook hook;
	public FishingLine line;
	public Fisher player;
	
	public static final int WIDTH = 4, HEIGHT = 8;

	public FishingRod(int x, int y, Board board, Fisher player) {
		super(x - 2, y - 2, WIDTH, HEIGHT, StaticSprites.fishingRodSprite);

		this.hook = new FishingHook(this.x, this.y - height, board, 10);
		this.player = player;
		this.line = new FishingLine(this, hook, board);

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
		line.update();
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
			super(x, y, 4, 8, StaticSprites.hookSprite);
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
		Board board;
		int x, y;

		public FishingLine(FishingRod rod, FishingHook hook, Board b) {
			super(hook.x, hook.y, 1, 1, Color.BLACK);
			this.rod = rod;
			this.hook = hook;
			this.board = b;
		}

		public void update() {
			/*
			 * x = rod.x; y = rod.y; width = (rod.x - hook.x);
			 * 
			 * x = hook.x + hook.width; y = hook.y; width = (rod.x - hook.x);
			 */
		}

		@Override
		public void render(Display d) {
			renderLine(d);
		}

		public void renderLine(Display d) {
			x = rod.x;
			y = rod.y;
			int x2 = hook.x + hook.width, y2 = hook.y;

			int w = x2 - x;
			int h = y2 - y;
			int dx1 = 0, dy1 = 0, dx2 = 0, dy2 = 0;
			if (w < 0)
				dx1 = -1;
			else if (w > 0)
				dx1 = 1;
			if (h < 0)
				dy1 = -1;
			else if (h > 0)
				dy1 = 1;
			if (w < 0)
				dx2 = -1;
			else if (w > 0)
				dx2 = 1;
			int longest = Math.abs(w);
			int shortest = Math.abs(h);
			if (!(longest > shortest)) {
				longest = Math.abs(h);
				shortest = Math.abs(w);
				if (h < 0)
					dy2 = -1;
				else if (h > 0)
					dy2 = 1;
				dx2 = 0;
			}
			int numerator = longest >> 1;
			for (int i = 0; i <= longest; i++) {
				d.pixels[(int) (x + y * d.width)] = 0xff000000;
				numerator += shortest;
				if (!(numerator < longest)) {
					numerator -= longest;
					x += dx1;
					y += dy1;
				} else {
					x += dx2;
					y += dy2;
				}
			}
		}

	}

}