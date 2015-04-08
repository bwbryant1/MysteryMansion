package game;

import static helpers.Artist.*;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class Player {

	private TileGrid grid;
	private TileType[] types;
	private int index;
	private boolean mousePressed = false;

	public Player(TileGrid grid) {
		this.grid = grid;
	

		this.index = 0;
	}

	public void SetTile() {
		int xCoordM = Mouse.getX();

		int yCoordM = Mouse.getY();
		int xPosM = xCoordM / (TileGrid.tilesize());
		int yPosM = HEIGHT - yCoordM - 1;
		// int MAX = (WIDTH / (TileGrid.tilesize()) - 1);

		grid.setTile(

		(int) Math.floor(xPosM), (int) Math.floor(yPosM)
				/ (TileGrid.tilesize()), types[index]);

	}

	public void Update() {
		
		int xCoordM = Mouse.getX();

		int yCoordM = Mouse.getY();
		int xPosM = xCoordM / (TileGrid.tilesize());
		int yPosM = HEIGHT - yCoordM - 1;
		
		//System.out.println(xPosM +" " + yPosM);

		
		
	}

	public void MoveIndex() {
		index++;
		if (index > types.length - 1)
			index = 0;
	}

}
