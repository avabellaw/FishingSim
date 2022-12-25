package fishsim.entities.menu;

import engine.core.graphics.Menu;
import engine.core.graphics.MenuItem;
import fishsim.graphics.StaticSprites;

public class EndMenu extends Menu{

	public EndMenu(int screenWidth, int screenHeight) {
		super(screenWidth, screenHeight);
		addMenuItem(new PlayAgain(StaticSprites.buttonSprite));
		addMenuItem(new ExitButton(StaticSprites.buttonSprite));
	}
	
	public void addMenuItem(MenuItem... items) {
		for (MenuItem item : items) {
			item.x = this.screenWidth / 2 - item.width /2;
			item.y = screenHeight / 2;
			if(menuItems.size() > 0) item.y += spacing + menuItems.get(menuItems.size() - 1).height;
			menuItems.add(item);
		}
		
		menuItemCount++;
	}

}
