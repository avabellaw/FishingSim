package fishsim.entities.passingobjects;

import java.awt.Dimension;

import engine.graphics.sprites.Sprite;
import fishsim.board.GameBoard;
import fishsim.graphics.StaticSprites;

public class Fish extends PassingObject {

	public Fish(GameBoard board, int width, int height, Sprite sprite, int points) {
		super(board, width, height, sprite, points);
	}

	@Override
	protected void caughtByHook() {
		GameBoard.addPoints(POINTS);
		removePassingObject();
	}

	public static class PinkFish extends Fish {

		public final static int WIDTH = 20, HEIGHT = 18;
		public final static Dimension size = new Dimension(WIDTH, HEIGHT);

		public PinkFish(GameBoard board) {
			super(board, size.width, size.height, StaticSprites.pinkFishSprite, 7);
			setSpeed(0.7);
		}
	}

	public static class YellowFish extends Fish {
		public final static int WIDTH = 19, HEIGHT = 18;
		public final static Dimension size = new Dimension(WIDTH, HEIGHT);

		public YellowFish(GameBoard board) {
			super(board, size.width, size.height, StaticSprites.yellowFishSprite, 6);
		}

	}

}
