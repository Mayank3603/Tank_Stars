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
import com.badlogic.gdx.math.Vector3;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

public class Pause_Screen implements Screen , Serializable {

    final Tank_Stars_Game tank_stars_game;
     private Game_Screen game_screen;
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Sprite background;
    private Sprite resume_button;
    private Sprite saved_button;
    private Sprite exit_button;
    private Vector3 touchpos = new Vector3();
    private ObjectOutputStream out = null;
    private float w;
    private float h;

    private FreeTypeFontGenerator fontGenerator;
    private List<BitmapFont> font;
    private BitmapFont font1;
    private FreeTypeFontGenerator.FreeTypeFontParameter fontParameter1;
    private FreeTypeFontGenerator.FreeTypeFontParameter fontParameter2;

    private BitmapFont font2;

    public Pause_Screen(final Tank_Stars_Game tank_stars_game,Game_Screen game_screen){
        this.tank_stars_game = tank_stars_game;
        this.game_screen = game_screen;
        this.w = (float) Gdx.graphics.getWidth();
        this.h = (float)Gdx.graphics.getHeight();
        (this.camera = new OrthographicCamera(this.w,this.h)).setToOrtho(false);
        this.batch = new SpriteBatch();
        this.background = new Sprite(new Texture("saved_gamed.png"));
        this.background.setSize(this.w,this.h);
        this.resume_button = new Sprite(new Texture("resume_game.png"));
        this.saved_button = new Sprite(new Texture("saved_button.png"));
        this.exit_button = new Sprite(new Texture("exit_game.png"));


        this.resume_button.setSize(this.w/6,this.h/12);
        this.resume_button.setPosition((this.w/10)+this.w/3,this.h/30+this.h/2+this.h/5);
        this.saved_button.setSize(this.w/6,this.h/12);
        this.saved_button.setPosition((this.w/10)+this.w/3,this.h/30+this.h/2);
        this.exit_button.setSize(this.w/6,this.h/12);
        this.exit_button.setPosition((this.w/10)+this.w/3,this.h/30+this.h/4);

        fontGenerator=new FreeTypeFontGenerator(Gdx.files.internal("yankclipper2.ttf"));
        fontParameter1=new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameter1.size= (int) (this.w/20);
        fontParameter1.color= Color.BLACK;
        fontParameter1.borderColor=Color.WHITE;
        fontParameter1.borderWidth=(int)(this.w/240);
        font1=fontGenerator.generateFont(fontParameter1);
        fontParameter2=new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameter2.borderColor=Color.WHITE;
        fontParameter2.borderWidth=(int)(this.w/240);
        fontParameter2.size=(int)(this.w/8);
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
        batch.setProjectionMatrix(this.camera.combined);
        batch.begin();
        this.background.draw(this.batch);
        this.resume_button.draw(this.batch);
        this.saved_button.draw(this.batch);
        this.exit_button.draw(this.batch);
        font1.draw(batch,"PAUSED",(this.w/10)+this.w/3,this.h-this.h/20);
        batch.end();
        inputhandle();
    }
    public void inputhandle() {
        if (Gdx.input.justTouched()){
            this.touchpos.set(Gdx.input.getX(),Gdx.input.getY(),0);
            this.camera.unproject(touchpos);
            if (touchpos.x >= (this.w/10)+this.w/3&& touchpos.x <= (this.w/10)+this.w/3+this.w/6 && touchpos.y >=this.h/30+this.h/2+this.h/5&& touchpos.y<=this.h/30+this.h/2+this.h/5+ this.h/12){
                tank_stars_game.setScreen(this.game_screen);
            }
            else if (touchpos.x >=(this.w/10)+this.w/3&& touchpos.x <= (this.w/10)+this.w/3+this.w/6&& touchpos.y >= this.h/30+this.h/2 && touchpos.y<=this.h/30+this.h/2+ this.h/12) {
                try {
                    serialize();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            else if (touchpos.x >= (this.w/10)+this.w/3&& touchpos.x <= (this.w/10)+this.w/3+this.w/6&& touchpos.y >=this.h/30+this.h/4&& touchpos.y<=this.h/30+this.h/4+ this.h/12) {
                Gdx.app.exit();
            }
        }
    }
    public void serialize() throws IOException{
//       try{
//           out = new ObjectOutputStream(new FileOutputStream("Gamessaved1.txt"));
//           out.writeObject(this);
//
//       }
//        finally {
//           out.close();
//       }
        tank_stars_game.setScreen(new Main_Screen(tank_stars_game));
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
