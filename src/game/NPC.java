package game;

import static helpers.Clock.Delta;
import game.GameCharSprite.Key_State;
import helpers.Clock;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.opengl.Texture;

public class NPC {
	public enum NPC_State {
		UP, DOWN, LEFT, RIGHT;
	}

	private static NPC_State npcState;
	private static NPC_State lastRender;

	private boolean first = true, alive = true, rendered = false;
	private TileGrid grid;
	private static float speed, x, y;
	private Tile startTile;

	private Texture texture;
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	private int width, height, health;
	private int direction = 1;
	private static CollisionGrid collide;
	private static String file;
	private static Animation ani;
	private static SpriteSheet sheet;
	private static int spriteWidth;
	private static int spriteHeight;
	private static GameCharSprite character;

	public NPC(String file, GameCharSprite character, int spriteWidth,
			int spriteHeight, Tile startTile, TileGrid grid, int width,
			int height, int speed, int health, CollisionGrid collide) {
		NPC.file = file;
		NPC.spriteWidth = spriteWidth;
		NPC.spriteHeight = spriteHeight;
		NPC.x = startTile.getX();
		NPC.y = startTile.getY();
		NPC.speed = speed;
		NPC.collide = collide;
		NPC.character = character;
		this.startTile = startTile;
		this.health = health;
		this.width = width;
		this.height = height;
		this.grid = grid;

	}

	public static Animation render() {
		try {
			sheet = new SpriteSheet(file, spriteWidth, spriteHeight);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		ani = new Animation(sheet, (int) (speed * 4));
		return ani;
	}

	public void setFile(String file) {
		NPC.file = file;
	}

	public void Update() {
		if (rendered == false) {
			render();
			rendered = true;
		}
		switch (direction) {
		case 1:
			npcState = NPC_State.RIGHT;
			if (lastRender != NPC_State.RIGHT) {
				direction();
			}

			ani.draw(x, y, width, height);
			ani.stop();
			if (true) {
				ani.start();
				ani.draw(x, y, width, height);
				x += Delta() * (speed) * direction;
			}
			if (x > 200) {
				direction = -1;
				setFile("res/redirect2.png");

			}
			break;
		case -1:
			npcState = NPC_State.LEFT;
			if (lastRender != NPC_State.LEFT) {
				direction();
			}

			ani.draw(x, y, width, height);
			ani.stop();
			if (true) {
				ani.start();
				ani.draw(x, y, width, height);
				this.x += Delta() * (speed) * direction;
			}
			if (x <= 50) {
				direction = 1;
				setFile("res/redirect1.png");

			}
			break;

		}
	}

	private void direction() {
		switch (npcState) {
		case UP:
			setFile("res/redirect1.png");
			render();
			lastRender = NPC_State.UP;
			break;
		case DOWN:
			setFile("res/redirect2.png");
			render();
			lastRender = NPC_State.DOWN;
			break;
		case LEFT:
			setFile("res/redirect2.png");
			render();
			lastRender = NPC_State.LEFT;
			break;
		case RIGHT:
			setFile("res/redirect.png");
			render();
			lastRender = NPC_State.RIGHT;
			break;

		}

	}

}
