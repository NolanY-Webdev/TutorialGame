package data;

import java.util.ArrayList;

import org.newdawn.slick.opengl.Texture;

public class BasicBullet extends Projectile {

	public BasicBullet(ProjectileType type, float x, float y, Enemy target, float towerAcc, ArrayList<Enemy> enemies) {
		super(type, x, y, target, towerAcc, enemies);
	}

}
