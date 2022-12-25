package fishsim.board;

import java.awt.Dimension;

import engine.core.graphics.Display;
import engine.core.io.Logger;
import fishsim.entities.startboard.Fisher;
import fishsim.graphics.StaticSprites;

public class StartBoard extends Board {

	public StartBoard(Dimension boardSize, Display display) {
		super(boardSize, display, StaticSprites.blueprintSprite);
		Logger.debug("Start board created");

		int playerX = 140, playerY = 76;
		player = new Fisher(playerX, playerY, this); // Fisher player new Fisher(...)
	}

}
