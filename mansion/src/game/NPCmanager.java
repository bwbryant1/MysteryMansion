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
	private boolean first2 = true, first3 = true;;
	private NPC cary;
	private boolean caryBool = true;
	private boolean CaryTalkScene = true;
	private boolean RenderCary = true;
	private NPC skeleton;
	private boolean first4 = true;
	private boolean fight1 = true;
	private boolean first100 = true;
	private boolean First10 = true;
	private static boolean Ballroom1 = true;
	private static boolean Ballroom2 = true;
	private NPC2 cary2;
	private boolean b = true, b2 = true;
	private boolean afterDialogue = false;
	private boolean cutsceneStarted;
	private NPC2 benedict;
	private boolean gallerySceneStarted = true;
	private boolean first5 = true;
	private NPC2 cecil;
	private boolean cecilPause = false;
	private FightManager fight;
	private boolean cecilFightStarted = false;
	private static boolean sceneStarted = false;
	private static boolean beginningScene2 = false;
	private static boolean Ballroom = true, BallroomSecond = true;

	public static boolean isSceneStarted(int scene) {
		switch (scene) {
		case 0:
			return sceneStarted;

		case 1:
			return beginningScene2;
		case 2:
			return Ballroom;

		}
		return false;
	}

	public static void setSceneStarted(boolean sceneStarted, int scene) {
		switch (scene) {
		case 0:
			NPCmanager.sceneStarted = sceneStarted;
			break;
		case 1:
			NPCmanager.beginningScene2 = sceneStarted;
			break;
		case 2:
			NPCmanager.Ballroom = sceneStarted;
			break;
		case 3:
			NPCmanager.BallroomSecond = sceneStarted;
			break;
		}

	}

	public boolean isPaused() {
		return paused;
	}

	public void setPaused(boolean paused) {
		this.paused = paused;
	}

	public NPCmanager(GameCharSprite character, TileGrid grid,
			CollisionGrid collide, ObjectManager manager, FightManager fight,
			Game game) {
		this.character = character;
		this.grid = grid;
		this.collide = collide;
		this.manager = manager;
		this.game = game;
		this.fight = fight;
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

	public NPC2 createNPC2(int level, GameCharSprite character, String file,
			float x, float y, int health) {

		NPC2 robot1 = new NPC2(file, character, collide, 64, 64, grid.getTile(
				(int) x, (int) y), grid, 64, 64, 30, health, collide);
		return robot1;

	}

	public void Update() {
		
		if(character.getLevel() == Events.Artgallery1 && !cutsceneStarted){
			if(gallerySceneStarted ){
				if(first5 ){
					cecil = createNPC2(1, character, "res/images/cecilL.png", 5, 5, 100);
					cecil.setSprite("cecil");
					cecil.setDirection(2);
					first5 = false;
					
				}
				if(Math.abs(cecil.getX()-character.getX())<75 && Math.abs(cecil.getY()-character.getY())<75){
					game.setDialogue(new Dialogue(game, DialogueText.artGalleryScene()));
					game.setState(State.DIALOGUE);
					gallerySceneStarted = false;
					cecilPause = true;
					
				}
				//cecil.Update(cecilPause );
				
			}
			if(!gallerySceneStarted && game.getState() == State.GAME && !cecilFightStarted){
				//fight = new FightManager(character, game.getInventory(), game.getTextManager());
				game.setBattleScene3(2);
				//fight = new FightManager(character, game.getInventory(), game.getTextManager());
				fight.reset();
				game.setState(State.PVE);
				cecilFightStarted = true;
			}
			if(!cecilFightStarted){
			cecil.Update(cecilPause );
		}
		}
		
		
		if (character.getLevel() == 100) { // Entrance2 == 1
			if (sceneStarted) {
				if (first2) {

					cary = createNPC(1, character, "res/redirect.png", 4, 4,
							100);
					cary.setSprite("robot");
					cary.setDirection(2);
					first2 = false;
				}
				if (RenderCary == true) {
					cary.Update2(caryBool);
					if (cary.getYInt() < 8) {
						caryBool = false;
						RenderCary = false;
						character.setPaused(false);

					}
					// System.out.println(game.getState() + "" +
					// cary.getYInt());

				}
				if (cary.getYInt() == 12) {
					caryBool = false;
					if (CaryTalkScene) {
						game.setState(State.DIALOGUE);
						CaryTalkScene = false;
					}
					// System.out.println(game.getState());
					if (CaryTalkScene == false
							&& game.getState() == game.state.GAME) {

						if (cary.getYInt() > 9) {
							caryBool = true;
							if (RenderCary == true) {
								// cary.Update2(caryBool);
							}
							cary.setDirection(1);
						}

					}
				}
			}

		}

		if (character.getLevel() == Entrance1) { // Entrance1 == 0
			cary.setX(300);
			cary.setY(400);
			if (first3) {
				cary.setDirection(2);
				cary.Update2(true);
				first3 = false;
			}
			cary.Update2(false);
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
		if (character.getLevel() == 104) { // LivingRoom5 == 6
			
			if(!First10){
				character.setPaused(false);
			First10 = true;
			game.setDialogue(new Dialogue(game, DialogueText.afterFight()));

			game.setState(State.DIALOGUE);
			}
		}
		if (character.getLevel() == Events.Ballroom1) { // LivingRoom5 == 6
			
			if(Ballroom1){
				character.setPaused(false);
			Ballroom1 = false;
			game.setDialogue(new Dialogue(game, DialogueText.ballroomScene1()));
			setSceneStarted(true, 2);
			game.setState(State.DIALOGUE);
			cary.setX(character.getX()+100);
			cary.setY(character.getY());
			}
			if(game.getState() == State.DIALOGUE){
				cary.setDirection(3);
				cary.setSprite("robot");
				if(cary.getX() < (int)character.getX()+50){
				b=false;	
				
				}
			cary.Update2(b);
			
			}
		}
		if (character.getLevel() == Events.Ballroom2) { // LivingRoom5 == 6
			
			if(Ballroom2){
				character.setPaused(false);
			Ballroom2 = false;
			game.setDialogue(new Dialogue(game, DialogueText.ballroomScene2()));
			setSceneStarted(true, 3);
			game.setState(State.DIALOGUE);
			cary.setX(character.getX()+100);
			cary.setY(character.getY());
			benedict = createNPC2(1, character, "res/images/benedictR.png", 5, 5, 100);
			benedict.setSprite("benedict");
			benedict.setDirection(3);
			benedict.setX(character.getX());
			benedict.setY(character.getY());
			}
			if(game.getState() == State.DIALOGUE){
				cary.setDirection(3);
				cary.setSprite("robot");
				if(cary.getX() < (int)character.getX()+50){
				b2=false;	
				afterDialogue = true;
				}
			cary.Update2(b2);
			
			}
			
				if(afterDialogue  && game.getState() == State.GAME){
					game.setState(State.CUTSCENE);
					afterDialogue = false;
				}
				
				
			
			if(game.getState() == State.CUTSCENE){
				if(!cutsceneStarted){
				b2 = true;
				cary.setDirection(3);
				cary.Update2(b2);
				}
				b2 = false;
				benedict.Update2(b2);
				cary.Update2(b2);
				cutsceneStarted = true;
				
				
				
			}
			if(game.getState() == State.GAME && cutsceneStarted){
					
				
				character.setLevel(LivingRoom1);
				grid.setGrid(Map.LivingRoom1());
				cutsceneStarted = false;
				
			}
		}
		
		if (character.getLevel() == 101) {
			boolean b;
			if (character.getXInt() == 4
					&& (character.getYInt() == 13 || character.getYInt() == 12 || character
							.getYInt() == 11)) {
				if(first4 ){
					skeleton = createNPC(1, character, "res/skeleton_r.png",
							character.getXInt2()-2, character.getYInt2()+1, 100);
					skeleton.setSprite("skeleton");
					first4 = false;
				}
				if(skeleton.getXInt2() < character.getXInt2()){
					b = true;
				}
				else{
					b=false;
					if(fight1){
						fight1 = false;
						character.setLevel(104);
						//game.setDialogue(new Dialogue(game,DialogueText.beginningScene4()));
						//game.setState(State.DIALOGUE);
						game.setState(State.PVE);
						
					}
					
				}
				if(First10){
					First10 = false;
					character.setPaused(true);
				}
				
				skeleton.setDirection(4);
				skeleton.Update2(b);

			}
		}

	}
}
