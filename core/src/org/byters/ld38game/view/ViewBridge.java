package org.byters.ld38game.view;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import org.byters.ld38game.controller.ControllerBridge;
import org.byters.ld38game.controller.ControllerGameFlow;

class ViewBridge {

    private static final String TEXTURE_BRIDGE_BACK = "textures/bridge_back.png";
    private static final String TEXTURE_BRIDGE_FRONT = "textures/bridge_front.png";
    private TextureRegion tBridgeBack, tBridgeFront;

    void load() {
        tBridgeBack = new TextureRegion(new Texture(Gdx.files.internal(TEXTURE_BRIDGE_BACK)));
        tBridgeBack.getTexture().setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);


        tBridgeFront = new TextureRegion(new Texture(Gdx.files.internal(TEXTURE_BRIDGE_FRONT)));
        tBridgeFront.getTexture().setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);

        ControllerBridge.getInstance().setWidth((int) (tBridgeBack.getTexture().getWidth() * ControllerGameFlow.getInstance().getScale()));
    }

    void drawBack(SpriteBatch batch) {
        draw(batch, tBridgeBack);
    }

    void drawFront(SpriteBatch batch) {
        draw(batch, tBridgeFront);
    }

    private void draw(SpriteBatch batch, TextureRegion texture) {
        for (int i = 0; i < ControllerBridge.getInstance().getBridgeNums(); ++i)
            batch.draw(texture, ControllerBridge.getInstance().getBridgePositionX(i), ControllerBridge.getInstance().getBridgePositionY(i),
                    getTextureWidth(), texture.getTexture().getHeight() * ControllerGameFlow.getInstance().getScale());
    }

    private float getTextureWidth() {
        return tBridgeBack.getTexture().getWidth() * ControllerGameFlow.getInstance().getScale();
    }

    void dispose() {
        tBridgeBack.getTexture().dispose();
        tBridgeFront.getTexture().dispose();
    }
}
