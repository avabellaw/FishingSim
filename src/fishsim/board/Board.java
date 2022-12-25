package fishsim.board;

import java.awt.Dimension;

import engine.BoardTemplate;
import engine.core.graphics.Display;
import engine.core.io.Logger;
import engine.graphics.sprites.Sprite;
import fishsim.Main;
import fishsim.entities.startboard.Fisher;
import fishsim.graphics.GameDisplay;

public abstract class Board extends BoardTemplate {

	protected int[] boardPixels;

	protected Sprite blueprint;

	protected Fisher player;

	public Board(Dimension boardSize, Display display, Sprite blueprintSprite) {
		super(boardSize, display);

		this.blueprint = blueprintSprite;

		boardPixels = new int[boardSize.width * boardSize.height];

		addMapToBoard();
	}

	public void addMapToBoard() {
		Sprite blueprintSprite = this.blueprint;
		int[] pixels = blueprintSprite.getSprite();

		for (int y = 0; y < blueprintSprite.getHeight(); y++) {
			for (int x = 0; x < blueprintSprite.getWidth(); x++) {
				int pixel = pixels[x + y * blueprintSprite.getWidth()];

				boardPixels[x + y * blueprintSprite.getWidth()] = pixel;
			}
		}
	}

	@Override
	public void render() {
		for (int i = 0; i < boardPixels.length; i++) {
				display.pixels[i] = boardPixels[i];
		}
		
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render(display.pixels, display.width);
		}

		if(Main.gameState == Main.State.Menu) GameDisplay.menu.render(display.pixels);
	}
	
	public void mouseClicked() {
		
	}

}
