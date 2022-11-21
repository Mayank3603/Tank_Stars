package com.tank_stars.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class Game_Screen implements Screen {

    private Vector3 touchpos = new Vector3();
    final Tank_Stars_Game tank_stars_game;

    private OrthographicCamera camera;
    private SpriteBatch batch;

    private Sprite pause_button;
    private Sprite background;


    private Sprite terror;

    private float w;
    private float h;

    public Game_Screen(final Tank_Stars_Game tank_stars_game){
        this.tank_stars_game = tank_stars_game;
        this.w = (float) Gdx.graphics.getWidth();
        this.h = (float)Gdx.graphics.getHeight();
        (this.camera = new OrthographicCamera(this.w,this.h)).setToOrtho(false);
        this.batch = new SpriteBatch();
        this.terror = new Sprite(new Texture("terrain_red.png"));
        this.terror.setSize(this.w,this.h/2);
        this.background = new Sprite(new Texture("background.jpeg"));
        this.pause_button = new Sprite(new Texture("pause-button.jpg"));
        this.background.setSize(this.w,this.h);
        this.pause_button.setSize(this.w/20,this.h/20);
        this.pause_button.setPosition((this.w/2),this.h-this.h/20);

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
        this.background.draw(this.batch);
        this.terror.draw(this.batch);
        this.pause_button.draw(this.batch);


        batch.end();
        inputhandle();
    }

    public void inputhandle(){
        if (Gdx.input.justTouched()){
            this.touchpos.set(Gdx.input.getX(),Gdx.input.getY(),0);
            this.camera.unproject(touchpos);
            if (touchpos.x >= (this.w/2) && touchpos.x <= this.h-this.h/20+this.w/20 && touchpos.y >= this.h-this.h/20 && touchpos.y<=this.h-this.h/20+ this.h/20){
                System.out.println("1");
                tank_stars_game.setScreen(new Pause_Screen(tank_stars_game,this));
            }
        }
    }
    public void throw_air_drop(){

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
