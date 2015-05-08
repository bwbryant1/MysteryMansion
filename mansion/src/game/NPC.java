package game;

import static helpers.Clock.Delta;
import helpers.Counter;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.opengl.Texture;

public class NPC {
	private enum NPC_State {
		UP, DOWN, LEFT, RIGHT;
	}

	private static NPC_State npcState;
	private static NPC_State lastRender;

	private static float speed, x, y;
	private static CollisionGrid collide;
	private static String file;
	private static Animation ani;

	private static SpriteSheet sheet;

	private static int spriteWidth;

	private static int spriteHeight;

	public static Animation render() {
		try {
			sheet = new SpriteSheet(file, spriteWidth, spriteHeight);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		ani = new Animation(sheet, (int) (speed * 4));
		return ani;
	}

	private boolean first = true, alive = true, rendered = false;
	private TileGrid grid;
	private Tile startTile;
	private Texture texture;
	private int width, height, health;
	private int direction = 1;
	private Counter walkCounter, resetCounter;
	private Counter counter;
	private boolean changedDirection = false;

	public NPC(String file, GameCharSprite character, CollisionGrid collide2,
			int spriteWidth, int spriteHeight, Tile startTile, TileGrid grid,
			int width, int height, int speed, int health, CollisionGrid collide) {
		this.file = file;
		this.spriteWidth = spriteWidth;
		this.spriteHeight = spriteHeight;
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.speed = speed;
		this.collide = collide;
		this.startTile = startTile;
		this.health = health;
		this.width = width;
		this.height = height;
		this.grid = grid;
		counter = new Counter(2, 2);

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

	public int getHealth() {
		return health;
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

	public float getY() {
		return y;
	}

	public int getYInt() {
		return (int) Math.floor(getY() * 2 / (TileGrid.tileSize));
	}

	public int getYInt2() {
		return (int) Math.floor(getY() / TileGrid.tileSize);
	}

	public NPC_State randomDirection() {
		int caseNum = (int) (Math.random() * 8) + 1;

		switch (caseNum) {
		case 1:
			return NPC_State.UP;
		case 2:
			return NPC_State.DOWN;
		case 3:
			return NPC_State.LEFT;
		case 4:
			return NPC_State.RIGHT;
		case 5:
			return NPC_State.UP;
		case 6:
			return NPC_State.DOWN;
		case 7:
			return NPC_State.LEFT;
		case 8:
			return NPC_State.RIGHT;

		}
		return null;

	}

	public void setDirection(int caseNum) {
		

		switch (caseNum) {
		case 1:
			npcState = NPC_State.UP;
			break;
		case 2:
			npcState = NPC_State.DOWN;
			break;
		case 3:
			npcState = NPC_State.LEFT;
			break;
		case 4:
			npcState = NPC_State.RIGHT;
			break;
		case 5:
			npcState = NPC_State.UP;
			break;
		case 6:
			npcState = NPC_State.DOWN;
			break;
		case 7:
			npcState = NPC_State.LEFT;
			break;
		case 8:
			npcState = NPC_State.RIGHT;
			break;

		}
		

	}

	public void setFile(String file) {
		this.file = file;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void Update(boolean b) {
		// System.out.println((currentTime - StartTime)/1000);

		// npcState = npcState.RIGHT;
		if (rendered == false) {
			npcState = randomDirection();
			render();
			rendered = true;
		}
		ani.draw(x, y, width, height);

		ani.stop();
		counter.Update();
		if (!b) {

			if (!Counter.isRunning()) {
				if (changedDirection) {
					Counter.setCountTime((int) (Math.random() * 6 + 1));
					npcState = randomDirection();
					changedDirection = false;
				}
			}

			if (Counter.isRunning()) {
				changedDirection = true;
				switch (npcState) {
				case RIGHT:
					npcState = NPC_State.RIGHT;
					if (lastRender != NPC_State.RIGHT) {
						direction();
					}
					if (x < TileGrid.tileSize * TileGrid.COLUMN - 64
							&& !findNextR()) {
						if (true) {
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
					if (x > 16 && !findNextL()) {
						if (true) {
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
					if (y > TileGrid.tileSize / 4 && !findNextT()) {
						if (true) {
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
					if (y < TileGrid.tileSize * TileGrid.ROW - 80
							&& !findNextB()) {
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
	}

	public void Update2(boolean b) {
		if (rendered == false) {
			
			render();
			rendered = true;
		}
		ani.draw(x, y, width, height);

		ani.stop();


			if (b) {
				changedDirection = true;
				switch (npcState) {
				case RIGHT:
					npcState = NPC_State.RIGHT;
					if (lastRender != NPC_State.RIGHT) {
						direction();
					}
					if (x < TileGrid.tileSize * TileGrid.COLUMN - 64
							&& !findNextR()) {
						if (true) {
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
					if (x > 16 && !findNextL()) {
						if (true) {
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
					if (y > TileGrid.tileSize / 4 && !findNextT()) {
						if (true) {
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
					if (y < TileGrid.tileSize * TileGrid.ROW - 80
							&& !findNextB()) {
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
	}
		
	

