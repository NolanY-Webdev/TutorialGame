package data;

import static helpers.Artist.*;

import java.util.ArrayList;

import org.lwjgl.input.*;

import helpers.Clock;

public class Player {

	private TileGrid grid;
	private int index;
	private WaveManager waveManager;
	private ArrayList<TowerCannon> towerList;
	private Boolean leftMouseButtonDown;
	

	public Player(TileGrid grid, WaveManager waveManager) {
		this.grid = grid;
		this.index = 0;
		this.waveManager = waveManager;
		this.towerList = new ArrayList<TowerCannon>();
		this.leftMouseButtonDown = true;
	}
	
	public void update() {
		
		for(TowerCannon t : towerList) {
			t.update();
			t.updateEnemyList(waveManager.getCurrentWave().getEnemyList());
		}
		
		//Mouse input
		if (Mouse.isButtonDown(0) && !leftMouseButtonDown) {
			
			towerList.add(new TowerCannon(QuickLoad("cannonBase"), grid.GetTile( (int) Math.floor(Mouse.getX() / 64), (int) Math.floor((HEIGHT - Mouse.getY() - 1) / 64)), 3, 800, waveManager.getCurrentWave().getEnemyList(), 2, 700));
		}
		
		leftMouseButtonDown = Mouse.isButtonDown(0);
		
		//Keyboard input
		while (Keyboard.next()) {
			if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT && Keyboard.getEventKeyState()) {
				Clock.ChangeMultiplier(0.07f);
			} else if (Keyboard.getEventKey() == Keyboard.KEY_LEFT && Keyboard.getEventKeyState()) {
				Clock.ChangeMultiplier(-0.07f);
			} else if (Keyboard.getEventKey() == Keyboard.KEY_T && Keyboard.getEventKeyState()) {
				towerList.add(new TowerCannon(QuickLoad("cannonBase"), grid.GetTile(17,7), 1000, 100, waveManager.getCurrentWave().getEnemyList(), 2, 700));
			}
		}
	}


}
