package com.tank_stars.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tank_Stars_Game implements ApplicationListener, InputProcessor {

	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Sprite starting_screen;
	private Sprite loading_sign;
	private BitmapFont font;
	private float w;
	private float h;



	@Override
	public void create () {
		this.w = (float)Gdx.graphics.getWidth();
		this.h = (float)Gdx.graphics.getHeight();
//		Gdx.input.setInputProcessor(this);
		(this.camera = new OrthographicCamera(this.w,this.h)).setToOrtho(false);
		batch = new SpriteBatch();
		font = new BitmapFont();
		starting_screen = new Sprite(new Texture("starting_screen.jpg"));
		starting_screen.setSize(800,400);

	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void render () {
			Gdx.gl.glClearColor(1.0f,1.0f,1.0f,1.0f);
			Gdx.gl.glClear(16384);
			batch.setProjectionMatrix(this.camera.combined);
			batch.begin();
			starting_screen.draw(batch);
			font.draw(batch,"WELCOME TO TANK_STARS",290,360);
			batch.end();

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
	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(float amountX, float amountY) {
		return false;
	}
}
