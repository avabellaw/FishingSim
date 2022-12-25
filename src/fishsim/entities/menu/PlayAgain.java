package fishsim.entities.menu;

import engine.core.graphics.MenuItem;
import engine.graphics.sprites.Sprite;
import fishsim.Main;
import fishsim.graphics.StaticSprites;

public class PlayAgain extends MenuItem.Button {

	public PlayAgain(Sprite sprite) {
		super(sprite);
		setTextSprite(StaticSprites.playAgainText);
	}
	
	public void click() {
		Main.goToGame();
	}

}
