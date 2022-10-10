package fishsim.entities;

import java.awt.Color;

import engine.core.graphics.Display;
import engine.entity.Entity;

public class FishingLine extends Entity {
	Entity hook;
	int x, y;

	public FishingLine(Entity hook) {
		super(hook.x, hook.y, 1, 1, Color.BLACK);
		this.hook = hook;
	}

	public void update() {
		
	}

	@Override
	public void render(Display d) {
		renderLine(d);
	}

	public void renderLine(Display d) {
		x = d.width / 2;
		y = 0;
		int x2 = hook.x + hook.width/2, y2 = hook.y;

		int w = x2 - x;
		int h = y2 - y;
		int dx1 = 0, dy1 = 0, dx2 = 0, dy2 = 0;
		if (w < 0)
			dx1 = -1;
		else if (w > 0)
			dx1 = 1;
		if (h < 0)
			dy1 = -1;
		else if (h > 0)
			dy1 = 1;
		if (w < 0)
			dx2 = -1;
		else if (w > 0)
			dx2 = 1;
		int longest = Math.abs(w);
		int shortest = Math.abs(h);
		if (!(longest > shortest)) {
			longest = Math.abs(h);
			shortest = Math.abs(w);
			if (h < 0)
				dy2 = -1;
			else if (h > 0)
				dy2 = 1;
			dx2 = 0;
		}
		int numerator = longest >> 1;
		for (int i = 0; i <= longest; i++) {
			d.pixels[(int) (x + y * d.width)] = 0xff000000;
			numerator += shortest;
			if (!(numerator < longest)) {
				numerator -= longest;
				x += dx1;
				y += dy1;
			} else {
				x += dx2;
				y += dy2;
			}
		}
	}

}