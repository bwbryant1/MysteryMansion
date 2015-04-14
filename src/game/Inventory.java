package game;

import java.util.ArrayList;

import static gameitems.powerUps.*;

import org.newdawn.slick.opengl.Texture;

import gameitems.Items;
import gameitems.powerUps;
import gameitems.allies;
import helpers.Artist;

public class Inventory {
	private Texture inventoryPic;
	private Items[] items;
	private powerUps[] powerUps;
	private allies[] allies;
	private static Items[] InventorySlot;
	private int constantY = -48;
	private static int constantX = 48;

	public Inventory() {
		InventorySlot = new Items[12];

		inventoryPic = Artist.QuickLoad("images/gui");
		loadItems();

	}

	public void Update() {
		Artist.DrawQuadTex(inventoryPic, 640 + constantX, 275 + constantY,
				64 * 4, 256);
		Draw();

	}

	private void Draw() {
		for (int itemNum = 0; itemNum < InventorySlot.length; itemNum++) {

			switch (itemNum) {
			case 0:
				Artist.DrawQuadTex(InventorySlot[0].getImage(),
						640 + constantX, 275 + constantY, 64, 64);
			case 1:
				Artist.DrawQuadTex(InventorySlot[1].getImage(),
						640 + 64 + constantX, 275 + constantY, 64, 64);
			case 2:
				Artist.DrawQuadTex(InventorySlot[2].getImage(),
						640 + 128 + constantX, 275 + constantY, 64, 64);
			case 3:
				Artist.DrawQuadTex(InventorySlot[3].getImage(),
						640 + constantX, 275 + 64 + constantY, 64, 64);
			case 4:
				Artist.DrawQuadTex(InventorySlot[4].getImage(),
						640 + 64 + constantX, 275 + 64 + constantY, 64, 64);
			case 5:
				Artist.DrawQuadTex(InventorySlot[5].getImage(),
						640 + 128 + constantX, 275 + 64 + constantY, 64, 64);
			case 6:
				Artist.DrawQuadTex(InventorySlot[6].getImage(),
						640 + constantX, 275 + 128 + constantY, 64, 64);
			case 7:
				Artist.DrawQuadTex(InventorySlot[7].getImage(),
						640 + 64 + constantX, 275 + 128 + constantY, 64, 64);
			case 8:
				Artist.DrawQuadTex(InventorySlot[8].getImage(),
						640 + 128 + constantX, 275 + 128 + constantY, 64, 64);
			case 9:
				Artist.DrawQuadTex(InventorySlot[9].getImage(),
						640 + constantX, 275 + 192 + constantY, 64, 64);
			case 10:
				Artist.DrawQuadTex(InventorySlot[10].getImage(),
						640 + 64 + constantX, 275 + 192 + constantY, 64, 64);
			case 11:
				Artist.DrawQuadTex(InventorySlot[11].getImage(),
						640 + 128 + constantX, 275 + 192 + constantY, 64, 64);

			}
		}

	}

	public void loadItems() {
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

	public void equip(int slot, boolean b) {
			InventorySlot[slot].setEquipped(b);
			

	}

	public static Items getInventorySlot(int slot) {
		return InventorySlot[slot];
	}
	public boolean isEmpty(int slot){
		if(InventorySlot[slot].getImageNum()==0){
			
			return true;
		}
		return false;
	}
	

}
