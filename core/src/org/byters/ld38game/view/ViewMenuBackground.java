package org.byters.ld38game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import org.byters.ld38game.controller.ControllerGameFlow;

public class ViewMenuBackground {

    private static final String TEXTURE_BACKGROUND = "textures/back.png";
    private TextureRegion tBackground;

    public void draw(SpriteBatch batch) {
        batch.draw(tBackground,
                0, Gdx.graphics.getHeight() - tBackground.getTexture().getHeight() * ControllerGameFlow.getInstance().getScale(),
                tBackground.getTexture().getWidth() * ControllerGameFlow.getInstance().getScale(), tBackground.getTexture().getHeight() * ControllerGameFlow.getInstance().getScale());
    }

    public void load() {
        tBackground = new TextureRegion(new Texture(Gdx.files.internal(TEXTURE_BACKGROUND)));
        tBackground.getTexture().setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
    }

    public void update() {
        tBackground.scroll(tBackground.getTexture().getWidth() / 200000f, 0);
    }

    public void dispose() {
        tBackground.getTexture().dispose();
    }
}
