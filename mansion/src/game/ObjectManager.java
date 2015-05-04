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

	public ObjectManager(GameCharSprite character) {
		this.character = character;
		stairs = Artist.QuickLoad("maps/Stairs_01");
		stairs2 = Artist.QuickLoad("maps/Stairs_02");
		fountain1 = Artist.QuickLoad("entrance/image/fountain_01");
		fountain2 = Artist.QuickLoad("entrance/image/fountain_02");
	}
	
	
	public void cat(){
		GameObj cat = new GameObj(QuickLoad("cat64"), 32, 32, (int)character.getX()-25, (int)character.getY()+25, character);
		cat.Draw();
	}
	
	public void cat2(int x, int y){
		GameObj cat2 = new GameObj(QuickLoad("cat64"), 32, 32, x, y);
		cat2.Draw();
	}
	public void Entrance1(){
		Artist.DrawQuadTex(stairs, 0, 0, 1024, 1024);
		Artist.DrawQuadTex(fountain1, 0, 0, 1020, 1024);
		
		
	}
	public void Entrance2(){
		Artist.DrawQuadTex(stairs2, 0, 0, 1024, 1024);
		Artist.DrawQuadTex(fountain2, 0, 0, 1024, 1024);
		
	}
	public void Update(){
		
		
		if(character.getLevel() == 1){
			cat();
		}
		if(character.getLevel() == 0){
			//cat2();
		}
		
			
	}
}
