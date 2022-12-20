package com.tank_stars.game;

import Scens.Hud;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthoCachedTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.*;

import javax.crypto.interfaces.PBEKey;

import java.nio.file.attribute.UserPrincipal;

import static com.badlogic.gdx.utils.JsonValue.ValueType.object;

public class Game_Screen implements Screen {

    private Vector3 touchpos = new Vector3();
    final Tank_Stars_Game tank_stars_game;

    private OrthographicCamera camera;
    private SpriteBatch batch;
    private TmxMapLoader mapLoader;
    private TiledMap map;

    private OrthogonalTiledMapRenderer renderer;

    private Sprite pause_button;
    private Sprite background;
    private Sprite health_bar;
    private Sprite health_bar2;
    private Sprite missile;
    private Sprite fire_button;
    private  Sprite left_button;
    private Sprite right_button;
    private Sprite angle;
    private Sprite fuel;
    private Sprite fuel1;
    private Sprite tanks1;
    private Sprite tanks2;
    private Sprite air_drop;
    int i = 0;
    int j =0;
    private BitmapFont font1;
    private FreeTypeFontGenerator fontGenerator;

    int odd ;
    int fuel_1 = 1000;
    int fuel_2 =1000;
    private FreeTypeFontGenerator.FreeTypeFontParameter fontParameter1;
    private FreeTypeFontGenerator.FreeTypeFontParameter fontParameter2;

    private BitmapFont font2;
//    private Sprite terror;
    private Sprite power;

    private Sprite left_button2;
    private Sprite right_button2;
    private Sprite fuel_icon;
    private Sprite fuel_icon2;
    private Sprite shooting_body;

    private World world;
    int shooting = -5;
    int flag = 1;
    private World doing_world;
    private Body player;
    private Body player_tank;
    private Body player_tank2;
    private  Body airdrop;
    private  Body shoot_flag;

    private Box2DDebugRenderer b2dr;
    private float w;
    private float h;
    private Hud hud;

    public Game_Screen(final Tank_Stars_Game tank_stars_game){
        this.tank_stars_game = tank_stars_game;
        this.w = (float) Gdx.graphics.getWidth();
        this.odd = 1;
        this.h = (float)Gdx.graphics.getHeight();
        (this.camera = new OrthographicCamera(this.w,this.h)).setToOrtho(false);
        this.batch = new SpriteBatch();
        hud = new Hud(this.batch);
        mapLoader=new TmxMapLoader();
        map=mapLoader.load("rectangle_new.tmx");
        renderer=new OrthogonalTiledMapRenderer(map);


//        this.terror = new Sprite(new Texture("terrain_red.png"));
//        this.terror.setSize(this.w,this.h/2);
        this.background = new Sprite(new Texture("background.jpeg"));
        this.pause_button = new Sprite(new Texture("pause-button.jpg"));
//        this.health_bar = new Sprite(new Texture("health_bar.png"));
//        this.health_bar2 = new Sprite(new Texture("health_bar2.png"));
        this.fire_button =new Sprite(new Texture("fire_button.png"));
        this.left_button = new Sprite(new Texture("left_button.png"));
        this.right_button = new Sprite(new Texture("right_button.png"));
        this.left_button2 = new Sprite(new Texture("left_button.png"));
        this.right_button2 =  new Sprite(new Texture("right_button.png"));
        this.fuel_icon = new Sprite(new Texture("fuel_icon.png"));
        this.fuel_icon2 = new Sprite(new Texture("fuel_icon.png"));
        this.power = new Sprite(new Texture("power.png"));
        this.angle = new Sprite(new Texture("angle.png"));
        this.fuel =  new Sprite(new Texture("fuel.png"));
        this.fuel1 =  new Sprite(new Texture("fuel.png"));
        this.tanks1 = new Sprite(new Texture("tank1.png"));
        this.tanks2 = new Sprite(new Texture("tank2.png"));



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
        fontParameter2.size=(int)(this.w/20);
        fontParameter2.color= Color.BLACK;
        font2=fontGenerator.generateFont(fontParameter2);
        this.background.setSize(this.w,this.h);
//        this.health_bar.setSize(this.w/20+(this.w/20)*2,this.h/20);
//        this.health_bar.setPosition(this.w/2-(this.w/16)*3,this.h-this.h/20);
//        this.health_bar2.setSize(this.w/20+(this.w/20)*2,this.h/20);
//        this.health_bar2.setPosition(this.w-(this.w/8)*4+3*(this.w/32),this.h-this.h/20);
        this.pause_button.setSize(this.w/20,this.h/20);
        this.pause_button.setPosition((this.w/2),this.h-this.h/20);
        this.fire_button.setSize(this.w/16,this.h/8);
        this.fire_button.setPosition((this.w/10)+this.w/3+4*(this.w/64)-this.w/32,this.h/30);
        this.left_button.setSize(this.w/16,this.h/8);

        this.right_button.setSize(this.w/16,this.h/8);
        this.left_button2.setSize(this.w/16,this.h/8);
        this.right_button2.setSize(this.w/16,this.h/8);

        this.left_button2.setPosition(this.w/2-this.w/4-this.w/8+this.w/16-this.w/32,this.h/30);
        this.right_button2.setPosition( this.w/2+this.w/4+this.w/8-this.w/16-this.w/32,this.h/30);

        this.right_button.setPosition(this.w/2-this.w/4-this.w/32,this.h/30);
        this.left_button.setPosition(this.w/2+this.w/4-this.w/32,this.h/30);
        this.fuel.setSize(this.w/16,this.h/8);
        this.fuel.setPosition(0,this.h/30);
        this.fuel1.setSize(this.w/16,this.h/8);
        this.fuel1.setPosition((this.w/12)*11,this.h/30);
        this.fuel_icon.setSize(this.w/7-this.w/30,this.h/8);
        this.fuel_icon.setPosition(this.w/20,this.h/30);
        this.fuel_icon2.setSize(this.w/7-this.w/30,this.h/8);
        this.fuel_icon2.setPosition(this.w-this.w/6,this.h/30);
        this.angle.setSize(this.w/6+this.w/24,this.h/6);
        this.angle.setPosition(this.w/2-this.w/4+this.w/16-this.w/32,this.h/120);
        this.power.setSize(this.w/6+this.w/24,this.h/6);
        this.power.setPosition(this.w/2-this.w/4+this.w/16+this.w/4-this.w/32,this.h/120);
        doing_world = new World(new Vector2(0,-25f),false);
        b2dr = new Box2DDebugRenderer();
        player = createPlayer(100,110,this.w,this.h/12+this.h/12+this.h/60+this.h/30,true);
        player_tank = createPlayer(this.w/4,this.h/2,50,50,false);
        player_tank2 = createPlayer(this.w-this.w/4,this.h/2,50,50,false);







//        doing_world = new World(new Vector2(0,-9.8f),false);



        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        Body body;

        for(MapObject object : map.getLayers().get(0).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            bdef.type   = BodyDef.BodyType.StaticBody;
            bdef.position.set(rect.getX()+ rect.getWidth()/2,rect.getY()+rect.getHeight()/2 );
            body = world.createBody(bdef);
            shape.setAsBox(rect.getWidth()/2,rect.getHeight()/2);
            fdef.shape = shape;
            body.createFixture(fdef);
        }
        this.tanks1.setSize(this.w/16,this.h/14);

        this.tanks2.setSize(this.w/16,this.h/14);

    }

    @Override
    public void show() {

    }

    public Body createPlayer(float position_x,float position_y ,float width,float height,boolean is_static){
        Body pBody;
        BodyDef def = new BodyDef();
        if (is_static){
            def.type = BodyDef.BodyType.StaticBody;
        }
        else{
            def.type = BodyDef.BodyType.DynamicBody;
        }
        def.position.set(position_x,position_y);
        def.fixedRotation = true;
        pBody = doing_world.createBody(def);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width,height);
        pBody.createFixture(shape,10.0f);
        shape.dispose();
        return  pBody;
    }

    public void update(float dt){
        this.doing_world.step(1/60f,6,2);

        inputhandle(dt);

//        this.camera.update();
        this.batch.setProjectionMatrix(camera.combined);

        renderer.setView(this.camera);
    }



    @Override
    public void render(float delta) {
        update(Gdx.graphics.getDeltaTime());
        Gdx.gl.glClearColor(1.0f,1.0f,1.0f,1.0f);
        Gdx.gl.glClear(16384);
        batch.setProjectionMatrix(this.hud.stage.getCamera().combined);

        batch.begin();
        this.tanks1.setPosition(player_tank.getPosition().x-40,this.h/4+this.h/16+this.h/64+this.h/64+this.h/64+this.h/64+this.h/64+this.h/128);
        this.tanks2.setPosition(player_tank2.getPosition().x-40,this.h/4+this.h/16+this.h/64+this.h/64+this.h/64+this.h/64+this.h/64+this.h/128);
        this.background.draw(this.batch);

        this.pause_button.draw(this.batch);
        renderer.render();

//        this.health_bar.draw(this.batch);
//        this.health_bar2.draw(this.batch);
        this.fire_button.draw(this.batch);
        this.left_button.draw(this.batch);
        this.right_button.draw(this.batch);
        this.left_button2.draw(this.batch);
        this.right_button2.draw(this.batch);
        this.angle.draw(this.batch);
        this.fuel.draw(this.batch);
        this.fuel1.draw(this.batch);
        this.tanks1.draw(this.batch);
        this.tanks2.draw(this.batch);
        this.power.draw(this.batch);
        this.fuel_icon.draw(this.batch);
        this.fuel_icon2.draw(this.batch);

        font2.draw(batch,"PLAYER-2",this.w/2+this.w/4+this.w/100+this.w/100+this.w/100+this.w/100+this.w/100+this.w/100,this.h-this.h/20);
        font1.draw(batch,"PLAYER-1",this.w/100,this.h-this.h/20);
        batch.end();
        if ((fuel_1  == 995 || fuel_2 == 995) && flag == 1){
            System.out.println("11");
            airdrop = createPlayer((player_tank.getPosition().x+player_tank2.getPosition().x)/2,this.h,40,40,false);
            flag = 0;
        }
        if (flag == 0){
            throw_air_drop();
            this.batch.begin();
            air_drop.draw(this.batch);
            this.batch.end();
        }
        if(shooting == 0){
//            for(int i=0; i<projectile.getFixtureList().size;i++){
//                projectile.getFixtureList().get(i).setSensor(true);
//            }
            System.out.println("1");
            shoot_flag = createPlayer((int)player_tank.getPosition().x +this.w/24+this.w/24, this.h/2,5,5,false);
            shoot_flag.applyLinearImpulse( 10,10,101,100,true);//            bomb_flag = 0;
            shooting = -1;
        }
        if (shooting == 1){

        }
        b2dr.render(this.doing_world,this.camera.combined);
        this.hud.stage.draw();
        this.hud.stage.act();
    }

    public void inputhandle(float dt){


        if (Gdx.input.justTouched()){
            this.touchpos.set(Gdx.input.getX(),Gdx.input.getY(),0);
            this.camera.unproject(touchpos);
            if (touchpos.x >= (this.w/2) && touchpos.x <= this.h-this.h/20+this.w/20 && touchpos.y >= this.h-this.h/20 && touchpos.y<=this.h-this.h/20+ this.h/20){

                tank_stars_game.setScreen(new Pause_Screen(tank_stars_game,this));
            }

        }
        player_tank.setLinearVelocity(0,player_tank.getLinearVelocity().y);
        player_tank2.setLinearVelocity(0,player_tank2.getLinearVelocity().y);

    if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            moving_left();
        }
     if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            moving_right();
        }
    if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
        shoot();
        }
    }

    public  void moving_left(){
        if (this.odd == 1){
            if (fuel_1 == 0){
                return;
            }
            player_tank.setLinearVelocity(-7500000,player_tank.getLinearVelocity().y);
            System.out.println("fuel_1");
            System.out.println(fuel_1);
            fuel_1  -= 1;

        } else if (this.odd == 0) {
            if (fuel_2 == 0){
                return;
            }
            player_tank2.setLinearVelocity(-7500000,player_tank2.getLinearVelocity().y);
            fuel_2 -= 1;
        }
    }

    public  void moving_right(){
        if (this.odd == 1){
            if (fuel_1 == 0){
                return;
            }
            player_tank.setLinearVelocity(7500000,player_tank.getLinearVelocity().y);
            System.out.println("fuel_1");
            System.out.println(fuel_1);
            fuel_1 -= 1;

        } else if (this.odd == 0) {
            if (fuel_2 == 0){
                return;
            }
            player_tank2.setLinearVelocity(7500000,player_tank2.getLinearVelocity().y);
            fuel_2 -= 1;

        }
    }

    public void shoot(){

        if(odd == 0){
            this.shooting = 0;
            this.odd = 1;
        }
        else if(odd == 1){
             this.shooting= 1;
            this.odd= 0;
        }
    }
    public  void throw_air_drop(){
        this.air_drop = new Sprite(new Texture("Airdrop_in_game.jpg"));
        this.air_drop.setSize(80,80);
        this.air_drop.setPosition(airdrop.getPosition().x-this.w/24+this.w/96,airdrop.getPosition().y-this.h/18-this.h/80);
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
        world.dispose();
        b2dr.dispose();

    }
}
