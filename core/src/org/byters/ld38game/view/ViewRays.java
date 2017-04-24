package org.byters.ld38game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import org.byters.ld38game.controller.ControllerGameFlow;
import org.byters.ld38game.controller.ControllerRays;
import org.byters.ld38game.model.RayInfo;


class ViewRays {
    private static final float START_WIDTH = 0.5f;
    private static final String TEXTURE_RAY2 = "textures/ray2.png";

    private TextureRegion tRay2;
    private float rayLength;

    void draw(SpriteBatch batch) {
        for (int i = 0; i < ControllerRays.getInstance().getRaysNum(); ++i) {
            batch.setColor(1, 1, 1, ControllerRays.getInstance().getAlphaRay(i));
            batch.draw(tRay2,
                    ControllerRays.getInstance().getPositionRayX(i), ControllerRays.getInstance().getPositionRayY(i),
                    tRay2.getTexture().getWidth() / 2, 0,
                    tRay2.getTexture().getWidth(), rayLength,
                    getRayScale(i), 1,
                    ControllerRays.getInstance().getRotationRay(i) - 90
            );
        }
        batch.setColor(1, 1, 1, 1);
    }

    private float getRayScale(int i) {
        return START_WIDTH + (1 - ControllerRays.getInstance().getAlphaRay(i)) * 3;
    }

    private float getRayLength() {
        return (int) (Math.pow(Gdx.graphics.getWidth(), 2) + Math.pow(Gdx.graphics.getHeight(), 2));
    }

    void load() {
        tRay2 = new TextureRegion(new Texture(Gdx.files.internal(TEXTURE_RAY2)));
        tRay2.getTexture().setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
        RayInfo.setAttackDistance(tRay2.getRegionWidth() * ControllerGameFlow.getInstance().getScale() * 2);
        rayLength = getRayLength();
    }

    void dispose() {
        tRay2.getTexture().dispose();
    }
}
