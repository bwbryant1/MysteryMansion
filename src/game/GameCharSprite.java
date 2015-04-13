package game;

import static helpers.Clock.Delta;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.opengl.Texture;

public class GameCharSprite {

	public enum Key_State {
		UP, DOWN, LEFT, RIGHT;
	}

	private static Key_State keyState;
	private static Key_State lastRender;

	private boolean first = true, alive = true, rendered = false;
	private TileGrid grid;
	private static float speed, x, y;
	private Tile startTile;

	private Texture texture;
	private int width, height, health;
	private static CollisionGrid collide;
	private static int currentLevel;
	private static String file;
	private static Animation ani;
	private static SpriteSheet sheet;
	private static int spriteWidth;
	private static int spriteHeight;
	private static TextManager textManager;

	public void setFile(String file) {
		GameCharSprite.file = file;
	}

	public GameCharSprite(String file, int spriteWidth, int spriteHeight,
			Tile startTile, TileGrid grid, int width, int height, int speed,
			int health, TextManager textManager, CollisionGrid collide) {
		GameCharSprite.file = file;
		this.startTile = startTile;
		GameCharSprite.x = startTile.getX();
		GameCharSprite.y = startTile.getY();
		this.width = width;
		this.height = height;
		this.grid = grid;
		GameCharSprite.collide = collide;
		GameCharSprite.speed = speed;
		GameCharSprite.spriteWidth = spriteWidth;
		GameCharSprite.spriteHeight = spriteHeight;
		GameCharSprite.currentLevel = 0;
		GameCharSprite.textManager = textManager;
		this.health = health;

	}

	public void Draw() {

	}

	public void setLevel(int level) {
		System.out.println(level);
		currentLevel = level;
	}

	public int getLevel() {
		return currentLevel;
	}

	public static Animation render() {
		try {
			sheet = new SpriteSheet(file, spriteWidth, spriteHeight);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		ani = new Animation(GameCharSprite.sheet, (int) GameCharSprite.speed);
		return ani;
	}

	public void Update() {

		textManager.setText(textManager.getText(1), "Health: " + health, 650,
				100, Color.red);
		textManager.callText(1);
		if (rendered == false) {
			render();
			rendered = true;
		}

		ani.draw(x, y, width, height);

		ani.stop();
		keyboard(getKey());

	}

	public boolean findNextT() {

		if (collide.getTile((int) Math.floor(getX() / 16),
				(int) Math.ceil(getY() / 16 - 1)).canCollide()) {
			{
				// System.out.println("Top");
				return true;
			}
		}
		return false;

	}

	public boolean findNextB() {

		if (collide.getTile((int) Math.floor(getX() / 16),
				(int) Math.floor(getY() / 16 + 2)).canCollide()) {
			{
				// System.out.println("Bottom");
				return true;
			}
		}
		return false;

	}

	public boolean findNextL() {

		if (collide.getTile((int) Math.floor(getX() / 16 - 1),
				(int) Math.floor(getY() / 16) + 1).canCollide()) {
			{
				// System.out.println("Left"+getXInt2());
				return true;
			}
		}
		return false;

	}

	public boolean findNextR() {

		if (collide.getTile((int) Math.floor(getX() / 16 + 1),
				(int) Math.floor(getY() / 16) + 1).canCollide()) {
			{
				// System.out.println("Right");
				return true;
			}
		}
		return false;

	}

	private int getKey() {
		if ((Keyboard.isKeyDown(Keyboard.KEY_W) || Keyboard
				.isKeyDown(Keyboard.KEY_UP)) && !findNextT()) {
			return 3;
		}
		if ((Keyboard.isKeyDown(Keyboard.KEY_S) || Keyboard
				.isKeyDown(Keyboard.KEY_DOWN)) && !findNextB()) {
			return 4;
		}
		if ((Keyboard.isKeyDown(Keyboard.KEY_A) || Keyboard
				.isKeyDown(Keyboard.KEY_LEFT)) && !findNextL()) {
			return 2;
		}
		if ((Keyboard.isKeyDown(Keyboard.KEY_D) || Keyboard
				.isKeyDown(Keyboard.KEY_RIGHT)) && !findNextR()) {
			return 1;
		}
		return 0;
	}

	private void direction() {
		switch (keyState) {
		case UP:
			setFile("res/images/playerU.png");
			render();
			lastRender = Key_State.UP;
			break;
		case DOWN:
			setFile("res/images/playerD.png");
			render();
			lastRender = Key_State.DOWN;
			break;
		case LEFT:
			setFile("res/images/playerL.png");
			render();
			lastRender = Key_State.LEFT;
			break;
		case RIGHT:
			setFile("res/images/playerR.png");
			render();
			lastRender = Key_State.RIGHT;
			break;

		}

	}

	private void keyboard(int key) {

		ani.draw(x, y, width, height);

		ani.stop();
		switch (key) {
		case 1:

			keyState = Key_State.RIGHT;
			if (lastRender != Key_State.RIGHT) {
				direction();
			}

			if (x < TileGrid.tileSize * TileGrid.COLUMN - 64) {
				ani.start();
				ani.draw(x, y, width, height);
				x += Delta() * speed;

			}
			break;

		case 2:
			keyState = Key_State.LEFT;
			if (lastRender != Key_State.LEFT) {
				direction();
			}
			if (x > 16) {
				ani.start();
				ani.draw(x, y, width, height);
				x -= Delta() * speed;

			}

			break;

		case 3:
			keyState = Key_State.UP;
			if (lastRender != Key_State.UP) {
				direction();
			}
			if (y > TileGrid.tileSize / 4) {
				ani.start();
				ani.draw(x, y, width, height);
				y -= Delta() * speed;

			}

			break;
		case 4:

			keyState = Key_State.DOWN;
			if (lastRender != Key_State.DOWN) {
				direction();
			}
			if (y < TileGrid.tileSize * TileGrid.ROW - 80) {
				ani.start();
				ani.draw(x, y, width, height);
				y += Delta() * speed;


			}

			break;

		}
	}

	public int getHealth() {
		return health;
	}

	public int getHeight() {
		return height;
	}

	public float getSpeed() {
		return speed;
	}

	public Tile getStartTile() {
		return startTile;
	}

	public Texture getTexture() {
		return texture;
	}

	public TileGrid getTileGrid() {
		return grid;
	}

	public int getWidth() {
		return width;
	}

	public float getX() {
		return x;
	}

	public int getXInt() {
		return (int) Math.floor(getX() * 3 / TileGrid.tileSize);
	}

	public int getXInt2() {
		return (int) Math.floor(getX() / TileGrid.tileSize);
	}

	public int getYInt() {
		return (int) Math.floor(getY() * 2 / (TileGrid.tileSize));
	}

	public int getYInt2() {
		return (int) Math.floor(getY() / TileGrid.tileSize);
	}

	public float getY() {
		return y;
	}

	public boolean isAlive() {
		return alive;
	}

	public boolean isFirst() {
		return first;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public void setFirst(boolean first) {
		this.first = first;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setSpeed(float speed) {
		GameCharSprite.speed = speed;
	}

	public void setStartTile(Tile startTile) {
		this.startTile = startTile;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setX(float x) {
		GameCharSprite.x = x;
	}

	public void setY(float y) {
		GameCharSprite.y = y;
	}
}