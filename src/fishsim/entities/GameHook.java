package fishsim.entities;

import engine.entity.Entity;
import fishsim.graphics.StaticSprites;

public class GameHook extends Entity {

	public final static int WIDTH = 8, HEIGHT = 16;

	public GameHook(int x, int y) {
		super(x, y, WIDTH, HEIGHT, StaticSprites.gameHookSprite);
	}

	@Override
	public void update() {

	}
}
