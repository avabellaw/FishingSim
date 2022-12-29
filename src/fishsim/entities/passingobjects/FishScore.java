package fishsim.entities.passingobjects;

import java.awt.Color;

import engine.entity.Entity;
import engine.graphics.sprites.Sprite;
import fishsim.Main;
import fishsim.board.GameBoard;
import fishsim.graphics.StaticSprites;

public class FishScore extends Entity {

	private final static int SPRITE_HEIGHT = 15;
	public final int POINTS;

	// Score entity created from the fish points when caught
	public FishScore(int points) {
		super(0, 0, getSpriteFromNumber(points));
		this.POINTS = points;
		this.isVoid = true;
		
		if(POINTS > 100) changeColour(Color.RED);
	}

	private static Sprite getSpriteFromNumber(int num) {
		int spriteWidth = 0;
		int[] pixels;
		String numAsStr = "" + num;

		Sprite[] sprites = new Sprite[numAsStr.length()];

		int spriteIndex = 0;

		for (char character : numAsStr.toCharArray()) {
			int numberSprite = Integer.parseInt(String.valueOf(character));
			sprites[spriteIndex] = StaticSprites.numbersSprite[numberSprite];
			spriteWidth += sprites[spriteIndex].getWidth();
			spriteIndex++;
		}
		spriteWidth++; // Increase pixels size to accomodate for gap

		pixels = new int[spriteWidth * SPRITE_HEIGHT + SPRITE_HEIGHT];

		int xOffSet = 0;
		for (Sprite sprite : sprites) {
			for (int y = 0; y < sprite.getHeight(); y++) {
				for (int x = 0; x < sprite.getWidth(); x++) {
					int pixel = sprite.getSprite()[x + y * sprite.getWidth()];

					pixels[x + xOffSet + y * (spriteWidth)] = pixel;
				}
			}

			xOffSet += sprite.getWidth() + 1; // Put in gap
		}

		return new Sprite(spriteWidth, SPRITE_HEIGHT, pixels);
	}

	public void update() {
		if (isVoid)
			return;

		y -= 2;

		if (y + height < 0)
			Main.board.entities.remove(this);
	}

	private void changeColour(Color colour) {
		for (int i = 0; i < pixels.length; i++) {
			if(pixels[i] == 0xff000000) pixels[i] = colour.getRGB() + (i * 1000); // Rainbow effect
		}
	}

	public void showScore(GameBoard board, int x, int y) {
		board.addPoints(POINTS);
		this.x = x;
		this.y = y;
		isVoid = false;
	}

}
