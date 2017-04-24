package org.byters.ld38game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.byters.engine.view.IScreen;
import org.byters.ld38game.controller.ControllerGameFlow;

public class ScreenWin implements IScreen {

    private static final String MESSAGE_WIN = "Your flower is grown";
    private static final String TEXTURE_ROSE = "textures/rose/rose_grown.png";
    private BitmapFont font;
    private GlyphLayout layout;
    private Texture tRose;

    @Override
    public void draw(SpriteBatch batch) {
        font.draw(batch, layout
                , (Gdx.graphics.getWidth() - layout.width) / 2, Gdx.graphics.getHeight() / 4);

        batch.draw(tRose,
                Gdx.graphics.getWidth() / 2 - tRose.getWidth() / 2 * ControllerGameFlow.getInstance().getScale(),
                Gdx.graphics.getHeight() - tRose.getHeight() * ControllerGameFlow.getInstance().getScale() * 1.5f,
                tRose.getWidth() * ControllerGameFlow.getInstance().getScale(),
                tRose.getHeight() * ControllerGameFlow.getInstance().getScale());
    }

    @Override
    public void load(SpriteBatch batch) {
        font = new BitmapFont();

        layout = new GlyphLayout();
        layout.setText(font, MESSAGE_WIN);

        tRose = new Texture(Gdx.files.internal(TEXTURE_ROSE));
    }

    @Override
    public void update() {

    }

    @Override
    public void input() {

    }

    @Override
    public void dispose() {
        font.dispose();
        tRose.dispose();
    }
}
