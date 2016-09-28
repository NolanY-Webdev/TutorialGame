package data;

import org.newdawn.slick.opengl.Texture;
import static helpers.Clock.*;
import static helpers.Artist.*;


public class Projectile {

	private Texture texture;
	private float x, y, width, height, speed, xVelocity, yVelocity;
	private int damage;
	private Enemy target;
	private boolean alive;
	
	public Projectile(Texture texture, float x, float y, float width, float height, float speed, int damage, Enemy target) {
		this.texture = texture;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed;
		this.damage = damage;
		this.target = target;
		this.xVelocity = 0f;
		this.yVelocity = 0f;
		this.alive = true;
		calculateDirection();
	}
	
	private void calculateDirection() {
		float totalAllowedMovement = 1.0f;
		float xDistanceFromTarget = Math.abs(target.getX() - x - (Game.TILE_SIZE / 4) + (Game.TILE_SIZE / 2));
		float yDistanceFromTarget = Math.abs(target.getY() - y - (Game.TILE_SIZE / 4) + (Game.TILE_SIZE / 2));
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
	
	public void update () {
		if(alive) {
			x += xVelocity * speed * Delta();
			y += yVelocity * speed * Delta();
			if(CheckCollision(x, y, width, height, target.getX(), target.getY(), target.getWidth(), target.getHeight())){
				target.damage(this.damage);
				alive = false;
			}
			draw();
		}
		
	}
	
	public void draw() {
		DrawQuadText(texture, x, y, 32, 32);
	}
	
}
