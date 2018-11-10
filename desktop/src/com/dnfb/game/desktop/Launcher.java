package com.dnfb.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.dnfb.game.Main;

public class Launcher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new Main(), config);
		config.width = Main.WIDTH;
		config.height = Main.HEIGHT;
		config.title = Main.TITLE;
	}
}
