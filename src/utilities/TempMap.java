package utilities;

import fishsim.board.Board;

public class TempMap {
	
	public enum Tile {
		VoidTile,
		GroundTile
	}
	
	public Tile[][] map;
	
	private int tileWidth, tileHeight;
	
	public TempMap(Board board) {
		tileWidth = board.BOARD_SIZE.width / board.TILE_SIZE;
		tileHeight =board.BOARD_SIZE.height / board.TILE_SIZE;
		
		map = new Tile[tileWidth][tileHeight];
		
		/*
		for(int y = 0; y < tileHeight; y++) {
			for(int x = 0; x < tileHeight; x++) {
				if(y > tileHeight - 3) map[x][y] = Tile.GroundTile;
				else map[x][y] = Tile.VoidTile;
			}
		}*/
	}	

}
