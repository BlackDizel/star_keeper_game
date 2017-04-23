package org.byters.ld38game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.byters.ld38game.controller.ControllerGameFlow;
import org.byters.ld38game.controller.ControllerPlayer;


class ViewTower {
    private static final int DELTA_POSITION = 3;
    private static final String TEXTURE_TOWER = "textures/tower_main.png";
    private Texture tTower;
    private float pos;

    void draw(SpriteBatch batch) {
        batch.draw(tTower, pos, tTower.getHeight() * ControllerGameFlow.getInstance().getScale() / 12f
                , tTower.getWidth() * ControllerGameFlow.getInstance().getScale(), tTower.getHeight() * ControllerGameFlow.getInstance().getScale());
    }

    void load() {
        tTower = new Texture(Gdx.files.internal(TEXTURE_TOWER));

        pos = Gdx.graphics.getWidth() / 3f * 2;
    }

    void dispose() {
        tTower.dispose();
    }

    void update() {
        if (ControllerPlayer.getInstance().isBounded()) {
            float deltaX = ControllerPlayer.getInstance().getDelta();
            pos -= deltaX;

            if (pos < -getDeltaPosition()) pos = Gdx.graphics.getWidth() + getDeltaPosition();
            if (pos > Gdx.graphics.getWidth() + getDeltaPosition()) pos = -getDeltaPosition();
        }
    }

    private int getDeltaPosition() {
        return Gdx.graphics.getWidth() / DELTA_POSITION;
    }
}
