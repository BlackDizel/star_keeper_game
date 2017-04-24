package org.byters.ld38game.controller;

import org.byters.ld38game.controller.listeners.ListenerEnemy;

public class ControllerEnemiesBase {
    private ListenerEnemy listener;

    public void setListener(ListenerEnemy listener) {
        this.listener = listener;
    }

    public void removeListener() {
        this.listener = null;
    }

    void notifyListenerIsBorn() {
        if (listener == null) return;
        listener.onBorn();
    }

    void notifyListenerIsDie() {
        if (listener == null) return;
        listener.onDie();
    }
}
