package fishsim.entities.passingobjects;

import engine.graphics.sprites.Sprite;
import fishsim.board.GameBoard;
import fishsim.graphics.StaticSprites;

public class Fish extends PassingObject {

	public Fish(GameBoard board, Sprite sprite, FishScore score) {
		super(board, sprite, score);
	}

	public static class PinkFish extends Fish {

		public final static int WIDTH = 20, HEIGHT = 18;

		public PinkFish(GameBoard board) {
			super(board, StaticSprites.pinkFishSprite, new FishScore(10));
			addSpeed(0.5);
		}
	}

	public static class YellowFish extends Fish {
		public final static int WIDTH = 19, HEIGHT = 18;

		public YellowFish(GameBoard board) {
			super(board, StaticSprites.yellowFishSprite, new FishScore(4));
			addSpeed(0.1);
		}

	}

	public static class ZebraFish extends Fish {
		public final static int WIDTH = 30, HEIGHT = 24;

		public ZebraFish(GameBoard board) {
			super(board, StaticSprites.zebraFishSprite, new FishScore(1));
			addSpeed(0.4);
		}
	}

	public static class ClownFish extends Fish {
		public final static int WIDTH = 29, HEIGHT = 14;

		public ClownFish(GameBoard board) {
			super(board, StaticSprites.clownFishSprite, new FishScore(5));
			addSpeed(0.3);
		}
	}
}
