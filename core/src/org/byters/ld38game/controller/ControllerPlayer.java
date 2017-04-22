package org.byters.ld38game.controller;

import com.badlogic.gdx.Gdx;

public class ControllerPlayer {

    private static final float SPEED = 100;
    private static final int DIRECTION_RIGHT = 1;
    private static final int DIRECTION_LEFT = -1;
    private static final int DIRECTION_NONE = 0;
    private static ControllerPlayer instance;
    private float xPosition;
    private int moveDirection;
    private boolean isBounded;

    public boolean isBounded() {
        return isBounded;
    }

    private ControllerPlayer() {
        xPosition = Gdx.graphics.getWidth() / 3;
        moveDirection = 0;
        isBounded = false;
    }

    public static ControllerPlayer getInstance() {
        if (instance == null) instance = new ControllerPlayer();
        return instance;
    }

    public float getPositionX() {
        return xPosition;
    }

    public void update() {
        float newValue = xPosition + getDelta();
        isBounded = true;
        if (newValue < getRightBounds()
                && newValue >= getLeftBounds()) {
            xPosition = newValue;
            isBounded = false;
        }
    }

    float getDelta() {
        return moveDirection * Gdx.graphics.getDeltaTime() * SPEED;
    }

    int getMoveDirection() {
        return moveDirection;
    }

    private float getLeftBounds() {
        return Gdx.graphics.getWidth() / 6;
    }

    private float getRightBounds() {
        return Gdx.graphics.getWidth() / 6 * 5;
    }

    public float getPositionY() {
        return Gdx.graphics.getHeight() / 3;
    }

    public void input() {
        if (ControllerInput.getInstance().isRightPressed())
            moveDirection = DIRECTION_RIGHT;
        else if (ControllerInput.getInstance().isLeftPressed())
            moveDirection = DIRECTION_LEFT;
        else moveDirection = DIRECTION_NONE;
    }

}
