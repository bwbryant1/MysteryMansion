package game;

import helpers.Artist;
import helpers.ConsoleParser;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.Texture;

public class Game {

	public enum State {
		GAME, PVE, DIALOGUE;
	}

	public static State state = State.GAME;
	public static boolean notPaused = true;

	public static State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

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
	private Dialogue dialogue;

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
				collide, inventory,this);
		this.parser = parser2;
		this.parser.setStuff(grid, events, manager, npcMan, character,
				textManager, inventory);
		this.fight = new FightManager(character, inventory, textManager);
		this.dialogue = new Dialogue(this,DialogueText.beginningScene());
		setBackgroundMusic(new Music("res/harmony.wav"));
		getBackgroundMusic().loop(1, 100);
		overlay = Artist.QuickLoad("Overlay");
	}

	public Dialogue getDialogue() {
		return dialogue;
	}

	public void setDialogue(Dialogue dialogue) {
		this.dialogue = dialogue;
	}

	public Music getBackgroundMusic() {
		return backgroundMusic;
	}

	public TileGrid getGrid() {
		return grid;
	}

	public void setBackgroundMusic(Music backgroundMusic) {
		this.backgroundMusic = backgroundMusic;
	}

	public void setGrid(TileGrid grid) {
		this.grid = grid;
	}

	public void Update() {
		switch (state) {
		case GAME:

			Draw();

			if ((Keyboard.isKeyDown(Keyboard.KEY_SPACE))) {
				// setPaused(true);
				//state = State.DIALOGUE;
				//Artist.DrawQuadTex(overlay, 0, 0, 1024, 1024);

			}

			break;
		case PVE:
			GL11.glClearColor(1.0f, 1.0f, 1.0f, 0.0f);
			backgroundMusic.pause();
			fight.Update();
			break;
		case DIALOGUE:

			Draw();
			dialogue.Update();

			break;
		}
	}

	public void setPaused(Boolean b) {
		character.setPaused(b);
		npcMan.setPaused(b);

	}

	private void Draw() {
		inventory.Update();
		getGrid().Update();
		getGrid().Draw();
		events.Update();
		manager.Update();
		npcMan.Update();

		character.Draw();
		character.Update();
	}

	public void setPaused(boolean b) {
		character.setPaused(b);
		npcMan.setPaused(b);
		
	}

}
