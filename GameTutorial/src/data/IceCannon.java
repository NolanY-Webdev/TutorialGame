package data;

import static helpers.Artist.QuickLoad;
import static helpers.Artist.TILE_SIZE;

import java.util.ArrayList;

public class IceCannon extends Tower{

	public IceCannon(TowerType type, Tile startTile, ArrayList<Enemy> enemies) {
		super(type, startTile, enemies);
	}
	
	@Override
	public void fire() {
		super.fire();
		super.getTarget().setSpeed(4);
	}
	
}
