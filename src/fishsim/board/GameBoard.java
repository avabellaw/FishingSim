package fishsim.board;

import java.awt.Dimension;

import engine.core.graphics.Display;
import fishsim.entities.FishingLine;
import fishsim.entities.GameHook;
import fishsim.entities.droppingobjects.Fish;
import fishsim.graphics.StaticSprites;

public class GameBoard extends Board {
	
	public static GameHook gHook;
	public static FishingLine line;

	public Boundaries boundaries;

	public GameBoard(Dimension boardSize, Display display) {
		super(boardSize, display, StaticSprites.gameBlueprintSprite);
		this.display = display;

		gHook = new GameHook(this, (BOARD_SIZE.width / 2) - GameHook.WIDTH / 2, BOARD_SIZE.height - GameHook.HEIGHT);
		entities.add(gHook);
		line = new FishingLine(gHook);
		entities.add(line);
		
		entities.add(new Fish(gHook));
		
		boundaries = new Boundaries(9, 9, 0, 0);
	}

	/**
	 * Put in the values for how many pixels away from the border you want the
	 * boundaries
	 */
	public class Boundaries {

		private int left, right, top, bottom;

		// Enter the values
		public Boundaries(int left, int right, int top, int bottom) {
			this.left = left;
			this.right = BOARD_SIZE.width - right;
			this.top = top;
			this.bottom = BOARD_SIZE.height - bottom;
		}
		
		public int left() {
			return left;
		}

		public int right() {
			return right;
		}

		public int top() {
			return top;
		}

		public int bottom() {
			return bottom;
		}

	}

}
