package data;

import org.newdawn.slick.opengl.Texture;
import static helpers.Clock.*;

import java.util.ArrayList;

import static helpers.Artist.*;


public abstract class Projectile implements Entity {

	private Texture texture;
	private float x, y, speed, xVelocity, yVelocity, maxRange, towerAcc;
	private int damage, width, height;
	private Enemy target;
	private boolean alive;
	private ProjectileType type;
	private ArrayList<Enemy> enemies;
	private int projectileSpin;
	
	public Projectile(ProjectileType type, float x, float y, Enemy target, float towerAcc, ArrayList<Enemy> enemyList) {
		this.type = type;
		this.texture = type.texture;
		this.x = x;
		this.y = y;
		this.width = type.width;
		this.height = type.height;
		this.speed = type.projectileSpeed;
		this.damage = type.projectileDamage;
		this.maxRange = type.projectileRange * 64;
		this.target = target;
		this.xVelocity = 0f;
		this.yVelocity = 0f;
		this.alive = true;
		this.towerAcc = towerAcc;
		this.enemies = enemies;
		this.projectileSpin = (int) (Math.random() * 360);
		calculateDirection();
	}
	
	private void calculateDirection() {
		float totalAllowedMovement = 1.0f;
		float xDistanceFromTarget = Math.abs(target.getX() - x - (TILE_SIZE / 4) + (TILE_SIZE / 2) + ( ((float)Math.random() * (32*towerAcc)) - 16*towerAcc ));
		float yDistanceFromTarget = Math.abs(target.getY() - y - (TILE_SIZE / 4) + (TILE_SIZE / 2) + ( ((float)Math.random() * (32*towerAcc)) - 16*towerAcc ));
		float totalDistanceFromTarget = xDistanceFromTarget + yDistanceFromTarget;
		float xPercentageOfMovement = xDistanceFromTarget/totalDistanceFromTarget;
		xVelocity = xPercentageOfMovement;
		yVelocity = totalAllowedMovement - xPercentageOfMovement;
		if(target.getX() < x) {
			xVelocity *= -1;
		}
		if(target.getY() < y) {
			yVelocity *= -1;
		}
	}
	
	public void collision (Enemy enemy) {
		enemy.damage(this.damage);
		alive = false;
	}
	
	public void update () {
		if(alive) {
			projectileSpin++;
			x += xVelocity * speed * Delta();
			y += yVelocity * speed * Delta();
			maxRange -= (Math.abs(xVelocity * speed * Delta()) + Math.abs(yVelocity * speed * Delta()));
			if(maxRange < 0f) {
				alive = false;
			}
			for(Enemy e : enemies) {
				if(e.isAlive() && CheckCollision(x,y,width,height,e.getX(),e.getY(),e.getWidth(),e.getHeight())) {
					collision(e);
				}
			}
			draw();
		}
		
	}
	
	public void draw() {
		DrawQuadTextRotate(texture, x, y, 32, 32, projectileSpin);
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public Enemy getTarget () {
		return target;
	}
	
	public void destroyProjectile() {
		alive = false;
	}
	
	public void getUpdatedEnemyList(ArrayList<Enemy> enemies) {
		this.enemies = enemies;
	}
}
