package game;

import static helpers.Artist.DrawQuadTex;

public class TileGrid {
	public static final int COLUMN = 10;
	public static final int ROW = 10;
	public static int tileSize = 64;
	public static float currentTime, lastTime;

	public static Tile[][] map;

	public static int tilesize() {
		return tileSize;
	}

	public TileGrid(int[][] newMap) {
		map = new Tile[COLUMN][ROW];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				switch (newMap[j][i]) {
				case 0:
					map[i][j] = new Tile(i * tileSize, j * tileSize, tileSize,
							tileSize, TileType.Floor);
					break;
				case 1:
					map[i][j] = new Tile(i * tileSize, j * tileSize, tileSize,
							tileSize, TileType.FloorL);
					break;
				case 2:
					map[i][j] = new Tile(i * tileSize, j * tileSize, tileSize,
							tileSize, TileType.FloorR);
					break;
				case 3:
					map[i][j] = new Tile(i * tileSize, j * tileSize, tileSize,
							tileSize, TileType.FloorT);
					break;
				case 4:
					map[i][j] = new Tile(i * tileSize, j * tileSize, tileSize,
							tileSize, TileType.FloorB);
					break;
				case 10:
					map[i][j] = new Tile(i * tileSize, j * tileSize, tileSize,
							tileSize, TileType.FloorLU);
					break;
				case 11:
					map[i][j] = new Tile(i * tileSize, j * tileSize, tileSize,
							tileSize, TileType.FloorRU);
					break;
				case 12:
					map[i][j] = new Tile(i * tileSize, j * tileSize, tileSize,
							tileSize, TileType.FloorRB);
					break;
				case 13:
					map[i][j] = new Tile(i * tileSize, j * tileSize, tileSize,
							tileSize, TileType.FloorLB);
					break;
				case 100:
					map[i][j] = new Tile(i * tileSize, j * tileSize, tileSize,
							tileSize, TileType.Blank);
					break;
				
				}
			}
		}
	}

	public void Draw() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				Tile t = map[i][j];
				DrawQuadTex(t.getTexture(), t.getX(), t.getY(), t.getWidth(),
						t.getHeight());
			}
		}
	}

	public Tile getTile(int xPlace, int yPlace) {

		if (xPlace < 0) {
			return map[0][yPlace];

		}

		return map[xPlace][yPlace];
	}

	public void setGrid(int[][] newLevel) {

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				switch (newLevel[j][i]) {
				case 0:
					setTile(i, j, TileType.Floor);
					break;

				case 1:

					setTile(i, j, TileType.FloorL);

					break;
				case 2:

					setTile(i, j, TileType.FloorR);

					break;
				case 3:

					setTile(i, j, TileType.FloorT);

					break;
				case 4:

					setTile(i, j, TileType.FloorB);

					break;
				case 10:
					setTile(i, j, TileType.FloorLU);

					break;
				case 11:
					setTile(i, j, TileType.FloorRU);

					break;
				case 12:
					setTile(i, j, TileType.FloorRB);

					break;
				case 13:
					setTile(i, j, TileType.FloorLB);

					break;
				case 100:
					setTile(i, j, TileType.Blank);
					break;
				}
			}
		}

	}

	public void setTile(int xCoord, int yCoord, TileType type) {
		map[xCoord][yCoord] = new Tile(xCoord * tileSize, yCoord * tileSize,
				tileSize, tileSize, type);
	}

	public void Update() {

	}
}
