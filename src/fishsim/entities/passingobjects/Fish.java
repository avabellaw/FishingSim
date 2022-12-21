package fishsim.entities.passingobjects;

import engine.graphics.sprites.Sprite;
import fishsim.board.GameBoard;
import fishsim.graphics.StaticSprites;

public class Fish extends PassingObject {

	public Fish(GameBoard board, Sprite sprite, int points) {
		super(board, sprite, points);
	}

	@Override
	protected void caughtByHook() {
		GameBoard.addPoints(POINTS);
		removePassingObject();
	}

	public static class PinkFish extends Fish {

		public final static int WIDTH = 20, HEIGHT = 18;

		public PinkFish(GameBoard board) {
			super(board, StaticSprites.pinkFishSprite, 7);
			setSpeed(0.7);
		}
	}

	public static class YellowFish extends Fish {
		public final static int WIDTH = 19, HEIGHT = 18;

		public YellowFish(GameBoard board) {
			super(board, StaticSprites.yellowFishSprite, 6);
		}

	}

	public static class ZebraFish extends Fish {
		public final static int WIDTH = 30, HEIGHT = 24;

		public ZebraFish(GameBoard board) {
			super(board, StaticSprites.zebraFishSprite, 10);
			setSpeed(1.2);
		}
	}
	
	public static class ClownFish extends Fish {
		public final static int WIDTH = 29, HEIGHT = 14;

		public ClownFish(GameBoard board) {
			super(board, StaticSprites.clownFishSprite, 10);
			setSpeed(1.2);
		}
	}
}
