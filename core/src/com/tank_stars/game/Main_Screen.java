package com.tank_stars.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class Main_Screen implements Screen{
    final Tank_Stars_Game tank_stars_game;
    private Choose_Player1 choose_player1;

    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Sprite main_menu_screen;
    private Sprite play_button;
    private Sprite resume_button;
    private Sprite exit_button;
    final Vector3 touchpos = new Vector3();

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
        this.play_button.setSize(this.w/6,this.h/12);
        this.play_button.setPosition(this.w/10,this.h/30);
        this.resume_button.setSize(this.w/6,this.h/12);
        this.resume_button.setPosition((this.w/10)+this.w/3,this.h/30);
        this.exit_button.setSize(this.w/6,this.h/12);
        this.exit_button.setPosition((this.w/10)+2*this.w/3,this.h/30);
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
        inputhandle();
    }
    
    public void inputhandle(){
        if (Gdx.input.justTouched()){
            this.touchpos.set(Gdx.input.getX(),Gdx.input.getY(),0);
            this.camera.unproject(touchpos);
            if (touchpos.x >= this.w/10 && touchpos.x <= this.h/30+this.w/6 && touchpos.y >= this.h/30 && touchpos.y<=this.h/30+ this.h/12){
                this.choose_player1 = new Choose_Player1(tank_stars_game);
                tank_stars_game.setScreen(this.choose_player1);
            }
            else if (touchpos.x >= (this.w/10)+this.w/3 && touchpos.x <= (this.w/10)+this.w/3+this.w/6&& touchpos.y >= this.h/30 && touchpos.y<=this.h/30+ this.h/12) {
                System.out.println("resume game");
            }
            else if (touchpos.x >= (this.w/10)+2*this.w/3 && touchpos.x <= (this.w/10)+2*this.w/3+this.w/6&& touchpos.y >= this.h/30 && touchpos.y<=this.h/30+ this.h/12) {
                System.out.println("exit game");
                Gdx.app.exit();
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
