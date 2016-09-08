package data;

import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;



public class Boot {

	public Boot() {
		Display.setTitle("Game Tutorial");
		try {
			Display.setDisplayMode(new DisplayMode(600, 400));
			Display.create();
			//DO NOT FORGET TO CREATE DISPLAY
			//SORTA NEEDS TO BE CREATED TO BE SHOWN
			
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, 600, 400, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		
		while(!Display.isCloseRequested()) {
			
			
			Display.update();
			Display.sync(60);
			
		}
		
		Display.destroy();
	}
	
	
	public static void main(String[] args) {
		new Boot();
	}
}
