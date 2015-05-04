package game;

public class CollisionGrid {
	public static final int COLUMN = 40;
	public static final int ROW = 40;
	public static int tileSize = 16;

	public static Tile[][] map;

	public CollisionGrid(int[][] newMap) {
		map = new Tile[COLUMN][ROW];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				switch (newMap[j][i]) {
				case 0:
					map[i][j] = new Tile(i * tileSize, j * tileSize, tileSize,
							tileSize, false);
					break;
				case 1:
					map[i][j] = new Tile(i * tileSize, j * tileSize, tileSize,
							tileSize, true);
					break;
				}
			}
		}
	}
	public Tile getTile(int xPlace, int yPlace) {

		if (xPlace < 0) {
			return map[0][yPlace];

		}
		if (yPlace < 0){
			return map[xPlace][0];
		}

		return map[xPlace][yPlace];
	}
	public void setGrid(int[][] newLevel) {
		System.out.println("on");

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				switch (newLevel[j][i]) {
				case 0:
					
				setTile(i, j, false);
				map[i][j] = new Tile(i * tileSize, j * tileSize, tileSize,
						tileSize, false);
					break;
				
				case 1:

					setTile(i, j, true);
					map[i][j] = new Tile(i * tileSize, j * tileSize, tileSize,
							tileSize, true);
					
					break;
				case 2:

					setTile(i, j, true);
					map[i][j] = new Tile(i * tileSize, j * tileSize, tileSize,
							tileSize, true);
					
					break;
				}
			}
		}
	}
	public void setTile(int xCoord, int yCoord, boolean canCollide) {
		map[xCoord][yCoord] = new Tile(xCoord * tileSize, yCoord * tileSize,
				tileSize, tileSize, canCollide);
	}
	public void setTileCollide(int xCoord, int yCoord, boolean canCollide) {
		map[xCoord][yCoord] = new Tile(xCoord * tileSize, yCoord * tileSize,
				tileSize, tileSize, canCollide);
	}
	

	

}
