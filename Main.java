package com.googlecode.lanterna.vim;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.dialogs.MessageDialog;
import com.googlecode.lanterna.gui2.dialogs.MessageDialogButton;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.TextCharacter;

import java.io.IOException;
import java.util.Arrays;

public class Main {
	public static void main(String[] args){
		DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
		Screen screen = null;

		try {
			screen = terminalFactory.createScreen();
			screen.startScreen();
			
			//WindowBasedTextGUI gui = new MultiWindowTextGUI(screen);
			MultiWindowTextGUI gui = new MultiWindowTextGUI(screen);
			
			//gui.setWindowPostRenderer(new EmptyWindowPostRenderer()); // remove o estilo padrão do lanterna
			//gui.setWindowPostRenderer((t, wm, w) -> { /* Sem operações */ });
//Tela de login
			
			Login screenLogin = new Login();
			gui.addWindowAndWait(screenLogin);

			if (screenLogin.isLogged()){
				//System.out.println("DEBUG: Login realizado com sucesso!");
				Menu screenMenu = new Menu();
				gui.addWindowAndWait(screenMenu);
				//Se o jogador  clicou em iniciar jogo e o menu fechou
				//aqui ficaria o loop da screen
			}
			else {
				//System.out.println("DEBUG: Falha no login");

			}


		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if(screen != null) {
				try {
					screen.close();
				}
				catch(IOException e) {
					e.printStackTrace();
				}
		    }
		}

	}
}
