package fishsim.board;

import java.awt.Dimension;

import engine.core.graphics.Display;
import fishsim.entities.Fisher;
import fishsim.graphics.StaticSprites;

public class StartBoard extends Board {

	public StartBoard(Dimension boardSize, Display display) {
		super(boardSize, display, StaticSprites.blueprintSprite);
		
		int playerX = 100, playerY = 55;
		player = new Fisher(playerX, playerY, this); // Fisher player new Fisher(...)
	}

}
