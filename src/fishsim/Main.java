package fishsim;

import java.awt.Dimension;
import java.awt.Point;

import engine.core.Component;
import engine.core.Ticker;
import engine.core.io.Logger;
import fishsim.board.Board;
import fishsim.board.GameBoard;
import fishsim.board.StartBoard;
import fishsim.graphics.GameDisplay;

public class Main extends Component {

	private final static int WIDTH = 200, HEIGHT = 200, SCALE = 2; // Sprite has to be adjust if size is changed
	public static int lastScore = 0;
	public final static Dimension DIMENSIONS = new Dimension(WIDTH, HEIGHT);

	public static GameDisplay display = new GameDisplay(DIMENSIONS, SCALE, "Fishing Simulator !");
	public static Board board;

	Ticker ticker = new Ticker(this, display, 100);
	
	public enum State {
		Splash, Game, Menu
	}

	public static State gameState = State.Splash;

	public Main() {
		super(Logger.Level.Live); // Set the log level
	}

	public void update() {
		board.update();
	}

	public static void goToMenu() {
		if (gameState == State.Game) {
			display.menu.init(display.pixels);
			gameState = State.Menu;
		}
	}

	public static void goToGame() {
		if (gameState == State.Splash) {
			Runnable r1 = () -> {
				try {
					Thread.sleep(200);
					board = new GameBoard(DIMENSIONS, display);
					GameDisplay.drawScore = true;
					gameState = State.Game;
				} catch (InterruptedException e) {
					Logger.error("Thread.sleep interupted when changing to game state");
				}
			};

			new Thread(r1).start();
		} else if (gameState == State.Menu) {
			board = new GameBoard(DIMENSIONS, display);
			((GameBoard) board).init();
		}

		gameState = State.Game;
	}

	public void render() {
		board.render();
		// .render the buttons
	}

	public static void mouseClicked(Point mousePoint) {
		if (gameState == State.Menu) {
			display.menu.click(mousePoint);
		}
	}

	@Override
	public void init() {
		board = new StartBoard(DIMENSIONS, display);
	}

}
