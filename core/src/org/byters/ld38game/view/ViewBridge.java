package org.byters.ld38game.view;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.byters.ld38game.controller.ControllerBridge;

class ViewBridge {


    private static final String TEXTURE_BRIDGE = "textures/bridge.png";
    private Texture tBridge;

    void load() {
        tBridge = new Texture(Gdx.files.internal(TEXTURE_BRIDGE));
        ControllerBridge.getInstance().setWidth(tBridge.getWidth());
    }

    void draw(SpriteBatch batch) {
        batch.draw(tBridge, ControllerBridge.getInstance().getPositionFirst(), ControllerBridge.getInstance().getPositionY());

        batch.draw(tBridge, ControllerBridge.getInstance().getPositionSecond(), ControllerBridge.getInstance().getPositionY());
    }

    void dispose() {
        tBridge.dispose();
    }
}
