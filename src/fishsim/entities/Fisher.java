package fishsim.entities;

import engine.entity.Entity;
import fishsim.board.Board;

public class Fisher extends Entity {

	private FishingRod rod;

	public Fisher(int x, int y, Board board) {
		super(x, y, 5, 8);

		rod = new FishingRod(x, y, board, this);

		board.entities.add(this);
		board.entities.add(rod);
		rod.initRod(board);
	} 
	
	@Override
	public void update() {
	}

}
