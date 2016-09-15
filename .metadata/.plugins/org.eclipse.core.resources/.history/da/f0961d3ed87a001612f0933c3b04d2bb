package data;

import static helpers.Artist.*;
import static helpers.Clock.*;

import java.util.ArrayList;

import org.newdawn.slick.opengl.*;

public class Enemy {
	private int width, height, health;
	private float speed, x, y;
	private Texture texture;
	private Tile startTile;
	private boolean first = true;
	private TileGrid grid;
	
	private ArrayList<Checkpoint> checkpoints;
	private int[] directions;

	public Enemy(Texture texture, Tile startTile, TileGrid grid, int width, int height, float speed) {
		this.texture = texture;
		this.startTile = startTile;
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.width = width;
		this.height = height;
		this.speed = speed;
		this.grid = grid;
		this.checkpoints = new ArrayList<Checkpoint>();
		this.directions = new int[2];
		this.directions[0] = 0;
		//0 = X direction
		this.directions[1] = 0;
		//1 = Y direction
		directions = FindNextDir(startTile);

	}

	public void Update() {
		if (first) {
			first = false;
		} else {
			x += Delta() * directions[0];
			y += Delta() * directions[1];
		}
	}

	private int[] FindNextDir(Tile s) {
		int[] dir = new int[2];
		Tile u = grid.GetTile(s.getXPlace(), s.getYPlace() - 1);
		Tile d = grid.GetTile(s.getXPlace(), s.getYPlace() + 1);
		Tile r = grid.GetTile(s.getXPlace() + 1, s.getYPlace());
		Tile l = grid.GetTile(s.getXPlace() - 1, s.getYPlace());
		
		if(s.getType() == u.getType()) {
			dir[0] = 0;
			dir[1] = -1;
		} else if (s.getType() == r.getType()) {
			dir[0] = 1;
			dir[1] = 0;
		} else if (s.getType() == d.getType()) {
			dir[0] = 0;
			dir[1] = 1;
		} else if (s.getType() == l.getType()) {
			dir[0] = -1;
			dir[1] = 0;
		} else {
			System.out.println("NO DIRECTION FOUND");
		}
			
		
		return dir;
	}
	
	
//	private boolean pathContinues() {
//		boolean answer = true;
//		Tile enemyTile = grid.GetTile((int) (x / 64), (int) (y / 64));
//		Tile nextXTile = grid.GetTile((int) (x / 64) + 1, (int) (y / 64));
//		
//		if(enemyTile.getType() != nextXTile.getType()) {
//			answer = false;
//		}
//		
//		
//		return answer;
//	}

	public void Draw() {
		DrawQuadText(texture, x, y, width, height);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public Tile getStartTile() {
		return startTile;
	}

	public void setStartTile(Tile startTile) {
		this.startTile = startTile;
	}

	public boolean isFirst() {
		return first;
	}

	public void setFirst(boolean first) {
		this.first = first;
	}

	public TileGrid getTileGrid() {
		return grid;
	}
	
}
