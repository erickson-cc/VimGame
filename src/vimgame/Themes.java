//package com.googlecode.lanterna.vim;
package vimgame;

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
		//window.setTheme(new SimpleTheme(FOREGROUND, BACKGROUND));

		SimpleTheme theme = new SimpleTheme(FOREGROUND, BACKGROUND);
		// FORÇA O DESTAQUE VISUAL PARA ITENS SELECIONADOS/FOCADOS
		// Fundo Branco e Texto Preto para dar contraste
		theme.getDefaultDefinition().setActive(TextColor.ANSI.BLACK, TextColor.ANSI.WHITE);
		theme.getDefaultDefinition().setSelected(TextColor.ANSI.BLACK, TextColor.ANSI.WHITE);

		window.setTheme(theme);
	}
	public static void loginTheme(Window window) {
		window.setTheme(new SimpleTheme(FOREGROUND, BACKGROUND));
	}
}
