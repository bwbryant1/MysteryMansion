package gameitems;

import helpers.Artist;

import org.newdawn.slick.opengl.Texture;

public class Items {

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

	public int getImageNum() {
		return imageNum;
	}

	public void setImageNum(int imageNum) {
		this.imageNum = imageNum;
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

	public Texture getImage() {
		return image;
	}

	public void setImage(Texture image) {
		this.image = image;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public boolean isEquipped() {
		return isEquipped;
	}

	public void setEquipped(boolean isEquipped) {
		this.isEquipped = isEquipped;
	}

	public static Items sword() {
		Items item = new Items("Sword", 25, 1000, 2);
		return item;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public static Items empty() {
		Items item = new Items("no item", 0, 0, 0);
		return item;
	}

}
