package data;

import static helpers.Artist.HEIGHT;
import static helpers.Cartog.*;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class Editor {

	private TileGrid grid;
	private int index;
	private TileType[] types;

	public Editor() {
		this.grid = new TileGrid();
		this.index = 0;
		this.types = new TileType[3];
		this.types[0] = TileType.Grass;
		this.types[1] = TileType.Dirt;
		this.types[2] = TileType.Water;
	}

	public void update() {
		grid.Draw();
		
		// Mouse input
		if (Mouse.isButtonDown(0)) {
			setTile();
		}

		// Keyboard input
		while (Keyboard.next()) {
			if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT && Keyboard.getEventKeyState()) {
				moveIndex();
			} else if (Keyboard.getEventKey() == Keyboard.KEY_LEFT && Keyboard.getEventKeyState()) {
				if(this.index == 0) {
					this.index = types.length - 1;
				} else {
					this.index--;
				}
			} else if (Keyboard.getEventKey() == Keyboard.KEY_S && Keyboard.getEventKeyState()) {
				saveMap("mapTest", grid);
			}
		}
	}

	private void setTile() {
		grid.SetTile((int) Math.floor(Mouse.getX() / 64), (int) Math.floor((HEIGHT - Mouse.getY() - 1) / 64),
				types[index]);
	}

	
	private void moveIndex() {
		this.index++;
		if (index > types.length - 1) {
			this.index = 0;
		}
	}
}
