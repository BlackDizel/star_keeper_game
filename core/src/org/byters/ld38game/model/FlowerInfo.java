package org.byters.ld38game.model;

import com.badlogic.gdx.Gdx;

public class FlowerInfo {

    private static final float STATE_MIDDLE = 0.5f;
    private static final float STATE_DIE = 0;
    private float currentState;

    public FlowerInfo() {
        this.currentState = STATE_MIDDLE;
    }

    public boolean idDie() {
        return currentState < STATE_DIE;
    }

    public void update(float starsLightPower) {
        currentState += (starsLightPower - STATE_MIDDLE) * Gdx.graphics.getDeltaTime();
    }
}
