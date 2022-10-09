package fishsim.board;

import java.awt.Dimension;

import engine.core.graphics.Display;
import fishsim.graphics.StaticSprites;

public class GameBoard extends Board {

	public GameBoard(Dimension boardSize, Display display) {
		super(boardSize, display, StaticSprites.gameBlueprintSprite);
	}

}
