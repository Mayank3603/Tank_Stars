package com.tank_stars.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

import java.io.IOException;

public class DesktopLauncher {
    public static void main(String[] args) throws IOException {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setTitle("Tank_Stars");
        config.setWindowedMode(1200,600);
        new Lwjgl3Application(new Tank_Stars_Game(),config);
    }
}
