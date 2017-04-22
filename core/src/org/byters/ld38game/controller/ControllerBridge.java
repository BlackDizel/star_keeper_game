package org.byters.ld38game.controller;

import com.badlogic.gdx.Gdx;

public class ControllerBridge {
    private static ControllerBridge instance;

    private float deltaX;
    private int width;

    private ControllerBridge() {
        deltaX = 0;
        width = 0;
    }

    public static ControllerBridge getInstance() {
        if (instance == null) instance = new ControllerBridge();
        return instance;
    }

    public float getPositionFirst() {
        return deltaX;
    }

    public float getPositionSecond() {
        return deltaX > 0 ? deltaX - width : deltaX + width;
    }

    public float getPositionY() {
        return Gdx.graphics.getHeight() / 6 * 1.5f;
    }


    public void update() {
        if (ControllerPlayer.getInstance().isBounded()) {
            deltaX -= ControllerPlayer.getInstance().getDelta();
            if (deltaX > width) deltaX -= width;
            if (deltaX < -width) deltaX += width;
        }
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
