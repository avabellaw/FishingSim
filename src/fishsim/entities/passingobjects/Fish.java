package fishsim.entities.passingobjects;

import java.awt.Color;

import fishsim.board.GameBoard;

public class Fish extends PassingObject {
	
	private static final int w = 10, h = 5;
	protected int pointsWorth = 5;

	public Fish(GameBoard board, int x) {
		super(board, x, w, h, Color.red);
	}
	
	public Fish(GameBoard board) {
		super(board, (int) (Math.random() * (board.boundaries.right() - board.boundaries.left() - w)) + board.boundaries.left(), w, h, Color.red);
	}

	@Override
	protected void caughtByHook() {
		GameBoard.addPoints(pointsWorth);
		removePassingObject();
	}

}
