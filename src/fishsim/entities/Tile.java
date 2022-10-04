package fishsim.entities;

import java.awt.Color;

import engine.entity.Entity;
import engine.graphics.sprites.Sprite;

public class Tile extends Entity {
	
	public Tile(int x, int y, int width, int height, Sprite sprite) {
		super(x, y, width, height, sprite);
		// TODO Auto-generated constructor stub
	}

	public Tile(int x, int y, int width, int height, Color tempColour) {
		super(x, y, width, height, new Sprite(width, height, tempColour));
		// TODO Auto-generated constructor stub
	}

	public Tile(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	protected void outlineTile(int tileSize) {
		int outlineColour = 0xcc12aa;
		for (int i = 0; i < width; i++) {
			pixels[i] = outlineColour;
			pixels[i + (height - 1) * tileSize] = outlineColour;
		}
		for (int i = 0; i < height; i++) {
			pixels[width - 1 + i * height] = outlineColour;
			pixels[i * height] = outlineColour;
		}
		pixels[0] = 0x000000;
		pixels[0 + (height - 1) * tileSize] = 0x39CCBA;
		pixels[width - 1 + (height - 1) * tileSize] = 0xCC1420;
		pixels[width - 1] = 0xFAFF00;
	}

	public static class waterTile extends Tile {

		public waterTile(int x, int y, int tileSize) {
			super(x, y, tileSize, tileSize, Color.blue);
			
		}

	}
	
	public static class airTile extends Tile {

		public airTile(int x, int y, int tileSize) {
			super(x, y, tileSize, tileSize, new Color(0x96FFF1));
		}

	}

	public static class voidTile extends Tile {

		public voidTile(int x, int y, int tileSize) {
			super(x, y, tileSize, tileSize);

			isVoid = true;
		}

	}

	public static class defaultTile extends Tile {

		public defaultTile(int x, int y, int tileSize) {
			super(x, y, tileSize, tileSize);

			outlineTile(tileSize);
		}
	}

	public static class groundTile extends Tile {

		public groundTile(int x, int y, int tileSize) {
			super(x, y, tileSize, tileSize);

			outlineTile(tileSize);
		}
	}

}
