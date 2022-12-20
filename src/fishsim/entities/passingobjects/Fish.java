package fishsim.entities.passingobjects;

import java.awt.Color;

import fishsim.board.GameBoard;

public class Fish extends PassingObject {
	
	protected int pointsWorth = 5;

	public Fish(GameBoard board, int x, int width, int height, int points) {
		super(board, x, width, height, Color.red);
	}

	@Override
	protected void caughtByHook() {
		GameBoard.addPoints(pointsWorth);
		removePassingObject();
	}
	
	public class PinkFish extends Fish{

		public PinkFish(GameBoard board, ) {
			super(board);
		}
		
	}

}
