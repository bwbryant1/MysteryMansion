package game;

import static helpers.Artist.QuickLoad;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;
import game.Boot.State;
import helpers.Artist;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.Texture;

public class Menu  {

	private Texture background;
	private Music backgroundNoise;
	private TextManager textManager;
	private GameObj cat1, cat2, cat3;
	private GameObj cat4, cat6, cat7, cat8, cat9, cat10;
	private GameObj cat5;
	public static boolean notPaused = true;
	public static long currentTime = System.currentTimeMillis();
	public static long currentTime2 = System.currentTimeMillis();

	public Menu() throws SlickException, LWJGLException {
		Display.setDisplayMode(new DisplayMode(Artist.WIDTH, Artist.HEIGHT));

		background = QuickLoad("background");
		setBackgroundNoise(new Music("res/Thunder.ogg"));
		getBackgroundNoise().setVolume((float) 1.0);
		getBackgroundNoise().loop();
		
		//grid = new TileGrid(Map.createMap(20, 10));
		cat1 = new GameObj(QuickLoad("cat64_2"), 640, 32, -50, 0);
		cat2 = new GameObj(QuickLoad("cat64_2"), 640, 32, -100, 64);
		cat3 = new GameObj(QuickLoad("cat64_2"), 640, 32, -150, 128);
		cat4 = new GameObj(QuickLoad("cat64_2"), 640, 32, -50, 192);
		cat5 = new GameObj(QuickLoad("cat64_2"), 640, 32, -100, 256);
		cat6 = new GameObj(QuickLoad("cat64_2"), 640, 32, -150, 320);

		cat7 = new GameObj(QuickLoad("cat64_2"), 640, 32, -50, 384);
		cat8 = new GameObj(QuickLoad("cat64_2"), 640, 32, -100, 448);
		cat9 = new GameObj(QuickLoad("cat64_2"), 640, 32, -150, 512);
		cat10 = new GameObj(QuickLoad("cat64_2"), 640, 32, -150, 576);
		textManager = new TextManager();

		
	}

	public void Update() {
		Artist.DrawQuadTex(background,0,0,1050,1050);
		long RunTime = (int) (((int) (System.currentTimeMillis() - currentTime) * 0.001) * 100);
		long RunTime2 = (int) (((int) (System.currentTimeMillis() - currentTime2) * 0.001) * 40);
		int constant = 400;
		//grid.Update();
		//grid.Draw();
		cat1.Draw();
		cat1.setX(RunTime2 - 200-constant);
		cat2.Draw();
		cat2.setX(RunTime - 650-constant);
		cat3.Draw();
		cat3.setX(RunTime - 225-constant);
		cat4.Draw();
		cat4.setX(RunTime2 - 450-constant);
		cat5.Draw();
		cat5.setX(RunTime - 610-constant);
		cat6.Draw();
		cat6.setX(RunTime2 - 640-constant);
		cat7.Draw();
		cat7.setX(RunTime - 900-constant);
		cat8.Draw();
		cat8.setX(RunTime2 - 500-constant);
		cat9.Draw();
		cat9.setX(RunTime - 100-constant);
		cat10.Draw();
		cat10.setX(RunTime - 1050-constant);

		if (RunTime > 2200) {
			currentTime = System.currentTimeMillis();

		}
		if (RunTime2 > 2000) {
			currentTime2 = System.currentTimeMillis();

		}
		textManager.callText(0);
		// System.out.println(((int)(System.currentTimeMillis()-currentTime)*0.001)*50);

	}

	public void check() throws LWJGLException {

		if (Keyboard.isKeyDown(Keyboard.KEY_RETURN)) {

			// System.out.println("yes");
			Display.setDisplayMode(new DisplayMode(Artist.WIDTH + Artist.GUI,
					Artist.HEIGHT));
			Boot.setState(State.GAME);

		}
	}

	public void check2() throws LWJGLException {

		if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {

			// System.out.println("yes");

			Boot.setState(State.MAIN_MENU);
			glClear(GL_COLOR_BUFFER_BIT);
			Display.setDisplayMode(new DisplayMode(Artist.WIDTH, Artist.HEIGHT));
			//grid.Draw();
			//grid.Update();
		}
	}

	public static boolean isNotPaused() {
		return notPaused;
	}

	public static void setPaused(boolean paused) {
		Game.notPaused = paused;
	}

	public Music getBackgroundNoise() {
		return backgroundNoise;
	}

	public void setBackgroundNoise(Music backgroundNoise) {
		this.backgroundNoise = backgroundNoise;
	}


}
