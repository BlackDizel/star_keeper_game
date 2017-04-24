package org.byters.ld38game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.byters.ld38game.controller.ControllerFlower;
import org.byters.ld38game.controller.ControllerGameFlow;

class ViewIndicator {
    private static final float INDICATOR_NONE = -3f;
    private static final float INDICATOR_MAX_SIZE = 2f;
    private static final String TEXTURE_GROW_GOOD = "textures/grow_good.png";
    private static final String TEXTURE_GROW_BAD = "textures/grow_bad.png";
    private static final float INDICATOR_SPEED = 2f;
    private Texture tGrowGood, tGrowBad;
    private float scaleIndicator;

    ViewIndicator() {
        scaleIndicator = 0;
    }

    public void draw(SpriteBatch batch) {
        if (scaleIndicator <= 0) return;

        batch.setColor(1, 1, 1, Math.max(INDICATOR_MAX_SIZE - scaleIndicator, 0));

        Texture texture = getCurrentIndicator();
        float width = texture.getWidth() * ControllerGameFlow.getInstance().getScale() * scaleIndicator;
        float height = texture.getHeight() * ControllerGameFlow.getInstance().getScale() * scaleIndicator;

        batch.draw(texture, texture.getWidth() * ControllerGameFlow.getInstance().getScale() / 2f - width / 2f,
                texture.getHeight() * ControllerGameFlow.getInstance().getScale() / 2f - height / 2f,
                width, height);

        batch.setColor(1, 1, 1, 1);

    }

    private Texture getCurrentIndicator() {
        return ControllerFlower.getInstance().isGrow() ? tGrowGood : tGrowBad;
    }

    public void load() {

        tGrowGood = new Texture(Gdx.files.internal(TEXTURE_GROW_GOOD));
        tGrowBad = new Texture(Gdx.files.internal(TEXTURE_GROW_BAD));
    }

    public void dispose() {

        tGrowGood.dispose();
        tGrowBad.dispose();
    }

    public void update() {
        if (scaleIndicator >= INDICATOR_MAX_SIZE)
            scaleIndicator = INDICATOR_NONE;
        scaleIndicator += Gdx.graphics.getDeltaTime() * INDICATOR_SPEED;
    }
}
