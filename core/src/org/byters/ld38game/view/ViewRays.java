package org.byters.ld38game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import org.byters.ld38game.controller.ControllerRays;


class ViewRays {
    private static final String TEXTURE_RAY = "textures/ray.png";
    private TextureRegion tRay;

    void draw(SpriteBatch batch) {
        for (int i = 0; i < ControllerRays.getInstance().getRaysNum(); ++i) {
            batch.setColor(1, 1, 1, ControllerRays.getInstance().getAlphaRay(i));
            batch.draw(tRay,
                    ControllerRays.getInstance().getPositionRayX(i), ControllerRays.getInstance().getPositionRayY(i),
                    0, tRay.getTexture().getHeight() / 2,
                    getRayLength(), tRay.getTexture().getHeight(),
                    1, 1,
                    ControllerRays.getInstance().getRotationRay(i)
            );
        }
        batch.setColor(1, 1, 1, 1);
    }

    private float getRayLength() {
        return (int) (Math.pow(Gdx.graphics.getWidth(), 2) + Math.pow(Gdx.graphics.getHeight(), 2));
    }

    void load() {
        tRay = new TextureRegion(new Texture(Gdx.files.internal(TEXTURE_RAY)));
        tRay.getTexture().setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
    }

    void dispose() {
        tRay.getTexture().dispose();
    }
}
