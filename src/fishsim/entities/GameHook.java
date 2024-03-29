package fishsim.entities;

import java.awt.Point;

import engine.entity.Entity;
import fishsim.board.GameBoard;
import fishsim.board.GameBoard.Boundaries;
import fishsim.graphics.GameDisplay;
import fishsim.graphics.StaticSprites;

public class GameHook extends Entity {

	public final static int WIDTH = 8, HEIGHT = 16;
	private GameBoard board;
	private int speed = 1;
	private double yDir = 0, xDir = 0;

	public GameHook(GameBoard board, int x, int y) {
		super(x, y, WIDTH, HEIGHT, StaticSprites.gameHookSprite);

		this.board = board;
	}

	@Override
	public void update() {
		Boundaries b = board.boundaries;
		int mX = GameDisplay.mouseX;
		int mY = GameDisplay.mouseY;
		xDir = 0;
		yDir = 0;

		if (GameDisplay.isMouseOnScreen) {
			
			final Point HOOK_MIDDLE = new Point(x + 4, y + 3); // Coordinates
			
			if (HOOK_MIDDLE.x < mX)
				xDir = 1;

			if (HOOK_MIDDLE.x > mX)
				xDir = -1;

			if (HOOK_MIDDLE.y < mY)
				yDir = 1;

			if (HOOK_MIDDLE.y > mY)
				yDir = -1;
		} else {
			if (x + WIDTH / 2 >= board.BOARD_SIZE.width / 2)
				xDir--;
			if (x - WIDTH / 2 <= board.BOARD_SIZE.width / 2)
				xDir++;
			
			if (y + HEIGHT / 2 >= board.BOARD_SIZE.height / 2)
				yDir--;
			if (y - HEIGHT / 2 <= board.BOARD_SIZE.height / 2)
				yDir++;
		}

		// if(x < GameDisplay.mouseX) x ++;
		// if(x > GameDisplay.mouseX) x--;
		// if(y < GameDisplay.mouseY) y++;
		// if(y > GameDisplay.mouseY) y--;

		// if(board.boundaries.exitedBorders(x, y, WIDTH, HEIGHT))
		// System.out.println("Exited");
		// else if(!board.boundaries.exitedBorders(x, y, WIDTH, HEIGHT))
		// System.out.println("entered");

		double addToX = (xDir * speed);
		double addToY = (yDir * speed);

		if (!(x + width + addToX > b.right()) && !(x + addToX < b.left()))
			x += addToX;
		if (!(y + height + addToY > b.bottom()) && !(y + addToY < b.top()))
			y += addToY;
	}
}
