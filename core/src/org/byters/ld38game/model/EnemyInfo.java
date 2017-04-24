package org.byters.ld38game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import org.byters.engine.model.PointInt;
import org.byters.ld38game.controller.ControllerPlayer;
import org.byters.ld38game.controller.ControllerTowers;

public class EnemyInfo {
    private static final float SPEED = 40;
    private static float originX;
    private static float originY;
    private static float originRadius;
    private static float attack_distance;
    private EnemyState state;

    private float positionX;
    private float positionY;
    private int health;
    private float finalPositionX;
    private float finalPositionY;
    private Vector2 direction;

    public EnemyInfo(float positionX, float positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        finalPositionX = 0;
        finalPositionY = 0;
        health = 3;
        state = new EnemyState();
    }

    public static void setOrigin(float originX, float originY) {
        EnemyInfo.originX = originX;
        EnemyInfo.originY = originY;
        EnemyInfo.originRadius = (float) PointInt.distance(0, 0, originX, originY);
        EnemyInfo.attack_distance = originRadius / 8f;
    }

    public float getPositionX() {
        return positionX;
    }

    public float getPositionY() {
        return positionY;
    }

    public int getHealth() {
        return health;
    }

    public boolean isNoDirection() {
        return finalPositionX == 0 && finalPositionY == 0;
    }

    public void setFinalPosition(float positionX, float positionY) {
        this.finalPositionX = positionX;
        this.finalPositionY = positionY;
        direction = new Vector2(finalPositionX - getPositionCenterX(), finalPositionY - getPositionCenterY()).nor().scl(SPEED);
    }

    public void update() {
        if (ControllerPlayer.getInstance().isBounded()) {
            positionX -= ControllerPlayer.getInstance().getDelta();
            positionX = ControllerTowers.getInstance().checkPos(positionX);

            finalPositionX -= ControllerPlayer.getInstance().getDelta();
            finalPositionX = ControllerTowers.getInstance().checkPos(finalPositionX);
        }

        if (isNoDirection()) return;
        checkMove();

        state.checkState(health);
    }

    private void checkMove() {
        if (isArrived() || !state.isMove())
            return;
        positionX += direction.x * Gdx.graphics.getDeltaTime();
        positionY += direction.y * Gdx.graphics.getDeltaTime();
    }

    private boolean isArrived() {
        boolean isArrived = PointInt.distance(getPositionCenterX(), getPositionCenterY(), finalPositionX, finalPositionY) < attack_distance;
        if (isArrived) state.setAttack();
        return isArrived;
    }

    public boolean isAttacking(StarInfo item) {
        return item.distance(getPositionCenterX(), getPositionCenterY()) < attack_distance;
    }

    public boolean isToRemove() {
        return state.isToRemove();
    }

    public float getPositionCenterX() {
        return positionX + originX;
    }


    public float getPositionCenterY() {
        return positionY + originY;
    }

    public void kick() {
        health -= 1;//todo implement
    }

    public boolean isMove() {
        return state.isMove();
    }

    public boolean isBorn() {
        return state.isBorn();
    }

    public boolean isAttack() {
        return state.isAttack();
    }

    public boolean isDie() {
        return state.isDie();
    }

    public long getLastTimeStateChanged() {
        return state.getLastTimeStateChanged();
    }
}
