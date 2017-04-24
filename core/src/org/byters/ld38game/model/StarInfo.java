package org.byters.ld38game.model;


import org.byters.engine.controller.ControllerMain;
import org.byters.engine.model.PointInt;
import org.byters.ld38game.controller.ControllerPlayer;
import org.byters.ld38game.controller.ControllerTowers;

public class StarInfo {
    private static final long TIME_CHANGE_DIRECTION_MILLIS = 2000;
    private static float originX;
    private static float originY;
    private float positionX;
    private float positionY;
    private boolean isRightWave;

    public StarInfo(float positionX, float positionY) {
        this.positionX = positionX;
        this.positionY = positionY;

        isRightWave = ControllerMain.getInstance().getRandom().nextBoolean();
    }

    public static void setOrigin(float originX, float originY) {
        StarInfo.originX = originX;
        StarInfo.originY = originY;
    }

    public float getPositionX() {
        return positionX + getDelta();
    }

    private int getDelta() {
        long check = ControllerMain.getInstance().getGameTime() % TIME_CHANGE_DIRECTION_MILLIS;
        int factor = check < TIME_CHANGE_DIRECTION_MILLIS / 4
                ? 0
                : check < TIME_CHANGE_DIRECTION_MILLIS / 2
                ? -1
                : check < TIME_CHANGE_DIRECTION_MILLIS / 4 * 3
                ? 0
                : 1;
        return isRightWave ? factor : factor * -1;
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

    public void update() {
        if (ControllerPlayer.getInstance().isBounded()) {
            positionX -= ControllerPlayer.getInstance().getDelta();

            positionX = ControllerTowers.getInstance().checkPos(positionX);
        }
    }
}
