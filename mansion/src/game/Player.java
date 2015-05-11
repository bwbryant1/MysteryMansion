package game;

import static helpers.Artist.*;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Input;

public class Player {

	private int xCoordM;
	private int yCoordM;
	private int xPosM;
	private int yPosM;
private Inventory inventory;
	public Player(Inventory inventory) {
		this.inventory = inventory;
	}

	public void getPos() {
		xCoordM = Mouse.getX();

		 yCoordM = (HEIGHT -Mouse.getY()-1);

		// int MAX = (WIDTH / (TileGrid.tilesize()) - 1);



	}
	public void Update() {
		getPos();
		//System.out.println(xCoordM + " " + yCoordM + " "+ Mouse.isButtonDown(Input.MOUSE_LEFT_BUTTON));
		if(Mouse.isButtonDown(Input.MOUSE_LEFT_BUTTON)){
			
			System.out.println(inventory.getSlot(xCoordM,yCoordM));
		}
	}





}