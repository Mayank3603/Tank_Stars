package Scens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import jogamp.graph.font.typecast.ot.table.DirectoryEntry;
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



    public Hud(SpriteBatch sb){
        this.tank1_fuel = 19;
        this.tank2_fuel = 10;
        this.fire_angle = 70;
        this.power = 40;


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


        table.add(tank2_fuel_label).expandX().pad(0,0,this.h/11,this.w/2-this.w/4-this.w/16);


        table.add(fire_angle_label).expandX().pad(0,-this.w/2-this.w/4-this.w/16,this.h/11,0);





        table.add(power_label).expandX().pad(0,-this.w/2-this.w/4-this.w/16,this.h/11,0);
        stage.addActor(this.table);
        };



}
