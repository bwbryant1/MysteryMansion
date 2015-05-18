package game;

import static helpers.Artist.QuickLoad;
import helpers.Artist;

import org.newdawn.slick.opengl.Texture;

public class ObjectManager {

	private GameCharSprite character;
	private Texture stairs;
	private Texture stairs2;
	private Texture fountain1;
	private Texture fountain2;
	private Texture ballroom1, ballroom2, ballroom3, ballroom4, ballroom5,
			ballroom6;
	private Texture Diningroom1;
	private Texture Diningroom2;
	private Texture Diningroom4;
	private Texture Diningroom5;
	private Texture Diningroom6;
	private Texture Diningroom3;
	private Texture Livingroom1, Livingroom2, Livingroom3, Livingroom4,
			Livingroom5;
	private Texture Artgallery1, Artgallery2, Artgallery3;
	private Texture Library1, Library2, Library3, Library4, Library5, Library6,
			Library7, Library8, Library9;

	public ObjectManager(GameCharSprite character) {
		this.character = character;
		stairs = Artist.QuickLoad("maps/Stairs_01");
		stairs2 = Artist.QuickLoad("maps/Stairs_02");
		fountain1 = Artist.QuickLoad("entrance/image/fountain_01");
		fountain2 = Artist.QuickLoad("entrance/image/fountain_02");

		ballroom1 = Artist.QuickLoad("ballroom/ballroom1");
		ballroom2 = Artist.QuickLoad("ballroom/ballroom2");
		ballroom3 = Artist.QuickLoad("ballroom/ballroom3");
		ballroom4 = Artist.QuickLoad("ballroom/ballroom4");
		ballroom5 = Artist.QuickLoad("ballroom/ballroom5");
		ballroom6 = Artist.QuickLoad("ballroom/ballroom6");

		Diningroom1 = Artist.QuickLoad("diningroom/diningroom1");
		Diningroom2 = Artist.QuickLoad("diningroom/diningroom2");
		Diningroom3 = Artist.QuickLoad("diningroom/diningroom3");
		Diningroom4 = Artist.QuickLoad("diningroom/diningroom4");
		Diningroom5 = Artist.QuickLoad("diningroom/diningroom5");
		Diningroom6 = Artist.QuickLoad("diningroom/diningroom6");

		Livingroom1 = Artist.QuickLoad("livingroom/livingroom1");
		Livingroom2 = Artist.QuickLoad("livingroom/livingroom2");
		Livingroom3 = Artist.QuickLoad("livingroom/livingroom3");
		Livingroom4 = Artist.QuickLoad("livingroom/livingroom4");
		Livingroom5 = Artist.QuickLoad("livingroom/livingroom5");

		Artgallery1 = Artist.QuickLoad("artgallery/artgallery1");
		Artgallery2 = Artist.QuickLoad("artgallery/artgallery2");
		Artgallery3 = Artist.QuickLoad("artgallery/artgallery3");

		Library1 = Artist.QuickLoad("library/library1");
		Library2 = Artist.QuickLoad("library/library2");
		Library3 = Artist.QuickLoad("library/library3");
		Library4 = Artist.QuickLoad("library/library4");
		Library5 = Artist.QuickLoad("library/library5");
		Library6 = Artist.QuickLoad("library/library6");
		Library7 = Artist.QuickLoad("library/library7");
		Library8 = Artist.QuickLoad("library/library8");
		Library9 = Artist.QuickLoad("library/library9");

	}

	public void cat() {
		GameObj cat = new GameObj(QuickLoad("cat64"), 32, 32,
				(int) character.getX() - 25, (int) character.getY() + 25,
				character);
		cat.Draw();
	}

	public void cat2(int x, int y) {
		GameObj cat2 = new GameObj(QuickLoad("cat64"), 32, 32, x, y);
		cat2.Draw();
	}

	public void Entrance1() {
		Artist.DrawQuadTex(stairs, 0, 0, 1024, 1024);
		Artist.DrawQuadTex(fountain1, 0, 0, 1020, 1024);

	}

	public void Entrance2() {
		Artist.DrawQuadTex(stairs2, 0, 0, 1024, 1024);
		Artist.DrawQuadTex(fountain2, 0, 0, 1024, 1024);

	}

	public void Update() {

		if (character.getLevel() == 1) {
			cat();
		}
		if (character.getLevel() == 0) {
			// cat2();
		}

	}

	public void Outside_Mansion() {
		// TODO Auto-generated method stub

	}

	public void Ballroom6() {
		Artist.DrawQuadTex(ballroom6, 0, 0, 1024, 1024);

	}

	public void Ballroom5() {
		Artist.DrawQuadTex(ballroom5, 0, 0, 1024, 1024);

	}

	public void Ballroom4() {
		Artist.DrawQuadTex(ballroom4, 0, 0, 1024, 1024);
	}

	public void Ballroom3() {
		Artist.DrawQuadTex(ballroom3, 0, 0, 1024, 1024);

	}

	public void Ballroom2() {
		Artist.DrawQuadTex(ballroom2, 0, 0, 1024, 1024);

	}

	public void Ballroom1() {
		Artist.DrawQuadTex(ballroom1, 0, 0, 1024, 1024);

	}

	public void Diningroom6() {
		Artist.DrawQuadTex(Diningroom6, 0, 0, 1024, 1024);

	}

	public void Diningroom5() {
		Artist.DrawQuadTex(Diningroom5, 0, 0, 1024, 1024);

	}

	public void Diningroom4() {
		Artist.DrawQuadTex(Diningroom4, 0, 0, 1024, 1024);

	}

	public void Diningroom3() {
		Artist.DrawQuadTex(Diningroom3, 0, 0, 1024, 1024);

	}

	public void Diningroom2() {
		Artist.DrawQuadTex(Diningroom2, 0, 0, 1024, 1024);

	}

	public void Diningroom1() {
		Artist.DrawQuadTex(Diningroom1, 0, 0, 1024, 1024);

	}

	public void Livingroom1() {
		Artist.DrawQuadTex(Livingroom1, 0, 0, 1024, 1024);

	}

	public void Livingroom2() {
		Artist.DrawQuadTex(Livingroom2, 0, 0, 1024, 1024);

	}

	public void Livingroom3() {
		Artist.DrawQuadTex(Livingroom3, 0, 0, 1024, 1024);

	}

	public void Livingroom4() {
		Artist.DrawQuadTex(Livingroom4, 0, 0, 1024, 1024);

	}

	public void Livingroom5() {
		Artist.DrawQuadTex(Livingroom5, 0, 0, 1024, 1024);

	}

	public void Library1() {
		Artist.DrawQuadTex(Library1, 0, 0, 1024, 1024);

	}

	public void Library2() {
		Artist.DrawQuadTex(Library2, 0, 0, 1024, 1024);

	}

	public void Library3() {
		Artist.DrawQuadTex(Library3, 0, 0, 1024, 1024);

	}

	public void Library4() {
		Artist.DrawQuadTex(Library4, 0, 0, 1024, 1024);

	}

	public void Library5() {
		Artist.DrawQuadTex(Library5, 0, 0, 1024, 1024);

	}

	public void Library6() {
		Artist.DrawQuadTex(Library6, 0, 0, 1024, 1024);

	}

	public void Library7() {
		Artist.DrawQuadTex(Library7, 0, 0, 1024, 1024);

	}

	public void Library8() {
		Artist.DrawQuadTex(Library8, 0, 0, 1024, 1024);

	}

	public void Library9() {
		Artist.DrawQuadTex(Library9, 0, 0, 1024, 1024);

	}

	public void Artgallery1() {
		Artist.DrawQuadTex(Artgallery1, 0, -100, 1024, 1024);

	}

	public void Artgallery2() {
		Artist.DrawQuadTex(Artgallery2, 0, -100, 1024, 1024);

	}

	public void Artgallery3() {
		Artist.DrawQuadTex(Artgallery3, 0, 0, 1024, 1024);

	}

}
