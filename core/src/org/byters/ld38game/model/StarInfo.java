package org.byters.ld38game.model;


import org.byters.engine.model.PointInt;

public class StarInfo {
    private static float originX;
    private static float originY;
    private float positionX;
    private float positionY;

    public StarInfo(float positionX, float positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public static void setOrigin(float originX, float originY) {
        StarInfo.originX = originX;
        StarInfo.originY = originY;
    }

    public float getPositionX() {
        return positionX;
    }

    public float getPositionY() {
        return positionY;
    }

    public float distance(float positionX, float positionY) {
        return (float) PointInt.distance(this.positionX + originX, this.positionY + originY, positionX, positionY);
    }

    public float getOriginX() {
        return originX;
    }

    public float getOriginY() {
        return originY;
    }
}
