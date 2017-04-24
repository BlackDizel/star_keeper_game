package org.byters.ld38game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import org.byters.engine.controller.ControllerMain;
import org.byters.ld38game.controller.ControllerGameFlow;
import org.byters.ld38game.controller.ControllerPlayer;

class ViewPlayer {

    private static final float FRAME_DURATION_SECONDS = 0.2f;
    private static final int FRAMES_NUM_MOVE = 4;

    private static final String TEXTURE_PLAYER = "textures/spr_starkeep.png";
    private Texture tPlayer;

    private Animation<TextureRegion> aPlayer;

    void load() {
        tPlayer = new Texture(Gdx.files.internal(TEXTURE_PLAYER));

        int frameWidth = tPlayer.getWidth() / FRAMES_NUM_MOVE;
        int frameHeight = tPlayer.getHeight();
        TextureRegion[][] frames = TextureRegion.split(tPlayer, frameWidth, frameHeight);
        TextureRegion[] framesMove = new TextureRegion[FRAMES_NUM_MOVE];
        for (int i = 0; i < FRAMES_NUM_MOVE; ++i)
            framesMove[i] = frames[0][i];

        aPlayer = new Animation<TextureRegion>(FRAME_DURATION_SECONDS, framesMove);
        aPlayer.setPlayMode(Animation.PlayMode.LOOP);

        ControllerPlayer.setOrigin(aPlayer.getKeyFrame(0).getRegionWidth() / 2 * ControllerGameFlow.getInstance().getScale()
                , aPlayer.getKeyFrame(0).getRegionHeight() / 2 * ControllerGameFlow.getInstance().getScale());
    }

    void draw(SpriteBatch batch) {
        TextureRegion texture = getCurrentFrame();
        batch.draw(texture,
                ControllerPlayer.getInstance().getPositionX(), ControllerPlayer.getInstance().getPositionY()
                , 0, 0,
                texture.getRegionWidth(), texture.getRegionHeight()
                , ControllerGameFlow.getInstance().getScale(), ControllerGameFlow.getInstance().getScale(),
                0
        );
    }


    private void checkFlip(TextureRegion textureRegion) {
        if (!ControllerPlayer.getInstance().isPlayerDirectionRight() && !textureRegion.isFlipX()
                || ControllerPlayer.getInstance().isPlayerDirectionRight() && textureRegion.isFlipX())
            textureRegion.flip(true, false);
    }

    private TextureRegion getCurrentFrame() {
        TextureRegion result;
        if (ControllerPlayer.getInstance().getMoveDirection() == ControllerPlayer.DIRECTION_NONE)
            result = aPlayer.getKeyFrame(0);
        else result = aPlayer.getKeyFrame(ControllerMain.getInstance().getGameTime() / 1000f);
        checkFlip(result);
        return result;
    }

    void dispose() {
        tPlayer.dispose();
    }
}
