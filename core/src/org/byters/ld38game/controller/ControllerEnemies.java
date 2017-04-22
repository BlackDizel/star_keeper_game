package org.byters.ld38game.controller;


import com.badlogic.gdx.Gdx;
import org.byters.ld38game.model.EnemyInfo;
import org.byters.ld38game.model.StarInfo;

import java.util.ArrayList;
import java.util.Iterator;

public class ControllerEnemies {
    private static ControllerEnemies instance;

    private ArrayList<EnemyInfo> lEnemies;

    private ControllerEnemies() {
        //todo implement
        lEnemies = new ArrayList<EnemyInfo>();
        lEnemies.add(new EnemyInfo(Gdx.graphics.getWidth() / 20, Gdx.graphics.getHeight() / 20 * 15));
        lEnemies.add(new EnemyInfo(Gdx.graphics.getWidth() / 20 * 10, Gdx.graphics.getHeight() / 20 * 12));
        lEnemies.add(new EnemyInfo(Gdx.graphics.getWidth() / 20 * 12, Gdx.graphics.getHeight() / 20 * 16));
        lEnemies.add(new EnemyInfo(Gdx.graphics.getWidth() / 20 * 15, Gdx.graphics.getHeight() / 20 * 14));
        lEnemies.add(new EnemyInfo(Gdx.graphics.getWidth() / 20 * 18, Gdx.graphics.getHeight() / 20 * 18));
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

    boolean isStarAttacked(StarInfo star) {
        if (lEnemies == null) return false;

        for (EnemyInfo item : lEnemies)
            if (item.isAttacking(star))
                return true;
        return false;
    }
}
