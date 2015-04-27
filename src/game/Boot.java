package game;

import static helpers.Artist.*;
import static org.lwjgl.opengl.GL11.*;

import java.net.MalformedURLException;

import helpers.Artist;
import helpers.Clock;
import helpers.ConsoleParser;
import helpers.GameMap;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.openal.AL;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.Color;
import org.newdawn.slick.SlickException;

public class Boot {

	public enum State {
		INTRO, GAME, MAIN_MENU, PAUSED;
	}

	public static State state = State.MAIN_MENU;
	public static TextString paused;

	public static State getState() {
		return state;
	}

	public static void setState(State state) {
		Boot.state = state;
	}

	public static void main(String[] args) throws SlickException, LWJGLException, MalformedURLException {
		ConsoleParser parser = new ConsoleParser();
		new Boot(parser);
		
	}

	private boolean first=true;
	private boolean GameMapVisible=true;
	private boolean first2= true;
	private ConsoleParser parser;

	public Boot(ConsoleParser parser2) throws SlickException, LWJGLException, MalformedURLException {
		parser = parser2;
		GameMap map = new GameMap(parser);
		
		map.setVisible(false);
		
		BeginSession();
		
		
		Game game = new Game(Map.Entrance1(),parser);
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
				if (Keyboard.isKeyDown(Keyboard.KEY_M)) {
					if(GameMapVisible){
					map.setVisible(true);
					//GameMapVisible = false;

					}
					if(!GameMapVisible){
						map.setVisible(false);
						GameMapVisible = true;
						//state = State.GAME;
						}
					
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
				//map.setVisible(false);
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