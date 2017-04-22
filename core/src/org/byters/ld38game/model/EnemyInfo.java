package org.byters.ld38game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import org.byters.engine.model.PointInt;

public class EnemyInfo {
    private static final float SPEED = 20;
    private static float originX;
    private static float originY;
    private static float originRadius;
    private static float attack_distance;

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
    }

    public static void setOrigin(float originX, float originY) {
        EnemyInfo.originX = originX;
        EnemyInfo.originY = originY;
        EnemyInfo.originRadius = (float) PointInt.distance(0, 0, originX, originY);
        EnemyInfo.attack_distance = originRadius / 3;
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
        if (isNoDirection()) return;
        if (PointInt.distance(getPositionCenterX(), getPositionCenterY(), finalPositionX, finalPositionY) < attack_distance)
            return;
        positionX += direction.x * Gdx.graphics.getDeltaTime();
        positionY += direction.y * Gdx.graphics.getDeltaTime();
    }

    public boolean isAttacking(StarInfo item) {
        return item.distance(getPositionCenterX(), getPositionCenterY()) < attack_distance;
    }

    public boolean isToRemove() {
        return health <= 0;
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
}