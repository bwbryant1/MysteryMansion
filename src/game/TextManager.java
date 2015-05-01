package game;

import java.util.ArrayList;

import org.newdawn.slick.Color;

public class TextManager {
	
	public TextString[] textCall;
	private TextString Paused;
	private TextString Title;
	private TextString CombatDialogue;
	private static TextString Level,Health;
	
	public TextManager() {
		textCall = new TextString[40];
		makeTextStrings();
	
}
	
	public void callText(int index){
		
		textCall[index].Update();
		
	}
public TextString getText(int index){
		
		return textCall[index];
		
	}
	
	private void makeTextStrings(){
		
		Level = new TextString(750, 250, null, Color.red,1);
		Health = new TextString(300, 300, null, Color.red,3);
		Paused = new TextString(640/2, 640/2, "PAUSED", Color.blue,1);
		Title = new TextString(60, 640/2, "Mystery Mansion of Forgotten Sorrows", Color.red,1);
		CombatDialogue = new TextString(60, 60, "A wild cary appears", Color.black,1);
		//Title.makeString();
		textCall[0]=Title;
		//Paused.makeString();
		textCall[1]=Paused;
		//Health.makeString();
		textCall[2]= (Health);
		//Level.makeString();
		textCall[3]=(Level);
		textCall[4]=(CombatDialogue);
		
		
	}
	public void setText(TextString text, String string,int x, int y,Color color){
		text.setText(string, x, y, color);
		
	}
}
