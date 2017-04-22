package org.byters.ld38game.controller;

import org.byters.engine.controller.ControllerMain;
import org.byters.ld38game.view.ScreenGameOver;

public class ControllerGameFlow {
    private static ControllerGameFlow instance;

    public static ControllerGameFlow getInstance() {
        if (instance == null) instance = new ControllerGameFlow();
        return instance;
    }

    public void update() {

        //todo implement enemies waves

        if (isGameOver()) ControllerMain.getInstance().navigateScreen(new ScreenGameOver());
    }

    private boolean isGameOver() {
        return ControllerFlower.getInstance().isDie();
    }
}
