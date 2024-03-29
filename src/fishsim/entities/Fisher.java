package fishsim.entities;

import engine.entity.Entity;
import fishsim.board.Board;

public class Fisher extends Entity {

	private FishingRod rod;
	
	public static int width = 5, height = 8;

	public Fisher(int x, int y, Board board) {
		super(x, y, width, height);

		rod = new FishingRod(x, y + height, board, this, 45);

		board.entities.add(this);
		board.entities.add(rod);
		rod.initRod(board);
	} 
	
	@Override
	public void update() {
	}

}
