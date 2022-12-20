package fishsim.board;

import java.awt.Dimension;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;

import engine.core.graphics.Display;
import engine.entity.Entity;
import fishsim.entities.FishingLine;
import fishsim.entities.GameHook;
import fishsim.entities.passingobjects.Fish;
import fishsim.entities.passingobjects.PassingObject;
import fishsim.graphics.StaticSprites;

public class GameBoard extends Board {

	public GameHook gHook;
	public static FishingLine line;
	private AtomicInteger aCounter = new AtomicInteger();
	private static int score = 0;
	private static int addFishCoolOff = 10;
	private LinkedList<PassingObject> objects = new LinkedList<PassingObject>();

	public Boundaries boundaries;

	public GameBoard(Dimension boardSize, Display display) {
		super(boardSize, display, StaticSprites.gameBlueprintSprite);
		this.display = display;
		boundaries = new Boundaries(9, 9, 0, 0);

		gHook = new GameHook(this, (BOARD_SIZE.width / 2) - GameHook.WIDTH / 2, BOARD_SIZE.height - GameHook.HEIGHT);
		entities.add(gHook);
		line = new FishingLine(gHook);
		entities.add(line);

		for(int i = 0; i < 100; i++) {
			objects.push(new Fish(this));
		}
	}

	public void update() {
		super.update();

		if (aCounter.incrementAndGet() >= addFishCoolOff + objects.size()) {
			aCounter.set(0);
			addNewFish();
		}
	}

	public void addNewFish() {
		try {
			entities.add(objects.pop());
		} catch (NoSuchElementException e) {
			System.out.println("no more objects");
		}
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

	public static void addPoints(int points) {
		score += points;
	}

	public static int getScore() {
		return score;
	}

}
