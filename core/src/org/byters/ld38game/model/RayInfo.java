package org.byters.ld38game.model;

import com.badlogic.gdx.Gdx;

public class RayInfo {
    private static final float ALPHA_CHANGE_SPEED = 0.2f;
    private static float ATTACK_DISTANCE;
    private final float positionX;
    private final float positionY;
    private final float rotation;
    private final float positionX2;
    private final float positionY2;
    private float alpha;

    public RayInfo(float positionX, float positionY, float positionX2, float positionY2) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.positionX2 = positionX2;
        this.positionY2 = positionY2;
        this.rotation = initRotation();
        this.alpha = 1;
    }

    public static void setAttackDistance(float attackDistance) {
        ATTACK_DISTANCE = attackDistance;
    }

    private float initRotation() {
        return (float) Math.toDegrees(Math.atan2(positionY2 - positionY, positionX2 - positionX));
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

    public boolean isAttacking(float x0, float y0) {
        float distance = (float) (Math.abs((positionX2 - positionX) * (positionY - y0) - (positionX - x0) * (positionY2 - positionY)) / Math.sqrt(Math.pow((positionX2 - positionX), 2) + Math.pow((positionY2 - positionY), 2))); //todo simplify
        return distance < ATTACK_DISTANCE;
    }
}
