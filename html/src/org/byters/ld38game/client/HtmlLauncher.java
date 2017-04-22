package org.byters.ld38game.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import org.byters.ld38game.GameMain;

public class HtmlLauncher extends GwtApplication {

    @Override
    public GwtApplicationConfiguration getConfig() {
        return new GwtApplicationConfiguration(640, 400);
    }

    @Override
    public ApplicationListener createApplicationListener() {
        return new GameMain();
    }
}