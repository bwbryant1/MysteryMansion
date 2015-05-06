package game;

import static helpers.Artist.QuickLoad;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;

import game.FightManager.State;
import helpers.Artist;

public class Dialogue {

	private Game game;
	private boolean wasPressed = true;
	private int dialogue_index = 0;
	private static String[] dialogueText;
	private static Texture dialogueBox = QuickLoad("dialogue");
	private static TextString dialogue ;
	private static String dialogueTextString = " test";
	private static TextManager text;
	private boolean first = true;

	public Dialogue(Game game, String[] dialogueText) {
		this.game = game;
		this.text = new TextManager();

	this.dialogueText = dialogueText;
}

	public static String[] getDialogueText() {
		return dialogueText;
	}

	public static void setDialogueText(String[] dialogueText) {
		Dialogue.dialogueText = dialogueText;
	}

	public void Update() {
		if (Keyboard.isKeyDown(Keyboard.KEY_RETURN)) {

			if (wasPressed) {
				System.out.println(dialogue_index);
				dialogueTextString = 
						("" + dialogueText[dialogue_index]);
				if (dialogue_index + 1 < dialogueText.length) {
					dialogue_index++;
				}
				if (dialogueText[dialogue_index].equals("")) {
					game.setPaused(false);
					game.setState(game.state.GAME);
			}
			}
			wasPressed = false;
		} else {
			
				wasPressed = true;
		}
		if (first) {
			dialogueTextString = "< press enter >";
			first = false;
			
		}
		Draw();

		

		
			//System.out.println(dialogueTextString);

	}
	private static void Draw(){
		Artist.DrawQuadTex(dialogueBox , 0, TileGrid.COLUMN * TileGrid.tileSize
				- 128, 448 * 2 + 64, 128);
		text.setText(text.getText(4), dialogueTextString, 50, TileGrid.COLUMN
				* TileGrid.tileSize - 100, Color.black);
		text.callText(4);
		
	}
}
