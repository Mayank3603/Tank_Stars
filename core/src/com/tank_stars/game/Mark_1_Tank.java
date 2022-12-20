package com.tank_stars.game;

import java.util.List;

public class Mark_1_Tank extends Tank{
    private String type="Mark_1 Tank";
    private List<Weapons> weapons_1;

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


    public Mark_1_Tank(){
        super();
        this.add_weapons();

    }
    @Override
    public void add_weapons(){
        try{
            Weapons weapon;
            weapon = Weapons.getInstance(25,"Red");
            this.weapons_1.add(weapon);
            weapon = Weapons.getInstance(25,"Red");
            this.weapons_1.add(weapon);
            weapon = Weapons.getInstance(25,"Red");
            this.weapons_1.add(weapon);
            weapon = Weapons.getInstance(100,"Brown");
            this.weapons_1.add(weapon);
            weapon = Weapons.getInstance(100,"Brwon");
            this.weapons_1.add(weapon);
            weapon = Weapons.getInstance(100,"Brwon");
            this.weapons_1.add(weapon);
        }
        catch (NullPointerException e){
            System.out.println("Found Null Weapon list");
        }



    }
    public String getType(){
        return this.type;
    }
}
