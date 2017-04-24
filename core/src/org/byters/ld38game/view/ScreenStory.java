package org.byters.ld38game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.byters.engine.controller.ControllerMain;
import org.byters.engine.view.IScreen;
import org.byters.ld38game.controller.ControllerGameFlow;

public class ScreenStory implements IScreen {

    private static final String TEXTURE_STORY = "textures/story.png";
    private Texture tStory;

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(tStory,
                0, Gdx.graphics.getHeight() - tStory.getHeight() * ControllerGameFlow.getInstance().getScale(),
                tStory.getWidth() * ControllerGameFlow.getInstance().getScale(), tStory.getHeight() * ControllerGameFlow.getInstance().getScale());

    }

    @Override
    public void load(SpriteBatch batch) {
        tStory = new Texture(Gdx.files.internal(TEXTURE_STORY));
    }

    @Override
    public void update() {

    }

    @Override
    public void input() {
        if (Gdx.input.justTouched())
            ControllerMain.getInstance().navigateScreen(new ScreenGame());
    }

    @Override
    public void dispose() {
        tStory.dispose();
    }
}
