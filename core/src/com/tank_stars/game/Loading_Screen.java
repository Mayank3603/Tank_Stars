package com.tank_stars.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class Loading_Screen implements Screen {

    final Tank_Stars_Game tank_stars_game;
    private  Main_Screen main;
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Sprite starting_screen;
    private Sprite loading_sign;

    private float w;
    private float h;
    private FreeTypeFontGenerator fontGenerator;
    private FreeTypeFontGenerator.FreeTypeFontParameter fontParameter1;
    private FreeTypeFontGenerator.FreeTypeFontParameter fontParameter2;
    private BitmapFont font1;
    private BitmapFont font2;

    public Loading_Screen(final Tank_Stars_Game tank_stars_game){
        this.tank_stars_game = tank_stars_game;
        this.w = (float)Gdx.graphics.getWidth();
        this.h = (float)Gdx.graphics.getHeight();

        (this.camera = new OrthographicCamera(this.w,this.h)).setToOrtho(false);
        this.batch = new SpriteBatch();
        fontGenerator=new FreeTypeFontGenerator(Gdx.files.internal("yankclipper2.ttf"));
        fontParameter1=new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameter1.size=60;
        fontParameter1.color= Color.BLACK;
        font1=fontGenerator.generateFont(fontParameter1);

        fontParameter2=new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameter2.size=30;
        fontParameter2.color= Color.BLACK;
        font2=fontGenerator.generateFont(fontParameter2);

        starting_screen = new Sprite(new Texture("starting_screen.jpg"));
        loading_sign = new Sprite(new Texture("loading_screen.jpg"));
        starting_screen.setSize(this.w,this.h);
        loading_sign.setSize(this.w/5,this.h/10);
        loading_sign.setPosition(this.w/3+2*this.w/24,this.h/30);
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
        font1.draw(batch,"Welcome to Tank Stars",7*this.w/20,4*this.h/5+this.h/20);
        font2.draw(batch,"Click Anywhere to start...",this.w/3+this.w/10,4*this.h/5-this.h/20);
        batch.end();
        if (Gdx.input.isTouched()){
            tank_stars_game.setScreen(new Main_Screen(tank_stars_game));
        }
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
    public void dispose () {
        this.batch.dispose();
        this.font1.dispose();
        this.font2.dispose();
        this.tank_stars_game.dispose();
    }


}

