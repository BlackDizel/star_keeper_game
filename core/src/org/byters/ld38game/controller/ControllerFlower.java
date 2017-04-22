package org.byters.ld38game.controller;

import org.byters.ld38game.model.FlowerInfo;

public class ControllerFlower {
    private static ControllerFlower instance;

    private FlowerInfo flowerInfo;

    public static ControllerFlower getInstance() {
        if (instance == null) instance = new ControllerFlower();
        return instance;
    }

    private ControllerFlower(){
        reset();
    }

    private void reset() {
        flowerInfo = new FlowerInfo();
    }

    public void update(){
        flowerInfo.update(ControllerStars.getInstance().getStarsLightPower());
    }

    boolean isDie() {
        return flowerInfo.idDie();
    }
}
