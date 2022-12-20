package fishsim.entities.passingobjects;

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
		
		public PinkFish(GameBoard board) {
			super(board, 18, 16, StaticSprites.pinkFishSprite, 12);
		}

	}

}
