package org.byters.ld38game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import org.byters.engine.controller.ControllerMain;
import org.byters.ld38game.controller.ControllerEnemies;
import org.byters.ld38game.controller.ControllerGameFlow;
import org.byters.ld38game.model.EnemyInfo;


class ViewEnemies {
    private static final String TEXTURE_ENEMY = "textures/dark.png";
    private static final String TEXTURE_ENEMY_BORN = "textures/dark_here.png";
    private static final String TEXTURE_ENEMY_ATTACK = "textures/dark_act.png";
    private static final String TEXTURE_ENEMY_DIE = "textures/dark_dead.png";

    private Texture tBorn, tAttack, tDie;
    private TextureRegion tEnemy;
    private Animation<TextureRegion> aBorn, aAttack, aDie;

    void draw(SpriteBatch batch) {
        for (int i = 0; i < ControllerEnemies.getInstance().getEnemiesNum(); ++i)
            batch.draw(getCurrentFrame(i), ControllerEnemies.getInstance().getPositionX(i), ControllerEnemies.getInstance().getPositionY(i),
                    tEnemy.getTexture().getWidth() * ControllerGameFlow.getInstance().getScale(), tEnemy.getTexture().getHeight() * ControllerGameFlow.getInstance().getScale());
    }

    private TextureRegion getCurrentFrame(int pos) {

        if (ControllerEnemies.getInstance().isBorn(pos))
            return aBorn.getKeyFrame((System.currentTimeMillis() - ControllerEnemies.getInstance().getLastTimeStateChanged(pos)) / 1000f);

        if (ControllerEnemies.getInstance().isMove(pos))
            return tEnemy;

        if (ControllerEnemies.getInstance().isAttack(pos))
            return aAttack.getKeyFrame(ControllerMain.getInstance().getGameTime() / 1000f);

        if (ControllerEnemies.getInstance().isDie(pos))
            return aDie.getKeyFrame((System.currentTimeMillis() - ControllerEnemies.getInstance().getLastTimeStateChanged(pos)) / 1000f);

        return null;
    }

    void load() {
        tEnemy = new TextureRegion(new Texture(Gdx.files.internal(TEXTURE_ENEMY)));
        EnemyInfo.setOrigin(tEnemy.getTexture().getWidth() * ControllerGameFlow.getInstance().getScale() / 2,
                tEnemy.getTexture().getHeight() * ControllerGameFlow.getInstance().getScale() / 2);

        aBorn = initAnimation(tBorn = new Texture(Gdx.files.internal(TEXTURE_ENEMY_BORN)), 4, 0.2f, Animation.PlayMode.NORMAL);
        aAttack = initAnimation(tAttack = new Texture(Gdx.files.internal(TEXTURE_ENEMY_ATTACK)), 4, 0.2f, Animation.PlayMode.LOOP);
        aDie = initAnimation(tDie = new Texture(Gdx.files.internal(TEXTURE_ENEMY_DIE)), 4, 0.2f, Animation.PlayMode.NORMAL);
    }

    private Animation<TextureRegion> initAnimation(Texture texture, int framesNum, float frameDurationSeconds, Animation.PlayMode mode) {

        int frameWidth = texture.getWidth() / framesNum;
        int frameHeight = texture.getHeight();
        TextureRegion[][] frames = TextureRegion.split(texture, frameWidth, frameHeight);
        TextureRegion[] framesMove = new TextureRegion[framesNum];
        for (int i = 0; i < framesNum; ++i)
            framesMove[i] = frames[0][i];

        Animation<TextureRegion> result = new Animation<TextureRegion>(frameDurationSeconds, framesMove);
        result.setPlayMode(mode);
        return result;
    }

    void dispose() {
        tEnemy.getTexture().dispose();
        tBorn.dispose();
        tAttack.dispose();
        tDie.dispose();
    }
}
