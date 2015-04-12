package game;

import static helpers.Clock.Delta;
import game.GameCharSprite.Key_State;
import helpers.Clock;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.opengl.Texture;

import helpers.Counter;

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
	private Counter walkCounter,resetCounter;
	private static int spriteWidth;
	private static int spriteHeight;
	private static GameCharSprite character;

	public NPC(String file, GameCharSprite character, CollisionGrid collide2,
			int spriteWidth, int spriteHeight, Tile startTile, TileGrid grid,
			int width, int height, int speed, int health, CollisionGrid collide) {
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
		walkCounter = new Counter(1);
		resetCounter = new Counter(2);
		resetCounter.setRunning(false);
		walkCounter.setRunning(false);
		npcState = NPC_State.DOWN;

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
		// System.out.println((currentTime - StartTime)/1000);

		// npcState = npcState.RIGHT;
		if (rendered == false) {
			render();
			rendered = true;
		}
		ani.draw(x, y, width, height);

		ani.stop();
		

		if(!resetCounter.isCountingDown()){
			//walkCounter.Update();
		}
		

		if (walkCounter.isCountingDown()) {
			switch (npcState) {
			case RIGHT:
				npcState = NPC_State.RIGHT;
				if (lastRender != NPC_State.RIGHT) {
					direction();
				}
				if (x < TileGrid.tileSize * TileGrid.COLUMN - 64) {
					if (isTimeToMove()) {
						ani.start();
						ani.draw(x, y, width, height);
						x += Delta() * speed;
					}

				}

				break;
			case LEFT:
				npcState = NPC_State.LEFT;
				if (lastRender != NPC_State.LEFT) {
					direction();
				}
				if (x > 16) {
					if (isTimeToMove()) {
						ani.start();
						ani.draw(x, y, width, height);
						x -= Delta() * speed;
					}

				}
				break;
			case UP:
				npcState = NPC_State.UP;
				if (lastRender != NPC_State.UP) {
					direction();
				}
				if (y > TileGrid.tileSize / 4) {
					if (isTimeToMove()) {
						ani.start();
						ani.draw(x, y, width, height);
						y -= Delta() * speed;
					}

				}
				break;
			case DOWN:
				npcState = NPC_State.DOWN;
				if (lastRender != NPC_State.DOWN) {
					direction();
				}
				if (y < TileGrid.tileSize * TileGrid.ROW - 80) {
					if (true) {
						ani.start();
						ani.draw(x, y, width, height);
						y += Delta() * speed;
					}

				}
				break;

			}
		}
	}

	private boolean isTimeToMove() {
		if (walkCounter.isCountingDown()) {
			return false;
		} else {
			return true;
		}
	}

	private void direction() {
		switch (npcState) {
		case UP:
			setFile("res/redirect3.png");
			render();
			lastRender = NPC_State.UP;
			break;
		case DOWN:
			setFile("res/redirect4.png");
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

	public NPC_State randomDirection() {
		int caseNum = (int) (Math.random() * 4) + 1;

		switch (caseNum) {
		case 1:
			return NPC_State.UP;
		case 2:
			return NPC_State.DOWN;
		case 3:
			return NPC_State.LEFT;
		case 4:
			return NPC_State.RIGHT;

		}
		return null;

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

}
