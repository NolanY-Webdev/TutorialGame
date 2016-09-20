package data;

import org.newdawn.slick.opengl.Texture;
import static helpers.Artist.*;
import static helpers.Clock.*;

import java.util.ArrayList;

public class TowerCannon {

	private float x, y, tSLS, fireRate, angle, projectileSpeed;  //tSLS - timeSinceLastShot;
	private int width, height, damage;
	private Texture baseTexture, cannonTexture;
	private Tile startTile;
	private ArrayList<Projectile> projectiles;
	private ArrayList<Enemy> enemies;
	private Enemy target;

	public TowerCannon(Texture baseTexture, Tile startTile, int damage, ArrayList<Enemy> enemies, float fireRate, float projectileSpeed) {
		this.baseTexture = baseTexture;
		this.cannonTexture = QuickLoad("cannonGun");
		this.startTile = startTile;
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.width = (int) startTile.getWidth();
		this.height = (int) startTile.getHeight();
		this.damage = damage;
		this.fireRate = fireRate;
		this.projectileSpeed = projectileSpeed;
		this.tSLS = 0;
		this.projectiles = new ArrayList<Projectile>();
		this.enemies = enemies;
		this.target = targetingSystems(); //vs accquireTarget in vid
		this.angle = calculateAngle();
		

	}
	
	private Enemy targetingSystems() {    //vs accquireTarget in vid
		return enemies.get(0);
	}
	
	private float calculateAngle() {
		double angleTemp = Math.atan2(target.getY() - y, target.getX() - x);
		return (float) Math.toDegrees(angleTemp) - 90;
	}

	private void fire() {
		tSLS = 0;
		projectiles.add(new Projectile(QuickLoad("bullet"), (x + (Game.TILE_SIZE / 2) - (Game.TILE_SIZE / 4)), (y + (Game.TILE_SIZE / 2) - (Game.TILE_SIZE / 4)), projectileSpeed, damage, target));
	}
	
	public void update() {
		tSLS += Delta();
		if(tSLS > fireRate){
			fire();
		}
		
		for(Projectile p: projectiles) {
			p.update();
		}
		angle = calculateAngle();
		draw();
	}

	public void draw() {
		DrawQuadText(baseTexture, x, y, width, height);
		DrawQuadTextRotate(cannonTexture, x, y, width, height, angle);

	}

}
