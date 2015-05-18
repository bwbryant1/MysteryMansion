package game;

import static helpers.Artist.QuickLoad;
import game.Game.State;
import gameitems.Items;
import helpers.Artist;

import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;

public class Events {

	private GameCharSprite character;
	private ObjectManager manager;
	private TileGrid grid;
	private TextManager textManager;
	private int levelX = 650, levelY = 50;
	static int Entrance1 = 0, Entrance2 = 1, LivingRoom1 = 2, LivingRoom2 = 3,
			LivingRoom3 = 4, LivingRoom4 = 5, LivingRoom5 = 6;

	static int Ballroom1 = 7;
	static int Ballroom2 = 8;
	static int Ballroom3 = 9;
	static int Ballroom4 = 10;
	static int Ballroom5 = 11;
	static int Ballroom6 = 12;
	static int Diningroom1 = 13;
	static int Diningroom2 = 14;
	static int Diningroom3 = 15;
	static int Diningroom4 = 16;
	static int Diningroom5 = 17;
	static int Diningroom6 = 18;
	static int Artgallery1 = 19, Artgallery2 = 20, Artgallery3 = 21;
	static int Library1 = 22, Library2 = 23, Library3 = 24, Library4 = 25,
			Library5 = 26, Library6 = 27, Library7 = 28, Library8 = 29,
			Library9 = 30;
	private CollisionGrid collide;
	private Inventory inventory;
	private Game game;
	private Texture MansionBackground;
	private boolean CaryScene = true;
	private NPCmanager npcMan;
	private boolean CaryScene2 = true;
	private boolean beginningScene2 = true;
	private boolean firstBattleEndText = true;
	private boolean first5 = true;
	private boolean first6 = true;

	public Events(GameCharSprite character, TileGrid grid,
			TextManager textManager, ObjectManager manager,
			CollisionGrid collide, Inventory inventory, Game game,
			NPCmanager npcMan) {

		this.character = character;
		this.grid = grid;
		this.textManager = textManager;
		this.manager = manager;
		this.collide = collide;
		this.inventory = inventory;
		this.game = game;
		this.npcMan = npcMan;
		MansionBackground = QuickLoad("ManBackground");

	}

	private void Outside_Mansion() {
		Artist.DrawQuadTex(MansionBackground, 0, 0, 1024, 1024);
		if (character.getYInt() == 13) {
			if (CaryScene) {
				character.setPaused(true);
				npcMan.setSceneStarted(true, 0);
				CaryScene = false;
				game.setDialogue(new Dialogue(game, DialogueText
						.beginningScene()));
			}

		}
		if (character.getYInt() == 8) {
			grid.setGrid(Map.Entrance1());
			collide.setGrid(CollideMaps.Entrance1());
			character.setLevel(Entrance1);
			character.setY(520);
		}

	}

	private void Entrance1() {
		if (CaryScene2) {
			character.setPaused(true);
			npcMan.setSceneStarted(true, 1);
			game.setDialogue(new Dialogue(game, DialogueText.beginningScene2()));
			CaryScene2 = false;
			character.setY(440);
			game.setState(State.DIALOGUE);

		}
		if (!CaryScene2 && game.state == State.GAME) {
			character.setLevel(101);
		}

		if (character.getXInt() == 27) {

			grid.setGrid(Map.Entrance2());
			character.setX(50);
			character.setLevel(Entrance2);
			collide.setGrid(CollideMaps.Entrance2());
		}

		if (character.getXInt() == 0
				&& (character.getYInt() == 13 || character.getYInt() == 12 || character
						.getYInt() == 11)) {

			grid.setGrid(Map.LivingRoom1());
			character.setX(550);
			character.setLevel(LivingRoom1);
			collide.setGrid(CollideMaps.LivingRoom1());
		}

	}

	private void Entrance1Copy() {

		if (CaryScene2 == false && game.state == State.GAME
				&& beginningScene2 == true) {
			inventory.getInventorySlot()[0] = Items.sword();
			inventory.equip(0, true);
			game.setDialogue(new Dialogue(game, DialogueText.beginningScene3()));

			game.setState(State.DIALOGUE);
			beginningScene2 = false;
		}

	}

	private void Entrance1copy2() {

		if (character.getXInt() == 27) {

			grid.setGrid(Map.Entrance2());
			character.setX(50);
			character.setLevel(Entrance2);
			collide.setGrid(CollideMaps.Entrance2());
		}

		if (character.getXInt() == 0
				&& (character.getYInt() == 13 || character.getYInt() == 12 || character
						.getYInt() == 11)) {

			grid.setGrid(Map.LivingRoom1());
			character.setX(550);
			character.setLevel(LivingRoom1);
			collide.setGrid(CollideMaps.LivingRoom1());
		}

	}

	private void Entrance1copy3() {

		if (character.getXInt() == 27) {

			grid.setGrid(Map.Entrance2());
			character.setX(50);
			character.setLevel(Entrance2);
			collide.setGrid(CollideMaps.Entrance2());
		}

	}

	private void Entrance1copy4() {

		if (character.getXInt() == 27) {

			grid.setGrid(Map.Entrance2());
			character.setX(50);
			character.setLevel(Entrance2);
			collide.setGrid(CollideMaps.Entrance2());
		}
		if (character.getXInt() == 0
				&& (character.getYInt() == 13 || character.getYInt() == 12 || character
						.getYInt() == 11)) {

			grid.setGrid(Map.LivingRoom1());
			character.setX(550);
			character.setLevel(LivingRoom1);
			collide.setGrid(CollideMaps.LivingRoom1());
		}

	}

	private void Entrance2() {

		if (character.getXInt() == 0) {
			// System.out.println("events");
			grid.setGrid(Map.Entrance1());
			character.setX(500);
			character.setLevel(105);
			collide.setGrid(CollideMaps.Entrance1());

		}
		if (character.getXInt() == 27
				&& (character.getYInt() == 12 || character.getYInt() == 11 || character
						.getYInt() == 13)) {
			// System.out.println("events");
			grid.setGrid(Map.Ballroom1());
			character.setX(50);
			character.setLevel(Ballroom1);
			collide.setGrid(CollideMaps.Ballroom1());

		}
	}

	private void LivingRoom1() {

		if (character.getXInt() == 27
				&& (character.getYInt() == 12 || character.getYInt() == 11 || character
						.getYInt() == 13)) {
			// System.out.println("events");
			grid.setGrid(Map.Entrance1());
			character.setX(50);
			character.setLevel(105);
			collide.setGrid(CollideMaps.Entrance1());

		}
		if (character.getXInt() == 0) {
			// System.out.println("events");
			grid.setGrid(Map.LivingRoom2());
			character.setX(550);
			character.setLevel(LivingRoom2);
			collide.setGrid(CollideMaps.LivingRoom2());

		}

	}

	private void LivingRoom2() {

		if (character.getXInt() == 27) {
			// System.out.println("events");
			grid.setGrid(Map.LivingRoom1());
			character.setX(64);
			character.setLevel(LivingRoom1);

		}
		if (character.getXInt() == 0) {
			// System.out.println("events");
			grid.setGrid(Map.LivingRoom3());
			character.setX(550);
			character.setLevel(LivingRoom3);
			collide.setGrid(CollideMaps.LivingRoom3());

		}
		if (character.getYInt() == 0) {
			// System.out.println("events");
			grid.setGrid(Map.LivingRoom5());
			character.setY(540);
			character.setLevel(LivingRoom5);
			collide.setGrid(CollideMaps.LivingRoom5());

		}

	}

	private void LivingRoom3() {

		if (character.getYInt() == 0) {
			// System.out.println("events");
			grid.setGrid(Map.LivingRoom4());
			character.setY(540);
			character.setLevel(LivingRoom4);
			collide.setGrid(CollideMaps.LivingRoom4());

		}

		if (character.getXInt() == 27) {
			// System.out.println("events");
			grid.setGrid(Map.LivingRoom2());
			character.setX(64);
			character.setLevel(LivingRoom2);
			collide.setGrid(CollideMaps.LivingRoom2());

		}

	}

	private void LivingRoom4() {
		if (character.getYInt() == 17) {
			// System.out.println("events");
			grid.setGrid(Map.LivingRoom3());
			character.setY(50);
			character.setLevel(LivingRoom3);
			collide.setGrid(CollideMaps.LivingRoom3());

		}
		if (character.getXInt() == 27) {
			// System.out.println("events");
			grid.setGrid(Map.LivingRoom5());
			character.setX(50);
			character.setLevel(LivingRoom5);
			collide.setGrid(CollideMaps.LivingRoom5());

		}
		if ((character.getYInt() == 0 || character.getYInt() == 0)
				&& (character.getXInt() == 7 || character.getXInt() == 8
						|| character.getXInt() == 9 || character.getXInt() == 10)) {
			// System.out.println("events");
			grid.setGrid(Map.ArtGallery1());
			character.setY(540);
			character.setLevel(Artgallery1);
			collide.setGrid(CollideMaps.Artgallery1());
		}

	}

	private void LivingRoom5() {
		if (character.getYInt() == 17) {
			// System.out.println("events");
			grid.setGrid(Map.LivingRoom2());
			character.setY(50);
			character.setLevel(LivingRoom2);
			collide.setGrid(CollideMaps.LivingRoom2());

		}
		if (character.getXInt() == 0) {
			// System.out.println("events");
			grid.setGrid(Map.LivingRoom4());
			character.setX(550);
			character.setLevel(LivingRoom4);
			collide.setGrid(CollideMaps.LivingRoom4());

		}
		if ((character.getYInt() == 0 || character.getYInt() == 0)
				&& (character.getXInt() == 15 || character.getXInt() == 16
						|| character.getXInt() == 17 || character.getXInt() == 18)) {
			// System.out.println("events");
			grid.setGrid(Map.ArtGallery2());
			character.setX(200);
			character.setY(540);
			character.setLevel(Artgallery2);
			collide.setGrid(CollideMaps.Artgallery2());
		}

	}

	private void Ballroom6() {
		if (character.getXInt() == 0) {
			// System.out.println("events");
			grid.setGrid(Map.Ballroom5());
			character.setX(550);
			character.setLevel(Ballroom5);
			collide.setGrid(CollideMaps.Ballroom5());

		}
		if (character.getYInt() == 17) {
			// System.out.println("events");
			grid.setGrid(Map.Ballroom3());
			character.setY(50);
			character.setLevel(Ballroom3);
			collide.setGrid(CollideMaps.Ballroom3());

		}
		if ((character.getYInt() == 0 || character.getYInt() == 0)
				&& (character.getXInt() == 13 || character.getXInt() == 14 || character
						.getXInt() == 15)) {
			// System.out.println("events");
			grid.setGrid(Map.Diningroom3());
			character.setY(540);
			character.setLevel(Diningroom3);
			collide.setGrid(CollideMaps.Diningroom3());
		}
	}

	private void Ballroom5() {
		if (character.getXInt() == 27) {
			// System.out.println("events");
			grid.setGrid(Map.Ballroom6());
			character.setX(64);
			character.setLevel(Ballroom6);
			collide.setGrid(CollideMaps.Ballroom6());

		}
		if (character.getYInt() == 17) {
			// System.out.println("events");
			grid.setGrid(Map.Ballroom2());
			character.setY(50);
			character.setLevel(Ballroom2);
			collide.setGrid(CollideMaps.Ballroom2());

		}
		if (character.getXInt() == 0) {
			// System.out.println("events");
			grid.setGrid(Map.Ballroom4());
			character.setX(550);
			character.setLevel(Ballroom4);
			collide.setGrid(CollideMaps.Ballroom4());

		}
	}

	private void Ballroom4() {
		if (character.getYInt() == 17) {
			// System.out.println("events");
			grid.setGrid(Map.Ballroom1());
			character.setY(50);
			character.setLevel(Ballroom1);
			collide.setGrid(CollideMaps.Ballroom1());

		}
		if (character.getXInt() == 27) {
			// System.out.println("events");
			grid.setGrid(Map.Ballroom5());
			character.setX(64);
			character.setLevel(Ballroom5);
			collide.setGrid(CollideMaps.Ballroom5());

		}
		if ((character.getYInt() == 0 || character.getYInt() == 0)
				&& (character.getXInt() == 13 || character.getXInt() == 14 || character
						.getXInt() == 15)) {
			// System.out.println("events");
			grid.setGrid(Map.Diningroom1());
			character.setY(540);
			character.setLevel(Diningroom1);
			collide.setGrid(CollideMaps.Diningroom1());
		}
	}

	private void Ballroom3() {
		if (character.getXInt() == 0) {
			// System.out.println("events");
			grid.setGrid(Map.Ballroom2());
			character.setX(550);
			character.setLevel(Ballroom2);
			collide.setGrid(CollideMaps.Ballroom2());

		}
		if (character.getYInt() == 0) {
			// System.out.println("events");
			grid.setGrid(Map.Ballroom6());
			character.setY(540);
			character.setLevel(Ballroom6);
			collide.setGrid(CollideMaps.Ballroom6());

		}

	}

	private void Ballroom2() {
		if (character.getXInt() == 27) {
			// System.out.println("events");
			grid.setGrid(Map.Ballroom3());
			character.setX(64);
			character.setLevel(Ballroom3);

		}
		if (character.getXInt() == 0) {
			// System.out.println("events");
			grid.setGrid(Map.Ballroom1());
			character.setX(550);
			character.setLevel(Ballroom1);
			collide.setGrid(CollideMaps.Ballroom1());

		}
		if (character.getYInt() == 0) {
			// System.out.println("events");
			grid.setGrid(Map.Ballroom5());
			character.setY(540);
			character.setLevel(Ballroom5);
			collide.setGrid(CollideMaps.Ballroom5());

		}

	}

	private void Ballroom1() {
		// System.out.println(character.getXInt() +" "+character.getYInt());
		if (character.getXInt() == 0
				&& (character.getYInt() == 13 || character.getYInt() == 12 || character
						.getYInt() == 11)) {

			grid.setGrid(Map.Entrance2());
			character.setX(550);
			character.setLevel(Entrance2);
			collide.setGrid(CollideMaps.Entrance2());
		}
		if (character.getXInt() == 27) {
			// System.out.println("events");
			grid.setGrid(Map.Ballroom2());
			character.setX(64);
			character.setLevel(Ballroom2);

		}
		if (character.getYInt() == 0) {
			// System.out.println("events");
			grid.setGrid(Map.Ballroom4());
			character.setY(540);
			character.setLevel(Ballroom4);
			collide.setGrid(CollideMaps.Ballroom4());

		}

	}

	private void Diningroom6() {
		if (character.getXInt() == 0) {
			// System.out.println("events");
			grid.setGrid(Map.Diningroom5());
			character.setX(550);
			character.setLevel(Diningroom5);
			collide.setGrid(CollideMaps.Diningroom5());

		}
		if (character.getYInt() == 17) {
			// System.out.println("events");
			grid.setGrid(Map.Diningroom3());
			character.setY(50);
			character.setLevel(Diningroom3);
			collide.setGrid(CollideMaps.Diningroom3());

		}

	}

	private void Diningroom5() {
		if (character.getXInt() == 27) {
			// System.out.println("events");
			grid.setGrid(Map.Diningroom6());
			character.setX(64);
			character.setLevel(Diningroom6);
			collide.setGrid(CollideMaps.Diningroom6());

		}
		if (character.getYInt() == 17) {
			// System.out.println("events");
			grid.setGrid(Map.Diningroom2());
			character.setY(50);
			character.setLevel(Diningroom2);
			collide.setGrid(CollideMaps.Diningroom2());

		}
		if (character.getXInt() == 0) {
			// System.out.println("events");
			grid.setGrid(Map.Diningroom4());
			character.setX(550);
			character.setLevel(Diningroom4);
			collide.setGrid(CollideMaps.Diningroom4());

		}

	}

	private void Diningroom4() {
		if (character.getYInt() == 17) {
			// System.out.println("events");
			grid.setGrid(Map.Diningroom1());
			character.setY(50);
			character.setLevel(Diningroom1);
			collide.setGrid(CollideMaps.Diningroom1());

		}
		if (character.getXInt() == 27) {
			// System.out.println("events");
			grid.setGrid(Map.Diningroom5());
			character.setX(64);
			character.setLevel(Diningroom5);
			collide.setGrid(CollideMaps.Diningroom5());

		}

	}

	private void Diningroom3() {
		if (character.getXInt() == 0) {
			// System.out.println("events");
			grid.setGrid(Map.Diningroom2());
			character.setX(550);
			character.setLevel(Diningroom2);
			collide.setGrid(CollideMaps.Diningroom2());

		}
		if (character.getYInt() == 0) {
			// System.out.println("events");
			grid.setGrid(Map.Diningroom6());
			character.setY(540);
			character.setLevel(Diningroom6);
			collide.setGrid(CollideMaps.Diningroom6());

		}
		if ((character.getYInt() == 17 || character.getYInt() == 17)
				&& (character.getXInt() == 13 || character.getXInt() == 14 || character
						.getXInt() == 15)) {
			// System.out.println("events");
			grid.setGrid(Map.Ballroom6());
			character.setY(50);
			character.setLevel(Ballroom6);
			collide.setGrid(CollideMaps.Ballroom6());
		}

	}

	private void Diningroom2() {
		if (character.getXInt() == 27) {
			// System.out.pridinntln("events");
			grid.setGrid(Map.Diningroom3());
			character.setX(64);
			character.setLevel(Diningroom3);

		}
		if (character.getXInt() == 0) {
			// System.out.println("events");
			grid.setGrid(Map.Diningroom1());
			character.setX(550);
			character.setLevel(Diningroom1);
			collide.setGrid(CollideMaps.Diningroom1());

		}
		if (character.getYInt() == 0) {
			// System.out.println("events");
			grid.setGrid(Map.Diningroom5());
			character.setY(540);
			character.setLevel(Diningroom5);
			collide.setGrid(CollideMaps.Diningroom5());

		}

	}

	private void Diningroom1() {
		if ((character.getYInt() == 17 || character.getYInt() == 17)
				&& (character.getXInt() == 13 || character.getXInt() == 14 || character
						.getXInt() == 15)) {
			// System.out.println("events");
			grid.setGrid(Map.Ballroom4());
			character.setY(50);
			character.setLevel(Ballroom4);
			collide.setGrid(CollideMaps.Ballroom4());
		}
		if (character.getYInt() == 0) {
			// System.out.println("events");
			grid.setGrid(Map.Diningroom4());
			character.setY(540);
			character.setLevel(Diningroom4);
			collide.setGrid(CollideMaps.Diningroom4());

		}
		if (character.getXInt() == 27) {
			// System.out.println("events");
			grid.setGrid(Map.Diningroom2());
			character.setX(64);
			character.setLevel(Diningroom2);

		}
		if (character.getYInt() == 17 && (character.getXInt() == 7)) {
			// System.out.println("events");
			grid.setGrid(Map.Ballroom4());
			character.setY(540);
			character.setLevel(Ballroom4);
			collide.setGrid(CollideMaps.Ballroom4());
		}

	}

	private void Library1() {

		if ((character.getYInt() == 17 )
				&& (character.getXInt() == 7 || character.getXInt() == 8 || character
						.getXInt() == 9|| character
						.getXInt() == 10)) {
			// System.out.println("events");
			grid.setGrid(Map.ArtGallery1());
			character.setY(50);
			character.setLevel(Artgallery1);
			collide.setGrid(CollideMaps.Artgallery1());
		}
		if (character.getYInt() == 0) {
			// System.out.println("events");
			grid.setGrid(Map.Diningroom4());
			character.setY(540);
			character.setLevel(Library4);
			collide.setGrid(CollideMaps.Library4());

		}
		if (character.getXInt() == 27) {
			// System.out.println("events");
			grid.setGrid(Map.Library2());
			character.setX(64);
			character.setLevel(Library2);
			collide.setGrid(CollideMaps.Library2());

		}

	}

	private void Library2() {

		if (character.getXInt() == 27) {
			// System.out.pridinntln("events");
			grid.setGrid(Map.Library3());
			character.setX(64);
			character.setLevel(Library3);
			collide.setGrid(CollideMaps.Library3());

		}
		if (character.getXInt() == 0) {
			// System.out.println("events");
			grid.setGrid(Map.Library1());
			character.setX(550);
			character.setLevel(Library1);
			collide.setGrid(CollideMaps.Library1());

		}
		if (character.getYInt() == 0) {
			// System.out.println("events");
			grid.setGrid(Map.Library5());
			character.setY(540);
			character.setLevel(Library5);
			collide.setGrid(CollideMaps.Library5());

		}

	}

	private void Library3() {
		if (character.getXInt() == 0) {
			// System.out.println("events");
			grid.setGrid(Map.Library2());
			character.setX(550);
			character.setLevel(Library2);
			collide.setGrid(CollideMaps.Library2());

		}
		if (character.getYInt() == 0) {
			// System.out.println("events");
			grid.setGrid(Map.Library6());
			character.setY(540);
			character.setLevel(Library6);
			collide.setGrid(CollideMaps.Library6());

		}
		if ((character.getYInt() == 17 || character.getYInt() == 17)
				&& (character.getXInt() == 13 || character.getXInt() == 14 || character
						.getXInt() == 15)) {
			// System.out.println("events");
			grid.setGrid(Map.ArtGallery3());
			character.setY(50);
			character.setLevel(Artgallery3);
			collide.setGrid(CollideMaps.Artgallery3());
		}

	}

	private void Library4() {

		if (character.getYInt() == 0) {
			// System.out.println("events");
			grid.setGrid(Map.Library7());
			character.setY(540);
			character.setLevel(Library7);
			collide.setGrid(CollideMaps.Library7());

		}
		if (character.getXInt() == 27) {
			// System.out.pridinntln("events");
			grid.setGrid(Map.Library5());
			character.setX(64);
			character.setLevel(Library5);
			collide.setGrid(CollideMaps.Library5());

		}
		if (character.getYInt() == 17) {
			// System.out.println("events");
			grid.setGrid(Map.Library1());
			character.setY(50);
			character.setLevel(Library1);
			collide.setGrid(CollideMaps.Library1());

		}
	}

	private void Library5() {
		if (character.getYInt() == 0) {
			// System.out.println("events");
			grid.setGrid(Map.Library8());
			character.setY(540);
			character.setLevel(Library8);
			collide.setGrid(CollideMaps.Library8());

		}
		if (character.getXInt() == 27) {
			// System.out.pridinntln("events");
			grid.setGrid(Map.Library6());
			character.setX(64);
			character.setLevel(Library6);
			collide.setGrid(CollideMaps.Library6());

		}
		if (character.getYInt() == 17) {
			// System.out.println("events");
			grid.setGrid(Map.Library2());
			character.setY(50);
			character.setLevel(Library2);
			collide.setGrid(CollideMaps.Library2());

		}
		if (character.getXInt() == 0) {
			// System.out.println("events");
			grid.setGrid(Map.Library4());
			character.setX(550);
			character.setLevel(Library4);
			collide.setGrid(CollideMaps.Library4());

		}

	}

	private void Library6() {
		if (character.getXInt() == 0) {
			// System.out.println("events");
			grid.setGrid(Map.Library5());
			character.setX(550);
			character.setLevel(Library5);
			collide.setGrid(CollideMaps.Library5());

		}
		if (character.getYInt() == 0) {
			// System.out.println("events");
			grid.setGrid(Map.Library9());
			character.setY(540);
			character.setLevel(Library9);
			collide.setGrid(CollideMaps.Library9());

		}
		if (character.getYInt() == 17) {
			// System.out.println("events");
			grid.setGrid(Map.Library3());
			character.setY(50);
			character.setLevel(Library3);
			collide.setGrid(CollideMaps.Library3());

		}
	}

	private void Library7() {
		if (character.getYInt() == 17) {
			// System.out.println("events");
			grid.setGrid(Map.Library4());
			character.setY(50);
			character.setLevel(Library4);
			collide.setGrid(CollideMaps.Library4());

		}
		if (character.getXInt() == 27) {
			// System.out.pridinntln("events");
			grid.setGrid(Map.Library8());
			character.setX(64);
			character.setLevel(Library8);
			collide.setGrid(CollideMaps.Library8());

		}
		if (character.getXInt() == 0) {
			// System.out.println("events");
			grid.setGrid(Map.Library5());
			character.setX(550);
			character.setLevel(Library5);
			collide.setGrid(CollideMaps.Library5());

		}
		
	}

	private void Library8() {
		if (character.getYInt() == 17) {
			// System.out.println("events");
			grid.setGrid(Map.Library5());
			character.setY(50);
			character.setLevel(Library5);
			collide.setGrid(CollideMaps.Library5());

		}
		if (character.getXInt() == 27) {
			// System.out.pridinntln("events");
			grid.setGrid(Map.Library9());
			character.setX(64);
			character.setLevel(Library9);
			collide.setGrid(CollideMaps.Library9());

		}
		if (character.getXInt() == 0) {
			// System.out.println("events");
			grid.setGrid(Map.Library7());
			character.setX(550);
			character.setLevel(Library7);
			collide.setGrid(CollideMaps.Library7());

		}
	}

	private void Library9() {
		if (character.getYInt() == 17) {
			// System.out.println("events");
			grid.setGrid(Map.Library6());
			character.setY(50);
			character.setLevel(Library6);
			collide.setGrid(CollideMaps.Library6());

		}
		if (character.getXInt() == 0) {
			// System.out.println("events");
			grid.setGrid(Map.Library8());
			character.setX(550);
			character.setLevel(Library8);
			collide.setGrid(CollideMaps.Library8());

		}
	}

	private void Artgallery3() {

		if (character.getXInt() == 0) {
			// System.out.pridinntln("events");
			grid.setGrid(Map.ArtGallery2());
			character.setX(550);
			character.setLevel(Artgallery2);
			collide.setGrid(CollideMaps.Artgallery2());

		}
		if ((character.getYInt() == 0)
				&& (character.getXInt() == 15 || character.getXInt() == 16
						|| character.getXInt() == 17 || character.getXInt() == 18)) {
			// System.out.println("events");
			grid.setGrid(Map.Library3());
			character.setY(540);
			character.setLevel(Library3);
			collide.setGrid(CollideMaps.Library3());
		}

	}

	private void Artgallery2() {
		if (character.getXInt() == 0) {
			// System.out.pridinntln("events");
			grid.setGrid(Map.ArtGallery1());
			character.setX(550);
			character.setLevel(Artgallery1);
			collide.setGrid(CollideMaps.Artgallery1());

		}
		if (character.getXInt() == 27) {
			// System.out.pridinntln("events");
			grid.setGrid(Map.ArtGallery3());
			character.setX(64);
			character.setLevel(Artgallery3);
			collide.setGrid(CollideMaps.Artgallery3());

		}
		if ((character.getYInt() == 17)
				&& (character.getXInt() == 5 || character.getXInt() == 6
						|| character.getXInt() == 7 || character.getXInt() == 8 || character
						.getXInt() == 9)) {
			// System.out.println("events");
			grid.setGrid(Map.LivingRoom5());
			character.setX(340);
			character.setY(64);
			character.setLevel(LivingRoom5);
			collide.setGrid(CollideMaps.LivingRoom5());
		}

	}

	private void Artgallery1() {
		if (character.getXInt() == 27) {
			// System.out.pridinntln("events");
			grid.setGrid(Map.ArtGallery2());
			character.setX(64);
			character.setLevel(Artgallery2);
			collide.setGrid(CollideMaps.Artgallery2());

		}
		if ((character.getYInt() == 17)
				&& (character.getXInt() == 7 || character.getXInt() == 8
						|| character.getXInt() == 9 || character.getXInt() == 10)) {
			// System.out.println("events");
			grid.setGrid(Map.LivingRoom4());
			character.setY(64);
			character.setLevel(LivingRoom4);
			collide.setGrid(CollideMaps.LivingRoom4());
		}
		if ((character.getYInt() == 0)
				&& (character.getXInt() == 7 || character.getXInt() == 8
						|| character.getXInt() == 9 || character.getXInt() == 10)) {
			// System.out.println("events");
			grid.setGrid(Map.Library1());
			character.setY(540);
			character.setLevel(Library1);
			collide.setGrid(CollideMaps.Library1());
		}

	}

	public void Update() {

		if (character.getLevel() == 100) {
			textManager.setText(textManager.getText(0), "Outside the mansion",
					levelX, levelY, Color.red);
			textManager.callText(0);
			Outside_Mansion();
			manager.Outside_Mansion();
			collide.setGrid(CollideMaps.Outside_Mansion());
		}

		if (character.getLevel() == Entrance1) { // Entrance1 == 0
			// System.out.println("Level is 0");
			textManager.setText(textManager.getText(0), "Entrance 1 55",
					levelX, levelY, Color.red);
			textManager.callText(0);
			collide.setGrid(CollideMaps.Entrance1());
			Entrance1();
			manager.Entrance1();

		}
		if (character.getLevel() == 101) {
			textManager.setText(textManager.getText(0), "Entrance 1", levelX,
					levelY, Color.red);
			textManager.callText(0);
			collide.setGrid(CollideMaps.Entrance1());
			Entrance1Copy();
			manager.Entrance1();

		}
		if (character.getLevel() == 102) {
			textManager.setText(textManager.getText(0), "Entrance 1", levelX,
					levelY, Color.red);
			textManager.callText(0);
			collide.setGrid(CollideMaps.Entrance1());
			Entrance1copy2();
			manager.Entrance1();

		}
		if (character.getLevel() == 103) {
			textManager.setText(textManager.getText(0), "Entrance 1",
					levelX, levelY, Color.red);
			textManager.callText(0);
			collide.setGrid(CollideMaps.Entrance1());
			Entrance1copy3();
			manager.Entrance1();

		}
		if (character.getLevel() == 104) {
			textManager.setText(textManager.getText(0), "Entrance 1",
					levelX, levelY, Color.red);
			textManager.callText(0);
			collide.setGrid(CollideMaps.Entrance1());
			Entrance1copy3();
			manager.Entrance1();

		}
		if (character.getLevel() == 105) {
			textManager.setText(textManager.getText(0), "Entrance 1",
					levelX, levelY, Color.red);
			textManager.callText(0);
			collide.setGrid(CollideMaps.Entrance1());
			Entrance1copy4();
			manager.Entrance1();

		}
		if (character.getLevel() == Entrance2) { // Entrance2 == 1
			// System.out.println("Level is 1");
			textManager.setText(textManager.getText(0), "Entrance 2", levelX,
					levelY, Color.red);
			textManager.callText(0);
			Entrance2();
			manager.Entrance2();

		}
		if (character.getLevel() == LivingRoom1) { // LivingRoom1 == 2
			// text();System.out.println("Level is 2");
			LivingRoom1();
			textManager.setText(textManager.getText(0), "LivingRoom 1", levelX,
					levelY, Color.red);
			textManager.callText(0);
			manager.Livingroom1();

		}

		if (character.getLevel() == LivingRoom2) {
			// System.out.println("Level is 3");
			LivingRoom2();
			textManager.setText(textManager.getText(0), "LivingRoom2", levelX,
					levelY, Color.red);
			textManager.callText(0);
			manager.Livingroom2();

		}
		if (character.getLevel() == LivingRoom3) {
			// System.out.println("Level is 3");
			LivingRoom3();
			textManager.setText(textManager.getText(0), "LivingRoom3", levelX,
					levelY, Color.red);
			textManager.callText(0);
			manager.Livingroom3();

		}
		if (character.getLevel() == LivingRoom4) {
			// System.out.println("Level is 3");
			LivingRoom4();
			textManager.setText(textManager.getText(0), "LivingRoom 4", levelX,
					levelY, Color.red);
			textManager.callText(0);
			manager.Livingroom4();

		}
		if (character.getLevel() == LivingRoom5) {
			// System.out.println("Level is 3");
			LivingRoom5();
			textManager.setText(textManager.getText(0), "LivingRoom 5", levelX,
					levelY, Color.red);
			textManager.callText(0);
			LivingRoom5();
			manager.Livingroom5();

		}
		if (character.getLevel() == Ballroom1) {
			textManager.setText(textManager.getText(0), "Ballroom 1", levelX,
					levelY, Color.red);
			textManager.callText(0);
			Ballroom1();
			manager.Ballroom1();
			collide.setGrid(CollideMaps.Ballroom1());
		}
		if (character.getLevel() == Ballroom2) {
			textManager.setText(textManager.getText(0), "Ballroom 2", levelX,
					levelY, Color.red);
			textManager.callText(0);
			Ballroom2();
			manager.Ballroom2();
			collide.setGrid(CollideMaps.Ballroom2());
		}
		if (character.getLevel() == Ballroom3) {
			textManager.setText(textManager.getText(0), "Ballroom 3", levelX,
					levelY, Color.red);
			textManager.callText(0);
			Ballroom3();
			manager.Ballroom3();
			collide.setGrid(CollideMaps.Ballroom3());
		}
		if (character.getLevel() == Ballroom4) {
			textManager.setText(textManager.getText(0), "Ballroom 4", levelX,
					levelY, Color.red);
			textManager.callText(0);
			Ballroom4();
			manager.Ballroom4();
			collide.setGrid(CollideMaps.Ballroom4());
		}
		if (character.getLevel() == Ballroom5) {
			textManager.setText(textManager.getText(0), "Ballroom 5", levelX,
					levelY, Color.red);
			textManager.callText(0);
			Ballroom5();
			manager.Ballroom5();
			collide.setGrid(CollideMaps.Ballroom5());
		}
		if (character.getLevel() == Ballroom6) {
			textManager.setText(textManager.getText(0), "Ballroom 6", levelX,
					levelY, Color.red);
			textManager.callText(0);
			Ballroom6();
			manager.Ballroom6();
			collide.setGrid(CollideMaps.Ballroom6());
		}
		if (character.getLevel() == Diningroom1) {
			textManager.setText(textManager.getText(0), "Diningroom 1", levelX,
					levelY, Color.red);
			textManager.callText(0);
			Diningroom1();
			manager.Diningroom1();
			collide.setGrid(CollideMaps.Diningroom1());
		}
		if (character.getLevel() == Diningroom2) {
			textManager.setText(textManager.getText(0), "Diningroom 2", levelX,
					levelY, Color.red);
			textManager.callText(0);
			Diningroom2();
			manager.Diningroom2();
			collide.setGrid(CollideMaps.Diningroom2());
		}
		if (character.getLevel() == Diningroom3) {
			textManager.setText(textManager.getText(0), "Diningroom 3", levelX,
					levelY, Color.red);
			textManager.callText(0);
			Diningroom3();
			manager.Diningroom3();
			collide.setGrid(CollideMaps.Diningroom3());
		}
		if (character.getLevel() == Diningroom4) {
			textManager.setText(textManager.getText(0), "Diningroom 4", levelX,
					levelY, Color.red);
			textManager.callText(0);
			Diningroom4();
			manager.Diningroom4();
			collide.setGrid(CollideMaps.Diningroom4());
		}
		if (character.getLevel() == Diningroom5) {
			textManager.setText(textManager.getText(0), "Diningroom 5", levelX,
					levelY, Color.red);
			textManager.callText(0);
			Diningroom5();
			manager.Diningroom5();
			collide.setGrid(CollideMaps.Diningroom5());
		}
		if (character.getLevel() == Diningroom6) {
			textManager.setText(textManager.getText(0), "Diningroom 6", levelX,
					levelY, Color.red);
			textManager.callText(0);
			Diningroom6();
			manager.Diningroom6();
			collide.setGrid(CollideMaps.Diningroom6());
		}
		if (character.getLevel() == Library1) {
			textManager.setText(textManager.getText(0), "Library 1", levelX,
					levelY, Color.red);
			textManager.callText(0);
			Library1();
			manager.Library1();
			collide.setGrid(CollideMaps.Library1());
		}
		if (character.getLevel() == Library2) {
			textManager.setText(textManager.getText(0), "Library 2", levelX,
					levelY, Color.red);
			textManager.callText(0);
			Library2();
			manager.Library2();
			collide.setGrid(CollideMaps.Library2());
		}
		if (character.getLevel() == Library3) {
			textManager.setText(textManager.getText(0), "Library 3", levelX,
					levelY, Color.red);
			textManager.callText(0);
			Library3();
			manager.Library3();
			collide.setGrid(CollideMaps.Library3());
		}
		if (character.getLevel() == Library4) {
			textManager.setText(textManager.getText(0), "Library 4", levelX,
					levelY, Color.red);
			textManager.callText(0);
			Library4();
			manager.Library4();
			collide.setGrid(CollideMaps.Library4());
		}
		if (character.getLevel() == Library5) {
			textManager.setText(textManager.getText(0), "Library 5", levelX,
					levelY, Color.red);
			textManager.callText(0);
			Library5();
			manager.Library5();
			collide.setGrid(CollideMaps.Library5());
		}
		if (character.getLevel() == Library6) {
			textManager.setText(textManager.getText(0), "Library 6", levelX,
					levelY, Color.red);
			textManager.callText(0);
			Library6();
			manager.Library6();
			collide.setGrid(CollideMaps.Library6());
		}
		if (character.getLevel() == Library7) {
			textManager.setText(textManager.getText(0), "Library 7", levelX,
					levelY, Color.red);
			textManager.callText(0);
			Library7();
			manager.Library7();
			collide.setGrid(CollideMaps.Library7());
		}
		if (character.getLevel() == Library8) {
			textManager.setText(textManager.getText(0), "Library 8", levelX,
					levelY, Color.red);
			textManager.callText(0);
			Library8();
			manager.Library8();
			collide.setGrid(CollideMaps.Library8());
		}
		if (character.getLevel() == Library9) {
			textManager.setText(textManager.getText(0), "Library 9", levelX,
					levelY, Color.red);
			textManager.callText(0);
			Library9();
			manager.Library9();
			collide.setGrid(CollideMaps.Library9());
		}
		if (character.getLevel() == Artgallery1) {
			textManager.setText(textManager.getText(0), "Artgallery 1", levelX,
					levelY, Color.red);
			textManager.callText(0);
			Artgallery1();
			manager.Artgallery1();
			collide.setGrid(CollideMaps.Artgallery1());
		}
		if (character.getLevel() == Artgallery2) {
			textManager.setText(textManager.getText(0), "Artgallery 2", levelX,
					levelY, Color.red);
			textManager.callText(0);
			Artgallery2();
			manager.Artgallery2();
			collide.setGrid(CollideMaps.Artgallery2());
		}
		if (character.getLevel() == Artgallery3) {
			textManager.setText(textManager.getText(0), "Artgallery 3", levelX,
					levelY, Color.red);
			textManager.callText(0);
			Artgallery3();
			manager.Artgallery3();
			collide.setGrid(CollideMaps.Artgallery3());
		}

	}

}
