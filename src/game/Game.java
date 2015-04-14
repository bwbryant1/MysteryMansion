package game;

import helpers.Artist;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.Texture;


public class Game {

	private TileGrid grid;
	private GameCharSprite character;
	private ObjectManager manager;
	private Events events;
	private TextManager textManager;
	private CollisionGrid collide;
	private Texture overlay;
	private NPCmanager npcMan;
	private Inventory gui;
	public static boolean notPaused = true;

	public Game(int[][] map) throws SlickException {
		this.gui = new Inventory();
		this.textManager = new TextManager();
		this.setGrid(new TileGrid(map));
		this.collide = new CollisionGrid(CollideMaps.Entrance1());

		this.character = new GameCharSprite("res/images/playerD.png", 64, 100,
				getGrid().getTile(5, 5), getGrid(), 32, 50, 200, 100,
				textManager, collide);

		this.manager = new ObjectManager(character);
		this.npcMan = new NPCmanager(character, getGrid(), collide, manager);
		this.events = new Events(character, getGrid(), textManager, manager,
				collide,gui);
		overlay = Artist.QuickLoad("Overlay");

	}

	public void Update() {
		gui.Update();
		getGrid().Update();
		getGrid().Draw();
		events.Update();

		manager.Update();
		npcMan.Update();

		character.Draw();

		character.Update();
		// events.Update();
		if ((Keyboard.isKeyDown(Keyboard.KEY_SPACE))) {
			Artist.DrawQuadTex(overlay, 0, 0, 1024, 1024);
		}

	}

	public void setGrid(TileGrid grid) {
		this.grid = grid;
	}

	public TileGrid getGrid() {
		return grid;
	}
}
