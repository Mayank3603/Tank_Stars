package Scens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import sun.jvm.hotspot.debugger.cdbg.basic.LazyBlockSym;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import javax.swing.text.TabableView;
import java.awt.*;
import java.nio.file.spi.FileTypeDetector;

public class Hud {
    public Stage stage;
    private Viewport viewport;
    private int tank1_fuel;
    private float w;
    private float h;

    public int getTank1_fuel() {
        return tank1_fuel;
    }

    public void setTank1_fuel(int tank1_fuel) {
        this.tank1_fuel = tank1_fuel;
    }

    private int tank2_fuel;
    private float fire_angle;
    private int power;
    Table table;
    Label tank1_fuel_label;
    Label tank2_fuel_label;
    Label fire_angle_label;
    Label power_label;
    Pixmap pixmap1;
    Pixmap pixmap2;
    TextureRegionDrawable drawable;




    public Hud(SpriteBatch sb){
        this.tank1_fuel = 19;
        this.tank2_fuel = 10;
        this.fire_angle = 70;
        this.power = 40;

        this.pixmap1=new Pixmap(400,200, Pixmap.Format.RGBA8888);
        pixmap1.setColor(Color.RED);
        pixmap1.fill();

        this.drawable=new TextureRegionDrawable(new TextureRegion(new Texture(pixmap1)));
        pixmap1.dispose();
        ProgressBar.ProgressBarStyle progressBarStyle= new ProgressBar.ProgressBarStyle();
        progressBarStyle.background=drawable;


        pixmap2 = new Pixmap(0, 20, Pixmap.Format.RGBA8888);
        pixmap2.setColor(Color.GREEN);
        pixmap2.fill();
        drawable = new TextureRegionDrawable(new TextureRegion(new Texture(pixmap2)));
        pixmap2.dispose();

        progressBarStyle.knob = drawable;

        Pixmap pixmap = new Pixmap(100, 20, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.GREEN);
        pixmap.fill();
        drawable = new TextureRegionDrawable(new TextureRegion(new Texture(pixmap)));
        pixmap.dispose();

        progressBarStyle.knob = drawable;


        this.w = (float) Gdx.graphics.getWidth();
        this.h = (float)Gdx.graphics.getHeight();
        this.viewport = new FitViewport((float) Gdx.graphics.getWidth(),(float)Gdx.graphics.getHeight(),new OrthographicCamera());
        stage = new Stage(viewport ,sb);
        table  = new Table();
        table.bottom();
        table.setFillParent(true);

        tank1_fuel_label = new Label(String.format("%d",tank1_fuel),new Label.LabelStyle(new BitmapFont(), Color.BLACK));
        tank2_fuel_label = new Label(String.format("%d",tank2_fuel),new Label.LabelStyle(new BitmapFont(), Color.BLACK));
        fire_angle_label = new Label(String.format("%f",fire_angle),new Label.LabelStyle(new BitmapFont(), Color.BLACK));
        power_label = new Label(String.format("%d",power),new Label.LabelStyle(new BitmapFont(), Color.BLACK));
        table.add(tank1_fuel_label).expandX().pad(0,-5*(this.w/6),this.h/11,0);

        ProgressBar healthBar = new ProgressBar(0.0f, 1.0f, 0.01f, false, progressBarStyle);
        healthBar.setValue(1.0f);
        healthBar.setAnimateDuration(0.25f);
        healthBar.setBounds(10, 10, 100, 20);

        stage.addActor(healthBar);
        table.add(tank2_fuel_label).expandX().pad(0,0,this.h/11,this.w/2-this.w/4-this.w/16);


        table.add(fire_angle_label).expandX().pad(0,-this.w/2-this.w/4-this.w/16,this.h/11,0);





        table.add(power_label).expandX().pad(0,-this.w/2-this.w/4-this.w/16,this.h/11,0);
        stage.addActor(this.table);
        };



}
