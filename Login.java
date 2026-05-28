package com.googlecode.lanterna.vim;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.graphics.SimpleTheme;
import java.util.Arrays;
import com.googlecode.lanterna.gui2.dialogs.MessageDialog;
import com.googlecode.lanterna.gui2.dialogs.MessageDialogButton;

// A classe Login AGORA É uma janela (estende BasicWindow)
public class Login extends VimModes {

	private static int largura = 35;
	private static int altura = 10;

	private static String title  = "Acesso ao Sistema";
	public Login() {
		super("Acesso ao Sistema"); // Define o título da janela

		//TextColor cinzaEscuro = TextColor.Factory.fromString("#252525");
		//SimpleTheme loginTheme = new SimpleTheme(TextColor.ANSI.WHITE, cinzaEscuro);
		Themes.applyTheme(this);


		// Configurações da Janela
		this.setHints(
			Arrays.asList(
				Window.Hint.CENTERED,
				Window.Hint.NO_POST_RENDERING // Tira as sombras da janela
				//Window.Hint.FIT_TERMINAL_WINDOW
				)
			);
		this.setFixedSize(new TerminalSize(largura, altura));

		// Criação do Painel Principal
		Panel mainPanel = new Panel();
		mainPanel.setLayoutManager(new LinearLayout(Direction.VERTICAL));

		mainPanel.addComponent(new Label("Login:"));
		TextBox txtLogin = new TextBox(new TerminalSize(20, 1));
		mainPanel.addComponent(txtLogin);

		mainPanel.addComponent(new Label("Senha:"));
		TextBox txtSenha = new TextBox(new TerminalSize(20, 1)).setMask('*');
		mainPanel.addComponent(txtSenha);

		mainPanel.addComponent(new EmptySpace(new TerminalSize(0, 1)));

		// Painel de Botões Lado a Lado
		Panel buttonPanel = new Panel();
		buttonPanel.setLayoutManager(new LinearLayout(Direction.HORIZONTAL));

		// Alignment.Beginning (esquerda) + CanGrow (estica para ocupar o espaço)
		//buttonPanel.addComponent(new EmptySpace(TerminalSize.ZERO), LinearLayout.createLayoutData(LinearLayout.Alignment.Beginning, LinearLayout.GrowPolicy.CanGrow));
		buttonPanel.addComponent(new Button("Entrar", () -> {
		    validarLogin(txtLogin.getText(), txtSenha.getText());
		}));

		buttonPanel.addComponent(new Button("Sair", () -> {
		    System.exit(0);
		}));

		mainPanel.addComponent(buttonPanel.setLayoutData( LinearLayout.createLayoutData(LinearLayout.Alignment.Fill)));
		//mainPanel.addComponent(buttonPanel);
		//buttonPanel.addComponent(new EmptySpace(TerminalSize.ZERO), LinearLayout.createLayoutData(LinearLayout.Alignment.Beginning, LinearLayout.GrowPolicy.CanGrow));

		// Define o conteúdo da janela
		this.setComponent(mainPanel);
	}

	private boolean logged = false;

	public boolean isLogged() {
		return logged;
	}

	private void validarLogin(String user, String pass) {
		// Lógica de validação futura
		if(user.equals("admin") && pass.equals("admin")) {
			this.logged = true;
			this.close(); // Fecha a janela de login se estiver correto
		}
		else {
			MessageDialog.showMessageDialog(getTextGUI(), "Erro", "Utilizador ou Senha inválidos!", MessageDialogButton.OK);
		}
	}

}
