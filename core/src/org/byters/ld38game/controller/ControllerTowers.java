package org.byters.ld38game.controller;

public class ControllerTowers {
    static final int HEIGHT_INDEX_NO_VALUE = -1;
    private static ControllerTowers instance;
    private int boundLeft, boundRight;
    private float[] positions;

    public static ControllerTowers getInstance() {
        if (instance == null) instance = new ControllerTowers();
        return instance;
    }

    private float checkPos(float pos) {
        if (pos < boundLeft) return pos + ControllerBridge.getInstance().getWidth();
        if (pos > boundRight) return pos - ControllerBridge.getInstance().getWidth();

        return pos;
    }

    public void setBounds(int left, int right) {
        boundLeft = left;
        boundRight = right;
    }

    public void update() {
        if (ControllerPlayer.getInstance().isBounded()) {
            float deltaX = ControllerPlayer.getInstance().getDelta();
            for (int i = 0; i < positions.length; ++i) {
                positions[i] -= deltaX;
                positions[i] = checkPos(positions[i]);
            }
        }
    }

    public void setPositions(float... pos) {
        positions = new float[pos.length];
        for (int i = 0; i < positions.length; ++i)
            positions[i] = pos[i];

        ControllerBridge.getInstance().checkPositions();
    }

    public float getPosition(int pos) {
        return positions[pos];
    }

    boolean isPositionSetted() {
        return positions != null;
    }

    int getBridgeHeightIndex(float x) {
        if (positions[2] > positions[1] && positions[1] > positions[0]) {
            if (x < positions[0]) return 0;
            if (x < positions[1]) return 2;
            if (x < positions[2]) return 1;
            return 0;
        }
        if (positions[0] > positions[2] && positions[2] > positions[1]) {
            if (x < positions[1]) return 2;
            if (x < positions[2]) return 1;
            if (x < positions[0]) return 0;
            return 2;
        }
        if (positions[1] > positions[0] && positions[0] > positions[2]) {
            if (x < positions[2]) return 1;
            if (x < positions[0]) return 0;
            if (x < positions[1]) return 2;
            return 1;
        }
        return HEIGHT_INDEX_NO_VALUE;
    }

    int getBoundLeft() {
        return boundLeft;
    }

    int getBoundRight() {
        return boundRight;
    }
}
