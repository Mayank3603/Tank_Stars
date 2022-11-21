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

    }
    public String getType(){
        return this.type;
    }
}
