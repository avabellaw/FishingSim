package fishsim.entities;

import engine.entity.Entity;
import fishsim.Main;
import fishsim.graphics.StaticSprites;

public class FishingHook extends Entity {

	private double startX, startY;
	private double xSpeed, ySpeed;
	private double time, deltaTime = 0.03; // in seconds

	private boolean hasHitWater = false;

	public FishingHook(int x, int y) {
		super(x, y, 4, 8, StaticSprites.hookSprite);
	}
	
	public void splash() {
		for(int i = 0; i < pixels.length; i ++) {
			int pixel = StaticSprites.splashSprite.getSprite()[i];
				pixels[i] = pixel;
		}
		
		new Thread() {
			public void run() {
				try {
					Thread.sleep(200);
					Main.swapBoard(Main.gameBoard);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}.start();
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

//	private double getRange() {
//		return (Math.pow(U, 2) * Math.sin(2 * angle)) / 9.8;
//	}
//
//	private double getEndTimeOfFlight() {
//		return ((2 * U * Math.sin(angle))) / 9.8;
//	}

	@Override
	public void update() {
		if (y < 64 - hook.height / 2 - 2) {
			x = (int) (startX - (xSpeed * time));
			y = (int) (startY - ((ySpeed * time) - (0.5 * 9.8 * Math.pow(time, 2))));
		} else {
			if (!hasHitWater) {
				hook.splash();
				
				hasHitWater = true;
			}
		}

		time += deltaTime;
	}

}