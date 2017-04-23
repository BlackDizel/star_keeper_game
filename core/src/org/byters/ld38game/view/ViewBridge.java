package org.byters.ld38game.view;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import org.byters.ld38game.controller.ControllerBridge;
import org.byters.ld38game.controller.ControllerGameFlow;
import org.byters.ld38game.controller.ControllerPlayer;

class ViewBridge {

    private static final String TEXTURE_BRIDGE_BACK = "textures/bridge_back.png";
    private static final String TEXTURE_BRIDGE_FRONT = "textures/bridge_front.png";
    private static final float PARALLAX_FACTOR = 0.8f;
    private TextureRegion tBridgeBack, tBridgeFront;
    private float drawNums;

    void load() {
        tBridgeBack = new TextureRegion(new Texture(Gdx.files.internal(TEXTURE_BRIDGE_BACK)));
        tBridgeBack.getTexture().setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);


        tBridgeFront = new TextureRegion(new Texture(Gdx.files.internal(TEXTURE_BRIDGE_FRONT)));
        tBridgeFront.getTexture().setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);

        ControllerBridge.getInstance().setWidth(tBridgeBack.getTexture().getWidth());

        drawNums = Gdx.graphics.getWidth() / tBridgeFront.getRegionWidth() / ControllerGameFlow.getInstance().getScale() + 1;
    }

    void update() {
        if (ControllerPlayer.getInstance().isBounded()) {
            float deltaX = ControllerPlayer.getInstance().getDelta();
            tBridgeBack.scroll(deltaX / getTextureWidth() * PARALLAX_FACTOR, 0);
            tBridgeFront.scroll(deltaX / getTextureWidth(), 0);
        }
    }

    void drawBack(SpriteBatch batch) {
        draw(batch, tBridgeBack);
    }

    void drawFront(SpriteBatch batch) {
        draw(batch, tBridgeFront);
    }

    private void draw(SpriteBatch batch, TextureRegion texture) {
        for (int i = 0; i < drawNums; ++i) //todo simplify
            batch.draw(texture, getTextureWidth() * i, getPositionY(),
                    getTextureWidth(), texture.getTexture().getHeight() * ControllerGameFlow.getInstance().getScale());
    }

    private float getTextureWidth() {
        return tBridgeBack.getTexture().getWidth() * ControllerGameFlow.getInstance().getScale();
    }

    private float getPositionY() {
        return ControllerBridge.getInstance().getPositionY() - tBridgeBack.getTexture().getHeight() / 4 * ControllerGameFlow.getInstance().getScale();
    }

    void dispose() {
        tBridgeBack.getTexture().dispose();
        tBridgeFront.getTexture().dispose();
    }
}
