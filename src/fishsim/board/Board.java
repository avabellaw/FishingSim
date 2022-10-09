package fishsim.board;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.BAD_INV_ORDER;

import engine.BoardTemplate;
import engine.core.graphics.Display;
import engine.entity.Entity;
import engine.graphics.sprites.Sprite;
import engine.graphics.sprites.Spritesheet;
import fishsim.entities.Fisher;
import fishsim.entities.Tile;

public class Board extends BoardTemplate {

	public List<Tile> tiles = new ArrayList<Tile>(); // Just tiletypes
	private int[] boardPixels;
	private Spritesheet blueprintSpritesheet = new Spritesheet("res/sprites/BoardBlueprint.png", 150, 150);
	private Sprite blueprintSprite = new Sprite(0, 0, 150, 150, blueprintSpritesheet);

	private Fisher player;

	public enum TileType {
		VoidTile, GroundTile, WaterTile,
	}

	public Board(Dimension boardSize, Display display) {
		super(boardSize, 1, display);

		boardPixels = new int[boardSize.width * boardSize.height * TILE_SIZE];
		
		int playerX = 100, playerY = 55;
		player = new Fisher(playerX, playerY, this);

		addMapToBoard();
	}

	public void addMapToBoard() {
		int[] pixels = blueprintSprite.getSprite();

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
	
	public void addToBoardPixels(int x, int y, int colour) {
		boardPixels[x +  y * BOARD_SIZE.width] = colour;
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
