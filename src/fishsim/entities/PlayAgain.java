package fishsim.entities;

import engine.core.graphics.MenuItem;
import engine.graphics.sprites.Sprite;
import fishsim.graphics.StaticSprites;

public class PlayAgain extends MenuItem.Button {

	public PlayAgain(Sprite sprite) {
		super(sprite);
		setTextSprite(StaticSprites.playAgainText);
	}
	
	public void click() {
		System.out.println("afsjhfalksf");
	}

}
