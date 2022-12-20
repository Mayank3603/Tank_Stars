package com.tank_stars.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Tank implements Fireweaponer , Serializable {
    private float pos_x;
    private float pos_y;
    private int Fuel;
    private String type;

    public int getHealth() {
        return Health;
    }

    private int Health = 100;
    private float Angle;
    private float shoot_power;
    private List<Weapons> weapons ;
    private  Weapons weapon;
    public String name ;
    private int weapons_quantity;
    private int no_of_moves=5;
    public void setFuel(int fuel) {
        Fuel = fuel;
    }

    public void setHealth(int health) {
        Health = health;
    }

    public abstract void getweapon();



    public Tank(){
        this.weapons = new ArrayList<Weapons>();
        this.add_weapons();

    }
    public abstract void add_weapons();


    public void leftmove(){
        this.no_of_moves-=1;
    }
    public void rightmove(){
        this.no_of_moves-=1;
    }
    public void make_move(String choice){
        if(choice=="left"){
            this.leftmove();
        }
        else{
            this.rightmove();
        }
    }
    public void set_projectile(){

    }
    public void setShoot_power(){

    }
    public final void Steps_to_follow(String choice){
        make_move(choice);
        set_projectile();
        setShoot_power();
        getweapon();
        fire();

    }


   public void collect_air_drop(Airdrop a){

   }
    @Override
    public void fire() {

    }
}
