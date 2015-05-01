package game;

import static helpers.Artist.QuickLoad;
import helpers.Artist;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;

public class FightManager {

	private GameCharSprite character;
	private Inventory inventory;
	private Texture dialogue;
	private Texture enemyTex;
	private Texture playerTex;
	private TextManager text;
	private String dialogueText;
	private boolean first = true;
	private Texture enemyStatus;
	private Texture playerStatus;

	public FightManager(GameCharSprite character, Inventory inventory,
			TextManager textManager) {
		this.text = textManager;
		this.character = character;
		this.inventory = inventory;
		load();
	}

	public void Update() {
		
		// Game.state = Game.state.GAME;
		if ((Keyboard.isKeyDown(Keyboard.KEY_SPACE))) {
			setDialogue("test");
			
			
		}
		Draw();
		Dialogue();
		
	}

	public String getDialogue() {
		return dialogueText;
	}

	public void setDialogue(String dialogue) {
		this.dialogueText = dialogue;
	}

	private void Draw() {
		Artist.DrawQuadTex(playerTex,100, 400-10, 128, 128);
		Artist.DrawQuadTex(dialogue, 0, TileGrid.COLUMN * TileGrid.tileSize
				- 128, 448 * 2 + 64, 128);
		Artist.DrawQuadTex(enemyTex, 700, 50, 128, 128);
		Artist.DrawQuadTex(enemyStatus, 10, 50, 256, 128);
		Artist.DrawQuadTex(playerStatus, 700-80, 400-10, 256, 128);
		
	}

	private void Dialogue() {
		if (first) {
		//	dialogueText = "You prepare for battle..";
			first = false;
		}
	/*	text.setText(text.getText(0), dialogueText, 50, TileGrid.COLUMN
				* TileGrid.tileSize - 100, Color.black);*/
		text.callText(4);

	}

	private void attack() {

	}

	private int attackHit() {
		int attackDamage = 0;
		return attackDamage;
	}

	private void load() {
		dialogue = QuickLoad("dialogue");
		enemyTex = QuickLoad("enemy");
		playerTex = QuickLoad("enemy");
		enemyStatus = QuickLoad("status");
		playerStatus  = QuickLoad("status");
		
	}
}
