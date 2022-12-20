package fishsim.entities.droppingobjects;

import java.awt.Color;

import fishsim.board.GameBoard;

public class Fish extends DroppingObject {

	public Fish(GameBoard board) {
		super(board, 0, 10, 5, Color.red);
	}

	@Override
	protected void caughtByHook() {
		removeDroppingObject();
	}

}
