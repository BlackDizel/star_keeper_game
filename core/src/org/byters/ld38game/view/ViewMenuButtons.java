package org.byters.ld38game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.byters.engine.controller.ControllerMain;
import org.byters.ld38game.controller.ControllerGameFlow;

public class ViewMenuButtons {
    private static final String TEXTUE_BUTTON_START = "textures/start.png";
    private static final String TEXTUE_BUTTON_EXIT = "textures/exit.png";

    private Texture tButtonStart, tButtonExit;
    private float buttonStartX, buttonStartY, buttonExitX, buttonExitY;

    public void load() {
        tButtonStart = new Texture(Gdx.files.internal(TEXTUE_BUTTON_START));
        tButtonExit = new Texture(Gdx.files.internal(TEXTUE_BUTTON_EXIT));

        buttonExitX = Gdx.graphics.getWidth() / 2 - tButtonExit.getWidth() * ControllerGameFlow.getInstance().getScale() / 2;
        buttonExitY = tButtonExit.getHeight() * ControllerGameFlow.getInstance().getScale() * 0.5f;

        buttonStartX = Gdx.graphics.getWidth() / 2 - tButtonStart.getWidth() * ControllerGameFlow.getInstance().getScale() / 2;
        buttonStartY = tButtonExit.getHeight() * ControllerGameFlow.getInstance().getScale() * 1.5f
                + tButtonStart.getHeight() * ControllerGameFlow.getInstance().getScale() * 0.5f;
    }

    void input() {
        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            if (isContainsMouse(tButtonStart, buttonStartX, buttonStartY))
                ControllerMain.getInstance().navigateScreen(new ScreenGame());
            else if (isContainsMouse(tButtonExit, buttonExitX, buttonExitY))
                Gdx.app.exit();
        }
    }

    private boolean isContainsMouse(Texture texture, float x, float y) {
        return x < Gdx.input.getX()
                && Gdx.input.getX() < x + texture.getWidth() * ControllerGameFlow.getInstance().getScale()
                && y < (Gdx.graphics.getHeight() - Gdx.input.getY())
                && (Gdx.graphics.getHeight() - Gdx.input.getY()) < y + texture.getHeight() * ControllerGameFlow.getInstance().getScale();
    }

    public void dispose() {
        tButtonStart.dispose();
        tButtonExit.dispose();
    }

    public void draw(SpriteBatch batch) {
        batch.draw(tButtonStart,
                buttonStartX, buttonStartY,
                tButtonStart.getWidth() * ControllerGameFlow.getInstance().getScale(), tButtonStart.getHeight() * ControllerGameFlow.getInstance().getScale());

        batch.draw(tButtonExit,
                buttonExitX, buttonExitY,
                tButtonExit.getWidth() * ControllerGameFlow.getInstance().getScale(), tButtonExit.getHeight() * ControllerGameFlow.getInstance().getScale());
    }
}
