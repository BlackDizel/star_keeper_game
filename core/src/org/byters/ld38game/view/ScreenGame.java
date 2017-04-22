package org.byters.ld38game.view;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.byters.engine.view.IScreen;
import org.byters.ld38game.controller.ControllerBridge;
import org.byters.ld38game.controller.ControllerPlanet;
import org.byters.ld38game.controller.ControllerPlayer;
import org.byters.ld38game.controller.ControllerRays;

public class ScreenGame implements IScreen {

    private ViewPlayer viewPlayer;
    private ViewPlanet viewPlanet;
    private ViewBridge viewBridge;
    private ViewStars viewStars;
    private ViewRays viewRays;

    @Override
    public void draw(SpriteBatch batch) {

        //todo draw background
        viewPlanet.draw(batch);
        viewBridge.draw(batch);
        viewStars.draw(batch);
        //todo draw enemies
        viewRays.draw(batch);
        viewPlayer.draw(batch);

    }

    @Override
    public void load(SpriteBatch batch) {
        viewPlayer = new ViewPlayer();
        viewPlayer.load();

        viewPlanet = new ViewPlanet();
        viewPlanet.load();

        viewBridge = new ViewBridge();
        viewBridge.load();

        viewStars = new ViewStars();
        viewStars.load();

        viewRays = new ViewRays();
        viewRays.load();
    }

    @Override
    public void update() {
        ControllerPlayer.getInstance().update();
        ControllerPlanet.getInstance().update();
        ControllerBridge.getInstance().update();
        ControllerRays.getInstance().update();
    }

    @Override
    public void input() {
        ControllerPlayer.getInstance().input();
        ControllerRays.getInstance().input();
    }

    @Override
    public void dispose() {
        viewPlayer.dispose();
        viewPlanet.dispose();
        viewBridge.dispose();
        viewStars.dispose();
        viewRays.dispose();
    }
}
