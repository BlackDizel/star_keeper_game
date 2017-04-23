package org.byters.ld38game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.byters.ld38game.controller.ControllerGameFlow;
import org.byters.ld38game.controller.ControllerStars;
import org.byters.ld38game.model.StarInfo;


class ViewStars {
    private static final String TEXTURE_STAR = "textures/star5.png";
    private static final String TEXTURE_ROPE = "textures/for_star.png";

    private Texture tStar;
    private Texture tRope;
    private int drawRopesNum;

    void draw(SpriteBatch batch) {
        for (int i = 0; i < ControllerStars.getInstance().getStarsNum(); ++i) {

            for (int r = 0; r < drawRopesNum; ++r)
                batch.draw(tRope,
                        getRopePositionX(i), getRopePositionY(i) + r * tRope.getHeight() * ControllerGameFlow.getInstance().getScale(),
                        tRope.getWidth() * ControllerGameFlow.getInstance().getScale(), tRope.getHeight() * ControllerGameFlow.getInstance().getScale());

            batch.draw(tStar,
                    ControllerStars.getInstance().getPositionStarX(i), ControllerStars.getInstance().getPositionStarY(i),
                    tStar.getWidth() * ControllerGameFlow.getInstance().getScale(), tStar.getHeight() * ControllerGameFlow.getInstance().getScale());
        }
    }

    private float getRopePositionY(int i) {
        return ControllerStars.getInstance().getPositionStarY(i) + ControllerStars.getInstance().getStarOriginY(i) * ControllerGameFlow.getInstance().getScale();
    }

    private float getRopePositionX(int i) {
        return ControllerStars.getInstance().getPositionStarX(i) + (ControllerStars.getInstance().getStarOriginX(i) - tRope.getWidth() / 2f) * ControllerGameFlow.getInstance().getScale();
    }

    void load() {
        tStar = new Texture(Gdx.files.internal(TEXTURE_STAR));
        StarInfo.setOrigin(tStar.getWidth() / 2, tStar.getHeight() / 2);

        tRope = new Texture(Gdx.files.internal(TEXTURE_ROPE));
        tRope.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);

        drawRopesNum = Gdx.graphics.getHeight() / tRope.getHeight() + 1;
    }

    void dispose() {
        tStar.dispose();
        tRope.dispose();
    }
}
