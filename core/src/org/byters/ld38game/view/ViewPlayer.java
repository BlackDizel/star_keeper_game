package org.byters.ld38game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import org.byters.ld38game.controller.ControllerPlayer;

class ViewPlayer {

    private static final String TEXTURE_PLAYER = "textures/player.png";
    private Texture tPlayer;

    void load() {
        tPlayer = new Texture(Gdx.files.internal(TEXTURE_PLAYER));
    }

    void draw(SpriteBatch batch) {
        batch.draw(tPlayer, ControllerPlayer.getInstance().getPositionX(), ControllerPlayer.getInstance().getPositionY());
    }

    void dispose() {
        tPlayer.dispose();
    }
}
