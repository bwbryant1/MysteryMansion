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
		GAME, PVE, DIALOGUE, CUTSCENE;
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
	private Player player;
	private Cutscene cutscene;
	private Texture cutsceneObject;
	private String[] dialogueText = DialogueText.ballroomSceneAfterCutscene();
	private boolean musicFlag;
	private Music fightMusic;
	private Object battleScene;
	private int battleScene3;
	

	public Game(int[][] map, ConsoleParser parser2) throws SlickException {
		
		cutsceneObject = Artist.QuickLoad("ballroom/ballroom3");
		this.inventory = new Inventory();
		this.textManager = new TextManager();
		this.setGrid(new TileGrid(map));
		this.collide = new CollisionGrid(CollideMaps.Entrance1());
		this.character = new GameCharSprite("res/images/playerD2.png", 511 / 7,
				128, getGrid().getTile(5, 8), getGrid(), (511 / 7) / 2,
				128 / 2, 80, 100, textManager, collide, inventory);

		this.manager = new ObjectManager(character);
		this.fight = new FightManager(character, inventory, textManager);
		this.npcMan = new NPCmanager(character, getGrid(), collide, manager,fight,
				this);
		this.events = new Events(character, getGrid(), textManager, manager,
				collide, inventory, this, npcMan);
		this.parser = parser2;
		this.parser.setStuff(grid, events, manager, npcMan, character,
				textManager, inventory);
		
		this.dialogue = new Dialogue(this, DialogueText.beginningScene());
		
		setBackgroundMusic(new Music("res/harmony.wav"));
		getBackgroundMusic().loop(1, 100);
		overlay = Artist.QuickLoad("Overlay");
		player = new Player(inventory, character);
		fightMusic  = new Music("res/sound/blinded.wav");
		
		this.cutscene = new Cutscene(this);
		this.battleScene3 = 1;
	}

	public TextManager getTextManager() {
		return textManager;
	}

	public void setTextManager(TextManager textManager) {
		this.textManager = textManager;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public void Update() {
		switch (state) {
		case GAME:
			if(!musicFlag){
				musicFlag = true;

				try {
					setBackgroundMusic(new Music("res/harmony.wav"));
				} catch (SlickException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				getBackgroundMusic().loop(1, 100);
				
			}

			Draw();
			

			if ((Keyboard.isKeyDown(Keyboard.KEY_SPACE))) {
				Artist.DrawQuadTex(overlay, 0, 0, 1024, 1024);
				character.setLevel(15);

			}

			break;
		case PVE:
			if(musicFlag){
				setBackgroundMusic(fightMusic);
				getBackgroundMusic().loop(1, 50);
				musicFlag = false;
			}
			GL11.glClearColor(1.0f, 1.0f, 1.0f, 0.0f);
			// backgroundMusic.pause();
			fight.Update(battleScene3);
			break;
		case DIALOGUE:

			Draw();
			character.setPaused(true);
			dialogue.Update();

			break;
		case CUTSCENE:

			GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
			dialogue.setDialogueText(dialogueText);
			cutscene.Update(npcMan);
			Artist.DrawQuadTex(cutsceneObject, 0, 0, 1024, 1024);
			
			
			break;
		}

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

	public void setBackgroundMusic(Music music) {
		this.backgroundMusic = music;
	}

	public void setGrid(TileGrid grid) {
		this.grid = grid;
	}

	public void setPaused(Boolean b) {
		character.setPaused(b);
		npcMan.setPaused(b);

	}

	private void Draw() {

		inventory.Update();
		player.Update();
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

	public int getBattleScene3() {
		return battleScene3;
	}

	public void setBattleScene3(int battleScene3) {
		this.battleScene3 = battleScene3;
	}

}
