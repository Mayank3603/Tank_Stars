package com.tank_stars.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tank_Stars_Game extends Game {

	public SpriteBatch batch;
	public BitmapFont font;
	private Tank tank_1;
	private Tank tank_2;

	public void create() {
		batch = new SpriteBatch();
		font = new BitmapFont(); // use libGDX's default Arial font
		this.setScreen(new Loading_Screen(this));
	}

	public void render() {
		super.render(); // important!
	}

	public void dispose() {
		batch.dispose();
		font.dispose();
	}

}