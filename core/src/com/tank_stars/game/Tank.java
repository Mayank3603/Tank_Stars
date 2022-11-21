package com.tank_stars.game;

import com.badlogic.gdx.InputProcessor;

import java.util.ArrayList;
import java.util.List;

public class Tank implements Fireweaponer {
    private float pos_x;
    private float pos_y;
    private int Fuel;
    private int Health;
    private float Angle;
    private float shoot_power;
    private List<Weapons> weapons ;
    private  Weapons weapon;
    public String name ;
    private int weapons_quantity;
    public void setFuel(int fuel) {
        Fuel = fuel;
    }

    public void setHealth(int health) {
        Health = health;
    }



    public Tank(){
        this.weapons = new ArrayList<Weapons>();
        add_weapons();

    }
    public  void add_weapons(){
        for (int i =0 ;i<3;i++){
        weapon = new Weapons();
        weapons.add(i,weapon);
        }

    }
    public void leftmove(){

    }
    public void rightmove(){

    }
   public void choose_weapon(){

   }
   public void collect_air_drop(Airdrop a){

   }
    @Override
    public void fire() {

    }
}
