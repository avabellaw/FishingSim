package fishsim.entities.passingobjects;

import engine.graphics.sprites.Sprite;
import fishsim.board.GameBoard;
import fishsim.graphics.StaticSprites;

public class FishScore extends PassingObject {

	private int[] pixels;
	private int spriteWidth = 0, spriteHeight = 15;

	// Score entity created from the fish points when caught
	public FishScore(GameBoard board, Sprite sprite, int points, int direction) {
		super(board, sprite, points, 1);
	}

	public void getSpriteFromNumber(int num) {
		String numAsStr = "" + num;

		Sprite[] sprites = new Sprite[numAsStr.length()];

		int spriteIndex = 0;

		spriteWidth += sprites[spriteIndex].getWidth();
		for (char character : numAsStr.toCharArray()) {
			sprites[spriteIndex++] = StaticSprites.numbersSprite[Integer.parseInt(String.valueOf(character))];
		}

		pixels = new int[spriteWidth * spriteHeight];
		
		for(Sprite sprite : sprites) {
			pixels += sprite.getSprite();
		}
	}

	@Override
	protected void caughtByHook() {
		// Not caught by hook it's void
	}

}
