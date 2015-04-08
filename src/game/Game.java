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
	public static boolean notPaused = true;
	

	

	public Game(int[][] map) throws SlickException {
		this.textManager = new TextManager();
		this.setGrid(new TileGrid(map));
		this.collide = new CollisionGrid(CollideMaps.Entrance1());
		
		
		
		this.character = new GameCharSprite("res/redirect.png", 64, 64, getGrid().getTile(2, 2), getGrid(), 64, 64, 160,100,textManager, collide);
		
		
		this.manager = new ObjectManager(character);
		this.events = new  Events(character, getGrid(),textManager,manager, collide);
		overlay = Artist.QuickLoad("Overlay");
		
		
				
		
			
		
		 
		
		//player = new Player(grid);
	}

	public void Update() {
		
		getGrid().Update();
		getGrid().Draw();
		events.Update();
		
		manager.Update();
		
		character.Draw();
		
		character.Update();
		//events.Update();
		if ((Keyboard.isKeyDown(Keyboard.KEY_SPACE))) {
			Artist.DrawQuadTex(overlay, 0, 0, 1024, 1024);
		}
		
		

		
		
		//character.Update();
		
		//player.Update();

	}

	public static boolean isNotPaused() {
		return notPaused;
	}

	public static void setPaused(boolean paused) {
		Game.notPaused = paused;
	}

	public TileGrid getGrid() {
		return grid;
	}

	public void setGrid(TileGrid grid) {
		this.grid = grid;
	}
}
