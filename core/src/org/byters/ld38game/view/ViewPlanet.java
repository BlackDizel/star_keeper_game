package org.byters.ld38game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import org.byters.ld38game.controller.ControllerGameFlow;
import org.byters.ld38game.controller.ControllerPlayer;

class ViewPlanet {

    private static final int TEXTURE_FILL_LINES = 3;
    private static final float PARALLAX_FACTOR = 0.8f;
    private static final String TEXTURE_PLANET_FILL = "textures/planet_fill.png";
    private static final String TEXTURE_PLANET_SURFACE = "textures/planet_surface.png";
    private TextureRegion tPlanetFill, tPlanetSurface;
    private int drawNums;

    void load() {
        tPlanetFill = new TextureRegion(new Texture(Gdx.files.internal(TEXTURE_PLANET_FILL)));
        tPlanetFill.getTexture().setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);

        tPlanetSurface = new TextureRegion(new Texture(Gdx.files.internal(TEXTURE_PLANET_SURFACE)));
        tPlanetSurface.getTexture().setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);

        drawNums = Gdx.graphics.getWidth() / tPlanetFill.getRegionWidth() / (int) ControllerGameFlow.getInstance().getScale() + 2;
    }

    void draw(SpriteBatch batch) {
        for (int i = 0; i < TEXTURE_FILL_LINES; ++i)
            draw(batch, tPlanetFill, -i * getTextureWidth() / 2, i * getTextureHeight());

        draw(batch, tPlanetSurface, 0, getTextureHeight() * TEXTURE_FILL_LINES);
    }

    private float getTextureHeight() {
        return tPlanetFill.getTexture().getHeight() * ControllerGameFlow.getInstance().getScale();
    }

    private void draw(SpriteBatch batch, TextureRegion texture, float positionX, float positionY) {
        for (int i = 0; i < drawNums; ++i) //todo simplify
            batch.draw(texture, getTextureWidth() * i + positionX, positionY,
                    getTextureWidth(), getTextureHeight());
    }

    private float getTextureWidth() {
        return tPlanetFill.getRegionWidth() * ControllerGameFlow.getInstance().getScale();
    }

    void update() {
        if (ControllerPlayer.getInstance().isBounded()) {
            float deltaX = ControllerPlayer.getInstance().getDelta();
            tPlanetFill.scroll(deltaX / getTextureWidth(), 0);
            tPlanetSurface.scroll(deltaX / getTextureWidth() * PARALLAX_FACTOR, 0);
        }
    }

    void dispose() {
        tPlanetFill.getTexture().dispose();
        tPlanetSurface.getTexture().dispose();
    }
}
