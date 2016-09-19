package data;

import static helpers.Artist.QuickLoad;

public class Game {

	private TileGrid grid;
	private Player player;
	private WaveManager waveManager;
	
	//TEMP VARS
	TowerCannon tower;
	
	public Game (int[][] map) {
		grid = new TileGrid(map);
		player = new Player(grid);
		waveManager = new WaveManager(new Enemy(QuickLoad("enemy1"), grid.GetTile(10, 8), grid, 64, 64, 40), 4, 5);
		
		tower = new TowerCannon(QuickLoad("cannonBase"), grid.GetTile(8,8), 10, 2, 80);
		
		
	}
	
	public void update() {
		grid.Draw();
		waveManager.update();
		player.Update();
		
		tower.update();
	}
}
