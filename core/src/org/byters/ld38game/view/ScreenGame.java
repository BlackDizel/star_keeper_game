package org.byters.ld38game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.byters.engine.view.IScreen;
import org.byters.ld38game.controller.*;
import org.byters.ld38game.controller.listeners.ListenerEnemy;

public class ScreenGame implements IScreen, ListenerEnemy {

    private static final String FILE_SONG = "audio/02 I Hope They Dont Attack.mp3";
    private static final String FILE_ENEMY_BORN = "audio/spawn04.mp3";
    private static final String FILE_ENEMY_DIE = "audio/death01.mp3";

    private ViewPlayer viewPlayer;
    private ViewPlanet viewPlanet;
    private ViewBridge viewBridge;
    private ViewStars viewStars;
    private ViewRays viewRays;
    private ViewEnemies viewEnemies;
    private ViewBackground viewBackground;
    private ViewTower viewTower;
    private ViewRose viewRose;

    private Music sound;
    private Sound soundEnemyBorn, soundEnemyDie;

    @Override
    public void draw(SpriteBatch batch) {

        viewBackground.draw(batch);
        viewPlanet.draw(batch);
        viewStars.draw(batch);
        viewEnemies.draw(batch);

        viewBridge.drawBack(batch);
        viewPlayer.draw(batch);
        viewBridge.drawFront(batch);

        viewRays.draw(batch);

        viewTower.draw(batch);

        viewRose.draw(batch);
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

        viewBackground = new ViewBackground();
        viewBackground.load();

        viewTower = new ViewTower();
        viewTower.load();

        viewRose = new ViewRose();
        viewRose.load();

        sound = Gdx.audio.newMusic(Gdx.files.internal(FILE_SONG));
        sound.play();

        soundEnemyBorn = Gdx.audio.newSound(Gdx.files.internal(FILE_ENEMY_BORN));
        soundEnemyDie = Gdx.audio.newSound(Gdx.files.internal(FILE_ENEMY_DIE));

        ControllerEnemies.getInstance().setListener(this);
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
        ControllerTowers.getInstance().update();

        viewPlanet.update();
        viewBackground.update();
        viewRose.update();
    }

    @Override
    public void input() {
        ControllerPlayer.getInstance().input();
        if (ControllerRays.getInstance().input())
            viewRays.playSound();
    }

    @Override
    public void dispose() {
        viewPlayer.dispose();
        viewPlanet.dispose();
        viewBridge.dispose();
        viewStars.dispose();
        viewRays.dispose();
        viewEnemies.dispose();
        viewBackground.dispose();
        viewRose.dispose();
        sound.dispose();

        ControllerEnemies.getInstance().removeListener();
    }

    @Override
    public void onBorn() {
        soundEnemyBorn.play();
    }

    @Override
    public void onDie() {
        soundEnemyDie.play();
    }
}
