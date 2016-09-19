package data;

public class WaveManager {

	
	private float timeSinceLastWave, spawnTime;
	private int waveNumber, enemiesPerWave;
	private Enemy enemyType;
	private Wave currentWave;
	
	public WaveManager(Enemy enemyType, float spawnTime, int enemiesPerWave) {
		this.enemyType = enemyType;
		this.enemiesPerWave = enemiesPerWave;
		this.spawnTime = spawnTime;
		this.timeSinceLastWave = 0;
		this.waveNumber = 0;

		this.currentWave = null;
		
		newWave();
	}
	
	public void update() {
		if(currentWave != null) {
			currentWave.Update();
		}
	}
	
	public void newWave() {
		currentWave = new Wave(enemyType, spawnTime, enemiesPerWave);
	}
	
}
