package com.cad.despacho.telas;

import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class Botoes {

    public static ToggleButton criarToggle(String texto, ToggleGroup grupo) {

        ToggleButton botao = new ToggleButton(texto);
        botao.setToggleGroup(grupo);
        botao.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(botao, Priority.ALWAYS);

        return botao;
    }
}
