package data;

import static helpers.Artist.*;

public class Game {

	private TileGrid grid;
	private Player player;
	private WaveManager waveManager;
	//TEMP VARS
//	TowerCannon tower;
	
	public Game (int[][] map) {
		grid = new TileGrid(map);
		waveManager = new WaveManager(new Enemy(QuickLoad("almostOKNewEnemy"), grid.getTile(10, 8), grid, 45, TILE_SIZE, TILE_SIZE, 60), 3, 5);
		player = new Player(grid, waveManager);
		
//		tower = new TowerCannon(QuickLoad("cannonBase"), grid.GetTile(8,8), 10, 2, 80);
	}
	
	public void update() {
		grid.draw();
		waveManager.update();
		player.update();
	}
}
