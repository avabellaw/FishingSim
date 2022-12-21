package fishsim.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import engine.core.Ticker;
import engine.core.graphics.Display;
import engine.core.graphics.MenuItem;
import fishsim.Main;
import fishsim.board.GameBoard;

public class GameDisplay extends Display {

	private static final long serialVersionUID = -3314553873794350154L;

	public static int mouseX = 0, mouseY = 0;

	public static boolean isMouseOnScreen = false;
	public static boolean isMouseOutsideBorders = false, drawScore = false;;

	private static Font font = new Font("Serif", Font.PLAIN, 25);
	private static Font menuFont = new Font("Serif", Font.BOLD, 35);

	private int buttonWidth = 170, buttonHeight = 45;
	private MenuItem playAgain = new MenuItem(this.getSize().width / 2 - (buttonWidth / 2),
			this.getSize().height / 3 + 45, buttonWidth, buttonHeight);
	private MenuItem exit = new MenuItem(this.getSize().width / 2 - (buttonWidth / 2), playAgain.y + buttonHeight + 25,
			buttonWidth, buttonHeight);

	JPanel panel = new JPanel();

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

		addMouseListener(new MouseAdapter() {
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
				if (Main.outOfObjects) {
					if (playAgain.MouseInBounds(getMousePosition())){
						System.out.println("clicked");
					} 
					if(exit.MouseInBounds(getMousePosition())){
						Ticker.close();
					}
				}
			}
		});
	}

	public void draw(Graphics g) {
		if (!drawScore)
			return;
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2.setFont(font);

		g2.drawString("Score: " + GameBoard.getScore(), 35, 25);

		if (Main.outOfObjects) {
			FontMetrics metrics = g.getFontMetrics(menuFont);
			String[] str = { "You scored:\n", GameBoard.getScore() + "/" + GameBoard.getTotalPointsPossible() };

			g2.setColor(new Color(0, 0, 0, 200));
			g2.fillRect(0, 0, this.getSize().width, this.getSize().height);
			g2.setColor(Color.WHITE);
			g2.setFont(menuFont);

			int stringX = this.getSize().width / 2, stringY = this.getSize().height / 3 - 20;
			g2.drawString(str[0], stringX - metrics.stringWidth(str[0]) / 2, stringY);
			g2.drawString(str[1], stringX - metrics.stringWidth(str[1]) / 2, stringY + 40);
			
			playAgain.draw(g2);
			exit.draw(g2);
		}

		// if(!isMouseOnScreen) {
		// FontMetrics metrics = g.getFontMetrics(fontPaused);
		//
		// String message = "PAUSED";
		//
		// g2.setColor(new Color(0, 0, 0, 150));
		// g2.fillRect(0, 0, this.getSize().width, this.getSize().height);
		// g2.setColor(Color.WHITE);
		// g2.setFont(fontPaused);
		// g2.drawString(message, this.getSize().width / 2 -
		// metrics.stringWidth(message) / 2, (this.getSize().height) / 2);
		// }
	}

}
