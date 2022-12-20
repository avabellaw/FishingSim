package fishsim.entities.droppingobjects;

import java.awt.Color;

import engine.entity.Entity;
import fishsim.Main;
import fishsim.entities.GameHook;

public abstract class DroppingObject extends Entity {

	double speed = 0.2, delta = 0.0;
	private GameHook hook;

	public DroppingObject(GameHook hook, int y, int width, int height, Color colour) {
		super((int) (Math.random() * Main.DIMENSIONS.width), y + 50, width, height, colour);

		this.hook = hook;
	}

	@Override
	public void update() {
		//delta += speed;

		if (delta >= 1.0) {
			y++;
			delta = 0.0;
		}
	}
	
	protected void collided() {
		
	}

	protected abstract void caughtByHook();

}