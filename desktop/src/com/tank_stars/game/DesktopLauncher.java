package com.tank_stars.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class DesktopLauncher {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setTitle("Tank_Stars");
        config.setWindowedMode(1600,800);
        new Lwjgl3Application(new Tank_Stars_Game(),config);
    }
}
