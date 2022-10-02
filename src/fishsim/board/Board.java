package fishsim.board;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import engine.BoardTemplate;
import engine.core.graphics.Display;
import fishsim.entities.Tile;

public class Board extends BoardTemplate {

	private List<Tile> tiles = new ArrayList<Tile>();

	public Board(Dimension boardSize, int tileSize, Display display) {
		super(boardSize, tileSize, display);
		
		for(int y = 0; y < BOARD_SIZE.height; y+= TILE_SIZE) {
			for(int x = 0; x < BOARD_SIZE.width; x+= TILE_SIZE) {
				tiles.add(new Tile.defaultTile(x, y, tileSize));
			}
		}

		entities.addAll(tiles);
	}

}
