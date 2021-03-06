package org.byters.ld38game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.byters.engine.view.IScreen;
import org.byters.ld38game.controller.ControllerGameFlow;

public class ScreenGameOver implements IScreen {

    private static final String TEXT_GAMEOVER = "Your flower is dead, brave hero";
    private static final String FILE_SONG = "audio/lose.mp3";
    private static final String TEXTURE_ROSE = "textures/rose/rose_dead.png";
    private BitmapFont font;
    private GlyphLayout layout;
    private Music sound;
    private Texture tRose;

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(tRose
                , Gdx.graphics.getWidth() / 2 - tRose.getWidth() / 2 * ControllerGameFlow.getInstance().getScale()
                , Gdx.graphics.getHeight() - tRose.getHeight() * ControllerGameFlow.getInstance().getScale() * 2
                , tRose.getWidth() * ControllerGameFlow.getInstance().getScale()
                , tRose.getHeight() * ControllerGameFlow.getInstance().getScale());

        font.draw(batch, layout
                , (Gdx.graphics.getWidth() - layout.width) / 2, Gdx.graphics.getHeight() / 2);
    }

    @Override
    public void load(SpriteBatch batch) {
        font = new BitmapFont();

        layout = new GlyphLayout();
        layout.setText(font, TEXT_GAMEOVER);

        tRose = new Texture(Gdx.files.internal(TEXTURE_ROSE));

        sound = Gdx.audio.newMusic(Gdx.files.internal(FILE_SONG));
        sound.play();
    }

    @Override
    public void update() {

    }

    @Override
    public void input() {

    }

    @Override
    public void dispose() {
        sound.dispose();
        font.dispose();
        tRose.dispose();
    }
}
