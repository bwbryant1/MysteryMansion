package game;

import gameitems.Items;
import gameitems.allies;
import gameitems.powerUps;
import helpers.Artist;

import org.newdawn.slick.opengl.Texture;

public class Inventory {
	private static Items[] InventorySlot;
	private static int constantX = 48;
	private Texture inventoryPic;
	private Items[] items;
	private powerUps[] powerUps;
	private allies[] allies;
	private int constantY = -48;
	private int slot_0_X,slot_1_X,slot_2_X,slot_3_X,slot_4_X,slot_5_X,slot_6_X,slot_7_X,slot_8_X,slot_9_X,slot_10_X,slot_11_X;

	private int slot_0_Y,slot_1_Y,slot_2_Y,slot_3_Y,slot_4_Y,slot_5_Y,slot_6_Y,slot_7_Y,slot_8_Y,slot_9_Y,slot_10_Y,slot_11_Y;

	public Inventory() {
		InventorySlot = new Items[12];

		inventoryPic = Artist.QuickLoad("images/gui");
		loadItems();

	}

	public void addItem(int inventorySlot, String text) {
		switch (text) {
		case "sword":
			InventorySlot[inventorySlot] = Items.sword();
			break;
		case "empty":
			InventorySlot[inventorySlot] = Items.empty();
			break;

		}

	}

	private void Draw() {
		
		//Draws the background for the GUI
		Artist.DrawQuadTex(inventoryPic, 640 + constantX, 275 + constantY,
				64 * 4, 256);
		//Draws each item in the inventory. so far 12 items (0-11)
		for (int itemNum = 0; itemNum < InventorySlot.length; itemNum++) {

			switch (itemNum) {
			case 0:
				Artist.DrawQuadTex(InventorySlot[0].getImage(),
						slot_0_X ,slot_0_Y , 64, 64);
			case 1:
				Artist.DrawQuadTex(InventorySlot[1].getImage(),
						slot_1_X , slot_1_Y , 64, 64);
			case 2:
				Artist.DrawQuadTex(InventorySlot[2].getImage(),
						slot_2_X , slot_2_Y, 64, 64);
			case 3:
				Artist.DrawQuadTex(InventorySlot[3].getImage(),
						slot_3_X , slot_3_Y, 64, 64);
			case 4:
				Artist.DrawQuadTex(InventorySlot[4].getImage(),
						slot_4_X , slot_4_Y, 64, 64);
			case 5:
				Artist.DrawQuadTex(InventorySlot[5].getImage(),
						slot_5_X , slot_5_Y, 64, 64);
			case 6:
				Artist.DrawQuadTex(InventorySlot[6].getImage(),
						slot_6_X ,slot_6_Y, 64, 64);
			case 7:
				Artist.DrawQuadTex(InventorySlot[7].getImage(),
						slot_7_X , slot_7_Y, 64, 64);
			case 8:
				Artist.DrawQuadTex(InventorySlot[8].getImage(),
						slot_8_X , slot_8_Y, 64, 64);
			case 9:
				Artist.DrawQuadTex(InventorySlot[9].getImage(),
						slot_9_X , slot_9_Y, 64, 64);
			case 10:
				Artist.DrawQuadTex(InventorySlot[10].getImage(),
						slot_10_X , slot_10_Y, 64, 64);
			case 11:
				Artist.DrawQuadTex(InventorySlot[11].getImage(),
						slot_11_X , slot_11_Y, 64, 64);

			}
		}

	}

	public void equip(int slot, boolean b) {
			InventorySlot[slot].setEquipped(b);
			

	}

	public static Items getInventorySlot(int slot) {
		return InventorySlot[slot];
	}

	public int getSlot_0_X() {
		return slot_0_X;
	}
	public int getSlot_0_Y() {
		return slot_0_Y;
	}

	public int getSlot_1_X() {
		return slot_1_X;
	}
	public int getSlot_1_Y() {
		return slot_1_Y;
	}

	public int getSlot_10_X() {
		return slot_10_X;
	}

	public int getSlot_10_Y() {
		return slot_10_Y;
	}

	public int getSlot_11_X() {
		return slot_11_X;
	}

	public int getSlot_11_Y() {
		return slot_11_Y;
	}

	public int getSlot_2_X() {
		return slot_2_X;
	}

	public int getSlot_2_Y() {
		return slot_2_Y;
	}

	public int getSlot_3_X() {
		return slot_3_X;
	}

	public int getSlot_3_Y() {
		return slot_3_Y;
	}

	public int getSlot_4_X() {
		return slot_4_X;
	}

	public int getSlot_4_Y() {
		return slot_4_Y;
	}

	public int getSlot_5_X() {
		return slot_5_X;
	}

	public int getSlot_5_Y() {
		return slot_5_Y;
	}

	public int getSlot_6_X() {
		return slot_6_X;
	}

	public int getSlot_6_Y() {
		return slot_6_Y;
	}

	public int getSlot_7_X() {
		return slot_7_X;
	}

	public int getSlot_7_Y() {
		return slot_7_Y;
	}

	public int getSlot_8_X() {
		return slot_8_X;
	}

	public int getSlot_8_Y() {
		return slot_8_Y;
	}

	public int getSlot_9_X() {
		return slot_9_X;
	}

	public int getSlot_9_Y() {
		return slot_9_Y;
	}

	public boolean isClicked(){
		
		return false;
		
	}

	public boolean isEmpty(int slot){
		if(InventorySlot[slot].getImageNum()==0){
			
			return true;
		}
		return false;
	}

	public void loadItems() {
		//row 1
		slot_0_X = 640 + constantX;
		slot_0_Y = 275 + constantY;
		slot_1_X = 640+64 + constantX;
		slot_1_Y = 275 + constantY;
		slot_2_X = 640+128 + constantX;
		slot_2_Y = 275 + constantY;
		//row 2
		 slot_3_X = 640 + constantX;
		 slot_3_Y = 275+64 + constantY;
		 slot_4_X = 640+64 + constantX;
		 slot_4_Y = 275+64 + constantY;
		 slot_5_X = 640+128 + constantX;
		 slot_5_Y = 275+64 + constantY;
		//row 3
		 slot_6_X = 640 + constantX;
		 slot_6_Y = 275+128 + constantY;
		 slot_7_X = 640+64 + constantX;
		 slot_7_Y = 275+128 + constantY;
		 slot_8_X = 640+128 + constantX;
		 slot_8_Y = 275+128 + constantY;
		//row 4
		slot_9_X = 640 + constantX;
		slot_9_Y = 275+192 + constantY;
		slot_10_X = 640+64 + constantX;
		slot_10_Y = 275+192 + constantY;
		slot_11_X = 640+128 + constantX;
		slot_11_Y = 275+192 + constantY;
		
		
		InventorySlot[0] = new Items("no item", 0, 0, 0);
		InventorySlot[1] = new Items("no item", 0, 0, 0);
		InventorySlot[2] = new Items("no item", 0, 0, 0);
		InventorySlot[3] = new Items("no item", 0, 0, 0);
		InventorySlot[4] = new Items("no item", 0, 0, 0);
		InventorySlot[5] = new Items("no item", 0, 0, 0);
		InventorySlot[6] = new Items("no item", 0, 0, 0);
		InventorySlot[7] = new Items("no item", 0, 0, 0);
		InventorySlot[8] = new Items("no item", 0, 0, 0);
		InventorySlot[9] = new Items("no item", 0, 0, 0);
		InventorySlot[10] = new Items("no item", 0, 0, 0);
		InventorySlot[11] = new Items("no item", 0, 0, 0);

	}

	public void Update() {
		
		Draw();

	}

	public int getSlot(int xCoordM, int yCoordM) {
		if(xCoordM >= slot_0_X && xCoordM <= slot_0_X+64 && yCoordM >= slot_0_Y && yCoordM <= slot_0_Y+64){
			return 0;
		}
		if(xCoordM >= slot_1_X && xCoordM <= slot_1_X+64 && yCoordM >= slot_1_Y && yCoordM <= slot_1_Y+64){
			return 1;
		}
		if(xCoordM >= slot_2_X && xCoordM <= slot_2_X+64 && yCoordM >= slot_2_Y && yCoordM <= slot_2_Y+64){
			return 2;
		}
		if(xCoordM >= slot_3_X && xCoordM <= slot_3_X+64 && yCoordM >= slot_3_Y && yCoordM <= slot_3_Y+64){
			return 3;
		}
		if(xCoordM >= slot_4_X && xCoordM <= slot_4_X+64 && yCoordM >= slot_4_Y && yCoordM <= slot_4_Y+64){
			return 4;
		}
		if(xCoordM >= slot_5_X && xCoordM <= slot_5_X+64 && yCoordM >= slot_5_Y && yCoordM <= slot_5_Y+64){
			return 5;
		}
		if(xCoordM >= slot_6_X && xCoordM <= slot_6_X+64 && yCoordM >= slot_6_Y && yCoordM <= slot_6_Y+64){
			return 6;
		}
		if(xCoordM >= slot_7_X && xCoordM <= slot_7_X+64 && yCoordM >= slot_7_Y && yCoordM <= slot_7_Y+64){
			return 7;
		}
		if(xCoordM >= slot_8_X && xCoordM <= slot_8_X+64 && yCoordM >= slot_8_Y && yCoordM <= slot_8_Y+64){
			return 8;
		}
		if(xCoordM >= slot_9_X && xCoordM <= slot_9_X+64 && yCoordM >= slot_9_Y && yCoordM <= slot_9_Y+64){
			return 9;
		}
		if(xCoordM >= slot_10_X && xCoordM <= slot_10_X+64 && yCoordM >= slot_10_Y && yCoordM <= slot_10_Y+64){
			return 10;
		}
		if(xCoordM >= slot_11_X && xCoordM <= slot_11_X+64 && yCoordM >= slot_11_Y && yCoordM <= slot_11_Y+64){
			return 11;
		}
		return 12;
	}
	

}
