package fishsim.entities.passingobjects;

import engine.core.Component;
import engine.entity.Entity;
import engine.graphics.sprites.Sprite;
import fishsim.board.GameBoard;
import fishsim.entities.GameHook;

public abstract class PassingObject extends Entity {

	double speed = 0.6, delta = 0.0;
	protected GameHook hook;
	protected GameBoard board;
	protected int pointsWorth = 0;
	
	public final int POINTS;

	public PassingObject(GameBoard board, int width, int height, Sprite sprite, int points) {
		super(board.BOARD_SIZE.width / 2, board.BOARD_SIZE.height, width, height, sprite);
		this.POINTS = points;
		this.board = board;
		this.hook = board.gHook;

		this.isVoid = true;
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
		if (Component.LOGGIN_ON)
			System.out.println("Removed object: " + getClassName());
	}

	private int getRandomStartX() {
		return (int) (Math.random() * (board.boundaries.right() - board.boundaries.left() - width))
				+ board.boundaries.left();
	}

}
