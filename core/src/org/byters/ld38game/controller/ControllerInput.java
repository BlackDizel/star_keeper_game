package org.byters.ld38game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

class ControllerInput {
    private static ControllerInput instance;

    private ControllerInput() {
    }

    static ControllerInput getInstance() {
        if (instance == null) instance = new ControllerInput();
        return instance;
    }

    boolean isRightPressed() {
        //todo  add gamepad support
        return Gdx.input.isKeyPressed(Input.Keys.D)
                || Gdx.input.isKeyPressed(Input.Keys.RIGHT);
    }

    boolean isLeftPressed() {
        //todo  add gamepad support
        return Gdx.input.isKeyPressed(Input.Keys.A)
                || Gdx.input.isKeyPressed(Input.Keys.LEFT);
    }

    boolean isShoot() {
        return Gdx.input.isButtonPressed(Input.Buttons.LEFT);
    }

    float getAimPositionX() {
        return Gdx.input.getX();
    }

    float getAimPositionY() {
        return Gdx.graphics.getHeight() - Gdx.input.getY();
    }
}
