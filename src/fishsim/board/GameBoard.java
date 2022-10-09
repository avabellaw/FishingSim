package fishsim.board;

import java.awt.Dimension;

import engine.core.graphics.Display;
import fishsim.entities.FishingRod.FishingHook;
import fishsim.graphics.StaticSprites;

public class GameBoard extends Board {
	
	private FishingHook hook;

	public GameBoard(Dimension boardSize, Display display) {
		super(boardSize, display, StaticSprites.gameBlueprintSprite);
		
	}

}
