package fishsim.board;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import engine.BoardTemplate;
import engine.core.graphics.Display;
import fishsim.entities.Tile;
import utilities.TempMap;;

public class Board extends BoardTemplate {

	private List<Tile> tiles = new ArrayList<Tile>();
	private TempMap map;

	public Board(Dimension boardSize, int tileSize, Display display) {
		super(boardSize, tileSize, display);
		map = new TempMap(this);
		
		for(int y = 0; y < BOARD_SIZE.height; y+= TILE_SIZE) {
			for(int x = 0; x < BOARD_SIZE.width; x+= TILE_SIZE) {
				utilities.TempMap.Tile tileType = map.map[x/TILE_SIZE][y/TILE_SIZE];
				
				switch (tileType) {
				case VoidTile :
					tiles.add(new Tile.voidTile(x, y, tileSize));
					break;
				case GroundTile :
					tiles.add(new Tile.groundTile(x, y, tileSize));
					break;
				}
			}
		}

		entities.addAll(tiles);
	}

}
