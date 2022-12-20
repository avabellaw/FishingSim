package fishsim.entities.passingobjects;

import java.awt.Color;

import engine.core.Component;
import engine.entity.Entity;
import fishsim.board.GameBoard;
import fishsim.entities.GameHook;

public abstract class PassingObject extends Entity {

	double speed = 0.5, delta = 0.0;
	protected GameHook hook;
	protected GameBoard board;

	public PassingObject(GameBoard board, int x, int width, int height, Color colour) {
		super(x, board.BOARD_SIZE.height, width, height, colour);
		this.board = board;
		this.hook = board.gHook;

	}

	@Override
	public void update() {
		delta += speed;

		if (delta >= 1.0) {
			y--;
			delta = 0.0;
		}

		if (this.isTouching(hook))
			caughtByHook();

		if (this.y + height< 0) {
			removePassingObject();
		}
	}

	protected abstract void caughtByHook();

	protected void removePassingObject() {
		board.entities.remove(this);
		if (Component.LOGGIN_ON)
			System.out.println("Removed object: " + getClassName());
	}

}
