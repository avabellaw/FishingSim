package fishsim.entities.menu;

import engine.core.graphics.Display;
import engine.core.graphics.Menu;
import engine.core.graphics.MenuItem;
import fishsim.graphics.StaticSprites;

public class EndMenu extends Menu {
	
	private int[] pixels;
	
	public EndMenu(Display d) {
		super(d);
		addMenuItem(new PlayAgain(StaticSprites.buttonSprite));
		addMenuItem(new ExitButton(StaticSprites.buttonSprite));
		
		pixels = new int[screenWidth * screenHeight];
		
		for(int i = 0; i < pixels.length; i++) pixels[i] = 0xAF000000;
	}

	public void addMenuItem(MenuItem... items) {
		for (MenuItem item : items) {
			item.x = this.screenWidth / 2 - item.width / 2;
			item.y = screenHeight / 2;
			if (menuItems.size() > 0)
				item.y += spacing + menuItems.get(menuItems.size() - 1).height;
			menuItems.add(item);
		}

		menuItemCount++;
	}

	@Override
	protected void renderBackground(int[] displayPixels, Display d) {
		for(int i = 0; i < displayPixels.length; i++) displayPixels[i] = d.mixTwoColours(displayPixels[i], this.pixels[i]); 
	}

}
