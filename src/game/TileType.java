package game;

public enum TileType {

	Floor("floor", true),Blank("blank", true), FloorL("floorL", true), FloorR("floorR", true), FloorLB(
			"floorLB", true), FloorLU("floorLU", true), FloorRB("floorRB", true), FloorRU(
			"floorRU", true), FloorT("floorT", true), FloorB("floorB", true),Background("background",true),GUI("gui",true);

	String textureName;
	boolean buildable;

	TileType(String textureName, boolean buildable) {

		this.textureName = textureName;
		this.buildable = buildable;

	}

}
