package fishsim;

import java.awt.Dimension;

import engine.core.Ticker;
import engine.core.graphics.Display;
import engine.core.main.Component;
import fishsim.board.Board;
import fishsim.board.GameBoard;
import fishsim.graphics.GameDisplay;
import fishsim.graphics.StaticSprites;

public class Main extends Component {

	private final static int WIDTH = 150, HEIGHT = 150;
	public final static Dimension DIMENSIONS = new Dimension(WIDTH, HEIGHT); 
	
	
	static Display display = new GameDisplay(new Dimension(WIDTH, HEIGHT), 3, "Fishing Simulator !");
	static Board board = new Board(DIMENSIONS, display, StaticSprites.blueprintSprite); //when set to 4 it breaks? 3 works fine...
	public static GameBoard gameBoard = new GameBoard(DIMENSIONS, display); 
	Ticker ticker = new Ticker(this, display);
	
	public Main() {
		
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
	public static void swapBoard(Board newBoard) {
		board = newBoard;
		board.removeEntities();
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
