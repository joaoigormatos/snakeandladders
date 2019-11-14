package br.quixada.ufc.snakeandladders.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import br.quixada.ufc.snakeandladders.GameLogic;

public class DesktopLauncher {
	 static int SCREEN_WIDTH = 600;
	 static int SCREEN_HEIGHT = 400;
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Snake And Ladders";
		new LwjglApplication(new GameLogic(SCREEN_WIDTH,SCREEN_HEIGHT), config);
	}
}
