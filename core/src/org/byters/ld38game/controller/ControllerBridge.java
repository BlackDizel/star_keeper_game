package org.byters.ld38game.controller;

import com.badlogic.gdx.Gdx;

public class ControllerBridge {
    private static ControllerBridge instance;

    private int width;
    private int bridgeNum;
    private PointFloat[] positions;

    private ControllerBridge() {
        width = 0;
        bridgeNum = 0;
    }

    public static ControllerBridge getInstance() {
        if (instance == null) instance = new ControllerBridge();
        return instance;
    }

    public void update() {
        if (ControllerPlayer.getInstance().isBounded()) {
            for (PointFloat item : positions) {
                item.x -= ControllerPlayer.getInstance().getDelta();

                if (item.x < ControllerTowers.getInstance().getBoundLeft())
                    item.x = item.x + getWidth();
                if (item.x > ControllerTowers.getInstance().getBoundRight())
                    item.x = item.x - getWidth();
                item.y = getY(item.x);
            }
        }
    }

    int getWidth() {
        return positions.length * width;
    }

    public void setWidth(int width) {
        this.width = width;
        checkPositions();
    }

    void checkPositions() {
        if (!ControllerTowers.getInstance().isPositionSetted() || width == 0)
            return;

        bridgeNum = (ControllerTowers.getInstance().getBoundRight() - ControllerTowers.getInstance().getBoundLeft())
                / width;

        positions = new PointFloat[bridgeNum];

        for (int i = 0; i < positions.length; ++i) {
            positions[i] = new PointFloat();
            positions[i].x = (i * width) + ControllerTowers.getInstance().getBoundLeft();
            positions[i].y = getY(positions[i].x);
        }
    }

    private int getY(float x) {
        int index = ControllerTowers.getInstance().getBridgeHeightIndex(x);

        if (index == ControllerTowers.HEIGHT_INDEX_NO_VALUE)
            return 0;

        return Gdx.graphics.getHeight() / 12 * (index + 4); //maaaaagic. from 1/3 to 1/2
    }

    public float getBridgePositionY(int index) {
        return positions[index].y;
    }

    public float getBridgePositionX(int index) {
        return positions[index].x;
    }

    public void setBridgeNum(int num) {
        this.bridgeNum = num;
        checkPositions();
    }

    public int getBridgeNums() {
        return positions == null ? 0 : positions.length;
    }

    private class PointFloat {
        float x, y;
    }
}
