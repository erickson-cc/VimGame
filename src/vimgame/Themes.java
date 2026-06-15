//package com.googlecode.lanterna.vim;
package vimgame;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.Theme;
import com.googlecode.lanterna.graphics.SimpleTheme;
import com.googlecode.lanterna.gui2.Window;

public class Themes {
	// Definição das cores padrão
	public static final TextColor BACKGROUND = TextColor.Factory.fromString("#252525");
	public static final TextColor FOREGROUND = TextColor.ANSI.WHITE;

	public static void applyTheme(Window window) {
		//SimpleTheme theme = new SimpleTheme(FOREGROUND, BACKGROUND);
		//theme.getDefaultDefinition().setActive(TextColor.ANSI.BLACK, TextColor.ANSI.WHITE);
		//theme.getDefaultDefinition().setSelected(TextColor.ANSI.BLACK, TextColor.ANSI.WHITE);
		//window.setTheme(theme);
		window.setTheme(getBaseTheme());
	}
	public static void loginTheme(Window window) {
		window.setTheme(new SimpleTheme(FOREGROUND, BACKGROUND));
	}
	public static Theme getBaseTheme(){
		return new SimpleTheme(FOREGROUND, BACKGROUND);
	}
	public static Theme getInteractiveTheme() {
		SimpleTheme theme = new SimpleTheme(FOREGROUND, BACKGROUND);
		theme.getDefaultDefinition().setActive(TextColor.ANSI.BLACK, TextColor.ANSI.WHITE);
		theme.getDefaultDefinition().setSelected(TextColor.ANSI.BLACK, TextColor.ANSI.WHITE);
        return theme;
    }
}
