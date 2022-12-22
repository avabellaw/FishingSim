package fishsim.board;

import java.awt.Dimension;

import engine.core.graphics.Display;
import fishsim.entities.Fisher;
import fishsim.graphics.StaticSprites;

public class StartBoard extends Board {
	private double startX, startY;
	private double xSpeed, ySpeed;
	private double time, deltaTime = 0.03; // in seconds
	
	public static boolean hasHitWater = false;

	public StartBoard(Dimension boardSize, Display display) {
		super(boardSize, display, StaticSprites.blueprintSprite);

		int playerX = 140, playerY = 76;
		player = new Fisher(playerX, playerY, this); // Fisher player new Fisher(...)
	}

	public void update() {
		if (y < 64 - height / 2 - 2) {
			x = (int) (startX - (xSpeed * time));
			y = (int) (startY - ((ySpeed * time) - (0.5 * 9.8 * Math.pow(time, 2))));
		} else {
			if (!hasHitWater) {
				splash();

				hasHitWater = true;
			}
		}

		time += deltaTime;
	}

	private void splash() {
		for (int i = 0; i < display.pixels.length; i++) {
			int pixel = StaticSprites.splashSprite.getSprite()[i];
			display.pixels[i] = pixel;
		}
	}

}
