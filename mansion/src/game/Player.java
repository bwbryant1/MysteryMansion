package game;

import static helpers.Artist.*;
import gameitems.Items;
import helpers.Artist;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Input;
import org.newdawn.slick.opengl.Texture;

public class Player {

	private int xCoordM;
	private int yCoordM;
	private int xPosM;
	private int yPosM;
	private static Inventory inventory;
	private boolean hasClicked = false;
	private Texture slot0, slot1, slot2, slot3, slot4, slot5, slot6, slot7,
			slot8, slot9, slot10, slot11;
	private Items[] backpack;
	private GameCharSprite character;

	public Player(Inventory inventory, GameCharSprite character2) {
		this.inventory = inventory;
		this.character = character2;
		storeItems();
	}

	public void getPos() {
		xCoordM = Mouse.getX();

		yCoordM = (HEIGHT - Mouse.getY() - 1);

		// int MAX = (WIDTH / (TileGrid.tilesize()) - 1);

	}

	public void Update() {
		getPos();
		// System.out.println(xCoordM + " " + yCoordM + " "+
		// Mouse.isButtonDown(Input.MOUSE_LEFT_BUTTON));
		if (Mouse.isButtonDown(Input.MOUSE_LEFT_BUTTON) && !hasClicked) {
			hasClicked = true;
			// System.out.println(inventory.getSlot(xCoordM, yCoordM));
			inventory.isClicked(inventory.getSlot(xCoordM, yCoordM));
			character.setSpeed(100);
			for (int i = 0; i < inventory.getInventorySlot().length; i++) {
				String text = inventory.getInventorySlot()[i].getItemName();
				switch(text){
				case "no item":
					
					break;
					
				
				case "Sword":
					
					break;
				case "Speed":
					character.setSpeed(200);
					break;
				
				}
			}

			// storeItems();

		}
		if (!Mouse.isButtonDown(Input.MOUSE_LEFT_BUTTON)) {
			hasClicked = false;
		}
		if (Mouse.isButtonDown(Input.MOUSE_RIGHT_BUTTON) && !hasClicked) {
			hasClicked = true;
			// System.out.println(inventory.getSlot(xCoordM, yCoordM));
			inventory.isClicked(inventory.getSlot(xCoordM, yCoordM));

			// storeItems();

		}
		if (!Mouse.isButtonDown(Input.MOUSE_RIGHT_BUTTON)) {
			hasClicked = false;
		}
		hover(xCoordM, yCoordM);

	}

	public void hover(int xCoordM, int yCoordM) {

		if (xCoordM >= inventory.getSlot_0_X()
				&& xCoordM <= inventory.getSlot_0_X() + 64
				&& yCoordM >= inventory.getSlot_0_Y()
				&& yCoordM <= inventory.getSlot_0_Y() + 64) {
			inventory.getInventorySlot(0).setImage(getImage());

		} else {
			inventory.getInventorySlot(0).setImage(slot0);
		}
		if (xCoordM >= inventory.getSlot_1_X()
				&& xCoordM <= inventory.getSlot_1_X() + 64
				&& yCoordM >= inventory.getSlot_1_Y()
				&& yCoordM <= inventory.getSlot_1_Y() + 64) {
			inventory.getInventorySlot(1).setImage(getImage());

		} else {
			inventory.getInventorySlot(1).setImage(slot1);
		}
		if (xCoordM >= inventory.getSlot_2_X()
				&& xCoordM <= inventory.getSlot_2_X() + 64
				&& yCoordM >= inventory.getSlot_2_Y()
				&& yCoordM <= inventory.getSlot_2_Y() + 64) {
			inventory.getInventorySlot(2).setImage(getImage());

		} else {
			inventory.getInventorySlot(2).setImage(slot2);
		}
		if (xCoordM >= inventory.getSlot_3_X()
				&& xCoordM <= inventory.getSlot_3_X() + 64
				&& yCoordM >= inventory.getSlot_3_Y()
				&& yCoordM <= inventory.getSlot_3_Y() + 64) {
			inventory.getInventorySlot(3).setImage(getImage());

		} else {
			inventory.getInventorySlot(3).setImage(slot3);
		}
		if (xCoordM >= inventory.getSlot_4_X()
				&& xCoordM <= inventory.getSlot_4_X() + 64
				&& yCoordM >= inventory.getSlot_4_Y()
				&& yCoordM <= inventory.getSlot_4_Y() + 64) {
			inventory.getInventorySlot(4).setImage(getImage());

		} else {
			inventory.getInventorySlot(4).setImage(slot4);
		}
		if (xCoordM >= inventory.getSlot_5_X()
				&& xCoordM <= inventory.getSlot_5_X() + 64
				&& yCoordM >= inventory.getSlot_5_Y()
				&& yCoordM <= inventory.getSlot_5_Y() + 64) {
			inventory.getInventorySlot(5).setImage(getImage());

		} else {
			inventory.getInventorySlot(5).setImage(slot5);
		}
		if (xCoordM >= inventory.getSlot_6_X()
				&& xCoordM <= inventory.getSlot_6_X() + 64
				&& yCoordM >= inventory.getSlot_6_Y()
				&& yCoordM <= inventory.getSlot_6_Y() + 64) {
			inventory.getInventorySlot(6).setImage(getImage());

		} else {
			inventory.getInventorySlot(6).setImage(slot6);
		}
		if (xCoordM >= inventory.getSlot_7_X()
				&& xCoordM <= inventory.getSlot_7_X() + 64
				&& yCoordM >= inventory.getSlot_7_Y()
				&& yCoordM <= inventory.getSlot_7_Y() + 64) {
			inventory.getInventorySlot(7).setImage(getImage());

		} else {
			inventory.getInventorySlot(7).setImage(slot7);
		}
		if (xCoordM >= inventory.getSlot_8_X()
				&& xCoordM <= inventory.getSlot_8_X() + 64
				&& yCoordM >= inventory.getSlot_8_Y()
				&& yCoordM <= inventory.getSlot_8_Y() + 64) {
			inventory.getInventorySlot(8).setImage(getImage());

		} else {
			inventory.getInventorySlot(8).setImage(slot8);
		}
		if (xCoordM >= inventory.getSlot_9_X()
				&& xCoordM <= inventory.getSlot_9_X() + 64
				&& yCoordM >= inventory.getSlot_9_Y()
				&& yCoordM <= inventory.getSlot_9_Y() + 64) {
			inventory.getInventorySlot(9).setImage(getImage());

		} else {
			inventory.getInventorySlot(9).setImage(slot9);
		}
		if (xCoordM >= inventory.getSlot_10_X()
				&& xCoordM <= inventory.getSlot_10_X() + 64
				&& yCoordM >= inventory.getSlot_10_Y()
				&& yCoordM <= inventory.getSlot_10_Y() + 64) {
			inventory.getInventorySlot(10).setImage(getImage());

		} else {
			inventory.getInventorySlot(10).setImage(slot10);
		}
		if (xCoordM >= inventory.getSlot_11_X()
				&& xCoordM <= inventory.getSlot_11_X() + 64
				&& yCoordM >= inventory.getSlot_11_Y()
				&& yCoordM <= inventory.getSlot_11_Y() + 64) {
			inventory.getInventorySlot(11).setImage(getImage());

		} else {
			inventory.getInventorySlot(11).setImage(slot11);
		}

	}

	private Texture getImage() {
		String text = inventory.getBackpack()[inventory.getCurrentIndex()]
				.getItemName();
		switch (text) {
		case "Sword":
			return inventory.getSword();
		case "no item":
			return inventory.getBlank();

		case "Strength":
			return inventory.getStrength();
		case "Speed":
			return inventory.getSpeed();

		}
		return inventory.getBlank();
	}

	private void storeItems() {
		slot0 = Inventory.getInventorySlot(0).getImage();
		slot1 = inventory.getInventorySlot(0).getImage();
		slot2 = inventory.getInventorySlot(0).getImage();
		slot3 = inventory.getInventorySlot(0).getImage();
		slot4 = inventory.getInventorySlot(0).getImage();
		slot5 = inventory.getInventorySlot(0).getImage();
		slot6 = inventory.getInventorySlot(0).getImage();
		slot7 = inventory.getInventorySlot(0).getImage();
		slot8 = inventory.getInventorySlot(0).getImage();
		slot9 = inventory.getInventorySlot(0).getImage();
		slot10 = inventory.getInventorySlot(0).getImage();
		slot11 = inventory.getInventorySlot(0).getImage();

	}

	public void setCharacter(GameCharSprite character) {
		this.character = character;
	}

}