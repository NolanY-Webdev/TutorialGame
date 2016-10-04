package data;

import static helpers.Artist.QuickLoad;
import static helpers.Artist.TILE_SIZE;

import java.util.ArrayList;

public class IceCannon extends Tower{

	private TowerType type;
	private boolean altShot = true;
	
	public IceCannon(TowerType type, Tile startTile, ArrayList<Enemy> enemies) {
		super(type, startTile, enemies);
		this.type = type;
	}
	
	@Override
	public void fire() {
		super.resetTSLS();
		if(altShot) {
			altShot = false;
			super.getProjectileList().add(new IceSpray(type.projectileType, (super.getX() + (TILE_SIZE / 2) - (TILE_SIZE / 4)), (super.getY() + (TILE_SIZE / 2) - (TILE_SIZE / 4)), super.getTarget(), type.towerAcc, super.getEnemyList()));
		} else {
			altShot = true;
			super.getProjectileList().add(new IceSpray(type.projectileAltType, (super.getX() + (TILE_SIZE / 2) - (TILE_SIZE / 4)), (super.getY() + (TILE_SIZE / 2) - (TILE_SIZE / 4)), super.getTarget(), type.towerAcc, super.getEnemyList()));
		}
	}
	
}
