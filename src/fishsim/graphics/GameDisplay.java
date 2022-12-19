package fishsim.graphics;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import engine.core.graphics.Display;

public class GameDisplay extends Display {

	private static final long serialVersionUID = -3314553873794350154L;

	public static int mouseX = 0, mouseY = 0;
	
	public static boolean isMouseOnScreen = false;
	public static boolean isMouseOutsideBorders = false;

	public GameDisplay(Dimension dimensions, int scale, String title) {
		super(dimensions, scale, title);

		addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
				mouseX = e.getX() / scale;
				mouseY = e.getY() / scale;
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				isMouseOnScreen = false;
				mouseX = e.getX();
				mouseY = e.getY();
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				isMouseOnScreen = true;
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}

}
