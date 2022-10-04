package fishsim.entities;

import engine.entity.Entity;
import fishsim.board.Board;

public class Fisher extends Entity{

	public Fisher(int x, int y, Board board) {
		super(x, y, board.TILE_SIZE * 2, board.TILE_SIZE * 2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
