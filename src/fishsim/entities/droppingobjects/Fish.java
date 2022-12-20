package fishsim.entities.droppingobjects;

import java.awt.Color;

import fishsim.entities.GameHook;

public class Fish extends DroppingObject {

	public Fish(GameHook hook) {
		super(hook, 0, 10, 5, Color.red);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void caughtByHook() {
		// TODO Auto-generated method stub

	}

}
