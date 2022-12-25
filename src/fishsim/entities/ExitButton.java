package fishsim.entities;

import engine.core.Ticker;
import engine.core.graphics.MenuItem;
import engine.graphics.sprites.Sprite;
import fishsim.graphics.StaticSprites;

public class ExitButton extends MenuItem.Button{

	public ExitButton(Sprite sprite) {
		super(sprite);
		setTextSprite(StaticSprites.exitText);
	}

	@Override
	public void click() {
		Ticker.close();
	}

}
