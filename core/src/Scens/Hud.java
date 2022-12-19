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



        this.viewport = new FitViewport((float) Gdx.graphics.getWidth(),(float)Gdx.graphics.getHeight(),new OrthographicCamera());
        stage = new Stage(viewport ,sb);
        table  = new Table();
        table.bottom();
        table.setFillParent(true);

        tank1_fuel_label = new Label(String.format("%d",tank1_fuel),new Label.LabelStyle(new BitmapFont(), Color.BLACK));
        table.add(tank1_fuel_label).expandX().pad(0,-(float) Gdx.graphics.getWidth()/2-(float) Gdx.graphics.getWidth()/4-(float) Gdx.graphics.getWidth()/16,(float) Gdx.graphics.getHeight()/11,0);

        stage.addActor(this.table);
        };



}
