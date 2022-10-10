package fishsim.graphics;

import engine.graphics.sprites.Sprite;
import engine.graphics.sprites.Spritesheet;
import fishsim.entities.FishingRod;
import fishsim.entities.GameHook;

public class StaticSprites {

	public static Spritesheet mainSpritesheet = new Spritesheet("res/sprites/Main.png", 150, 150);
	public static Sprite hookSprite = new Sprite(0, 0, 4, 8, mainSpritesheet);
	public static Sprite gameHookSprite = new Sprite(17, 0, GameHook.WIDTH, GameHook.HEIGHT, mainSpritesheet);
	
	public static Sprite fishingRodSprite = new Sprite(4, 0, FishingRod.WIDTH, FishingRod.HEIGHT, mainSpritesheet);
	public static Sprite splashSprite = new Sprite(4 + FishingRod.WIDTH, 0, 4, 8, mainSpritesheet);
	

	public static Spritesheet blueprintSpritesheet = new Spritesheet("res/sprites/BoardBlueprint.png", 300, 150);
	public static Sprite blueprintSprite = new Sprite(0, 0, 150, 150, blueprintSpritesheet);
	public static Sprite gameBlueprintSprite = new Sprite(150, 0, 150, 150, blueprintSpritesheet);
}
