package fishsim.entities.menu;

import java.awt.Point;

import engine.core.graphics.Display;
import engine.core.graphics.Menu;
import engine.core.graphics.MenuItem;
import fishsim.graphics.StaticSprites;

public class EndMenu extends Menu {

	public EndMenu(Display d) {
		super(d);
		addMenuItem(new PlayAgain(StaticSprites.buttonSprite));
		addMenuItem(new ExitButton(StaticSprites.buttonSprite));
	}

	public void addMenuItem(MenuItem... items) {
		for (MenuItem item : items) {
			item.x = this.width / 2 - item.width / 2;
			item.y = height / 2;
			if (menuItems.size() > 0)
				item.y += spacing + menuItems.get(menuItems.size() - 1).height;
			menuItems.add(item);
		}

		menuItemCount++;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}