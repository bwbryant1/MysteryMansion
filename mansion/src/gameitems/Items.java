package gameitems;

import helpers.Artist;

import org.newdawn.slick.opengl.Texture;

public class Items {

	public static Items empty() {
		Items item = new Items("no item", 0, 0, 0);
		return item;
	}
	public static Items sword() {
		Items item = new Items("Sword", 25, 1000, 2);
		return item;
	}
	private String itemName;
	private int value, damage, cost;
	private boolean isEquipped;

	private Texture image;

	private int imageNum;

	public Items(String itemName, int damage, int value, int image) {
		this.itemName = itemName;
		this.damage = damage;
		this.value = value;
		this.imageNum = image;

		this.image = getImage(image);
		this.isEquipped = false;

	}

	public int getCost() {
		return cost;
	}

	public int getDamage() {
		return damage;
	}

	public Texture getImage() {
		return image;
	}

	private Texture getImage(int image) {
		if (isEquipped == true) {
			switch (image) {
			case 0:
				return Artist.QuickLoad("items/BlankTile");
			case 1:

				return Artist.QuickLoad("items/potion_E");
			case 2:
				return Artist.QuickLoad("items/sword_E");

			}
		} else {
			switch (image) {
			case 0:
				return Artist.QuickLoad("items/BlankTile");
			case 1:

				return Artist.QuickLoad("items/potion");
			case 2:
				return Artist.QuickLoad("items/sword");

			}
		}
		return null;

	}

	public int getImageNum() {
		return imageNum;
	}

	public String getItemName() {
		return itemName;
	}

	public int getValue() {
		return value;
	}

	public boolean isEquipped() {
		return isEquipped;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public void setEquipped(boolean isEquipped) {
		this.isEquipped = isEquipped;
	}

	public void setImage(Texture image) {
		this.image = image;
	}

	public void setImageNum(int imageNum) {
		this.imageNum = imageNum;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
