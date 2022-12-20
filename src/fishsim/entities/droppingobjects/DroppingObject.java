package fishsim.entities.droppingobjects;

import java.awt.Color;

import engine.entity.Entity;
import fishsim.Main;
import fishsim.board.GameBoard;
import fishsim.entities.GameHook;

public abstract class DroppingObject extends Entity {

	double speed = 0.2, delta = 0.0;
	protected GameHook hook;
	protected GameBoard board;

	public DroppingObject(GameBoard board, int y, int width, int height, Color colour) {
		super((int) (Math.random() * Main.DIMENSIONS.width), y + 50, width, height, colour);
		this.board = board;
		this.hook = board.gHook;

	}

	@Override
	public void update() {
		// delta += speed;

		if (delta >= 1.0) {
			y++;
			delta = 0.0;
		}

		if (this.isTouching(hook))
			caughtByHook();
	}

	protected abstract void caughtByHook();
	
	protected void removeDroppingObject() {
		board.entities.remove(this);
	}

}
