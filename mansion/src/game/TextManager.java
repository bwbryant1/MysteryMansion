package game;

import java.util.ArrayList;

import org.newdawn.slick.Color;

public class TextManager {

	public static ArrayList<TextString> textCall;
	private static TextString Paused;
	private static TextString Title;
	private static TextString CombatDialogue;
	private static TextString playerLevel, exp;
	private static TextString Level, Health;
	private static TextString enemyHealth, enemyLevel, enemyExp,enemyName;
	private TextString playerName;
	private static TextString Enter;

	public TextManager() {
		textCall = new ArrayList<TextString>();
		makeTextStrings();

	}

	public void callText(int index) {

		textCall.get(index).Update();

	}

	public TextString getText(int index) {

		return textCall.get(index);

	}

	private void makeTextStrings() {

		Level = new TextString(750, 250, "test", Color.red, 1);
		playerLevel = new TextString(750, 250, "test", Color.red, 1);
		playerName = new TextString(750, 250, "test", Color.red, 1);
		exp = new TextString(750, 250, "test", Color.red, 1);
		Health = new TextString(300, 300, "test", Color.red, 3);
		Paused = new TextString(640 / 2, 640 / 2, "PAUSED", Color.blue, 1);
		Title = new TextString(60, 640 / 2,
				"Mystery Mansion of Forgotten Sorrows", Color.red, 1);
		Enter = new TextString(60, 640 / 2,
				"press enter", Color.red, 2);
		CombatDialogue = new TextString(60, 60, "A wild cary appears",
				Color.black, 1);

		enemyHealth = new TextString(750, 250, "test", Color.red, 1);
		enemyLevel = new TextString(750, 250, "test", Color.red, 1);
		enemyExp = new TextString(750, 250, "test", Color.red, 1);
		enemyName = new TextString(750, 250, "test", Color.red, 1);
		
		textCall.add(Title);
		textCall.add(Paused);
		textCall.add(Health);
		textCall.add(Level);
		textCall.add(CombatDialogue);
		textCall.add(playerLevel);
		textCall.add(playerName);
		textCall.add(exp);
		textCall.add(enemyHealth);
		textCall.add(enemyLevel);
		textCall.add(enemyExp);
		textCall.add(enemyName);
		textCall.add(Enter);

		
		
/*		textCall[3] = Level;
		textCall[4] = CombatDialogue;
		textCall[5] = playerLevel;
		textCall[6] = playerName;
		textCall[7] = exp;
		textCall[8] = enemyHealth;
		textCall[9] = enemyLevel;
		textCall[10] = enemyExp;
		textCall[11] = enemyName;
		textCall[20] = Title;
		textCall[21] = Enter;*/

	}

	public void setText(TextString text, String string, int x, int y,
			Color color) {
		text.setText(string, x, y, color);

	}
}
