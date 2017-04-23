package org.byters.ld38game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import org.byters.ld38game.controller.ControllerRays;
import org.byters.ld38game.model.RayInfo;


class ViewRays {
    public static final float START_WIDTH = 0.5f;
    private static final String TEXTURE_RAY = "textures/ray.png";
    private TextureRegion tRay;

    void draw(SpriteBatch batch) {
        for (int i = 0; i < ControllerRays.getInstance().getRaysNum(); ++i) {
            batch.setColor(1, 1, 1, ControllerRays.getInstance().getAlphaRay(i));
            batch.draw(tRay,
                    ControllerRays.getInstance().getPositionRayX(i), ControllerRays.getInstance().getPositionRayY(i),
                    0, tRay.getTexture().getHeight() / 2,
                    getRayLength(), tRay.getTexture().getHeight(),
                    1, getRayScale(i),
                    ControllerRays.getInstance().getRotationRay(i)
            );
        }
        batch.setColor(1, 1, 1, 1);
    }

    private float getRayScale(int i) {
        return START_WIDTH + (1 - ControllerRays.getInstance().getAlphaRay(i)) * 5;
    }

    private float getRayLength() {
        return (int) (Math.pow(Gdx.graphics.getWidth(), 2) + Math.pow(Gdx.graphics.getHeight(), 2));
    }

    void load() {
        tRay = new TextureRegion(new Texture(Gdx.files.internal(TEXTURE_RAY)));
        tRay.getTexture().setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
        RayInfo.setAttackDistance(tRay.getRegionHeight() / 2);
    }

    void dispose() {
        tRay.getTexture().dispose();
    }
}
