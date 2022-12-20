package fishsim.graphics;

import java.awt.Dimension;

import engine.graphics.sprites.Sprite;
import engine.graphics.sprites.Spritesheet;
import fishsim.Main;
import fishsim.entities.FishingRod;
import fishsim.entities.GameHook;

public class StaticSprites {

	// res/sprites/Main.png
	private static final Dimension MAIN = new Dimension(150, 150);
	public static Spritesheet mainSpritesheet = new Spritesheet("res/sprites/Main.png", MAIN.width, MAIN.height);
	public static Sprite hookSprite = new Sprite(0, 0, 4, 8, mainSpritesheet);
	public static Sprite gameHookSprite = new Sprite(17, 0, GameHook.WIDTH, GameHook.HEIGHT, mainSpritesheet);
	
	// Fishing rod
	public static Sprite fishingRodSprite = new Sprite(4, 0, FishingRod.WIDTH, FishingRod.HEIGHT, mainSpritesheet);
	public static Sprite splashSprite = new Sprite(4 + FishingRod.WIDTH, 0, 4, 8, mainSpritesheet);
	
	// res/sprites/BoardBlueprint.png
	private static final int BOARD_WIDTH = Main.DIMENSIONS.width, BOARD_HEIGHT = Main.DIMENSIONS.height;
	public static Spritesheet blueprintSpritesheet = new Spritesheet("res/sprites/BoardBlueprint.png", BOARD_WIDTH * 2, BOARD_HEIGHT);
	public static Sprite blueprintSprite = new Sprite(0, 0, BOARD_WIDTH, BOARD_HEIGHT, blueprintSpritesheet);
	public static Sprite gameBlueprintSprite = new Sprite(BOARD_WIDTH/*offset*/, 0, BOARD_WIDTH, BOARD_HEIGHT, blueprintSpritesheet);
	
	//Fish	
	enum FishSize {
		PINK (18, 16);
		
		int width, height;
		
		Dimension dimensions() {
			return new Dimension(width, height);
		}
		
		FishSize(int width, int height){
			this.width = width;
			this.height = height;
		}
	}
	
	public static Sprite pinkFishSprite = new Sprite(0, MAIN.height-FishSize.PINK.width, FishSize.PINK.dimensions(), mainSpritesheet);
}
