package org.byters.ld38game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import org.byters.ld38game.controller.ControllerGameFlow;
import org.byters.ld38game.controller.ControllerPlayer;


class ViewBackground {
    private static final String TEXTURE_BACKGROUND = "textures/back.png";
    private TextureRegion tBackground;

    void draw(SpriteBatch batch) {
        batch.draw(tBackground, 0, Gdx.graphics.getHeight() - tBackground.getTexture().getHeight() * ControllerGameFlow.getInstance().getScale()
                , tBackground.getTexture().getWidth() * ControllerGameFlow.getInstance().getScale(), tBackground.getTexture().getHeight() * ControllerGameFlow.getInstance().getScale());
    }

    void load() {
        tBackground = new TextureRegion(new Texture(Gdx.files.internal(TEXTURE_BACKGROUND)));
        tBackground.getTexture().setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
    }

    public void update() {
        if (ControllerPlayer.getInstance().isBounded())
            tBackground.scroll(tBackground.getTexture().getWidth() / 800000f * ControllerPlayer.getInstance().getDelta(), 0);
    }


    void dispose() {
        tBackground.getTexture().dispose();
    }
}
