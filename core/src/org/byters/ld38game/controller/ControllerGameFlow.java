package org.byters.ld38game.controller;

import org.byters.engine.controller.ControllerMain;
import org.byters.ld38game.view.ScreenGameOver;
import org.byters.ld38game.view.ScreenWin;

public class ControllerGameFlow {
    private static ControllerGameFlow instance;

    public static ControllerGameFlow getInstance() {
        if (instance == null) instance = new ControllerGameFlow();
        return instance;
    }

    public void update() {

        //todo implement enemies waves

        if (isWin()) ControllerMain.getInstance().navigateScreen(new ScreenWin());
        if (isGameOver()) ControllerMain.getInstance().navigateScreen(new ScreenGameOver());
    }

    private boolean isGameOver() {
        return ControllerFlower.getInstance().isDie();
    }

    private boolean isWin() {
        return ControllerFlower.getInstance().isGrown();
    }

    public float getScale() {
        return 2;
    }
}
