package jGame;

import static helpers.Artist.DrawQuadTex;
import static helpers.Clock.Delta;

import org.newdawn.slick.opengl.Texture;

public class Enemy {
	private int width, height, health;
	private float speed, x, y;
	private Texture texture;
	private Tile startTile;
	private boolean first = true;
	private TileGrid grid;
	

	public Enemy(Texture texture, Tile startTile, TileGrid grid, int width,
			int height, float speed) {

		this.texture = texture;
		this.startTile = startTile;
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.width = width;
		this.height = height;
		this.speed = speed;
		this.grid = grid;

	}

	public void Update() {
		if (first) {
			first = false;
		} else {
			if(pathContinues())
				
			
			x += Delta() * speed;
		}
	}

	private boolean pathContinues() {
		boolean answer = true;
		
		Tile myTile = grid.getTile((int)(x/64), (int)(y/64));
		Tile nextTile = grid.getTile((int)(x/64)+1, (int)(y/64));
		if(myTile.getType()!=nextTile.getType())
		answer = false;
		
		return answer;

	}

	public Tile getStartTile() {
		return startTile;
	}

	public void setStartTile(Tile startTile) {
		this.startTile = startTile;
	}

	public boolean isFirst() {
		return first;
	}

	public void setFirst(boolean first) {
		this.first = first;
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public void Draw() {
		DrawQuadTex(texture, x, y, width, height);

	}

	public float getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}
	public TileGrid getTileGrid(){
		return grid;
	}
}
