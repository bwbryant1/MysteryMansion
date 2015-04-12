package game;

import org.newdawn.slick.Color;

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

	public NPCmanager(GameCharSprite character, TileGrid grid,
			CollisionGrid collide, ObjectManager manager) {
		this.character = character;
		this.grid = grid;
		this.collide = collide;
		this.manager = manager;
	}

	public void Update() {
		
		if (character.getLevel() == Entrance1) { // Entrance1 == 0
			if(first ){
				npc1 = createNPC(0, character, "res/redirect.png", 2, 2, 100);
				
				first = false;
			}
			npc1.Update();
		}
		if (character.getLevel() == Entrance2) { // Entrance2 == 1

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

	public NPC createNPC(int level,GameCharSprite character,String file,float x, float y,int health) {
		switch (level) {
		case 0:
			
			NPC robot = new NPC(file,character,collide, 64, 64, grid.getTile((int)x, (int)y), grid, 64, 64, 30, health, collide);
			
			return robot;

			
		case 1:

			break;
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

}
