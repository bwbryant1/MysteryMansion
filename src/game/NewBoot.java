package game;

import static helpers.Artist.*;
import static org.lwjgl.opengl.GL11.*;
import helpers.Artist;
import helpers.Clock;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.openal.AL;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.SlickException;

public class NewBoot {

	public enum State {
		INTRO, GAME, MAIN_MENU, PAUSED;
	}

	public static State state = State.GAME;
	public static TextString paused;

	public static State getState() {
		return state;
	}

	public static void setState(State state) {
		NewBoot.state = state;
	}

	public static void main(String[] args) throws SlickException, LWJGLException {
		
		new NewBoot();
	}

	private Tile console;
	private boolean isStarted=false;
	private boolean first=true;

	public NewBoot() throws SlickException, LWJGLException {

		BeginSession();
		
		Game game = new Game(Map.Entrance1());
		Menu menu = new Menu();
		
		//Color.white.bind();
		while (!Display.isCloseRequested()) {
			while (Keyboard.next()) {
				if (Keyboard.isKeyDown(Keyboard.KEY_P)) {
					if (state == State.GAME)
						state = State.PAUSED;

					else if (state == State.PAUSED)
						state = State.GAME;

				}
			}

			switch (state) {
			case INTRO:
				// playIntro();
				break;
			case MAIN_MENU:
				glClear(GL_COLOR_BUFFER_BIT);
				Clock.Update();
				menu.Update();
				menu.check();
				break;
			case GAME:
				menu.getBackgroundNoise().stop();
				glClear(GL_COLOR_BUFFER_BIT);
				if(first){
					Display.setDisplayMode(new DisplayMode(Artist.WIDTH+GUI, Artist.HEIGHT));
					game.getGrid().setGrid(Map.Entrance1());
					
					
					first = false;
				}
				Clock.Update();
				game.Update();
				menu.check2();

				break;
			case PAUSED:
				//menu.check();
				menu.check2();
				paused = new TextString(300, 300, "PAUSED", Color.yellow);
				
				//paused.makeString();
				paused.Update();
				
				
				break;

			}

			Display.update();
			Display.sync(60);

		}

		Display.destroy();
		AL.destroy();
		System.exit(0);
	}
}