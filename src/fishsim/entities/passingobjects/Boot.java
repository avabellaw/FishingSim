package fishsim.entities.passingobjects;

import fishsim.board.GameBoard;
import fishsim.graphics.StaticSprites;

public class Boot extends PassingObject {

	public Boot(GameBoard board) {
		super(board, StaticSprites.bootSprite, new FishScore(-100));
		addSpeed(0.2);
	}

}
