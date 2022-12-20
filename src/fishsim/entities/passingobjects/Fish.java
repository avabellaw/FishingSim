package fishsim.entities.passingobjects;

import java.awt.Color;

import fishsim.board.GameBoard;

public class Fish extends PassingObject {

	public Fish(GameBoard board, int x) {
		super(board, x, 10, 5, Color.red);
	}

	@Override
	protected void caughtByHook() {
		removeDroppingObject();
	}

}
