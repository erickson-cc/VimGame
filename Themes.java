package com.googlecode.lanterna.vim;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.SimpleTheme;
import com.googlecode.lanterna.gui2.Window;

public class Themes {
	// Definição das cores padrão
	public static final TextColor BACKGROUND = TextColor.Factory.fromString("#252525");
	public static final TextColor FOREGROUND = TextColor.ANSI.WHITE;

	/**
	* Aplica o tema padrão da aplicação a uma janela.
	*/
	public static void applyTheme(Window window) {
		// SimpleTheme define o par de cores (texto, fundo)
		window.setTheme(new SimpleTheme(FOREGROUND, BACKGROUND));
	}
}
