package com.tank_stars.game;

import java.awt.*;
import java.util.HashMap;

public class Weapons {
    private final int damage;
    private final String colour;
    private static HashMap<String, Weapons> instances=new HashMap<String,Weapons>();
    public static Weapons getInstance(int damage,String colour){
        String key= damage +" "+ colour;
        if(!instances.containsKey(key)){
            instances.put(key,new Weapons(damage,colour));
        }
        return instances.get(key);
    }
    private Weapons(int damage,String colour){
        this.damage=damage;
        this.colour=colour;

    }

    public int getDamage(){
        return this.damage;
    }
    public String getColour(){
        return  this.colour;
    }

}
