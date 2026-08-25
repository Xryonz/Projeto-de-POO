package com.cad.despacho;

import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class TelaPrincipal {

    StackPane areaConteudo = new StackPane();
    MenuLateral menu = new MenuLateral();

    public BorderPane criar() {

        BorderPane raiz = new BorderPane();
        raiz.setPadding(new Insets(32));

        VBox menuPronto = menu.criar(this);
        raiz.setLeft(menuPronto);
        BorderPane.setMargin(menuPronto, new Insets(0, 24, 0, 0));

        raiz.setCenter(areaConteudo);

        navegar("nova");

        return raiz;
    }

    public void navegar(String tela) {

        areaConteudo.getChildren().clear();

        if (tela.equals("nova")) {
            areaConteudo.getChildren().add(new TelaNovaOcorrencia().criar(this));
        } else if (tela.equals("consultar")) {
            areaConteudo.getChildren().add(new TelaConsultarOcorrencias().criar());
        } else if (tela.equals("comunicacao")) {
            areaConteudo.getChildren().add(new TelaComunicacao().criar());
        }
    }
}
