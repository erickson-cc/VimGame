package vimgame;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;
import java.io.File;
import java.util.Arrays;

public class SelecionarFase extends VimModes {
    private String faseEscolhida = null;

    public SelecionarFase() {
        super("Fases Disponíveis");
        this.setHints(Arrays.asList(Window.Hint.CENTERED, Window.Hint.NO_POST_RENDERING));
        this.setFixedSize(new TerminalSize(40, 15));

        Panel mainPanel = new Panel();
        mainPanel.setLayoutManager(new LinearLayout(Direction.VERTICAL));
        mainPanel.addComponent(new Label("Selecione uma fase:"));
        mainPanel.addComponent(new EmptySpace(new TerminalSize(0, 1)));

        // ActionListBox cria uma lista selecionável
        ActionListBox list = new ActionListBox(new TerminalSize(38, 8));

        // Lê os arquivos da pasta "fases"
        File folder = new File("fases");
        if (!folder.exists()) folder.mkdir(); // Cria a pasta se não existir
        
        File[] listOfFiles = folder.listFiles();
        if (listOfFiles != null && listOfFiles.length > 0) {
            for (File file : listOfFiles) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    list.addItem(file.getName(), () -> {
                        this.faseEscolhida = file.getAbsolutePath();
                        this.close(); // Fecha a janela ao selecionar
                    });
                }
            }
        } else {
            list.addItem("Nenhuma fase encontrada!", () -> {});
        }

        mainPanel.addComponent(list);
        mainPanel.addComponent(new EmptySpace(new TerminalSize(0, 1)));
        mainPanel.addComponent(new Button("Voltar", this::close));

        this.setComponent(mainPanel);
    }

    public String getFaseEscolhida() {
        return faseEscolhida;
    }
}
