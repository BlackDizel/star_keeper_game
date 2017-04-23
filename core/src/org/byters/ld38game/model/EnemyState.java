package org.byters.ld38game.model;


class EnemyState {
    private static final long TIME_BORN = 1000;
    private static final long TIME_DIE = 1500;
    private long lastTimeStateChange;
    private State state;

    EnemyState() {
        state = State.BORN;
        lastTimeStateChange = System.currentTimeMillis();
    }

    boolean isMove() {
        return state == State.MOVE;
    }

    boolean isBorn() {
        return state == State.BORN;
    }

    boolean isAttack() {
        return state == State.ATTACK;
    }

    boolean isDie() {
        return state == State.DIE;
    }

    void checkState(float health) {
        if (state == State.BORN && lastTimeStateChange + TIME_BORN < System.currentTimeMillis()) {
            state = State.MOVE;
            lastTimeStateChange = System.currentTimeMillis();
            return;
        }

        if (health < 0 && state != State.DIE) {
            state = State.DIE;
            lastTimeStateChange = System.currentTimeMillis();
        }
    }

    boolean isToRemove() {
        return state == State.DIE && lastTimeStateChange + TIME_DIE < System.currentTimeMillis();
    }

    void setAttack() {
        if (state != State.MOVE) return;
        state = State.ATTACK;
        lastTimeStateChange = System.currentTimeMillis();
    }

    long getLastTimeStateChanged() {
        return lastTimeStateChange;
    }

    private enum State {BORN, MOVE, ATTACK, DIE}
}
