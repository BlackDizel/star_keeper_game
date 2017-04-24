package org.byters.ld38game.model;

import com.badlogic.gdx.Gdx;

public class FlowerInfo {

    private static final float POWER_MIDDLE = 0.5f;
    private static final float STATE_DIE = 0;
    private static final float GROW_FACTOR = 0.2f;

    private static final float STATE_30 = 2.5f;
    private static final float STATE_60 = 5f;
    private static final float STATE_GROWN = 7.5f;

    private float currentState;

    public FlowerInfo() {
        this.currentState = STATE_30;
    }

    public boolean idDie() {
        return currentState < STATE_DIE;
    }

    public void update(float starsLightPower) {
        currentState += (starsLightPower - POWER_MIDDLE) * (starsLightPower > POWER_MIDDLE ? GROW_FACTOR : 1) * Gdx.graphics.getDeltaTime();
    }

    public String getHealth() {
        String result = String.valueOf(currentState);
        return result.substring(0, Math.min(4, result.length()));
    }

    public boolean isGrown() {
        return currentState > STATE_GROWN;
    }

    public int getState() {
        return currentState < STATE_30
                ? 0
                : currentState < STATE_60
                ? 1
                : 2;
    }
}
