package fishsim.graphics;

import java.awt.Color;
import java.awt.Dimension;

import engine.graphics.sprites.Sprite;
import engine.graphics.sprites.Spritesheet;
import fishsim.Main;
import fishsim.entities.GameHook;
import fishsim.entities.passingobjects.Fish;
import fishsim.entities.startboard.FishingRod;

public class StaticSprites {

	// res/sprites/Main.png
	private static final Dimension MAIN = new Dimension(200, 250);
	public static final Spritesheet mainSpritesheet = new Spritesheet("res/sprites/Main.png", MAIN.width, MAIN.height);
	public static final Sprite hookSprite = new Sprite(0, 0, 4, 8, mainSpritesheet);
	public static final Sprite gameHookSprite = new Sprite(17, 0, GameHook.WIDTH, GameHook.HEIGHT, mainSpritesheet);

	// Fishing rod
	public static final Sprite fishingRodSprite = new Sprite(4, 0, FishingRod.WIDTH, FishingRod.HEIGHT,
			mainSpritesheet);
	public static final Sprite splashSprite = new Sprite(4 + FishingRod.WIDTH, 0, 4, 8, mainSpritesheet);

	// res/sprites/BoardBlueprint.png
	private static final int BOARD_WIDTH = Main.DIMENSIONS.width, BOARD_HEIGHT = Main.DIMENSIONS.height;
	public static final Spritesheet blueprintSpritesheet = new Spritesheet("res/sprites/BoardBlueprint.png",
			400, 400);
	public static final Sprite blueprintSprite = new Sprite(0, 0, BOARD_WIDTH, BOARD_HEIGHT, blueprintSpritesheet);
	public static final Sprite gameBlueprintSprite = new Sprite(BOARD_WIDTH/* offset */, 0, BOARD_WIDTH, 400,
			blueprintSpritesheet);

	// Fish
	public final static Sprite pinkFishSprite = new Sprite(0, 132, Fish.PinkFish.WIDTH,
			Fish.PinkFish.HEIGHT, mainSpritesheet);
	public final static Sprite yellowFishSprite = new Sprite(pinkFishSprite.positionRight(),
			pinkFishSprite.samePosition().y, Fish.YellowFish.WIDTH, Fish.YellowFish.HEIGHT, mainSpritesheet);
	public final static Sprite zebraFishSprite = new Sprite(0, pinkFishSprite.positionAbove(Fish.ZebraFish.HEIGHT),
			Fish.ZebraFish.WIDTH, Fish.ZebraFish.HEIGHT, mainSpritesheet);
	public final static Sprite clownFishSprite = new Sprite(0, zebraFishSprite.positionAbove(Fish.ClownFish.HEIGHT),
			Fish.ClownFish.WIDTH, Fish.ClownFish.HEIGHT, mainSpritesheet);
	
	// Buttons
	public static final int BUTTON_WIDTH = 127, BUTTON_HEIGHT = 33;
	public final static Sprite buttonSprite = new Sprite(0, pinkFishSprite.positionUnder(), BUTTON_WIDTH,
			BUTTON_HEIGHT, mainSpritesheet);
	public final static Sprite playAgainText = new Sprite(0, buttonSprite.positionUnder(),98,
			15, mainSpritesheet);
	public final static Sprite exitText = new Sprite(0, playAgainText.positionUnder(),35,
			12, mainSpritesheet);
	
	// Number sprites for score
	public final static Sprite[] numbersSprite = {numSprite(12), numSprite(9), numSprite(12), numSprite(12), numSprite(14), numSprite(12), numSprite(12), numSprite(12), numSprite(12), numSprite(12)};

	static int previousWidth = 0;
	public static Sprite numSprite(int width) {
		Sprite s = new Sprite(previousWidth, 210, width, 15, mainSpritesheet);
		previousWidth += width;
		return s; 
	}
}
