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
        System.out.println("hooe;vjldkjvlajd");
        System.out.println("adfbafb");

    }
    public String getType(){
        return this.type;
    }
}
