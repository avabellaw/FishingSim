package fishsim.entities;

import engine.entity.Entity;
import fishsim.graphics.StaticSprites;

public class FishingHook extends Entity {

	public FishingHook(int x, int y, int maxU) {
		super(x, y, 4, 8, StaticSprites.hookSprite);
	}

	@Override
	public void update() {
		
	}

}