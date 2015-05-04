package game;

import static helpers.Artist.QuickLoad;

import org.newdawn.slick.opengl.Texture;

import helpers.Artist;

public class Dialogue {
	private GameCharSprite character;
	private Events events;
	private ObjectManager manager;
	private Inventory inventory;
	private NPCmanager npcMan;
	private Game game;
	private static String[] dialogueText;
	private static Texture dialogueBox = QuickLoad("dialogue");

	public Dialogue(GameCharSprite character, Events events, ObjectManager manager, Inventory inventory, NPCmanager npcMan, Game game) {
	this.character = character;
	this.events = events;
	this.manager = manager;
	this.inventory = inventory;
	this.npcMan = npcMan;
	this.game = game;
	this.dialogueText = DialogueText.beginningScene();
}

	public static String[] getDialogueText() {
		return dialogueText;
	}

	public static void setDialogueText(String[] dialogueText) {
		Dialogue.dialogueText = dialogueText;
	}

	public void Update() {
		Draw();

	}
	private static void Draw(){
		Artist.DrawQuadTex(dialogueBox , 0, TileGrid.COLUMN * TileGrid.tileSize
				- 128, 448 * 2 + 64, 128);
	}
}
