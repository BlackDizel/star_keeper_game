package org.byters.ld38game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.byters.ld38game.controller.ControllerFlower;
import org.byters.ld38game.controller.ControllerGameFlow;

class ViewRose {

    private static final String TEXTURE_ROSE_1 = "textures/rose/rose1.png";
    private static final String TEXTURE_ROSE_2 = "textures/rose/rose2.png";
    private static final String TEXTURE_ROSE_3 = "textures/rose/rose3.png";
    private Texture tRose1, tRose2, tRose3;

    public void draw(SpriteBatch batch) {
        Texture texture = getCurrentStateTexture();
        batch.draw(getCurrentStateTexture()
                , texture.getWidth() * ControllerGameFlow.getInstance().getScale() / 4
                , texture.getHeight() * ControllerGameFlow.getInstance().getScale() / 4
                , texture.getWidth() * ControllerGameFlow.getInstance().getScale()
                , texture.getHeight() * ControllerGameFlow.getInstance().getScale());
    }

    private Texture getCurrentStateTexture() {
        int state = ControllerFlower.getInstance().getState();
        return state == 0 ? tRose1
                : state == 1 ? tRose2
                : tRose3;
    }

    public void load() {
        tRose1 = new Texture(Gdx.files.internal(TEXTURE_ROSE_1));
        tRose2 = new Texture(Gdx.files.internal(TEXTURE_ROSE_2));
        tRose3 = new Texture(Gdx.files.internal(TEXTURE_ROSE_3));
    }

    public void dispose() {
        tRose1.dispose();
        tRose2.dispose();
        tRose3.dispose();
    }
}
