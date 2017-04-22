package org.byters.ld38game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.byters.ld38game.controller.ControllerEnemies;
import org.byters.ld38game.model.EnemyInfo;


class ViewEnemies {
    private static final String TEXTURE_ENEMY = "textures/enemy.png";
    private Texture tEnemy;

    void draw(SpriteBatch batch) {
        for (int i = 0; i < ControllerEnemies.getInstance().getEnemiesNum(); ++i)
            batch.draw(tEnemy, ControllerEnemies.getInstance().getPositionX(i), ControllerEnemies.getInstance().getPositionY(i));
    }

    void load() {
        tEnemy = new Texture(Gdx.files.internal(TEXTURE_ENEMY));
        EnemyInfo.setOrigin(tEnemy.getWidth()/2,tEnemy.getHeight()/2);
    }

    void dispose() {
        tEnemy.dispose();
    }
}
