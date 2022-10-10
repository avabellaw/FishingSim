package fishsim.board;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import engine.core.graphics.Display;
import fishsim.entities.FishingLine;
import fishsim.entities.GameHook;
import fishsim.graphics.StaticSprites;

public class GameBoard extends Board implements MouseMotionListener{

	private GameHook gHook;

	public GameBoard(Dimension boardSize, Display display) {
		super(boardSize, display, StaticSprites.gameBlueprintSprite);
		gHook = new GameHook((BOARD_SIZE.width / 2) - GameHook.WIDTH / 2, BOARD_SIZE.height - GameHook.HEIGHT);
		entities.add(gHook);
		FishingLine line = new FishingLine(gHook);
		entities.add(line);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		gHook.x = e.getX();
		gHook.y = e.getY();
		
	}

}
