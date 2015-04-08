package game;

public class CollisionGrid {
	public static final int COLUMN = 40;
	public static final int ROW = 40;
	public static int tileSize = 16;

	public static Tile[][] map;
	private GameCharSprite character;

	public CollisionGrid(int[][] newMap) {
		this.character = character;
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
	public void setTile(int xCoord, int yCoord, boolean canCollide) {
		map[xCoord][yCoord] = new Tile(xCoord * tileSize, yCoord * tileSize,
				tileSize, tileSize, canCollide);
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
	public boolean findNextT() {

		if (getTile((int) character.getX()/16, (int) character.getY()/16+1).canCollide()) {
			{
				System.out.println("Top");
				return true;
			}
		}
		return false;

	}

	public boolean findNextB() {

		if (getTile((int) character.getX()/16, (int)character.getY()/16-1).canCollide()) {
			{
				System.out.println("Bottom");
				return true;
			}
		}
		return false;

	}

	public boolean findNextL() {

		if (getTile((int) character.getX()/16-1, (int) character.getY()/16).canCollide()) {
			{
				 System.out.println("Left"+character.getXInt2());
				return true;
			}
		}
		return false;

	}

	public boolean findNextR() {

		if (getTile((int) character.getX()/16+1, (int) character.getY()/16).canCollide()) {
			{
				 System.out.println("Right");
				return true;
			}
		}
		return false;

	}

}
