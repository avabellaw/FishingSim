package fishsim.board;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import engine.BoardTemplate;
import engine.core.graphics.Display;
import engine.graphics.sprites.Sprite;
import fishsim.entities.Fisher;
import fishsim.entities.Tile;

public abstract class Board extends BoardTemplate {

	public List<Tile> tiles = new ArrayList<Tile>(); // Just tiletypes
	protected int[] boardPixels;

	protected Sprite blueprint;

	protected Fisher player;

	public enum TileType {
		VoidTile, GroundTile, WaterTile,
	}

	public Board(Dimension boardSize, Display display, Sprite blueprintSprite) {
		super(boardSize, 1, display);

		this.blueprint = blueprintSprite;
		
		boardPixels = new int[boardSize.width * boardSize.height * TILE_SIZE];

		addMapToBoard();
	}

	public void addMapToBoard() {
		Sprite blueprintSprite = this.blueprint;
		int[] pixels = blueprintSprite.getSprite();
		tiles.clear();

		for (int y = 0; y < blueprintSprite.getHeight(); y += TILE_SIZE) {
			for (int x = 0; x < blueprintSprite.getWidth(); x += TILE_SIZE) {
				int pixel = pixels[x + y * blueprintSprite.getWidth()];

				switch (pixel) {
				case Tile.airTile.DEFAULT_COLOUR: // White colour - air
					tiles.add(new Tile.airTile(x, y, TILE_SIZE));
					break;
				case Tile.waterTile.DEFAULT_COLOUR: // Blue colour - water
					tiles.add(new Tile.waterTile(x, y, TILE_SIZE));
					break;
				case Tile.groundTile.DEFAULT_COLOUR: // Brown colour - earth
					tiles.add(new Tile.groundTile(x, y, TILE_SIZE));
					break;
				}

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
			entities.get(i).render(display);
		}
	}

}
