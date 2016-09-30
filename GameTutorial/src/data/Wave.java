package data;

import java.util.ArrayList;
import static helpers.Clock.*;
import static helpers.Artist.*;

public class Wave {

	private float timeSinceLastSpawn, spawnTime;
	private Enemy enemyType;
	private ArrayList<Enemy> enemyList;
	private int enemiesPerWave;
	private boolean waveCompleted;
	
	

	public Wave(Enemy enemyType, float spawnTime, int enemiesPerWave) {
		this.enemyType = enemyType;
		this.spawnTime = spawnTime;
		this.enemiesPerWave = enemiesPerWave;
		this.waveCompleted = false;
		this.enemyList = new ArrayList<Enemy>();
		
		spawn();
	}

	public void update() {
		boolean allEnemiesDead = true;
		if(enemyList.size() < enemiesPerWave) {
			timeSinceLastSpawn += Delta();
			if (timeSinceLastSpawn > spawnTime) {
				spawn();
				timeSinceLastSpawn = 0;
			}
		}

		for (Enemy e : enemyList) {
			if(e.isAlive()) {
				e.update();
				e.draw();
				allEnemiesDead = false;
			}
		}
		if(allEnemiesDead && (enemyList.size() == enemiesPerWave)) {
			waveCompleted = true;
		}
	}

	private void spawn() {
		enemyList.add(new Enemy(enemyType.getTexture(), enemyType.getStartTile(), enemyType.getTileGrid(), enemyType.getHealth(), TILE_SIZE, TILE_SIZE, enemyType.getSpeed()));
	}
	
	public boolean isCompleted() {
		return waveCompleted;
	}
	
	public ArrayList<Enemy> getEnemyList() {
		return enemyList;
	}
}
