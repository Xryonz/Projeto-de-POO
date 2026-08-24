package com.cad.despacho.telas;

import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class Cabecalho {

    public static VBox criar(String titulo) {

        Label label = new Label(titulo);
        label.getStyleClass().add("titulo-tela");

        Region linha = new Region();
        linha.getStyleClass().add("linha-titulo");

        VBox caixa = new VBox(10);
        caixa.getChildren().add(label);
        caixa.getChildren().add(linha);

        return caixa;
    }
}
