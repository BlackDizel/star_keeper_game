package org.byters.ld38game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.byters.engine.view.IScreen;
import org.byters.ld38game.controller.ControllerGameFlow;

public class ScreenMenu implements IScreen {

    private static final String TEXURE_LOGO = "textures/logo.png";
    private ViewMenuBackground viewBackground;
    private Texture tLogo;
    private ViewMenuButtons viewButtons;

    @Override
    public void draw(SpriteBatch batch) {
        viewBackground.draw(batch);
        batch.draw(tLogo,
                Gdx.graphics.getWidth() / 2 - tLogo.getWidth() * ControllerGameFlow.getInstance().getScale() / 2
                , Gdx.graphics.getHeight() - tLogo.getHeight() * ControllerGameFlow.getInstance().getScale()
                , tLogo.getWidth() * ControllerGameFlow.getInstance().getScale(), tLogo.getHeight() * ControllerGameFlow.getInstance().getScale());

        viewButtons.draw(batch);
    }

    @Override
    public void load(SpriteBatch batch) {
        viewBackground = new ViewMenuBackground();
        viewBackground.load();

        viewButtons = new ViewMenuButtons();
        viewButtons.load();
        tLogo = new Texture(Gdx.files.internal(TEXURE_LOGO));
    }

    @Override
    public void update() {
        viewBackground.update();
    }

    @Override
    public void input() {
        viewButtons.input();
    }

    @Override
    public void dispose() {
        viewBackground.dispose();
        tLogo.dispose();
        viewButtons.dispose();
    }
}
