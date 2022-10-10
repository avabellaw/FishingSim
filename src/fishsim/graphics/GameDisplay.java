package fishsim.graphics;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import engine.core.graphics.Display;
import fishsim.board.GameBoard;

public class GameDisplay extends Display {

	private static final long serialVersionUID = -3314553873794350154L;
	
	public static int mouseX = 0, mouseY = 0;

	public GameDisplay(Dimension dimensions, int scale, String title) {
		super(dimensions, scale, title);
		
		addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}

}
