package com.tank_stars.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Choose_player2 implements Screen {

    final Tank_Stars_Game tank_stars_game;
    private float w;
    private float h;
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Sprite main_menu_screen;
    public Choose_player2(final Tank_Stars_Game tank_stars_game) {
        this.tank_stars_game = tank_stars_game;
        this.w = (float) Gdx.graphics.getWidth();
        this.h = (float)Gdx.graphics.getHeight();
        (this.camera = new OrthographicCamera(this.w,this.h)).setToOrtho(false);
        this.batch = new SpriteBatch();
        this.main_menu_screen = new Sprite(new Texture("loading_screen.jpg"));
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1.0f,1.0f,1.0f,1.0f);
        Gdx.gl.glClear(16384);
        this.batch.setProjectionMatrix(this.camera.combined);
        this.batch.begin();
        this.main_menu_screen.draw(batch);
        this.batch.end();
    }

    @Override
    public void resize(int width, int height) {

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
    public void dispose() {

    }
}
