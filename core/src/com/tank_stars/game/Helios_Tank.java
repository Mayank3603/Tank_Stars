package com.tank_stars.game;

import java.util.List;

public class Helios_Tank extends Tank{
    private String type="Helios Tank";
    private List<Weapons> weapons_1;
    public Helios_Tank(){
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
