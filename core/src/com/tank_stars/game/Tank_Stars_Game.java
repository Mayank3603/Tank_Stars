package com.tank_stars.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class Tank_Stars_Game implements Screen, InputProcessor,ApplicationListener {

	private  Main_Screen main;
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private final Sprite starting_screen;
	private final Sprite loading_sign;

	private float w;
	private float h;
	private FreeTypeFontGenerator fontGenerator;
	private FreeTypeFontGenerator.FreeTypeFontParameter fontParameter1;
	private FreeTypeFontGenerator.FreeTypeFontParameter fontParameter2;
	private BitmapFont font1;
	private BitmapFont font2;




	public Tank_Stars_Game () {
		this.w = (float)Gdx.graphics.getWidth();
		this.h = (float)Gdx.graphics.getHeight();
//		Gdx.input.setInputProcessor(this);
		(this.camera = new OrthographicCamera(this.w,this.h)).setToOrtho(false);
		batch = new SpriteBatch();
		fontGenerator=new FreeTypeFontGenerator(Gdx.files.internal("yankclipper2.ttf"));
		fontParameter1=new FreeTypeFontGenerator.FreeTypeFontParameter();
		fontParameter1.size=30;
		fontParameter1.color= Color.BLACK;
		font1=fontGenerator.generateFont(fontParameter1);

		fontParameter2=new FreeTypeFontGenerator.FreeTypeFontParameter();
		fontParameter2.size=30;
		fontParameter2.color= Color.BLACK;
		font2=fontGenerator.generateFont(fontParameter2);

		starting_screen = new Sprite(new Texture("starting_screen.jpg"));
		loading_sign = new Sprite(new Texture("loading_screen.jpg"));
		starting_screen.setSize(800,400);
		loading_sign.setSize(150,60);
		loading_sign.setPosition(330f,10f);
	}

	@Override
	public void show() {

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1.0f,1.0f,1.0f,1.0f);
		Gdx.gl.glClear(16384);
		batch.setProjectionMatrix(this.camera.combined);
		batch.begin();
		starting_screen.draw(batch);
		loading_sign.draw(batch);
		font1.draw(batch,"Welcome to Tank Stars",220,360);
		font2.draw(batch,"Click Anywhere to start",240,330);
		batch.end();
		if (Gdx.input.isTouched()){
			main = new Main_Screen();

		}
	}

	@Override
	public void create() {

	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void render() {

	}


	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void hide() {

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
