package data;

import static helpers.Artist.*;
import static helpers.Clock.*;

import java.util.Random;
import org.lwjgl.opengl.Display;

import helpers.Clock;

public class Boot {

	public Boot() {

		BeginSession();

		int[][] map = { 
				{ 0, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
				{ 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
				{ 0, 2, 2, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 2, 2, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1 } };

		
		Game game = new Game(map);

		
//		OLD CODE NOW HANDLED BY 'GAME'	
//		TileGrid mATS = new TileGrid(map); // macAirTileSize -> mATS RANDOM MAP
//										   // (1408 x 832 / 22x13 64 bit tiles)
//
		
//		Random rand = new Random();
//		
//		 int[][] map2 = new int[13][22];
//		
//		 for(int i = 0; i < map2.length; i++) {
//		// System.out.println();
//		 for (int j = 0; j < map2[i].length; j++) {
//		 map2[i][j] = rand.nextInt(2);
//		// System.out.print("[" + i + ", " + j + "] " + map2[i][j] + "; ");
//		 }
//		 }
//		// System.out.println();
//		TileGrid mATS = new TileGrid(map2); // macAirTileSize -> mATS RANDOM MAP
//											// (1408 x 832 / 22x13 64 bit tiles)
//		
		
//		OLD CODE NOW IN 'GAME'
		
//		mATS.SetTile(3, 4, mATS.GetTile(2, 4).getType());
//		Enemy e = new Enemy(QuickLoad("enemy1"), mATS.GetTile(10, 8), mATS, 64, 64, 5);
//		Wave wave1 = new Wave(20, e);
//		Player player = new Player(mATS);
//		
//		TowerCannon tower = new TowerCannon(QuickLoad("cannonBase"), mATS.GetTile(8,8), 10);
//		
		
		
		
		while (!Display.isCloseRequested()) {
			Clock.update();

			game.update();
			
//			OLD CODE NOW HANDLED BY 'GAME'
			
//			mATS.Draw();
//			wave1.Update();
//			player.Update();
//			tower.update();
			
			Display.update();
			Display.sync(60);

		}

		Display.destroy();
	}

	public static void main(String[] args) {
		new Boot();
	}
}
