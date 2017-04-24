package org.byters.ld38game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.byters.ld38game.controller.ControllerGameFlow;
import org.byters.ld38game.controller.ControllerTowers;


class ViewTower {
    private static final String TEXTURE_TOWER_MAIN = "textures/tower_main.png";
    private static final String TEXTURE_TOWER = "textures/tower.png";
    private Texture tTowerMain, tTower;

    void draw(SpriteBatch batch) {
        batch.draw(tTower, ControllerTowers.getInstance().getPosition(0), tTower.getHeight() * ControllerGameFlow.getInstance().getScale() / 12f
                , tTower.getWidth() * ControllerGameFlow.getInstance().getScale(), tTower.getHeight() * ControllerGameFlow.getInstance().getScale());

        batch.draw(tTowerMain, ControllerTowers.getInstance().getPosition(1), tTowerMain.getHeight() * ControllerGameFlow.getInstance().getScale() / 12f
                , tTowerMain.getWidth() * ControllerGameFlow.getInstance().getScale(), tTowerMain.getHeight() * ControllerGameFlow.getInstance().getScale());

        batch.draw(tTower, ControllerTowers.getInstance().getPosition(2), tTower.getHeight() * ControllerGameFlow.getInstance().getScale() / 12f
                , tTower.getWidth() * ControllerGameFlow.getInstance().getScale(), tTower.getHeight() * ControllerGameFlow.getInstance().getScale());
    }

    void load() {
        tTowerMain = new Texture(Gdx.files.internal(TEXTURE_TOWER_MAIN));
        tTower = new Texture(Gdx.files.internal(TEXTURE_TOWER));

        ControllerTowers.getInstance().setBounds(-Gdx.graphics.getWidth() / 2, Gdx.graphics.getWidth() + Gdx.graphics.getWidth() / 2);
        ControllerTowers.getInstance().setPositions(0, Gdx.graphics.getWidth() * 2 / 3f, Gdx.graphics.getWidth() * 4 / 3f + 32);
    }

    void dispose() {
        tTowerMain.dispose();
        tTower.dispose();
    }

}
