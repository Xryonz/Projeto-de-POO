package com.cad.despacho.telas;

import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class TelaPrincipal {

    StackPane areaConteudo = new StackPane();
    MenuLateral menu = new MenuLateral();

    public BorderPane criar() {

        BorderPane raiz = new BorderPane();
        raiz.getStyleClass().add("app-bg");
        raiz.setPadding(new Insets(32));

        VBox menuPronto = menu.criar(this);
        raiz.setLeft(menuPronto);
        BorderPane.setMargin(menuPronto, new Insets(0, 24, 0, 0));

        raiz.setCenter(areaConteudo);

        navegar(Tela.NOVA_OCORRENCIA);

        return raiz;
    }

    public void navegar(Tela tela) {

        areaConteudo.getChildren().clear();

        if (tela == Tela.NOVA_OCORRENCIA) {
            areaConteudo.getChildren().add(new TelaNovaOcorrencia().criar(this));
        } else if (tela == Tela.CONSULTAR) {
            areaConteudo.getChildren().add(new TelaConsultarOcorrencias().criar());
        } else if (tela == Tela.COMUNICACAO) {
            areaConteudo.getChildren().add(new TelaComunicacao().criar());
        }

        menu.marcarAtiva(tela);
    }
}
