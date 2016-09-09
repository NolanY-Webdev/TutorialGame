package data;

import static helpers.Artist.BeginSession;
import static helpers.Artist.DrawQuadText;

import org.lwjgl.opengl.Display;

public class Boot {

	public Boot() {

		BeginSession();

		TileGrid macAirTileSize = new TileGrid();
		
		while (!Display.isCloseRequested()) {
			
			macAirTileSize.Draw();
			
			Display.update();
			Display.sync(60);

		}

		Display.destroy();
	}

	public static void main(String[] args) {
		new Boot();
	}
}
