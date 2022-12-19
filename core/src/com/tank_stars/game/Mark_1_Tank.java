package com.tank_stars.game;

import java.util.List;

public class Mark_1_Tank extends Tank{
    private String type="Mark_1 Tank";
    private List<Weapons> weapons_1;
    public Mark_1_Tank(){
        super();
        this.add_weapons();

    }
    @Override
    public void add_weapons(){
//        Weapons weapon;
//        weapon = Weapons.getInstance(25,"Red");
//        this.weapons_1.add(weapon);
//        weapon = Weapons.getInstance(25,"Red");
//        this.weapons_1.add(weapon);
//        weapon = Weapons.getInstance(25,"Red");
//        this.weapons_1.add(weapon);
//        weapon = Weapons.getInstance(100,"Brown");
//        this.weapons_1.add(weapon);
//        weapon = Weapons.getInstance(100,"Brwon");
//        this.weapons_1.add(weapon);
//        weapon = Weapons.getInstance(100,"Brwon");
//        this.weapons_1.add(weapon);

    }
    public String getType(){
        return this.type;
    }
}
