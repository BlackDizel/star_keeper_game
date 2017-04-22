package org.byters.ld38game.model;

import com.badlogic.gdx.Gdx;

public class RayInfo {
    private static final float ALPHA_CHANGE_SPEED = 0.2f;
    private final float positionX;
    private final float positionY;
    private final float rotation;
    private float alpha;

    public RayInfo(float positionX, float positionY, float rotation) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.rotation = rotation;
        this.alpha = 1;
    }

    public float getPositionX() {
        return positionX;
    }

    public float getPositionY() {
        return positionY;
    }

    public float getRotation() {
        return rotation;
    }

    public void update() {
        alpha -= Gdx.graphics.getDeltaTime() * ALPHA_CHANGE_SPEED;
    }

    public float getAlpha() {
        return alpha;
    }

    public boolean isToRemove() {
        return alpha < 0;
    }
}
