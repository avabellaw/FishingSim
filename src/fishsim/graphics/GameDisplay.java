package fishsim.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import engine.core.graphics.Display;
import engine.core.graphics.Menu;
import fishsim.Main;
import fishsim.board.GameBoard;
import fishsim.entities.menu.EndMenu;
import io.MouseInput;

public class GameDisplay extends Display {

	private static final long serialVersionUID = -3314553873794350154L;

	public static boolean drawScore = false;

	private static Font font = new Font("Serif", Font.PLAIN, 25);
	private static Font menuFont = new Font("Serif", Font.BOLD, 35);

	public static Menu menu;

	JPanel panel = new JPanel();

	private MouseInput mouseInput;

	public GameDisplay(Dimension dimensions, int scale, String title) {
		super(dimensions, scale, title);
		menu = new EndMenu(this);

		mouseInput = new MouseInput(this);
		addMouseListener(mouseInput);
		addMouseMotionListener(mouseInput);
	}

	public void draw(Graphics g) {
		if (Main.gameState == Main.State.Splash)
			return;
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2.setFont(font);

		if (Main.gameState == Main.State.Game && drawScore)
			g2.drawString("Score: " + ((GameBoard) Main.board).getScore(), 35, 25);

		if (Main.gameState == Main.State.Menu) {
			FontMetrics metrics = g.getFontMetrics(menuFont);
			String[] str = { "You scored:\n",
					((GameBoard) Main.board).getScore() + "/" + ((GameBoard) Main.board).getTotalPointsPossible() };

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
}
