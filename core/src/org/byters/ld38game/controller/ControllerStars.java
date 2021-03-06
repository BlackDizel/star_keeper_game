package org.byters.ld38game.controller;

import com.badlogic.gdx.Gdx;
import org.byters.ld38game.model.StarInfo;

import java.util.ArrayList;

public class ControllerStars {
    private static ControllerStars instance;

    private ArrayList<StarInfo> lStars;

    private ControllerStars() {
        lStars = new ArrayList<StarInfo>();

        lStars.add(new StarInfo(-Gdx.graphics.getWidth() / 20*5, Gdx.graphics.getHeight() / 20 * 9));

        lStars.add(new StarInfo(Gdx.graphics.getWidth() / 20, Gdx.graphics.getHeight() / 20 * 16));
        lStars.add(new StarInfo(Gdx.graphics.getWidth() / 20 * 4, Gdx.graphics.getHeight() / 20 * 12));
        lStars.add(new StarInfo(Gdx.graphics.getWidth() / 20 * 6, Gdx.graphics.getHeight() / 20 * 18));
        lStars.add(new StarInfo(Gdx.graphics.getWidth() / 20 * 9, Gdx.graphics.getHeight() / 20 * 8));
        lStars.add(new StarInfo(Gdx.graphics.getWidth() / 20 * 12, Gdx.graphics.getHeight() / 20 * 14));
        lStars.add(new StarInfo(Gdx.graphics.getWidth() / 20 * 17, Gdx.graphics.getHeight() / 20 * 11));

        lStars.add(new StarInfo(Gdx.graphics.getWidth() / 20*22, Gdx.graphics.getHeight() / 20 * 13));
        lStars.add(new StarInfo(Gdx.graphics.getWidth() / 20*25, Gdx.graphics.getHeight() / 20 * 17));
        lStars.add(new StarInfo(Gdx.graphics.getWidth() / 20*29, Gdx.graphics.getHeight() / 20 * 16));
    }

    public static ControllerStars getInstance() {
        if (instance == null) instance = new ControllerStars();
        return instance;
    }

    public int getStarsNum() {
        return lStars == null ? 0 : lStars.size();
    }

    private StarInfo getStar(int pos) {
        return lStars == null || pos < 0 || pos >= lStars.size() ? null : lStars.get(pos);
    }

    public float getPositionStarX(int i) {
        StarInfo star = getStar(i);
        return star == null ? 0 : star.getPositionX();
    }

    public float getPositionStarY(int i) {
        StarInfo star = getStar(i);
        return star == null ? 0 : star.getPositionY();
    }

    public void update() {
        if (lStars == null) return;
        for (StarInfo info : lStars)
            info.update();
    }

    StarInfo getNearestStar(float positionX, float positionY) {
        if (lStars == null) return null;

        StarInfo star = null;

        for (StarInfo item : lStars) {
            if (star == null) {
                star = item;
                continue;
            }

            if (item.distance(positionX, positionY) <
                    star.distance(positionX, positionY))
                star = item;
        }

        return star;
    }

    float getStarsLightPower() {
        if (lStars == null) return 0;
        int power = 0;
        for (StarInfo item : lStars)
            if (!ControllerEnemies.getInstance().isStarAttacked(item))
                ++power;
        return power / (float) lStars.size();
    }

    public float getStarOriginY(int i) {
        StarInfo star = getStar(i);
        return star == null ? 0 : star.getOriginY();
    }

    public float getStarOriginX(int i) {
        StarInfo star = getStar(i);
        return star == null ? 0 : star.getOriginX();
    }
}
