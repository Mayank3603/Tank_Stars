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
        if (ischeckingcontact(fa,fb)){
            this.game_screen.to_kill_tank_2();
            System.out.println("collison happen");
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
    private boolean ischeckingcontact(Fixture a ,Fixture b){
        System.out.println(a.getDensity());
        System.out.println(b.getDensity());
        if (a.getDensity() == 11.0f && b.getDensity() == 5.0f){
            return true;
        }
        if (a.getDensity() == 5.0f && b.getDensity() == 11.0f){
            return true;
        }
        if (a.getDensity() == 10.0f && b.getDensity() == 5.0f){
            return true;
        }
        if (a.getDensity() == 5.0f && b.getDensity() == 10.0f){
            return true;
        }
        return false;
    }
}
