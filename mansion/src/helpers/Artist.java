package helpers;

//import org.newdawn.slick.opengl.*;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex2f;
import game.TileGrid;

import java.io.IOException;
import java.io.InputStream;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Artist {

	public static final int 
	WIDTH = TileGrid.ROW * TileGrid.tileSize,
	HEIGHT = TileGrid.COLUMN * TileGrid.tileSize,
	GUI = 300;

	public static final void BeginSession() {

		try {
			Display.setDisplayMode(new DisplayMode(WIDTH + GUI, HEIGHT));
			Display.setTitle("Mystery Mansion of Forgotten Sorrows");
			Display.create();
			Display.setVSyncEnabled(true);
		} catch (LWJGLException e) {

			e.printStackTrace();
			Display.destroy();
			System.exit(1);
		}
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glShadeModel(GL11.GL_SMOOTH);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDisable(GL11.GL_LIGHTING);

		GL11.glClearColor(0.1f, 0.1f, 0.0f, 0.0f);
		GL11.glClearDepth(1);

		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

		GL11.glViewport(0, 0, WIDTH+GUI, HEIGHT);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);

		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, WIDTH+GUI, HEIGHT, 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);

		// glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		// glClearDepth(1);
	}

	public static void DrawQuad(float x, float y, float width, float height) {
		glBegin(GL_QUADS);
		glVertex2f(x, y); // top left
		glVertex2f(x + width, y); // top right
		glVertex2f(x + width, y + height); // bottom left
		glVertex2f(x, y + height); // bottom right

		glEnd();

	}

	public static void DrawQuadTex(Texture tex, float x, float y, float width,
			float height) {

		tex.bind();
		glTranslatef(x, y, 0);
		glBegin(GL_QUADS);

		glTexCoord2f(0, 0); // top left
		glVertex2f(0, 0);

		glTexCoord2f(1, 0); // top right
		glVertex2f(width, 0);

		glTexCoord2f(1, 1); // bottom right
		glVertex2f(width, height);

		glTexCoord2f(0, 1); // bottom left
		glVertex2f(0, height);

		glEnd();
		glLoadIdentity();
	}

	public static void DrawQuadTexRotate(Texture tex, float x, float y,
			float width, float height, float angle) {

		tex.bind();
		glTranslatef(x + width / 2, y + height / 2, 0);
		glRotatef(angle, 0, 0, 1);
		glTranslatef(-width / 2, -height / 2, 0);
		glBegin(GL_QUADS);

		glTexCoord2f(0, 0); // top left
		glVertex2f(0, 0);

		glTexCoord2f(1, 0); // top right
		glVertex2f(width, 0);

		glTexCoord2f(1, 1); // bottom right
		glVertex2f(width, height);

		glTexCoord2f(0, 1); // bottom left
		glVertex2f(0, height);

		glEnd();
		glLoadIdentity();
	}

	public static Audio LoadAudio(String path, String fileType) {
		Audio aud = null;
		InputStream in = ResourceLoader.getResourceAsStream(path);
		try {
			aud = AudioLoader.getAudio(fileType, in);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return aud;
	}

	public static Texture LoadTexture(String path, String fileType) {
		Texture tex = null;

		try {
			InputStream in = ResourceLoader.getResourceAsStream(path);
			tex = TextureLoader.getTexture(fileType, in);
		} catch (IOException e) {
			//e.printStackTrace();
		}

		return tex;

	}

	public static Texture QuickLoad(String name) {
		Texture tex = null;
		tex = LoadTexture("res/" + name + ".png", "PNG");
		return tex;

	}

	public static Audio QuickLoadAud(String name) {
		Audio aud = null;
		aud = LoadAudio("res/" + name + ".wav", "WAV");
		return aud;

	}

}
