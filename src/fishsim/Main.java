package fishsim;

import java.awt.Dimension;

import engine.core.Ticker;
import engine.core.graphics.Display;
import engine.core.main.Component;
import fishsim.board.Board;
import fishsim.board.GameBoard;
import fishsim.board.StartBoard;
import fishsim.graphics.GameDisplay;

public class Main extends Component {

	private final static int WIDTH = 150, HEIGHT = 150;
	public final static Dimension DIMENSIONS = new Dimension(WIDTH, HEIGHT);

	public static Display display = new GameDisplay(new Dimension(WIDTH, HEIGHT), 3, "Fishing Simulator !");
	public static Board board = new StartBoard(DIMENSIONS, display); 
	public static Board gameBoard = new GameBoard(DIMENSIONS, display);
	Ticker ticker = new Ticker(this, display);

	public Main() {

	}

	public static void main(String[] args) {
		new Main();
	}

	public static void swapBoard(Board newBoard) {
		board = newBoard;
	}

	@Override
	public void update() {
		board.update();
	}

	@Override
	public void render() {
		board.render();
	}

}
