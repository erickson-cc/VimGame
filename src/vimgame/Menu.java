package vimgame;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.graphics.SimpleTheme;
import java.util.Arrays;


public class Menu extends VimModes {
	private static int largura = 35;
	private static int altura = 10;
	private boolean selecionarFaseClicked = false;
	public boolean isSelecionarFaseClicked() { return selecionarFaseClicked; }
	public Menu(){
		super("Menu Principal");
		// Centraliza a janela e remove a sombra
		this.setHints(Arrays.asList(Window.Hint.CENTERED, Window.Hint.NO_POST_RENDERING));
		this.setFixedSize(new TerminalSize(largura, altura));

		//Themes.applyTheme(this);

		Panel mainPanel = new Panel();
		mainPanel.setTheme(Themes.getInteractiveTheme());
		mainPanel.setLayoutManager(new LinearLayout(Direction.VERTICAL));

		mainPanel.addComponent(new Label("Usuário: "+ "admin"));//substituir admin por variável user
		mainPanel.addComponent(new EmptySpace(new TerminalSize(0, 1)));

		// Opções do Menu
		mainPanel.addComponent(new Button("Selecionar Fase", () -> {
			this.selecionarFaseClicked = true;
			this.close(); // Fecha o menu para abrir a próxima tela
		}));

		mainPanel.addComponent(new Button("Desenvolver Fase", () -> {
			// Criar uma lógica de if para aparecer essa seleção
			// apenas para o usuário desenvolvedor
		}));

		mainPanel.addComponent(new Button("Ranking", () -> {
			// Lógica de configurações
		}));

		mainPanel.addComponent(new Button("Sair", () -> {
			System.exit(0);
		}));

		this.setComponent(mainPanel);
	}
}
