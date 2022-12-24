package fishsim;

import java.awt.Dimension;

import engine.core.Component;
import engine.core.Ticker;
import engine.core.io.Logger;
import fishsim.board.Board;
import fishsim.board.GameBoard;
import fishsim.board.StartBoard;
import fishsim.graphics.GameDisplay;
import io.MouseInput;

public class Main extends Component {

	private final static int WIDTH = 200, HEIGHT = 200, SCALE = 2; // Sprite has to be adjust if size is changed
	public final static Dimension DIMENSIONS = new Dimension(WIDTH, HEIGHT);
	public static boolean isPaused = false, outOfObjects = false;

	public static GameDisplay display = new GameDisplay(DIMENSIONS, SCALE, "Fishing Simulator !");
	public static Board board = new StartBoard(DIMENSIONS, display);
	public static Board gameBoard = new GameBoard(DIMENSIONS, display);

	public static boolean splashFinished = false;
	Ticker ticker = new Ticker(this, display, 100);

	public enum State {
		Splash, Game, Menu
	}

	public static State gameState = State.Splash;

	public Main(int args) {
		super(args);
	}

	public static void main(String[] args) {
		int logLevel = Logger.LIVE;

		if (args.length > 0) {
			logLevel = Integer.parseInt(args[0]);
		}

		new Main(logLevel);
	}

	public void update() {
		board.update();
	}

	public static void changeGameState(State state) {
		if (gameState == State.Splash && state == State.Game) {
			Runnable r1 = () -> {
				try {
					Thread.sleep(200);
					board = Main.gameBoard;
					GameDisplay.drawScore = true;
					Main.splashFinished = true;
					gameState = State.Game;
				} catch (InterruptedException e) {
					Logger.error("Thread.sleep interupted when changing to '" + state + "'");
				}
			};

			new Thread(r1).start();
		}
	}

	public void render() {
		board.render();
	}

}
