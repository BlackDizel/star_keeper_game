package org.byters.ld38game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.byters.engine.view.IScreen;

public class ScreenGameOver implements IScreen {

    BitmapFont font;
    GlyphLayout layout;

    @Override
    public void draw(SpriteBatch batch) {
        font.draw(batch, layout
                , (Gdx.graphics.getWidth() - layout.width) / 2, Gdx.graphics.getHeight() / 2);
    }

    @Override
    public void load(SpriteBatch batch) {
        font = new BitmapFont();

        layout = new GlyphLayout();
        layout.setText(font, "Your flower is die, brave hero");
    }

    @Override
    public void update() {

    }

    @Override
    public void input() {

    }

    @Override
    public void dispose() {

    }
}
