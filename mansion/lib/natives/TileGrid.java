package jGame;

import static helpers.Artist.*;

public class TileGrid {

	public static int tileSize = 64;
	
	public static int tilesize() {
		return tileSize;
	}

	

	public Tile[][] map;

	public TileGrid() {
		map = new Tile[(WIDTH / tileSize)][(HEIGHT / tileSize)];

		for (int i = 0; i < map.length; i++) {

			for (int j = 0; j < map[i].length; j++) {

				map[i][j] = new Tile(i * tileSize, j * tileSize, tileSize,
						tileSize, TileType.Grass);
			}
		}

	}

	public TileGrid(int[][] newMap) {

		map = new Tile[20][15];

		for (int i = 0; i < map.length; i++) {

			for (int j = 0; j < map[i].length; j++) {

				if (newMap[j][i] == 0) {
					map[i][j] = new Tile(i * tileSize, j * tileSize, tileSize,
							tileSize, TileType.Grass);
				} else {
					map[i][j] = new Tile(i * tileSize, j * tileSize, tileSize,
							tileSize, TileType.Dirt);
				}
				switch (newMap[j][i]) {
				case 0:
					map[i][j] = new Tile(i * tileSize, j * tileSize, tileSize,
							tileSize, TileType.Grass);
					break;

				case 1:
					map[i][j] = new Tile(i * tileSize, j * tileSize, tileSize,
							tileSize, TileType.Dirt);
					break;

				case 2:
					map[i][j] = new Tile(i * tileSize, j * tileSize, tileSize,
							tileSize, TileType.Water);
					break;
				}
			}
		}

	}

	public void setTile(int xCoord, int yCoord, TileType type) {
		map[xCoord][yCoord] = new Tile(xCoord * tileSize, yCoord * tileSize,
				tileSize, tileSize, type);
	}

	public Tile getTile(int xCoord, int yCoord) {
		return map[xCoord][yCoord];
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

}
