package org.byters.ld38game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.byters.engine.view.IScreen;
import org.byters.ld38game.controller.*;

public class ScreenGame implements IScreen {

    BitmapFont fontDebug;
    private ViewPlayer viewPlayer;
    // private ViewPlanet viewPlanet;
    private ViewBridge viewBridge;
    private ViewStars viewStars;
    private ViewRays viewRays;
    private ViewEnemies viewEnemies;
    private ViewBackground viewBackground;
    private ViewTower viewTower;
    private Music sound;

    @Override
    public void draw(SpriteBatch batch) {

        viewBackground.draw(batch);
        //viewPlanet.draw(batch);
        viewStars.draw(batch);
        viewEnemies.draw(batch);

        viewBridge.drawBack(batch);
        viewPlayer.draw(batch);
        viewBridge.drawFront(batch);

        viewRays.draw(batch);

        viewTower.draw(batch);

        fontDebug.draw(batch, "Flower life debug: " + ControllerFlower.getInstance().getFlowerHealth(), Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 10);
    }

    @Override
    public void load(SpriteBatch batch) {
        viewPlayer = new ViewPlayer();
        viewPlayer.load();

        // viewPlanet = new ViewPlanet();
        //  viewPlanet.load();

        viewBridge = new ViewBridge();
        viewBridge.load();

        viewStars = new ViewStars();
        viewStars.load();

        viewRays = new ViewRays();
        viewRays.load();

        viewEnemies = new ViewEnemies();
        viewEnemies.load();

        viewBackground = new ViewBackground();
        viewBackground.load();

        viewTower = new ViewTower();
        viewTower.load();

        fontDebug = new BitmapFont();

        sound = Gdx.audio.newMusic(Gdx.files.internal("audio/02 I Hope They Dont Attack.mp3"));
        sound.play();
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
        viewTower.update();
    }

    @Override
    public void input() {
        ControllerPlayer.getInstance().input();
        ControllerRays.getInstance().input();
    }

    @Override
    public void dispose() {
        viewPlayer.dispose();
        //viewPlanet.dispose();
        viewBridge.dispose();
        viewStars.dispose();
        viewRays.dispose();
        viewEnemies.dispose();
        viewBackground.dispose();
        sound.dispose();
    }
}
