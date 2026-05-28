package com.googlecode.lanterna.vim;

import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import java.util.ArrayList;
import java.util.List;

public abstract class VimModes extends BasicWindow {
    protected enum Mode { NORMAL, INSERT }
    protected Mode currentMode = Mode.NORMAL;
    protected List<TextBox> editables = new ArrayList<>();

    public VimModes(String title){
	    super(title);
	    Themes.applyTheme(this);
    }

    // Método para as classes filhas registrarem suas caixas de texto
    protected void addEditable(TextBox textBox) {
        this.editables.add(textBox);
        textBox.setReadOnly(true); // Começa em modo NORMAL
    }

    @Override
    public boolean handleInput(KeyStroke key) {
        // ESC sempre volta para o modo NORMAL
        if (key.getKeyType() == KeyType.Escape) {
            switchMode(Mode.NORMAL);
            return true;
        }

        if (currentMode == Mode.NORMAL) {
            if (key.getCharacter() != null) {
                switch (key.getCharacter()) {
                    case 'i': case 'a':
                        switchMode(Mode.INSERT);
                        return true;
//                    case 'j': // Próximo campo
//                        getTextGUI().getInteractableRenderer().nextFocus(getTextGUI().getFocusedInteractable());
//                        return true;
//                    case 'k': // Campo anterior
//                        getTextGUI().getInteractableRenderer().previousFocus(getTextGUI().getFocusedInteractable());
//                        return true;
                }
            }
        }
        return super.handleInput(key);
    }

    private void switchMode(Mode mode) {
        this.currentMode = mode;
        boolean isReadOnly = (mode == Mode.NORMAL);
        for (TextBox tb : editables) {
            tb.setReadOnly(isReadOnly);
        }
        this.setTitle(this.getTitle().split(" \\[")[0] + " [" + mode + "]");
    }
}
