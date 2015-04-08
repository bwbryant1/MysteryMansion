package game;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;
import helpers.Artist;
import static helpers.Artist.*;

import java.awt.Font;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.opengl.Texture;

public class Events {

	private GameCharSprite character;
	private ObjectManager manager;
	private TileGrid grid;
	private TextManager textManager;
	private int levelX = 650, levelY = 50;
	private int Entrance1 = 0, Entrance2 = 1, LivingRoom1 = 2, LivingRoom2 = 3,
			LivingRoom3 = 4, LivingRoom4 = 5, LivingRoom5 = 6;
	private Texture stairs;
	private Texture stairs2;
	private CollisionGrid collide;

	// private static TextString text;

	public Events(GameCharSprite character, TileGrid grid,
			TextManager textManager,ObjectManager manager, CollisionGrid collide) {

		this.character = character;
		this.grid = grid;
		this.textManager = textManager;
		this.manager = manager;
		this.collide = collide;
		
	}

	public void Update() {
		//System.out.println((Artist.WIDTH - character.getX()-1)/32);

		if (character.getLevel() == Entrance1) { // Entrance1 == 0
			// System.out.println("Level is 0");
			textManager.setText(textManager.getText(0), "Entrance 1", levelX,
					levelY, Color.red);
			textManager.callText(0);
			Entrance1();
			manager.Entrance1();
			

		}
		if (character.getLevel() == Entrance2) { // Entrance2 == 1
			// System.out.println("Level is 1");
			textManager.setText(textManager.getText(0), "Entrance 2", levelX,
					levelY, Color.red);
			textManager.callText(0);
			Entrance2();
			manager.Entrance2();

		}
		if (character.getLevel() == LivingRoom1) { // LivingRoom1 == 2
			// text();System.out.println("Level is 2");
			LivingRoom1();
			textManager.setText(textManager.getText(0), "LivingRoom 1", levelX,
					levelY, Color.red);
			textManager.callText(0);
			
		}
		if (character.getLevel() == LivingRoom2) {
			// System.out.println("Level is 3");
			LivingRoom2();
			textManager.setText(textManager.getText(0), "LivingRoom2", levelX,
					levelY, Color.red);
			textManager.callText(0);

		}
		if (character.getLevel() == LivingRoom3) {
			// System.out.println("Level is 3");
			LivingRoom3();
			textManager.setText(textManager.getText(0), "LivingRoom3", levelX,
					levelY, Color.red);
			textManager.callText(0);

		}
		if (character.getLevel() == LivingRoom4) {
			// System.out.println("Level is 3");
			LivingRoom4();
			textManager.setText(textManager.getText(0), "LivingRoom 4", levelX,
					levelY, Color.red);
			textManager.callText(0);

		}
		if (character.getLevel() == LivingRoom5) {
			// System.out.println("Level is 3");
			LivingRoom5();
			textManager.setText(textManager.getText(0), "LivingRoom 5", levelX,
					levelY, Color.red);
			textManager.callText(0);
			LivingRoom5();

		}

	}

	private void Entrance2() {
		
		if (character.getXInt() == 0) {
			// System.out.println("events");
			grid.setGrid(Map.Entrance1());
			character.setX(500);
			character.setLevel(Entrance1);
			collide.setGrid(CollideMaps.Entrance1());

		}

	}

	private void Entrance1() {
		//collide.setGrid(CollideMaps.Entrance1());
		if (character.getXInt() == 27) {

			grid.setGrid(Map.Entrance2());
			character.setX(50);
			character.setLevel(Entrance2);
			collide.setGrid(CollideMaps.Entrance2());
		}
		
		if (character.getXInt() == 0
				&& (character.getYInt() == 13 ||character.getYInt() == 12 || character.getYInt() == 11  )) {

			grid.setGrid(Map.LivingRoom1());
			character.setX(550);
			character.setLevel(LivingRoom1);
			collide.setGrid(CollideMaps.LivingRoom1());
		}

	}

	private void LivingRoom1() {
		
		if (character.getXInt() == 27
				&& (character.getYInt() == 12 || character.getYInt() == 11 || character
						.getYInt() == 13)) {
			// System.out.println("events");
			grid.setGrid(Map.Entrance1());
			character.setX(50);
			character.setLevel(Entrance1);
			collide.setGrid(CollideMaps.Entrance1());

		}
		if (character.getXInt() == 0) {
			// System.out.println("events");
			grid.setGrid(Map.LivingRoom2());
			character.setX(550);
			character.setLevel(LivingRoom2);
			collide.setGrid(CollideMaps.LivingRoom2());

		}

	}

	private void LivingRoom2() {

		if (character.getXInt() == 27) {
			// System.out.println("events");
			grid.setGrid(Map.LivingRoom1());
			character.setX(64);
			character.setLevel(LivingRoom1);

		}
		if (character.getXInt() == 0) {
			// System.out.println("events");
			grid.setGrid(Map.LivingRoom3());
			character.setX(550);
			character.setLevel(LivingRoom3);

		}
		if (character.getYInt() == 0) {
			// System.out.println("events");
			grid.setGrid(Map.LivingRoom5());
			character.setY(540);
			character.setLevel(LivingRoom5);

		}

	}

	private void LivingRoom3() {

		if (character.getYInt() == 0) {
			// System.out.println("events");
			grid.setGrid(Map.LivingRoom4());
			character.setY(540);
			character.setLevel(LivingRoom4);

		}

		if (character.getXInt() == 27) {
			// System.out.println("events");
			grid.setGrid(Map.LivingRoom2());
			character.setX(64);
			character.setLevel(LivingRoom2);

		}

	}

	private void LivingRoom4() {
		if (character.getYInt() == 17) {
			// System.out.println("events");
			grid.setGrid(Map.LivingRoom3());
			character.setY(50);
			character.setLevel(LivingRoom3);

		}
		if (character.getXInt() == 27) {
			// System.out.println("events");
			grid.setGrid(Map.LivingRoom5());
			character.setX(50);
			character.setLevel(LivingRoom5);

		}

	}

	private void LivingRoom5() {
		if (character.getYInt() == 17) {
			// System.out.println("events");
			grid.setGrid(Map.LivingRoom2());
			character.setY(50);
			character.setLevel(LivingRoom2);

		}
		if (character.getXInt() == 0) {
			// System.out.println("events");
			grid.setGrid(Map.LivingRoom4());
			character.setX(550);
			character.setLevel(LivingRoom4);

		}

	}
	private boolean findNextT() {

		if (collide.getTile((int) character.getX()/16, (int) character.getY()/16+1).canCollide()) {
			{
				System.out.println("Top");
				return true;
			}
		}
		return false;

	}

	private boolean findNextB() {

		if (collide.getTile((int) character.getX()/16, (int)character.getY()/16-1).canCollide()) {
			{
				System.out.println("Bottom");
				return true;
			}
		}
		return false;

	}

	private boolean findNextL() {

		if (collide.getTile((int) character.getX()/16-1, (int) character.getY()/16).canCollide()) {
			{
				 System.out.println("Left"+character.getXInt2());
				return true;
			}
		}
		return false;

	}

	private boolean findNextR() {

		if (collide.getTile((int) character.getX()/16+1, (int) character.getY()/16).canCollide()) {
			{
				 System.out.println("Right");
				return true;
			}
		}
		return false;

	}
}
