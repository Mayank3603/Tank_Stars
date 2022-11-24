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
    private Sprite health_bar;
    private Sprite health_bar2;
    private Sprite fire_button;
    private  Sprite left_button;
    private Sprite right_button;
    private Sprite angle;
    private Sprite fuel;
    private Sprite tanks1;
    private Sprite tanks2;



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
        this.health_bar = new Sprite(new Texture("health_bar.png"));
        this.health_bar2 = new Sprite(new Texture("health_bar2.png"));
        this.fire_button =new Sprite(new Texture("fire_button.png"));
        this.left_button = new Sprite(new Texture("left_button.png"));
        this.right_button = new Sprite(new Texture("right_button.png"));
        this.angle = new Sprite(new Texture("angle.png"));
        this.fuel =  new Sprite(new Texture("fuel.png"));
        this.tanks1 = new Sprite(new Texture("tank1.png"));
        this.tanks2 = new Sprite(new Texture("tank2.png"));
        this.background.setSize(this.w,this.h);
        this.health_bar.setSize(this.w/20+(this.w/20)*2,this.h/20);
        this.health_bar.setPosition(this.w/2-(this.w/16)*3,this.h-this.h/20);
        this.health_bar2.setSize(this.w/20+(this.w/20)*2,this.h/20);
        this.health_bar2.setPosition(this.w-(this.w/8)*4+3*(this.w/32),this.h-this.h/20);
        this.pause_button.setSize(this.w/20,this.h/20);
        this.pause_button.setPosition((this.w/2),this.h-this.h/20);
        this.fire_button.setSize(this.w/16,this.h/8);
        this.fire_button.setPosition((this.w/10)+this.w/3+4*(this.w/64),this.h/30);
        this.left_button.setSize(this.w/16,this.h/8);
        this.right_button.setSize(this.w/16,this.h/8);
        this.right_button.setPosition(this.w/2-this.w/4,this.h/30);
        this.left_button.setPosition(this.w/2+this.w/4,this.h/30);
        this.fuel.setSize(this.w/16,this.h/8);
        this.angle.setSize(this.w/6+this.w/24,this.h/6);
        this.angle.setPosition(this.w/2-this.w/4+this.w/16,this.h/120);
        this.fuel.setPosition(0,this.h/30);
        this.tanks1.setSize(this.w/16,this.h/14);
        this.tanks1.setPosition(this.w/8,this.h/4-this.h/64);
        this.tanks2.setPosition(this.w-this.w/8,this.h/4+this.h/16+this.h/64);
        this.tanks2.setSize(this.w/16,this.h/14);
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
        this.health_bar.draw(this.batch);
        this.health_bar2.draw(this.batch);
        this.fire_button.draw(this.batch);
        this.left_button.draw(this.batch);
        this.right_button.draw(this.batch);
        this.angle.draw(this.batch);
        this.fuel.draw(this.batch);
        this.tanks1.draw(this.batch);
        this.tanks2.draw(this.batch);
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
