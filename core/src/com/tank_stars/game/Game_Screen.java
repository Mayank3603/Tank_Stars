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
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthoCachedTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector3;

public class Game_Screen implements Screen {

    private Vector3 touchpos = new Vector3();
    final Tank_Stars_Game tank_stars_game;

    private OrthographicCamera camera;
    private SpriteBatch batch;
    private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;

//    private Sprite pause_button;
//    private Sprite background;
//    private Sprite health_bar;
//    private Sprite health_bar2;
//    private Sprite fire_button;
//    private  Sprite left_button;
//    private Sprite right_button;
//    private Sprite angle;
//    private Sprite fuel;
//    private Sprite fuel1;
//    private Sprite tanks1;
//    private Sprite tanks2;
//    private BitmapFont font1;
//    private FreeTypeFontGenerator fontGenerator;
//    private FreeTypeFontGenerator.FreeTypeFontParameter fontParameter1;
//    private FreeTypeFontGenerator.FreeTypeFontParameter fontParameter2;
//
//    private BitmapFont font2;
//    private Sprite terror;
//    private Sprite power;
//
//    private Sprite left_button2;
//    private Sprite right_button2;
//    private Sprite fuel_icon;
//    private Sprite fuel_icon2;
    private float w;
    private float h;

    public Game_Screen(final Tank_Stars_Game tank_stars_game){
        this.tank_stars_game = tank_stars_game;
        this.w = (float) Gdx.graphics.getWidth();
        this.h = (float)Gdx.graphics.getHeight();
        (this.camera = new OrthographicCamera(this.w,this.h)).setToOrtho(false);
        this.batch = new SpriteBatch();

        mapLoader=new TmxMapLoader();
        map=mapLoader.load("background_terrain.tmx");
        renderer=new OrthogonalTiledMapRenderer(map);


//        this.terror = new Sprite(new Texture("terrain_red.png"));
//        this.terror.setSize(this.w,this.h/2);
//        this.background = new Sprite(new Texture("background.jpeg"));
//        this.pause_button = new Sprite(new Texture("pause-button.jpg"));
//        this.health_bar = new Sprite(new Texture("health_bar.png"));
//        this.health_bar2 = new Sprite(new Texture("health_bar2.png"));
//        this.fire_button =new Sprite(new Texture("fire_button.png"));
//        this.left_button = new Sprite(new Texture("left_button.png"));
//        this.right_button = new Sprite(new Texture("right_button.png"));
//        this.left_button2 = new Sprite(new Texture("left_button.png"));
//        this.right_button2 =  new Sprite(new Texture("right_button.png"));
//        this.fuel_icon = new Sprite(new Texture("fuel_icon.png"));
//        this.fuel_icon2 = new Sprite(new Texture("fuel_icon.png"));
//        this.power = new Sprite(new Texture("power.png"));
//        this.angle = new Sprite(new Texture("angle.png"));
//        this.fuel =  new Sprite(new Texture("fuel.png"));
//        this.fuel1 =  new Sprite(new Texture("fuel.png"));
//        this.tanks1 = new Sprite(new Texture("tank1.png"));
//        this.tanks2 = new Sprite(new Texture("tank2.png"));
//
//
//
//        fontGenerator=new FreeTypeFontGenerator(Gdx.files.internal("yankclipper2.ttf"));
//        fontParameter1=new FreeTypeFontGenerator.FreeTypeFontParameter();
//        fontParameter1.size= (int) (this.w/20);
//        fontParameter1.color= Color.BLACK;
//        fontParameter1.borderColor=Color.WHITE;
//        fontParameter1.borderWidth=(int)(this.w/240);
//        font1=fontGenerator.generateFont(fontParameter1);
//        fontParameter2=new FreeTypeFontGenerator.FreeTypeFontParameter();
//        fontParameter2.borderColor=Color.WHITE;
//        fontParameter2.borderWidth=(int)(this.w/240);
//        fontParameter2.size=(int)(this.w/20);
//        fontParameter2.color= Color.BLACK;
//        font2=fontGenerator.generateFont(fontParameter2);
//        this.background.setSize(this.w,this.h);
//        this.health_bar.setSize(this.w/20+(this.w/20)*2,this.h/20);
//        this.health_bar.setPosition(this.w/2-(this.w/16)*3,this.h-this.h/20);
//        this.health_bar2.setSize(this.w/20+(this.w/20)*2,this.h/20);
//        this.health_bar2.setPosition(this.w-(this.w/8)*4+3*(this.w/32),this.h-this.h/20);
//        this.pause_button.setSize(this.w/20,this.h/20);
//        this.pause_button.setPosition((this.w/2),this.h-this.h/20);
//        this.fire_button.setSize(this.w/16,this.h/8);
//        this.fire_button.setPosition((this.w/10)+this.w/3+4*(this.w/64)-this.w/32,this.h/30);
//        this.left_button.setSize(this.w/16,this.h/8);
//
//        this.right_button.setSize(this.w/16,this.h/8);
//        this.left_button2.setSize(this.w/16,this.h/8);
//        this.right_button2.setSize(this.w/16,this.h/8);
//
//        this.left_button2.setPosition(this.w/2-this.w/4-this.w/8+this.w/16-this.w/32,this.h/30);
//        this.right_button2.setPosition( this.w/2+this.w/4+this.w/8-this.w/16-this.w/32,this.h/30);
//
//        this.right_button.setPosition(this.w/2-this.w/4-this.w/32,this.h/30);
//        this.left_button.setPosition(this.w/2+this.w/4-this.w/32,this.h/30);
//        this.fuel.setSize(this.w/16,this.h/8);
//        this.fuel.setPosition(0,this.h/30);
//        this.fuel1.setSize(this.w/16,this.h/8);
//        this.fuel1.setPosition((this.w/12)*11,this.h/30);
//        this.fuel_icon.setSize(this.w/7-this.w/30,this.h/8);
//        this.fuel_icon.setPosition(this.w/20,this.h/30);
//        this.fuel_icon2.setSize(this.w/7-this.w/30,this.h/8);
//        this.fuel_icon2.setPosition(this.w-this.w/6,this.h/30);
//        this.angle.setSize(this.w/6+this.w/24,this.h/6);
//        this.angle.setPosition(this.w/2-this.w/4+this.w/16-this.w/32,this.h/120);
//        this.power.setSize(this.w/6+this.w/24,this.h/6);
//        this.power.setPosition(this.w/2-this.w/4+this.w/16+this.w/4-this.w/32,this.h/120);
//
//        this.tanks1.setSize(this.w/16,this.h/14);
//        this.tanks1.setPosition(this.w/8,this.h/4-this.h/64);
//        this.tanks2.setPosition(this.w-this.w/8,this.h/4+this.h/16+this.h/64);
//        this.tanks2.setSize(this.w/16,this.h/14);
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
//        this.background.draw(this.batch);
//        this.terror.draw(this.batch);
//        this.pause_button.draw(this.batch);
//        this.health_bar.draw(this.batch);
//        this.health_bar2.draw(this.batch);
//        this.fire_button.draw(this.batch);
//        this.left_button.draw(this.batch);
//        this.right_button.draw(this.batch);
//        this.left_button2.draw(this.batch);
//        this.right_button2.draw(this.batch);
//        this.angle.draw(this.batch);
//        this.fuel.draw(this.batch);
//        this.fuel1.draw(this.batch);
//        this.tanks1.draw(this.batch);
//        this.tanks2.draw(this.batch);
//        this.power.draw(this.batch);
//        this.fuel_icon.draw(this.batch);
//        this.fuel_icon2.draw(this.batch);
//        font1.draw(batch,"PLAYER-1",this.w/100,this.h-this.h/20);
//        font2.draw(batch,"PLAYER-2",this.w/2+this.w/4+this.w/100+this.w/100+this.w/100+this.w/100+this.w/100+this.w/100,this.h-this.h/20);
        batch.end();
        inputhandle();
    }

    public void inputhandle(){
        if (Gdx.input.justTouched()){
            this.touchpos.set(Gdx.input.getX(),Gdx.input.getY(),0);
            this.camera.unproject(touchpos);
            if (touchpos.x >= (this.w/2) && touchpos.x <= this.h-this.h/20+this.w/20 && touchpos.y >= this.h-this.h/20 && touchpos.y<=this.h-this.h/20+ this.h/20){

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
