package org.byters.ld38game.controller;

import org.byters.ld38game.model.FlowerInfo;

public class ControllerFlower {
    private static ControllerFlower instance;

    private FlowerInfo flowerInfo;

    private ControllerFlower() {
        reset();
    }

    public static ControllerFlower getInstance() {
        if (instance == null) instance = new ControllerFlower();
        return instance;
    }

    private void reset() {
        flowerInfo = new FlowerInfo();
    }

    public void update() {
        flowerInfo.update(ControllerStars.getInstance().getStarsLightPower());
    }

    boolean isDie() {
        return flowerInfo.idDie();
    }

    public String getFlowerHealth() {
        return flowerInfo.getHealth();
    }

    boolean isGrown() {
        return flowerInfo.isGrown();
    }

    public int getState() {
        return flowerInfo.getState();
    }

    public boolean isGrow() {
        return flowerInfo.isGrow();
    }
}
