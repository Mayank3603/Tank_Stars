package com.tank_stars.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.bullet.collision._btMprSimplex_t;

import java.io.Serializable;

public class Tank_Stars_Game extends Game  {

	public SpriteBatch batch;
	public BitmapFont font;


	public void setTank_1(Tank tank_1) {
		this.tank_1 = tank_1;
	}

	public Tank getTank_1() {
		return tank_1;
	}

	private Tank tank_1;

	public void setTank_2(Tank tank_2) {
		this.tank_2 = tank_2;
	}

	public Tank getTank_2() {
		return tank_2;
	}

	private Tank tank_2;
	private Weapons Airdrop;

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