package com.tank_stars.game;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class T_34_Tank extends Tank{
    private String type="T-34 Tank";
    private List<Weapons> weapons_1;
    public T_34_Tank(){
        super();
        this.add_weapons();

    }

    @Override
    public void getweapon() {
        int max=0;
        try{
            for(int i=0;i<this.weapons_1.size();i++){
                if(max<weapons_1.get(i).getDamage()) {
                    max = weapons_1.get(i).getDamage();
                }
            }
        }
        catch(NullPointerException e){
            System.out.println("The Weapon list is empty");

        }

    }


    @Override
    public void add_weapons(){
        try{
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
        catch (NullPointerException e){
            System.out.println("Caught null pointer exception");
        }
    }
    public String getType(){
        return this.type;
    }
}
