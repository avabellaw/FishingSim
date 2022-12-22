package fishsim.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import engine.core.graphics.Display;
import engine.core.graphics.MenuItem;
import fishsim.Main;
import fishsim.board.GameBoard;

public class GameDisplay extends Display {

	private static final long serialVersionUID = -3314553873794350154L;

	public static boolean drawScore = false;

	private static Font font = new Font("Serif", Font.PLAIN, 25);
	private static Font menuFont = new Font("Serif", Font.BOLD, 35);
	
	private static BufferedImage menuBackground;

	public static final int BUTTON_WIDTH = 170, BUTTON_HEIGHT = 45;

	private MenuItem playAgain = new MenuItem.Button(this.getSize().width / 2 - (BUTTON_WIDTH / 2),
			this.getSize().height / 3 + 45, BUTTON_WIDTH, BUTTON_HEIGHT, StaticSprites.buttonSprite);
	private MenuItem exit = new MenuItem.Button(this.getSize().width / 2 - (BUTTON_WIDTH / 2),
			playAgain.y + BUTTON_HEIGHT + 25, BUTTON_WIDTH, BUTTON_HEIGHT, StaticSprites.buttonSprite);

	JPanel panel = new JPanel();

	public GameDisplay(Dimension dimensions, int scale, String title) {
		super(dimensions, scale, title);
	
		menuBackground = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
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

			g2.drawImage(menuBackground, 0, 0, width * getScale(), height * getScale(), null);
			g2.setColor(Color.WHITE);
			g2.setFont(menuFont);

			int stringX = this.getSize().width / 2, stringY = this.getSize().height / 3 - 20;
			g2.drawString(str[0], stringX - metrics.stringWidth(str[0]) / 2, stringY);
			g2.drawString(str[1], stringX - metrics.stringWidth(str[1]) / 2, stringY + 40);
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

	public boolean playAgainButtonClicked() {
		return playAgain.isMouseInBounds(getMousePosition());
	}

	public boolean exitButtonClicked() {
		return exit.isMouseInBounds(getMousePosition());
	}

}
