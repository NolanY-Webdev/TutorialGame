package data;

import org.newdawn.slick.opengl.Texture;
import static helpers.Artist.*;
import static helpers.Clock.*;

import java.util.ArrayList;

public class TowerCannon {

	private float x, y, tSLS, fireRate, angle, projectileSpeed;  //tSLS - timeSinceLastShot;
	private int width, height, damage, range;
	private Texture baseTexture, cannonTexture;
	private Tile startTile;
	private ArrayList<Projectile> projectiles;
	private ArrayList<Enemy> enemies;
	private Enemy target;
	private boolean targetLocked;

	public TowerCannon(Texture baseTexture, Tile startTile, int damage, int range, ArrayList<Enemy> enemies, float fireRate, float projectileSpeed) {
		this.baseTexture = baseTexture;
		this.cannonTexture = QuickLoad("cannonGun");
		this.startTile = startTile;
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.damage = damage;
		this.range = range;
		this.width = (int) startTile.getWidth();
		this.height = (int) startTile.getHeight();
		this.fireRate = fireRate;
		this.projectileSpeed = projectileSpeed;
		this.tSLS = 0;
		this.projectiles = new ArrayList<Projectile>();
		this.enemies = enemies;
		this.targetLocked = false;
		
	}
	
	private Enemy targetingSystems() {    //vs accquireTarget in vid
		Enemy closestNme = null;
		float closestDistance = 10000;
		for(Enemy e : enemies) {
			if(rangeCheck(e) && (distanceCheck(e) < closestDistance)) {
				closestDistance = distanceCheck(e);
				closestNme = e;
			}
		}
		if (closestNme != null) {
			targetLocked = true;
		}
		return closestNme;
	}
	
	private boolean rangeCheck(Enemy e) { //vs isInRange for vid
		float xDistance = Math.abs(e.getX() - x);
		float yDistance = Math.abs(e.getY() - y);
		if(xDistance < range && yDistance < range){
			return true;
		}
		return false;
	}
	
	private float distanceCheck(Enemy e) { //vs findDistance for vid
		float xDistance = Math.abs(e.getX() - x);
		float yDistance = Math.abs(e.getY() - y);
		return xDistance + yDistance;
	}
	
	private float calculateAngle() {
		if(target.isAlive()){
			double angleTemp = Math.atan2(target.getY() - y, target.getX() - x);
			return (float) Math.toDegrees(angleTemp) - 90;	
		} else {
			return 0;
		}
	}

	private void fire() {
		tSLS = 0;
		projectiles.add(new BasicBullet(ProjectileType.BasicBullet, (x + (TILE_SIZE / 2) - (TILE_SIZE / 4)), (y + (TILE_SIZE / 2) - (TILE_SIZE / 4)), target));
	}
	
	public void updateEnemyList(ArrayList<Enemy> newList) {
		enemies = newList;
	}
	
	//AKA: Tower AI
	public void update() {
		//LOCKED ON? NO? LOCK ON!
		if(!targetLocked){
			target = targetingSystems();
			
		}
		
		//STILL LOCKED? NO? BACK TO STEP 1
		if(target == null || !target.isAlive() || !rangeCheck(target)) {
			targetLocked = false;
		}
		
		//THIS LINE FIXED THE TOWER RANGE TARGETING ERROR, SAYS IF YOU ARE LOCKED ON AND IN RANGE THEN AIM
		if(targetLocked && rangeCheck(target)) {
			angle = calculateAngle();
		}
		
		//IF IT IS TIME TO FIRE THEN FIRE ASSUMING THINGS ARE STILL LOCKED ON
		tSLS += Delta();
		if(tSLS > fireRate && targetLocked == true){
			fire();
		}
		
		for(Projectile p: projectiles) {
			p.update();
		}

		draw();
	}

	public void draw() {
		DrawQuadText(baseTexture, x, y, width, height);
		DrawQuadTextRotate(cannonTexture, x, y, width, height, angle);

	}

}
