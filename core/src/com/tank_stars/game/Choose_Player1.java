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

public class Choose_Player1 implements Screen {
    final  Tank_Stars_Game tank_stars_game;
    private float w;
    private float h;
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Sprite background;
    private Sprite Helios_tank_image;
    private Sprite Mark_1_tank_image;
    private Sprite T_34_tank_image;
    private FreeTypeFontGenerator fontGenerator;
    private FreeTypeFontGenerator.FreeTypeFontParameter fontParameter1;
    private FreeTypeFontGenerator.FreeTypeFontParameter fontParameter2;
    private BitmapFont font1;
    private BitmapFont font2;


    public int getPlayer_set() {
        return player_set;
    }

    private int player_set = 0;
    public Choose_Player1(final Tank_Stars_Game tank_stars_game ){
        this.tank_stars_game = tank_stars_game;
        this.w = (float) Gdx.graphics.getWidth();
        this.h = (float)Gdx.graphics.getHeight();
        (this.camera = new OrthographicCamera(this.w,this.h)).setToOrtho(false);
        this.batch = new SpriteBatch();
        this.background = new Sprite(new Texture("tank_choose_screen_background.jpg"));

        this.T_34_tank_image = new Sprite(new Texture("t_34_tank.jpg"));
        this.Mark_1_tank_image = new Sprite(new Texture("Mark_tank.jpg"));
        this.Helios_tank_image = new Sprite(new Texture("Helios_tank_.jpg"));
        this.background.setSize(this.w,this.h);
        this.T_34_tank_image.setSize(this.w/6,this.h/12);
        this.T_34_tank_image.setPosition(this.w/10,this.h/30);

        this.Mark_1_tank_image.setSize(this.w/6,this.h/12);
        this.Mark_1_tank_image.setPosition((this.w/10)+this.w/3,this.h/30);

        this.Helios_tank_image.setSize(this.w/6,this.h/12);
        this.Helios_tank_image.setPosition((this.w/10)+2*this.w/3,this.h/30);

        fontGenerator=new FreeTypeFontGenerator(Gdx.files.internal("yankclipper2.ttf"));
        fontParameter1=new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameter1.size=60;
        fontParameter1.color= Color.BLACK;
        font1=fontGenerator.generateFont(fontParameter1);

        fontParameter2=new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameter2.size=30;
        fontParameter2.color= Color.BLACK;
        font2=fontGenerator.generateFont(fontParameter2);


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
        this.background.draw(batch);
        this.Helios_tank_image.draw(batch);
        this.Mark_1_tank_image.draw(batch);
        this.T_34_tank_image.draw(batch);
        font1.draw(batch,"PLAYER-1",7*this.w/20,4*this.h/5+this.h/20);
        font2.draw(batch,"Choose a Tank",this.w/3+this.w/10,4*this.h/5-this.h/20);

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
