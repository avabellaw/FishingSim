package fishsim.entities.passingobjects;

import engine.core.io.Logger;
import engine.entity.Entity;
import engine.graphics.sprites.Sprite;
import fishsim.board.GameBoard;
import fishsim.entities.GameHook;
import io.MouseInput;

public abstract class PassingObject extends Entity {

	private double speed = 0.6, delta = 0.0;
	protected GameHook hook;
	protected GameBoard board;
	protected int pointsWorth = 0;

	public final int POINTS;

	public PassingObject(GameBoard board, Sprite sprite, int points) {
		super(board.BOARD_SIZE.width / 2, board.BOARD_SIZE.height, sprite);
		this.POINTS = points;
		this.board = board;
		this.hook = board.gHook;

		this.isVoid = true;
	}

	protected void addSpeed(double speed) {
		this.speed += speed;
	}

	@Override
	public void update() {
		delta += speed;

		if (delta >= 1.0) {
			y--;
			delta--;
		}

		if (this.isTouching(hook) && MouseInput.isMouseOnScreen)
			caughtByHook();

		if (this.y + height < 0) {
			removePassingObject();
		}
	}

	public void initialise() {
		x = getRandomStartX();
		isVoid = false;
	}

	protected abstract void caughtByHook();

	protected void removePassingObject() {
		board.entities.remove(this);
		Logger.debug("Removed object: " + getClassName());
	}

	private int getRandomStartX() {
		return (int) (Math.random() * (board.boundaries.right() - board.boundaries.left() - width))
				+ board.boundaries.left();
	}

}
