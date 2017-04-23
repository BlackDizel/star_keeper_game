package org.byters.ld38game.controller;


import com.badlogic.gdx.Gdx;
import org.byters.engine.controller.ControllerMain;
import org.byters.ld38game.model.EnemyInfo;
import org.byters.ld38game.model.StarInfo;

import java.util.ArrayList;
import java.util.Iterator;

public class ControllerEnemies {
    private static final int MAX_ENEMY_NUM = 20;
    private static ControllerEnemies instance;

    private ArrayList<EnemyInfo> lEnemies;
    private long lastTimeCreateMillis;
    private long timeCreateDelayMillis;

    private ControllerEnemies() {
        generateNewDelay();
    }

    public static ControllerEnemies getInstance() {
        if (instance == null) instance = new ControllerEnemies();
        return instance;
    }

    public int getEnemiesNum() {
        return lEnemies == null ? 0 : lEnemies.size();
    }

    public float getPositionX(int i) {
        EnemyInfo item = getEnemyInfo(i);
        return item == null ? 0 : item.getPositionX();
    }

    public float getPositionY(int i) {
        EnemyInfo item = getEnemyInfo(i);
        return item == null ? 0 : item.getPositionY();
    }

    private EnemyInfo getEnemyInfo(int i) {
        return lEnemies == null || i < 0 || i >= lEnemies.size() ? null : lEnemies.get(i);
    }

    public void update() {
        checkNewEnemy();

        if (lEnemies == null) return;

        Iterator<EnemyInfo> iterator = lEnemies.iterator();
        while (iterator.hasNext()) {
            EnemyInfo item = iterator.next();

            if (item.isNoDirection()) {
                StarInfo nearestStar = ControllerStars.getInstance().getNearestStar(item.getPositionCenterX(), item.getPositionCenterY());
                if (nearestStar != null)
                    item.setFinalPosition(nearestStar.getPositionX(), nearestStar.getPositionY());
            }

            if (ControllerRays.getInstance().isAttacking(item.getPositionCenterX(), item.getPositionCenterY()))
                item.kick();

            if (item.isToRemove())
                iterator.remove();

            item.update();
        }
    }

    private void checkNewEnemy() {
        if (lastTimeCreateMillis + timeCreateDelayMillis > System.currentTimeMillis()
                || lEnemies != null && lEnemies.size() > MAX_ENEMY_NUM) return;
        if (lEnemies == null) lEnemies = new ArrayList<EnemyInfo>();
        lEnemies.add(new EnemyInfo(ControllerMain.getInstance().getRandom().nextFloat() * Gdx.graphics.getWidth(),
                ControllerMain.getInstance().getRandom().nextFloat() * Gdx.graphics.getHeight()));

        generateNewDelay();
    }

    private void generateNewDelay() {
        lastTimeCreateMillis = System.currentTimeMillis();
        timeCreateDelayMillis = 1000 + (int) (ControllerMain.getInstance().getRandom().nextFloat() * 2000);
    }

    boolean isStarAttacked(StarInfo star) {
        if (lEnemies == null) return false;

        for (EnemyInfo item : lEnemies)
            if (item.isAttacking(star))
                return true;
        return false;
    }

    public boolean isMove(int i) {
        EnemyInfo item = getEnemyInfo(i);
        return item != null && item.isMove();
    }

    public boolean isBorn(int i) {
        EnemyInfo item = getEnemyInfo(i);
        return item != null && item.isBorn();
    }

    public boolean isAttack(int i) {
        EnemyInfo item = getEnemyInfo(i);
        return item != null && item.isAttack();
    }

    public boolean isDie(int i) {
        EnemyInfo item = getEnemyInfo(i);
        return item != null && item.isDie();
    }

    public long getLastTimeStateChanged(int i){
        EnemyInfo item = getEnemyInfo(i);
        return item == null ?0:item.getLastTimeStateChanged();
    }
}
