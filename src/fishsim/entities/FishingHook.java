package fishsim.entities;

import engine.entity.Entity;
import fishsim.Main;
import fishsim.graphics.StaticSprites;

public class FishingHook extends Entity {

	private double startX, startY;
	private double xSpeed, ySpeed;
	private double time, deltaTime = 0.03; // in seconds

	private boolean hasHitWater = false;

	public FishingHook(int x, int y, int maxU) {
		super(x, y, 4, 8, StaticSprites.hookSprite);
	}

	public void splash() {
		for (int i = 0; i < pixels.length; i++) {
			int pixel = StaticSprites.splashSprite.getSprite()[i];
			pixels[i] = pixel;
		}

		new Thread() {
			public void run() {
				try {
					Thread.sleep(200);
					Main.swapBoard(Main.gameBoard);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}.start();
	}

	@Override
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

}