package org.byters.ld38game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.byters.ld38game.controller.ControllerGameFlow;


class ViewBackground {
    private static final String TEXTURE_BACKGROUND = "textures/back.png";
    private Texture tBackground;

    void draw(SpriteBatch batch) {
        batch.draw(tBackground, 0, Gdx.graphics.getHeight() - tBackground.getHeight() * ControllerGameFlow.getInstance().getScale()
                , tBackground.getWidth() * ControllerGameFlow.getInstance().getScale(), tBackground.getHeight() * ControllerGameFlow.getInstance().getScale());
    }

    void load() {
        tBackground = new Texture(Gdx.files.internal(TEXTURE_BACKGROUND));
    }

    void dispose() {
        tBackground.dispose();
    }
}
