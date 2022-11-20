package com.tank_stars.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import  com.tank_stars.game.InputManager;
import  com.tank_stars.game.GameManager;
public class Tank_Stars_Game  implements ApplicationListener {

	private OrthographicCamera camera;
	private SpriteBatch batch;
	private float w;
	private float h;



	@Override
	public void create () {
		this.w = (float)Gdx.graphics.getWidth();
		this.h = (float)Gdx.graphics.getHeight();
		(this.camera = new OrthographicCamera(this.w,this.h)).setToOrtho(false);
		GameManager.initialize(this.w,this.h);
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void render () {
			Gdx.gl.glClearColor(1.0f,1.0f,1.0f,1.0f);
			Gdx.gl.glClear(16384);
			this.batch.setProjectionMatrix(this.camera.combined);
			InputManager.handleInput(this.camera);
			this.batch.begin();
			GameManager.rendergame(this.batch);
			this.batch.end();
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose () {
		this.batch.dispose();
		GameManager.dispose();
	}
}
