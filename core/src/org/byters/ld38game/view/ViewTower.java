package org.byters.ld38game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.byters.ld38game.controller.ControllerGameFlow;
import org.byters.ld38game.controller.ControllerPlayer;


class ViewTower {
    private static final String TEXTURE_TOWER_MAIN = "textures/tower_main.png";
    private static final String TEXTURE_TOWER = "textures/tower.png";
    private Texture tTowerMain, tTower;
    private float posMain, pos1, pos2;

    void draw(SpriteBatch batch) {
        batch.draw(tTowerMain, posMain, tTowerMain.getHeight() * ControllerGameFlow.getInstance().getScale() / 12f
                , tTowerMain.getWidth() * ControllerGameFlow.getInstance().getScale(), tTowerMain.getHeight() * ControllerGameFlow.getInstance().getScale());

        batch.draw(tTower, pos1, tTower.getHeight() * ControllerGameFlow.getInstance().getScale() / 12f
                , tTower.getWidth() * ControllerGameFlow.getInstance().getScale(), tTower.getHeight() * ControllerGameFlow.getInstance().getScale());

        batch.draw(tTower, pos2, tTower.getHeight() * ControllerGameFlow.getInstance().getScale() / 12f
                , tTower.getWidth() * ControllerGameFlow.getInstance().getScale(), tTower.getHeight() * ControllerGameFlow.getInstance().getScale());

    }

    void load() {
        tTowerMain = new Texture(Gdx.files.internal(TEXTURE_TOWER_MAIN));
        tTower = new Texture(Gdx.files.internal(TEXTURE_TOWER));

        posMain = Gdx.graphics.getWidth() / 3f * 2;
        pos1 = Gdx.graphics.getWidth() / 3f * 4;
        pos2 = 0;
    }

    void dispose() {
        tTowerMain.dispose();
        tTower.dispose();
    }

    void update() {
        if (ControllerPlayer.getInstance().isBounded()) {
            float deltaX = ControllerPlayer.getInstance().getDelta();
            posMain -= deltaX;
            pos1 -= deltaX;
            pos2 -= deltaX;

            posMain = checkPos(posMain);
            pos1 = checkPos(pos1);
            pos2 = checkPos(pos2);
        }
    }

    private float checkPos(float pos) {
        if (pos < -Gdx.graphics.getWidth() / 2) return Gdx.graphics.getWidth() + Gdx.graphics.getWidth() / 2;
        if (pos > Gdx.graphics.getWidth() + Gdx.graphics.getWidth() / 2) return -Gdx.graphics.getWidth() / 2;

        return pos;
    }

}
