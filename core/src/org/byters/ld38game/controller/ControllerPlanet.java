package org.byters.ld38game.controller;

import com.badlogic.gdx.Gdx;

public class ControllerPlanet {
    private static final float SPEED = 20;
    private static ControllerPlanet instance;

    private float rotation;

    private ControllerPlanet() {
        rotation = 0;
    }

    public static ControllerPlanet getInstance() {
        if (instance == null) instance = new ControllerPlanet();
        return instance;
    }

    public float getPositionX() {
        return Gdx.graphics.getWidth() / 6;
    }


    public float getPositionY() {
        return Gdx.graphics.getHeight() / 6 * 4;
    }

    public float getRotation() {
        return rotation;
    }

    public void update() {
        if (ControllerPlayer.getInstance().isBounded())
            rotation += Gdx.graphics.getDeltaTime() * ControllerPlayer.getInstance().getMoveDirection() * SPEED;
    }
}
