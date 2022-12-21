package fishsim.entities;

import java.awt.Color;

import engine.entity.TileTemplate;
import engine.graphics.sprites.Sprite;

public class Tile extends TileTemplate {

	public Tile(int x, int y, int width, int height, int colour) {
		super(x, y, width, height, new Sprite(width, height, new Color(colour)));
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

	public static class waterTile extends Tile {

		public static final int DEFAULT_COLOUR = 0xff0800FF;

		public waterTile(int x, int y, int tileSize, int pixelColour) {
			super(x, y, tileSize, tileSize, pixelColour);

		}

		public waterTile(int x, int y, int tileSize) {
			super(x, y, tileSize, tileSize, DEFAULT_COLOUR);

		}

	}

	public static class airTile extends Tile {

		public static final int DEFAULT_COLOUR = 0xffffffff;

		public airTile(int x, int y, int tileSize, int pixelColour) {
			super(x, y, tileSize, tileSize, pixelColour);

			isVoid = true;
		}

		public airTile(int x, int y, int tileSize) {
			super(x, y, tileSize, tileSize, DEFAULT_COLOUR);

			isVoid = true;
		}

	}

	public static class groundTile extends Tile {

		public static final int DEFAULT_COLOUR = 0xff8E260C;

		public groundTile(int x, int y, int tileSize, int pixelColour) {
			super(x, y, tileSize, tileSize, pixelColour);
		}

		public groundTile(int x, int y, int tileSize) {
			super(x, y, tileSize, tileSize, DEFAULT_COLOUR);
		}
	}

}
