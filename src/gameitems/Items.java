package gameitems;

import helpers.Artist;

import org.newdawn.slick.opengl.Texture;

public class Items {

	private String itemName;
	private int value, damage, cost;
	private Texture image;

	public Items(String itemName, int damage, int value, int image) {
		this.itemName = itemName;
		this.damage = damage;
		this.value = value;
		this.image = getImage(image);

	}

	private Texture getImage(int image) {
		switch (image) {
		case 0:
			return Artist.QuickLoad("items/BlankTile");
		case 1:

			return Artist.QuickLoad("items/potion");
		case 2:
			return Artist.QuickLoad("items/potion2");

		}
		return null;

	}

	public Texture getImage() {
		return image;
	}

	public void setImage(Texture image) {
		this.image = image;
	}

}
