package org.byters.ld38game.controller;

import com.badlogic.gdx.Gdx;
import org.byters.ld38game.model.StarInfo;

import java.util.ArrayList;

public class ControllerStars {
    private static ControllerStars instance;

    private ArrayList<StarInfo> lStars;

    private ControllerStars() {
        //todo implement
        lStars = new ArrayList<StarInfo>();
        lStars.add(new StarInfo(Gdx.graphics.getWidth() / 20, Gdx.graphics.getHeight() / 20 * 16));
        lStars.add(new StarInfo(Gdx.graphics.getWidth() / 20 * 4, Gdx.graphics.getHeight() / 20 * 12));
        lStars.add(new StarInfo(Gdx.graphics.getWidth() / 20 * 6, Gdx.graphics.getHeight() / 20 * 18));
        lStars.add(new StarInfo(Gdx.graphics.getWidth() / 20 * 12, Gdx.graphics.getHeight() / 20 * 10));
        lStars.add(new StarInfo(Gdx.graphics.getWidth() / 20 * 17, Gdx.graphics.getHeight() / 20 * 18));
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
}
