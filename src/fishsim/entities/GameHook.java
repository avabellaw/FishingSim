package fishsim.entities;

import java.awt.Point;

import engine.entity.Entity;
import fishsim.Main;
import fishsim.board.GameBoard;
import fishsim.board.GameBoard.Boundaries;
import fishsim.graphics.StaticSprites;
import io.MouseInput;

public class GameHook extends Entity {

	public final static int WIDTH = 8, HEIGHT = 16;
	private GameBoard board;
	private int speed = 3;
	private double yDir = 0, xDir = 0;

	public GameHook(GameBoard board, int x, int y) {
		super(x, y, WIDTH, HEIGHT, StaticSprites.gameHookSprite);

		this.board = board;
	}

	@Override
	public void update() {
		Boundaries b = board.boundaries;
		xDir = 0;
		yDir = 0;

		if (MouseInput.isMouseOnScreen) {

			for (int i = 0; i < speed; i++) {
				setDirections();

				if (!(x + width + xDir > b.right()) && !(x + xDir < b.left()))
					x += xDir;
				if (!(y + height + yDir > b.bottom()) && !(y + yDir < b.top()))
					y += yDir;
			}
		} else {
			if (x + WIDTH / 2 >= board.BOARD_SIZE.width / 2)
				x--;
			if (x + WIDTH / 2 < board.BOARD_SIZE.width / 2)
				x++;

			if (y + HEIGHT / 2 >= board.BOARD_SIZE.height / 2)
				y--;
			if (y + HEIGHT / 2 <= board.BOARD_SIZE.height / 2)
				y++;
		}
	}

	private void setDirections() {
		int mX = MouseInput.mouseX;
		int mY = MouseInput.mouseY;

		final Point HOOK_MIDDLE = new Point(x + 4, y + 3); // Coordinates

		if (HOOK_MIDDLE.x < mX)
			xDir = 1;

		if (HOOK_MIDDLE.x > mX)
			xDir = -1;

		if (HOOK_MIDDLE.y < mY)
			yDir = 1;

		if (HOOK_MIDDLE.y > mY)
			yDir = -1;
	}
}
