package fishsim;

import java.awt.Dimension;

import engine.core.Ticker;
import engine.core.graphics.Display;
import engine.core.main.Component;
import fishsim.board.Board;
import fishsim.graphics.GameDisplay;

public class Main extends Component {

	private final int WIDTH = 150, HEIGHT = 150;
	public final Dimension DIMENSIONS = new Dimension(WIDTH, HEIGHT); 
	
	
	Display display = new GameDisplay(new Dimension(WIDTH, HEIGHT), 3, "Fishing Simulator !");
	Board board = new Board(DIMENSIONS, display); //when set to 4 it breaks? 3 works fine...
	Ticker ticker = new Ticker(this, display);
	
	public Main() {
		
	}
	
	public static void main(String[] args) {
		new Main();
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
