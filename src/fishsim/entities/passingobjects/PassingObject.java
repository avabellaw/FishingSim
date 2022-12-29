package fishsim.entities.passingobjects;

import engine.core.io.Logger;
import engine.entity.Entity;
import engine.graphics.sprites.Sprite;
import fishsim.board.GameBoard;
import fishsim.entities.GameHook;
import io.MouseInput;

public abstract class PassingObject extends Entity {

	private double speed = 0.7, delta = 0.0;
	protected GameHook hook;
	protected GameBoard board;
	protected int pointsWorth = 0;
	private boolean caught = false;

	private FishScore score;

	private int direction = -1;

	public static int totalPassingObjects = 0, totalPossibleScore = 0;

	static int instanceNumber = 0;

	public PassingObject(GameBoard board, Sprite sprite, FishScore score) {
		super(board.BOARD_SIZE.width / 2, board.BOARD_SIZE.height, sprite);
		this.board = board;
		this.hook = board.gHook;
		this.score = score;

		board.entities.add(score);
		totalPassingObjects++; // Need to move this into fish and rename
		board.addToTotalPossibleScore(score.POINTS);
	}

	public PassingObject(GameBoard board, Sprite sprite, FishScore score, int direction) {
		this(board, sprite, score);

		this.direction = direction;
	}

	protected void addSpeed(double speed) {
		this.speed += speed;
	}

	@Override
	public void update() {
		delta += speed;

		if (delta >= 1.0) {
			y += direction;
			delta--;
		}

		if (this.isTouching(hook) && MouseInput.isMouseOnScreen && !caught) {
			caught = true;
			caughtByHook();
		}

		if (direction < 0 ? this.y + height < 0 : this.y > board.BOARD_SIZE.height) {
			removePassingObject();
		}

		score.update();
	}

	public void setRandomStartX() {
		x = getRandomStartX();
	}

	protected void caughtByHook() {
		score.showScore(this);
	}

	protected void removePassingObject() {
		board.entities.remove(this);
		Logger.debug("Removed object: " + getClassName());
	}

	private int getRandomStartX() {
		return (int) (Math.random() * (board.boundaries.right() - board.boundaries.left() - width))
				+ board.boundaries.left();
	}

}
