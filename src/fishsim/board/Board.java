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

		tiles.add(new Tile(0, 0, 16, 16, null));

		entities.addAll(tiles);
	}

}
