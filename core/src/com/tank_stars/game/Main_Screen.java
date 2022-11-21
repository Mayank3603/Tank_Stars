package com.tank_stars.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Main_Screen implements Screen{
    final Tank_Stars_Game tank_stars_game;
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Sprite main_menu_screen;
    private Sprite play_button;
    private Sprite resume_button;
    private Sprite exit_button;

    private float w;
    private float h;
    public Main_Screen(final Tank_Stars_Game tank_stars_game){
        this.tank_stars_game = tank_stars_game;
        this.w = (float)Gdx.graphics.getWidth();
        this.h = (float)Gdx.graphics.getHeight();
        (this.camera = new OrthographicCamera(this.w,this.h)).setToOrtho(false);
        this.batch = new SpriteBatch();
        this.main_menu_screen = new Sprite(new Texture("main_menu_screen.png"));
        this.play_button = new Sprite(new Texture("new_game_button.png"));
        this.resume_button = new Sprite(new Texture("resume_game.png"));
        this.exit_button = new Sprite(new Texture("exit_game.png"));
        this.main_menu_screen.setSize(this.w,this.h);
        this.play_button.setSize(150,50);
        this.play_button.setPosition(this.w/10-50,this.h/40);
        this.resume_button.setSize(150,50);
        this.resume_button.setPosition(4*(this.w/10)-50,this.h/40);
        this.exit_button.setSize(150,50);
        this.exit_button.setPosition(7*(this.w/10)-50,this.h/40);
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
        this.main_menu_screen.draw(this.batch);
        this.play_button.draw(this.batch);
        this.resume_button.draw(this.batch);
        this.exit_button.draw(this.batch);
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
