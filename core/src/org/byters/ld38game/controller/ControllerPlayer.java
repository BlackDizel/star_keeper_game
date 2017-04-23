package org.byters.ld38game.controller;

import com.badlogic.gdx.Gdx;

public class ControllerPlayer {

    public static final int DIRECTION_RIGHT = 1;
    public static final int DIRECTION_LEFT = -1;
    public static final int DIRECTION_NONE = 0;
    private static final float SPEED = 30;
    private static ControllerPlayer instance;
    private float xPosition;
    private int moveDirection;
    private int lookDirection;
    private boolean isBounded;

    private ControllerPlayer() {
        xPosition = Gdx.graphics.getWidth() / 3;
        moveDirection = DIRECTION_NONE;
        lookDirection = DIRECTION_RIGHT;
        isBounded = false;
    }

    public static ControllerPlayer getInstance() {
        if (instance == null) instance = new ControllerPlayer();
        return instance;
    }

    public boolean isBounded() {
        return isBounded;
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

    public float getDelta() {
        return moveDirection * Gdx.graphics.getDeltaTime() * SPEED * ControllerGameFlow.getInstance().getScale();
    }

    public int getMoveDirection() {
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
        if (ControllerInput.getInstance().isRightPressed()) {
            moveDirection = DIRECTION_RIGHT;
            lookDirection = DIRECTION_RIGHT;
        } else if (ControllerInput.getInstance().isLeftPressed()) {
            moveDirection = DIRECTION_LEFT;
            lookDirection = DIRECTION_LEFT;
        } else moveDirection = DIRECTION_NONE;
    }

    public boolean isPlayerDirectionRight() {
        return lookDirection == DIRECTION_RIGHT;
    }
}
