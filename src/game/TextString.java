package game;

import java.awt.Font;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import static helpers.Clock.*;

import org.newdawn.slick.Color;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.util.ResourceLoader;

public class TextString {

	private static TrueTypeFont font;
	private static Font awtFont;
	private static int x, y;
	private static String text;
	private static Color color;

	public TextString(int x, int y, String text, Color color) {
		this.x = x;
		this.y = y;
		this.text = text;
		this.color = color;

	}

	public TextString(int x, int y, String text, Color color, int font) {

		this.x = x;
		this.y = y;
		this.text = text;
		this.color = color;
		this.awtFont = getFont(font);
		this.font = new TrueTypeFont(awtFont, false);
		
	}

	private Font getFont(int font) {
		switch(font){
		case 1:
			return awtFont = new Font("Times New Roman", Font.BOLD, 24);
		case 2:
			return awtFont = new Font("Arial", Font.BOLD, 24);
		case 3:
		{
			try {
				
				InputStream inputStream = ResourceLoader
						.getResourceAsStream("res/fonts/myfont.ttf");

				awtFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
				awtFont = awtFont.deriveFont(36f); // set font size
				return awtFont;
			

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			
		}
		return null;
	}

	public void setText(String text, int x2, int y2, Color color2) {
		TextString.text = text;
		x = x2;
		y = y2;
		color = color2;
	
	}

	public void Update() {

		font.drawString(x, y, text, color);
		Color.white.bind();

	}

	/*public void makeString() {

		// load font from a .ttf file
		try {
			Font awtFont = new Font("Times New Roman", Font.BOLD, 24);
			InputStream inputStream = ResourceLoader
					.getResourceAsStream("res/myfont.ttf");

			Font awtFont2 = Font.createFont(Font.TRUETYPE_FONT, inputStream);
			awtFont2 = awtFont2.deriveFont(36f); // set font size
			font = new TrueTypeFont(awtFont, false);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

}
