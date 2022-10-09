package fishsim.graphics;

import engine.graphics.sprites.Sprite;
import engine.graphics.sprites.Spritesheet;
import fishsim.entities.FishingRod;

public class StaticSprites {

	public static Spritesheet mainSpritesheet = new Spritesheet("res/sprites/Main.png", 150, 150);
	public static Sprite hookSprite = new Sprite(0, 0, 4, 8, mainSpritesheet);
	public static Sprite fishingRodSprite = new Sprite(4, 0, FishingRod.WIDTH, FishingRod.HEIGHT, mainSpritesheet);
	public static Sprite splashSprite = new Sprite(4 + FishingRod.WIDTH, 0, 4, 8, mainSpritesheet);
}
