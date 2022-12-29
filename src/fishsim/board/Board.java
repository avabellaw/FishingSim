package fishsim.board;

import java.awt.Dimension;

import engine.BoardTemplate;
import engine.core.graphics.Display;
import engine.graphics.sprites.Sprite;
import fishsim.Main;
import fishsim.entities.startboard.Fisher;

public abstract class Board extends BoardTemplate {

	protected int[] boardPixels;

	protected Sprite blueprint;

	protected Fisher player;
	
	private int yOffSet = 0, interval = 0;

	public Board(Dimension boardSize, Display display, Sprite blueprintSprite) {
		super(boardSize, display);

		this.blueprint = blueprintSprite;

		boardPixels = new int[boardSize.width * boardSize.height * 2];

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
		if (Main.gameState == Main.State.Menu)
			Main.display.menu.render(display.pixels);
		else {
			
			for(int y = 0; y < BOARD_SIZE.height; y++) {
				for(int x = 0; x < BOARD_SIZE.width; x++) {
					display.pixels[x + y * BOARD_SIZE.width] = boardPixels[x + ((y + yOffSet) % BOARD_SIZE.height) * BOARD_SIZE.width];
				}
			}

			for (int i = 0; i < entities.size(); i++) {
				entities.get(i).render(display.pixels, display.width);
			}
		}
	}
	
	@Override
	public void update() {
		super.update();
		if(Main.gameState != Main.State.Game) return;
		if(interval % 2 == 0)yOffSet++;
		interval++;
	}

	public void mouseClicked() {

	}

}
