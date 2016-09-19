package data;

import org.newdawn.slick.opengl.Texture;
import static helpers.Artist.*;
import static helpers.Clock.*;

import java.util.ArrayList;

public class TowerCannon {

	private float x, y, tSLS, fireRate, projectileSpeed;  //tSLS - timeSinceLastShot;
	private int width, height, damage;
	private Texture baseTexture, cannonTexture;
	private Tile startTile;
	private ArrayList<Projectile> projectiles;

	public TowerCannon(Texture baseTexture, Tile startTile, int damage, float fireRate, float projectileSpeed) {
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

	}

	private void fire() {
		tSLS = 0;
		projectiles.add(new Projectile(QuickLoad("bullet"), x + 32, y + 32, projectileSpeed, damage));
	}
	
	public void update() {
		tSLS += Delta();
		if(tSLS > fireRate){
			fire();
		}
		
		for(Projectile p: projectiles) {
			p.update();
		}
		
		draw();
	}

	public void draw() {
		DrawQuadText(baseTexture, x, y, width, height);
		DrawQuadTextRotate(cannonTexture, x, y, width, height, 45);

	}

}