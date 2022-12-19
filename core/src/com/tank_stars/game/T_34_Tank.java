package com.tank_stars.game;

import java.util.List;

public class T_34_Tank extends Tank{
    private String type="T-34 Tank";
    private List<Weapons> weapons_1;
    public T_34_Tank(){
        super();
        this.add_weapons();

    }
    @Override
    public void add_weapons(){
        Weapons weapon;
        weapon = Weapons.getInstance(25,"Red");
        this.weapons_1.add(weapon);
        weapon = Weapons.getInstance(25,"Red");
        this.weapons_1.add(weapon);
        weapon = Weapons.getInstance(50,"Blue");
        this.weapons_1.add(weapon);
        weapon = Weapons.getInstance(50,"Blue");
        this.weapons_1.add(weapon);
        weapon = Weapons.getInstance(100,"Brwon");
        this.weapons_1.add(weapon);
        weapon = Weapons.getInstance(100,"Brwon");
        this.weapons_1.add(weapon);
    }
    public String getType(){
        return this.type;
    }
}
