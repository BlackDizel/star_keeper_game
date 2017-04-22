package org.byters.ld38game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class HelperFont {
    private static final String FONT_FILE = "font/freesans15white.fnt";
    private static HelperFont instance;
    private BitmapFont font;

    public static HelperFont getInstance() {
        if (instance == null) instance = new HelperFont();
        return instance;
    }

    public BitmapFont getFont() {
        return font;
    }

    public void dispose() {
        if (font == null) return;
        font.dispose();
    }

    public void load() {
        font = newInstanceFont();
    }

    BitmapFont newInstanceFont() {
        return new BitmapFont(Gdx.files.internal(FONT_FILE));
    }
}
