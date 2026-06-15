//package com.googlecode.lanterna.vim;
package vimgame;

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
			
			MultiWindowTextGUI gui = new MultiWindowTextGUI(screen);
			
			//Tela de login
			Login screenLogin = new Login();
			gui.addWindowAndWait(screenLogin);

			if (screenLogin.isLogged()){
				boolean rodando = true;
				while (rodando) {
					Menu screenMenu = new Menu();
					gui.addWindowAndWait(screenMenu);
					if (screenMenu.isSelecionarFaseClicked()){
						SelecionarFase telaFases = new SelecionarFase();
						gui.addWindowAndWait(telaFases);

						String caminhoFase = telaFases.getFaseEscolhida();

						if (caminhoFase != null) {
							// Pausa lanterna
							screen.stopScreen();
							long tempoInicio = System.currentTimeMillis();
							try{
								// Chama o VIM nativo, precisa estar instalado no computador
								ProcessBuilder pb = new ProcessBuilder("vim", caminhoFase);
								pb.inheritIO(); // Fundamental: Conecta o Vim ao terminal
								Process processoVim = pb.start();
								processoVim.waitFor(); // O Java congela aqui até o usuário sair do Vim
							} catch (InterruptedException e ){
								e.printStackTrace();
							}
							long tempoFim = System.currentTimeMillis();
							// Criar uma classe de desempenho da fase 'conclusao.tempo()'
							long segundosGastos = (tempoFim - tempoInicio) / 1000;

							screen.startScreen();// Volta ao lanterna
									     //
							MessageDialog.showMessageDialog(gui, "Fase Concluída!", "Tempo gasto: " + segundosGastos + " segundos.", MessageDialogButton.OK);
							}
					}
					else{
						rodando = false;
					}
				}
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
