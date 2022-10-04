package utilities;

import fishsim.board.Board;

public class TempMap {

	public enum Tile {
		VoidTile, GroundTile, WaterTile, AirTile, DefaultTile, Fisher
	}

	public Tile[][] map;
	public FileRW fw;

	private int tileWidth, tileHeight;

	public TempMap(Board board) {
		fw = new FileRW("map.txt");

		tileWidth = board.BOARD_SIZE.width / board.TILE_SIZE;
		tileHeight = board.BOARD_SIZE.height / board.TILE_SIZE;

		map = new Tile[tileWidth][tileHeight];

		// setDefaultMap();
		if (fw.isNewFile())
			writeBaseMap();

		String[] mapFile = fw.read();

		for (int y = 0; y < mapFile.length; y++) {
			for (int x = 0; x < mapFile[y].length(); x++) {
				switch (mapFile[y].charAt(x)) {
				case '0':
					this.map[x][y] = Tile.VoidTile;
					break;
				case '1':
					this.map[x][y] = Tile.GroundTile;
					break;
				case '2':
					this.map[x][y] = Tile.WaterTile;
					break;
				case '3':
					this.map[x][y] = Tile.AirTile;
					break;

				}
			}
		}
	}

	private void setDefaultMap() {
		for (int y = 0; y < tileHeight; y++) {
			for (int x = 0; x < tileHeight; x++) {
				if (y > tileHeight - 3)
					map[x][y] = Tile.GroundTile;
				else
					map[x][y] = Tile.VoidTile;
			}
		}
	}

	public void writeBaseMap() {
		for (int y = 0; y < tileHeight; y++) {
			for (int x = 0; x < tileWidth; x++) {
				fw.write("0");
			}
			if (y < tileHeight - 1)
				fw.newLine();
		}

		fw.closeWriter();
	}

}
