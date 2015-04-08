package game;

import java.util.ArrayList;

import org.newdawn.slick.Color;

public class TextManager {
	
	public ArrayList textCall;
	private TextString Paused;
	private TextString Title;
	private static TextString Level,Health;
	
	public TextManager() {
		textCall = new ArrayList<TextString>();
		makeTextStrings();
	
}
	
	public void callText(int index){
		
		((TextString) textCall.get(index)).Update();
		
	}
public TextString getText(int index){
		
		return ((TextString) textCall.get(index));
		
	}
	
	private void makeTextStrings(){
		
		Level = new TextString(750, 250, null, Color.red,1);
		Health = new TextString(300, 300, null, Color.red,3);
		Paused = new TextString(640/2, 640/2, "PAUSED", Color.blue,1);
		Title = new TextString(60, 640/2, "Mystery Mansion of Forgotten Sorrows", Color.red,1);
		//Title.makeString();
		textCall.add(Title);
		//Paused.makeString();
		textCall.add(Paused);
		//Health.makeString();
		textCall.add(Health);
		//Level.makeString();
		textCall.add(Level);
		
		
	}
	public void setText(TextString text, String string,int x, int y,Color color){
		text.setText(string, x, y, color);
		
	}
}
