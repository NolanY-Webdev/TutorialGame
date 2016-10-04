package data;

import org.newdawn.slick.opengl.Texture;
import static helpers.Artist.*;

public enum TowerType {

	CannonRed(new Texture[] {QuickLoad("cannonBase"), QuickLoad("cannonGun")}, 10, 300, 3, 500, 1, ProjectileType.BasicBullet), 
	CannonBlue(new Texture[] {QuickLoad("cannonBaseBlue"), QuickLoad("cannonGunBlue")}, 30, 500, 5, 300, 1, ProjectileType.BasicBullet),
	IceCannon(new Texture[] {QuickLoad("iceTowerBase"), QuickLoad("iceTowerGun")}, 1, 128,(float) 1/32, 64, 3, ProjectileType.IceSpray, ProjectileType.FrostSpray);
	
	Texture[] textures;
	int damage, range, width, height;
	float  fireRate, projectileSpeed, towerAcc;
	ProjectileType projectileType, projectileAltType;
	
	TowerType(Texture[] textures, int damage, int range, float fireRate, int projectileSpeed, float towerAcc, ProjectileType projectileType) {
		this.textures = textures;
		this.damage = damage;
		this.range = range;
		this.fireRate = fireRate;
		this.projectileSpeed = projectileSpeed;
		this.projectileType = projectileType;
		this.towerAcc = towerAcc;
	}
	
	TowerType(Texture[] textures, int damage, int range, float fireRate, int projectileSpeed, float towerAcc, ProjectileType projectileType, ProjectileType projectileAltType) {
		this.textures = textures;
		this.damage = damage;
		this.range = range;
		this.fireRate = fireRate;
		this.projectileSpeed = projectileSpeed;
		this.projectileType = projectileType;
		this.towerAcc = towerAcc;
		this.projectileAltType = projectileAltType;
	}
}
