package game;

import org.newdawn.slick.opengl.Texture;
import static helpers.Artist.*;

public class Tile {

	private Texture texture;
	private TileType type;
	private float x, y, width, height;
	private boolean canCollide;

	public Tile(float x, float y, float width, float height, TileType type) {

		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.type = type;
		this.texture = QuickLoad(type.textureName);
	}

	public Tile(float x, float y, float width, float height, boolean canCollide) {

		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.type = type;
		this.canCollide = canCollide;
	}
	

	public boolean canCollide() {
		return canCollide;
	}

	public void Draw() {
		DrawQuadTex(texture, x, y, width, height);

	}

	public float getHeight() {
		return height;
	}

	public Texture getTexture() {
		return texture;
	}

	public TileType getType() {
		return type;
	}

	public float getWidth() {
		return width;
	}

	public float getX() {
		return x;
	}

	public int getXPlace() {
		return (int) x / TileGrid.tileSize;
	}

	public float getY() {
		return y;
	}

	public int getYPlace() {
		return (int) y / TileGrid.tileSize;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public void setType(TileType type) {
		this.type = type;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

}
