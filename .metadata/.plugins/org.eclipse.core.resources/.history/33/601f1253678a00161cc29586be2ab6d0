package data;

import java.util.ArrayList;

public class IceSpray extends Projectile{

	private ProjectileType type;
	
	public IceSpray(ProjectileType type, float x, float y, Enemy target, ArrayList<Enemy> enemies) {
		super(type, x, y, target, enemies);
		this.type = type;
	}

	@Override
	public void collision (Enemy enemy) {
		enemy.setSpeed(4f); 
		enemy.damage(0);
//		super.destroyProjectile();
	}
	
}
