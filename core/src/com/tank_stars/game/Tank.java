package com.tank_stars.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Tank implements Fireweaponer , Serializable {
    private float pos_x ;
    private float pos_y;

    public float getPos_x() {
        return pos_x;
    }

    public float getPos_y() {
        return pos_y;
    }

    public void setPos_x(float pos_x) {
        this.pos_x = pos_x;
    }

    public void setPos_y(float pos_y) {
        this.pos_y = pos_y;
    }

    private int Fuel=1000;
    private String type;
    private int Health = 200;
    private float Angle=70;
    private float shoot_power=70;
    private List<Weapons> weapons ;
    private  Weapons weapon;
    public String name ;
    private int weapons_quantity;
    private int no_of_moves=5;
    public void setFuel(int fuel) {
        Fuel = Fuel-fuel;
    }

    public void setHealth(int health) {
        Health = Health-health;
    }

    public void getweapon(){

    }



    public Tank(){
        this.weapons = new ArrayList<Weapons>();
        this.add_weapons();

    }
    public  void add_weapons(){

    }


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
    public int getHealth() {
        return Health;
    }

    public int getFuel() {
        return Fuel;
    }

    public String getType() {
        return type;
    }

    public float getAngle() {
        return Angle;
    }

    public float getShoot_power() {
        return shoot_power;
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
