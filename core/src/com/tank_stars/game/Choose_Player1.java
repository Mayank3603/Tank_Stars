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

public class Choose_Player1 implements Screen {
    final  Tank_Stars_Game tank_stars_game;
    private Vector3 touchpos = new Vector3();
    private Choose_player2 choose_player2;
    private float w;
    private float h;
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Sprite background;
    private Sprite Helios_tank_image;
    private Sprite Mark_1_tank_image;
    private Sprite T_34_tank_image;
    private  Sprite back_button;

    private FreeTypeFontGenerator fontGenerator;
    private FreeTypeFontGenerator.FreeTypeFontParameter fontParameter1;
    private FreeTypeFontGenerator.FreeTypeFontParameter fontParameter2;
    private BitmapFont font1;
    private BitmapFont font2;



    public Choose_Player1(final Tank_Stars_Game tank_stars_game ){
        this.tank_stars_game = tank_stars_game;
        this.w = (float) Gdx.graphics.getWidth();
        this.h = (float)Gdx.graphics.getHeight();
        (this.camera = new OrthographicCamera(this.w,this.h)).setToOrtho(false);
        this.batch = new SpriteBatch();
        this.background = new Sprite(new Texture("saved_gamed.png"));
        this.T_34_tank_image = new Sprite(new Texture("t_34_tank.png"));
        this.Mark_1_tank_image = new Sprite(new Texture("Mark_tank.png"));
        this.Helios_tank_image = new Sprite(new Texture("Helios.png"));
        this.back_button = new Sprite(new Texture("back_button.png"));
        this.background.setSize(this.w,this.h);

        this.Helios_tank_image.setSize(this.w/3-this.w/12,this.h/3);
        this.Helios_tank_image.setPosition((this.w/12)-this.w/24,this.h/8);

        this.T_34_tank_image.setSize(this.w/3-this.w/12,this.h/3);
        this.T_34_tank_image.setPosition((this.w/12)+2*this.w/3-this.w/24,this.h/8);

        this.Mark_1_tank_image.setSize(this.w/3-this.w/12,this.h/3);
        this.Mark_1_tank_image.setPosition((this.w/12)+this.w/3-this.w/24,this.h/8);

        this.back_button.setSize(this.w/6,this.h/12);
        this.back_button.setPosition(this.w/2+this.w/4,this.h-this.h/10);

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
        this.batch.setProjectionMatrix(this.camera.combined);
        this.batch.begin();
        this.background.draw(batch);
        this.Helios_tank_image.draw(batch);
        this.Mark_1_tank_image.draw(batch);
        this.T_34_tank_image.draw(batch);
        font1.draw(batch,"PLAYER-1:",this.w/100,this.h-this.h/20);
        font2.draw(batch,"CHOOSE A TANK:",this.w/3-this.w/24,4*this.h/5-this.h/20);

        font1.draw(batch,"HELIOS TANK",(this.w/12)-this.w/48,this.h/10);
        font1.draw(batch,"MARK TANK",(this.w/12)+this.w/3,this.h/10);
        font1.draw(batch,"T_34 TANK",(this.w/12)+2*this.w/3,this.h/10);
        this.back_button.draw(this.batch);
        this.batch.end();
        this.inputhandle();
    }

    public void inputhandle(){
        if (Gdx.input.justTouched()){
            this.touchpos.set(Gdx.input.getX(),Gdx.input.getY(),0);
            this.camera.unproject(touchpos);
            if (touchpos.x >= (this.w/12)-this.w/24 && touchpos.x <= (this.w/12)-this.w/24+this.w/3-this.w/12 && touchpos.y >= this.h/8 && touchpos.y<=this.h/8+ this.h/3){
                this.choose_player2 = new Choose_player2(tank_stars_game);
                tank_stars_game.setTank_1(new Helios_Tank());
                tank_stars_game.setScreen(this.choose_player2);
            }
            else if (touchpos.x >= (this.w/12)+2*this.w/3-this.w/24&& touchpos.x <=  (this.w/12)+2*this.w/3-this.w/24+this.w/3-this.w/12&& touchpos.y >= this.h/8 && touchpos.y<=this.h/8+ this.h/3) {
                this.choose_player2 = new Choose_player2(tank_stars_game);
                tank_stars_game.setTank_1(new Mark_1_Tank());
                tank_stars_game.setScreen(this.choose_player2);
            }
            else if (touchpos.x >= (this.w/12)+this.w/3-this.w/24 && touchpos.x <= (this.w/12)+this.w/3-this.w/24+this.w/3-this.w/12&& touchpos.y >= this.h/8 && touchpos.y<=this.h/8+this.h/3) {
                this.choose_player2 = new Choose_player2(tank_stars_game);
                tank_stars_game.setTank_1(new T_34_Tank());
                tank_stars_game.setScreen(this.choose_player2);
            } else if (touchpos.x >= this.w/2+this.w/4 && touchpos.x <= this.w/2+this.w/4+ this.w/6&& touchpos.y >= this.h-this.h/10 && touchpos.y<=this.h-this.h/10+this.h/12) {
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
