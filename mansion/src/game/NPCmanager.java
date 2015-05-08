package game;

import game.Game.State;

public class NPCmanager {
	private GameCharSprite character;
	private TileGrid grid;
	private CollisionGrid collide;
	private ObjectManager manager;
	private int Entrance1 = 0, Entrance2 = 1, LivingRoom1 = 2, LivingRoom2 = 3,
			LivingRoom3 = 4, LivingRoom4 = 5, LivingRoom5 = 6;
	private boolean first = true;
	private NPC npc1;
	private NPC npc2;
	private NPC npc3;
	private boolean paused = false;
	private Game game;
	private boolean first2 = true;
	private NPC cary;
	private boolean caryBool = true;
	private boolean CaryTalkScene = true;

	public boolean isPaused() {
		return paused;
	}

	public void setPaused(boolean paused) {
		this.paused = paused;
	}

	public NPCmanager(GameCharSprite character, TileGrid grid,
			CollisionGrid collide, ObjectManager manager, Game game) {
		this.character = character;
		this.grid = grid;
		this.collide = collide;
		this.manager = manager;
		this.game = game;
	}

	public NPC createNPC(int level, GameCharSprite character, String file,
			float x, float y, int health) {
		switch (level) {
		case 0:

			NPC robot = new NPC(file, character, collide, 64, 64, grid.getTile(
					(int) x, (int) y), grid, 64, 64, 30, health, collide);
			// NPC robot2 = new NPC(file,character,collide, 64, 64,
			// grid.getTile((int)x+1, (int)y+1), grid, 64, 64, 30, health,
			// collide);

			return robot;

		case 1:

			NPC robot1 = new NPC(file, character, collide, 64, 64,
					grid.getTile((int) x, (int) y), grid, 64, 64, 30, health,
					collide);

			return robot1;
		case 2:

			break;
		case 3:

			break;
		case 4:

			break;
		case 5:

			break;
		case 6:

			break;

		}
		return null;

	}

	public void Update() {
		if (character.getLevel() == 100) { // Entrance2 == 1
			if (character.isPaused() == true) {
				if (first2) {

					cary = createNPC(1, character, "res/redirect.png", 5, 4,
							100);
					first2 = false;
				}
				cary.setDirection(2);
				cary.Update2(caryBool);
				if (cary.getYInt() == 12) {
					caryBool = false;
					if (CaryTalkScene) {
						game.setState(State.DIALOGUE);
						CaryTalkScene = false;
					}
					System.out.println(game.getState());
					if(!CaryTalkScene){
						
					}
				}
			}

		}

		if (character.getLevel() == Entrance1) { // Entrance1 == 0
			if (first) {
				// npc1 = new NPC("res/redirect.png",character,collide, 64, 64,
				// grid.getTile(6,6), grid, 64, 64, 30, 100, collide);
				npc2 = createNPC(1, character, "res/redirect.png", 6, 6, 100);
				// npc2 = new NPC("res/redirect.png",character,collide, 64, 64,
				// grid.getTile(0,0), grid, 64, 64, 30, 100, collide);
				first = false;
			}
			// npc1.Update(paused );
			npc2.Update(paused);
		}
		if (character.getLevel() == Entrance2) { // Entrance2 == 1
			// npc2.Update(paused );

		}
		if (character.getLevel() == LivingRoom1) { // LivingRoom1 == 2

		}
		if (character.getLevel() == LivingRoom2) { // LivingRoom2 == 3

		}
		if (character.getLevel() == LivingRoom3) { // LivingRoom3 == 4

		}
		if (character.getLevel() == LivingRoom4) { // LivingRoom4 == 5

		}
		if (character.getLevel() == LivingRoom5) { // LivingRoom5 == 6

		}

	}

}
