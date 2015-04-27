package helpers;

import game.Events;
import game.GameCharSprite;
import game.Inventory;
import game.NPCmanager;
import game.ObjectManager;
import game.TextManager;
import game.TileGrid;

public class ConsoleParser {
	private TileGrid grid;
	private GameCharSprite character;
	private ObjectManager manager;
	private Events events;
	private TextManager textManager;
	private NPCmanager npcMan;
	private Inventory inventory;
	private GameMap map;

	public GameMap getMap() {
		return map;
	}

	public void setMap(GameMap map) {
		this.map = map;
	}

	private String lastCommand = "";

	public void setStuff(TileGrid grid2, Events events2,
			ObjectManager manager2, NPCmanager npcMan2,
			GameCharSprite character2, TextManager textManager2, Inventory gui2) {

		this.textManager = textManager2;
		this.character = character2;
		this.manager = manager2;
		this.events = events2;
		this.npcMan = npcMan2;
		this.grid = grid2;
		this.inventory = gui2;
	}

	public TileGrid getGrid() {
		return grid;
	}

	public void setGrid(TileGrid grid) {
		this.grid = grid;
	}

	public GameCharSprite getCharacter() {
		return character;
	}

	public void setCharacter(GameCharSprite character) {
		this.character = character;
	}

	public ObjectManager getManager() {
		return manager;
	}

	public void setManager(ObjectManager manager) {
		this.manager = manager;
	}

	public Events getEvents() {
		return events;
	}

	public void setEvents(Events events) {
		this.events = events;
	}

	public TextManager getTextManager() {
		return textManager;
	}

	public void setTextManager(TextManager textManager) {
		this.textManager = textManager;
	}

	public NPCmanager getNpcMan() {
		return npcMan;
	}

	public void setNpcMan(NPCmanager npcMan) {
		this.npcMan = npcMan;
	}

	public Inventory getinventory() {
		return inventory;
	}

	public void setinventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public String getLastCommand() {
		return lastCommand;
	}

	public void setLastCommand(String lastCommand) {
		this.lastCommand = lastCommand;
	}

	public ConsoleParser() {

	}

	public void receiveCommand(String command) {
		lastCommand = command;
		// System.out.println(lastCommand);
		switch (command) {
		case "godmode":
			character.setHealth(1000000000);
			break;
		case "hardmode":
			character.setHealth(-1);
			break;
		case "setSpeedFast":
			character.setSpeed(300);
			
			break;
		case "setSpeedNormal":
			character.setSpeed(100);
			break;
		case "setLevel1":
			character.setLevel(1);
			break;
		case "setLevel2":
			character.setLevel(2);
			break;
		case "setLevel3":
			character.setLevel(3);
			break;
		case "setLevel4":
			character.setLevel(4);
			break;
		case "setLevel5":
			character.setLevel(5);
			break;
		case "setLevel6":
			character.setLevel(6);
			break;

		}

	}

}
