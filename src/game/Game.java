package game;

import game.Boot.State;
import helpers.Artist;
import helpers.ConsoleParser;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.Texture;

public class Game {

	public enum State {
		GAME, PVE;
	}

	public static State state = State.PVE;
	private Music backgroundMusic;
	private TileGrid grid;
	private GameCharSprite character;
	private ObjectManager manager;
	private Events events;
	private TextManager textManager;
	private CollisionGrid collide;
	private Texture overlay;
	private NPCmanager npcMan;
	private Inventory inventory;
	private ConsoleParser parser;
	private FightManager fight;
	public static boolean notPaused = true;

	public Game(int[][] map, ConsoleParser parser2) throws SlickException {
		
		this.inventory = new Inventory();
		this.textManager = new TextManager();
		this.setGrid(new TileGrid(map));
		this.collide = new CollisionGrid(CollideMaps.Entrance1());
		this.character = new GameCharSprite("res/images/playerD.png", 64, 100,
				getGrid().getTile(5, 5), getGrid(), 32, 50, 100, 100,
				textManager, collide);
		this.manager = new ObjectManager(character);
		this.npcMan = new NPCmanager(character, getGrid(), collide, manager);
		this.events = new Events(character, getGrid(), textManager, manager,
				collide, inventory);

		this.parser = parser2;
		overlay = Artist.QuickLoad("Overlay");
		this.parser.setStuff(grid, events, manager, npcMan, character,
				textManager, inventory);
		this.fight = new FightManager(character,inventory,textManager);
		
		setBackgroundMusic(new Music("res/harmony.wav"));
		
		getBackgroundMusic().loop(3, 100);
	}

	public Music getBackgroundMusic() {
		return backgroundMusic;
	}

	public void setBackgroundMusic(Music backgroundMusic) {
		this.backgroundMusic = backgroundMusic;
	}

	public void Update() {
		switch (state) {
		case GAME:
			if(state == Game.state.GAME){
			
			}
			inventory.Update();
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
			break; 
		case PVE:
			GL11.glClearColor(1.0f, 1.0f, 1.0f, 0.0f);
			backgroundMusic.pause();
			fight.Update();
			break;
		}
	}

	public static State getState() {
		return state;
	}

	public static void setState(State state) {
		Game.state = state;
	}

	public void setGrid(TileGrid grid) {
		this.grid = grid;
	}

	public TileGrid getGrid() {
		return grid;
	}
}
