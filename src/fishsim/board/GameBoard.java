package fishsim.board;

import java.awt.Dimension;
import java.util.concurrent.atomic.AtomicInteger;

import engine.core.graphics.Display;
import engine.entity.Entity;
import fishsim.entities.FishingLine;
import fishsim.entities.GameHook;
import fishsim.entities.passingobjects.Fish;
import fishsim.graphics.StaticSprites;

public class GameBoard extends Board {

	public GameHook gHook;
	public static FishingLine line;
	private AtomicInteger aCounter = new AtomicInteger();

	public Boundaries boundaries;

	public GameBoard(Dimension boardSize, Display display) {
		super(boardSize, display, StaticSprites.gameBlueprintSprite);
		this.display = display;
		boundaries = new Boundaries(9, 9, 0, 0);
		
		
		gHook = new GameHook(this, (BOARD_SIZE.width / 2) - GameHook.WIDTH / 2, BOARD_SIZE.height - GameHook.HEIGHT);
		entities.add(gHook);
		line = new FishingLine(gHook);
		entities.add(line);

		addNewFish();
	}
	
	public void update() {
		super.update();
		
		if(aCounter.incrementAndGet() >= 180) {
			aCounter.set(0);
			addNewFish();
		}
	}
	
	public void addNewFish() {
		entities.add(new Fish(this));
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
		
		public boolean withinBoundaries(int x, int y) {
			return x > left && x < right && y > top && y < bottom;
		}
		
		public boolean withinBoundaries(Entity e) {
			int x = e.x;
			int y = e.y;
			return x > left && x < right && y > top && y < bottom;
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
