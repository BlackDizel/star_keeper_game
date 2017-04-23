package org.byters.ld38game.view;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.byters.engine.view.IScreen;
import org.byters.ld38game.controller.*;

public class ScreenGame implements IScreen {

    private ViewPlayer viewPlayer;
    private ViewPlanet viewPlanet;
    private ViewBridge viewBridge;
    private ViewStars viewStars;
    private ViewRays viewRays;
    private ViewEnemies viewEnemies;


    //BitmapFont fontDebug;

    @Override
    public void draw(SpriteBatch batch) {

        //todo draw background
        viewPlanet.draw(batch);
        viewStars.draw(batch);
        viewEnemies.draw(batch);

        viewBridge.drawBack(batch);
        viewPlayer.draw(batch);
        viewBridge.drawFront(batch);

        viewRays.draw(batch);

        //fontDebug.draw(batch, "Flower life debug: "+ ControllerFlower.getInstance().getFlowerHealth(), Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/10);
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

        viewEnemies = new ViewEnemies();
        viewEnemies.load();

       // fontDebug = new BitmapFont();
    }

    @Override
    public void update() {
        ControllerPlayer.getInstance().update();
        ControllerPlanet.getInstance().update();
        ControllerBridge.getInstance().update();
        ControllerRays.getInstance().update();
        ControllerEnemies.getInstance().update();
        ControllerFlower.getInstance().update();
        ControllerGameFlow.getInstance().update();

        viewBridge.update();
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
        viewEnemies.dispose();
    }
}
