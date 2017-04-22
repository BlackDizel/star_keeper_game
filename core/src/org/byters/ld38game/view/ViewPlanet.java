package org.byters.ld38game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import org.byters.ld38game.controller.ControllerPlanet;

class ViewPlanet {

    private static final String TEXTURE_PLANET = "textures/planet.png";
    private TextureRegion tPlanet;

    void load() {
        tPlanet = new TextureRegion(new Texture(Gdx.files.internal(TEXTURE_PLANET)));
    }

    void draw(SpriteBatch batch) {
        batch.draw(tPlanet,
                ControllerPlanet.getInstance().getPositionX(), ControllerPlanet.getInstance().getPositionY(),
                tPlanet.getTexture().getWidth() / 2, tPlanet.getTexture().getHeight() / 2,
                tPlanet.getTexture().getWidth(), tPlanet.getTexture().getHeight(),
                1, 1,
                ControllerPlanet.getInstance().getRotation());
    }

    void dispose() {
        tPlanet.getTexture().dispose();
    }
}
