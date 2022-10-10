package fishsim.entities;

import engine.entity.Entity;
import fishsim.board.GameBoard;
import fishsim.graphics.GameDisplay;
import fishsim.graphics.StaticSprites;

public class GameHook extends Entity {

	public final static int WIDTH = 8, HEIGHT = 16;
	private GameBoard board;

	public GameHook(GameBoard board, int x, int y) {
		super(x, y, WIDTH, HEIGHT, StaticSprites.gameHookSprite);

		this.board = board;
	}

	@Override
	public void update() {
		if (GameDisplay.isMouseOnScreen) {
			if (x > board.boundaries.left() && y > board.boundaries.top() && x < board.boundaries.right() && y < board.boundaries.bottom()) {
				x = GameDisplay.mouseX;
				y = GameDisplay.mouseY;
			}
		}
	}
}
