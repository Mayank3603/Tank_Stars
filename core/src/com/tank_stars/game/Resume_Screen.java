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
import com.badlogic.gdx.utils.Array;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static java.lang.System.in;

public class Resume_Screen implements Screen, Serializable {
    final Tank_Stars_Game tank_stars_game;
    private OrthographicCamera camera;
    private SpriteBatch batch;

    private Sprite bg;
    private float w;
    private float h;
    int total_file;
    int i =0;
    FileReader in = null;
    FileReader total =null;
    ObjectInputStream out = null;
    private FreeTypeFontGenerator fontGenerator;
    private List<BitmapFont> font;
    private BitmapFont font1;
    private FreeTypeFontGenerator.FreeTypeFontParameter fontParameter1;
    private Vector3 postion_saved_game = new Vector3();
    private  List<Vector3> postion_saved;
    private Sprite resume_button;
    private Sprite back_button;
    private Sprite saved_button;
    private Sprite exit_button;
    private Vector3 touchpos = new Vector3();


    private FreeTypeFontGenerator.FreeTypeFontParameter fontParameter2;

    private BitmapFont font2;

    public Resume_Screen(final  Tank_Stars_Game tank_stars_game) throws IOException {
        this.tank_stars_game = tank_stars_game;
        this.font = new ArrayList<BitmapFont>();
        this.postion_saved = new ArrayList<Vector3>();
        this.w = (float) Gdx.graphics.getWidth();
        this.h = (float)Gdx.graphics.getHeight();
        (this.camera = new OrthographicCamera(this.w,this.h)).setToOrtho(false);
        this.batch = new SpriteBatch();
        this.bg = new Sprite(new Texture("saved_gamed.png"));
        this.bg.setSize(this.w,this.h);
        this.resume_button = new Sprite(new Texture("new_game.png"));
        this.saved_button = new Sprite(new Texture("new_game.png"));
        this.exit_button = new Sprite(new Texture("new_game.png"));
        this.back_button = new Sprite(new Texture("resume_game.png"));

        this.resume_button.setSize(this.w/6,this.h/12);
        this.resume_button.setPosition((this.w/10)+this.w/3,this.h/30+this.h/2+this.h/5);
        this.saved_button.setSize(this.w/6,this.h/12);
        this.saved_button.setPosition((this.w/10)+this.w/3,this.h/30+this.h/2);
        this.exit_button.setSize(this.w/6,this.h/12);
        this.exit_button.setPosition((this.w/10)+this.w/3,this.h/30+this.h/4);
        this.back_button.setSize(this.w/6,this.h/12);
        this.back_button.setPosition(this.w/100,this.h-this.h/10);

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
        try {
            total = new FileReader("Total_saved_game");
            int c;
            while ((c = total.read()) != -1){
                total_file = Character.getNumericValue(c);
            }
            total.close();
            for (i =0 ;i < total_file;i++){
                fontGenerator=new FreeTypeFontGenerator(Gdx.files.internal("yankclipper2.ttf"));
                fontParameter1=new FreeTypeFontGenerator.FreeTypeFontParameter();
                fontParameter1.size= (int) (this.w/20);
                fontParameter1.color= Color.BLACK;
                fontParameter1.borderColor=Color.WHITE;
                fontParameter1.borderWidth=(int)(this.w/240);
                font1=fontGenerator.generateFont(fontParameter1);
                font.add(i,font1);
            }
        }
        finally {
            if (total != null){
                total.close();
            }

        }

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

        this.bg.draw(batch);
        font1.draw(batch,"LOAD GAMES",(this.w/10)+this.w/3,this.h-this.h/20);
        this.resume_button.draw(this.batch);
        this.exit_button.draw(this.batch);
        this.saved_button.draw(this.batch);
        this.back_button.draw(this.batch);
        try {
            deserialize();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        this.batch.end();
        inputhandle();

    }

public void deserialize() throws IOException,ClassNotFoundException{
        float change_x = this.w;
        float change_y = this.h;
        try{
            for ( i = 0 ;i < 1;i++){
                this.out = new ObjectInputStream(new FileInputStream("Gamessaved"+(i+1)+".txt"));
//                Game_Screen t1 = (Tank_Stars_Game) out.readObject();
//                font.get(i).draw(batch,Integer.toString(t1.getTank_1().getHealth()),change_x/2,change_y-change_y/20);
//                font.get(i).draw(batch,Integer.toString(t1.getTank_2().getHealth()),change_x/2,change_y-change_y/20);
                change_y = change_y - (change_y/10+change_y/30);
                this.postion_saved_game.set(change_x,change_y,0);
                this.postion_saved.add(i,postion_saved_game);
            }
        }
        finally {
            if (out != null){
                out.close();
            }

        }
    }


    public void inputhandle(){
        if (Gdx.input.justTouched()){
            this.touchpos.set(Gdx.input.getX(),Gdx.input.getY(),0);
            this.camera.unproject(touchpos);
            if (touchpos.x >= (this.w/10)+this.w/3&& touchpos.x <= (this.w/10)+this.w/3+this.w/6 && touchpos.y >=this.h/30+this.h/2+this.h/5&& touchpos.y<=this.h/30+this.h/2+this.h/5+ this.h/12){
                tank_stars_game.setScreen(new Game_Screen(tank_stars_game));
            }
            else if (touchpos.x >=(this.w/10)+this.w/3&& touchpos.x <= (this.w/10)+this.w/3+this.w/6&& touchpos.y >= this.h/30+this.h/2 && touchpos.y<=this.h/30+this.h/2+ this.h/12) {
                tank_stars_game.setScreen(new Game_Screen(tank_stars_game));
            }
            else if (touchpos.x >= (this.w/10)+this.w/3&& touchpos.x <= (this.w/10)+this.w/3+this.w/6&& touchpos.y >=this.h/30+this.h/4&& touchpos.y<=this.h/30+this.h/4+ this.h/12) {
                tank_stars_game.setScreen(new Game_Screen(tank_stars_game));
            } else if (touchpos.x >= this.w/100&& touchpos.x <= this.w/100+this.w/6&& touchpos.y >=this.h-this.h/10&& touchpos.y<=this.h-this.h/10+this.h/12) {
                tank_stars_game.setScreen(new Main_Screen(tank_stars_game));

            }
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
    public void dispose() {

    }
}
