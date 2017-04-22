package org.byters.ld38game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.byters.ld38game.controller.ControllerStars;


class ViewStars {
    private static final String TEXTURE_STAR = "textures/star.png";
    private Texture tStar;

    void draw(SpriteBatch batch) {
        for (int i = 0; i < ControllerStars.getInstance().getStarsNum(); ++i)
            batch.draw(tStar, ControllerStars.getInstance().getPositionStarX(i), ControllerStars.getInstance().getPositionStarY(i));
    }

    void load() {
        tStar = new Texture(Gdx.files.internal(TEXTURE_STAR));
    }

    void dispose() {
        tStar.dispose();
    }
}
