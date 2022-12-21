package com.tank_stars.game;

import com.badlogic.gdx.physics.box2d.*;

import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;

public class Contactlistener implements ContactListener {
Game_Screen game_screen;

    public Contactlistener(Game_Screen game_screen) {
        this.game_screen = game_screen;
    }

    @Override
    public void beginContact(Contact contact) {
        Fixture fa = contact.getFixtureA();
        Fixture fb = contact.getFixtureB();
        if (fa == null || fb == null){
            return;
        }
        if (fa.getUserData() == null || fb.getUserData() == null){
            return;
        }
        if (ischeckingcontact(fa,fb) == 1){
            this.game_screen.to_kill_shoot_flag();
            System.out.println("collison happen");
        }
        if (ischeckingcontact(fa,fb) == 2 ){
            this.game_screen.setHealth_two(10);
            this.game_screen.to_kill_tank_2();
        }
        if (ischeckingcontact(fa,fb) == 3){
            this.game_screen.setHealth_one(10);
            this.game_screen.to_kill_tank_1();
        }
        if (ischeckingcontact(fa,fb) == 4){
            System.out.println("agaya");
            this.game_screen.to_remove_air_drop_tank1();
        }
        if (ischeckingcontact(fa,fb) == 5){
            this.game_screen.to_remove_air_drop_tank2();
        }
        if (ischeckingcontact(fa,fb) == 6){
            this.game_screen.to_kill_shoot_flag();
        }

    }

    @Override
    public void endContact(Contact contact) {
        Fixture fa = contact.getFixtureA();
        Fixture fb = contact.getFixtureB();
        if (fa == null || fb == null){
            return;
        }
        if (fa.getUserData() == null || fb.getUserData() == null){
            return;
        }
        System.out.println("a collision  stop");
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
    private int ischeckingcontact(Fixture a ,Fixture b){
        System.out.println(a.getDensity());
        System.out.println(b.getDensity());

        if (a.getDensity() == 11.0f && b.getDensity() == 5.0f){
            return 1;
        }

        if (a.getDensity() == 5.0f && b.getDensity() == 11.0f){
            return 1;
        }

        if (a.getDensity() == 10.0f && b.getDensity() == 5.0f){
            return 2;
        }
        if (a.getDensity() == 5.0f && b.getDensity() == 10.0f){
            return 2;
        }

        if (a.getDensity() == 12.0f && b.getDensity() == 5.0f){
            return 3;
        }
        if (a.getDensity() == 5.0f && b.getDensity() == 12.0f){
            return 3;
        }

        if (a.getDensity() == 12.0f && b.getDensity() == 6.0f){
            return 4;
        }
        if (a.getDensity() == 6.0f && b.getDensity() == 12.0f){
            return 4;
        }
        if (a.getDensity() == 10.0f && b.getDensity() == 6.0f){
            return 5;
        }
        if (a.getDensity() == 6.0f && b.getDensity() == 10.0f){
            return 5;
        }
        if (a.getDensity() == 5.0f && b.getDensity() == 6.0f){
            return 6;
        }
        if (a.getDensity() == 6.0f && b.getDensity() == 5.0f){
            return 6;
        }
        return 0;
    }
}
