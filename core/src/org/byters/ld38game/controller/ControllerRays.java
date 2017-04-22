package org.byters.ld38game.controller;

import org.byters.ld38game.model.RayInfo;

import java.util.ArrayList;
import java.util.Iterator;

public class ControllerRays {

    private static final long SHOOT_DELAY_MILLIS = 2000;
    private static ControllerRays instance;

    private ArrayList<RayInfo> lRays;
    private long shootLastTime;

    private ControllerRays() {
        lRays = null;
        shootLastTime = 0;
    }


    public static ControllerRays getInstance() {
        if (instance == null) instance = new ControllerRays();
        return instance;
    }

    public int getRaysNum() {
        return lRays == null ? 0 : lRays.size();
    }

    public float getPositionRayX(int i) {
        RayInfo item = getRayInfo(i);
        return item == null ? 0 : item.getPositionX();
    }

    private RayInfo getRayInfo(int i) {
        return lRays == null || i < 0 || i >= lRays.size() ? null : lRays.get(i);
    }

    public float getPositionRayY(int i) {
        RayInfo item = getRayInfo(i);
        return item == null ? 0 : item.getPositionY();
    }

    public float getRotationRay(int i) {
        RayInfo item = getRayInfo(i);
        return item == null ? 0 : item.getRotation();
    }

    public float getAlphaRay(int i) {
        RayInfo item = getRayInfo(i);
        return item == null ? 0 : item.getAlpha();
    }

    public void input() {
        if (ControllerInput.getInstance().isShoot()
                && shootLastTime + SHOOT_DELAY_MILLIS < System.currentTimeMillis()) {
            addRay();
            shootLastTime = System.currentTimeMillis();
        }
    }

    public void update() {
        if (lRays == null) return;
        Iterator<RayInfo> iterator = lRays.iterator();
        while (iterator.hasNext()) {
            RayInfo item = iterator.next();
            item.update();
            if (item.isToRemove())
                iterator.remove();
        }
    }

    private void addRay() {
        if (lRays == null) lRays = new ArrayList<RayInfo>();
        lRays.add(new RayInfo(ControllerPlayer.getInstance().getPositionX(), ControllerPlayer.getInstance().getPositionY(), getRotation()));
    }

    private float getRotation() {
        return (float) Math.toDegrees(Math.atan2(ControllerInput.getInstance().getAimPositionY() - ControllerPlayer.getInstance().getPositionY()
                , ControllerInput.getInstance().getAimPositionX() - ControllerPlayer.getInstance().getPositionX()));
    }
}

