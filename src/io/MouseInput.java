package io;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import engine.core.Ticker;
import fishsim.Main;
import fishsim.graphics.GameDisplay;

public class MouseInput extends MouseAdapter {

	public static boolean isMouseOutsideBorders = false, isMouseOnScreen = false;

	public static int mouseX = 0, mouseY = 0;

	private GameDisplay display;

	public MouseInput(GameDisplay display) {
		this.display = display;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX() / display.getScale();
		mouseY = e.getY() / display.getScale();
		isMouseOnScreen = true;
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
		if (Main.outOfObjects) {
			if (display.playAgainButtonClicked()) {
				System.out.println("clicked");
			}
			if (display.exitButtonClicked()) {
				Ticker.close();
			}
		}
	}
}
