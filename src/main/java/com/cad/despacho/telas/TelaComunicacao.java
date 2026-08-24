package com.cad.despacho.telas;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class TelaComunicacao {

    public VBox criar() {

        VBox raiz = new VBox(24);
        raiz.getChildren().add(Cabecalho.criar("CENTRAL DE RADIO E TEXTO COBOM"));

        HBox area = new HBox(24);
        VBox.setVgrow(area, Priority.ALWAYS);

        VBox painelViaturas = montarViaturasAtivas();
        VBox painelRecursos = montarRecursos();
        HBox.setHgrow(painelRecursos, Priority.ALWAYS);

        area.getChildren().add(painelViaturas);
        area.getChildren().add(painelRecursos);

        raiz.getChildren().add(area);

        return raiz;
    }

    VBox montarViaturasAtivas() {

        VBox painel = new VBox(16);
        painel.getStyleClass().add("card");
        painel.setPrefWidth(280);
        painel.setMinWidth(280);

        Label titulo = new Label("VIATURAS ATIVAS");
        titulo.getStyleClass().add("card-title");

        VBox lista = new VBox(8);
        lista.getChildren().add(criarItemLista("ABTR-05"));
        lista.getChildren().add(criarItemLista("ASU-12"));
        lista.getChildren().add(criarItemLista("UR-03"));

        painel.getChildren().add(titulo);
        painel.getChildren().add(lista);
        return painel;
    }

    VBox criarItemLista(String codigo) {
        VBox item = new VBox();
        item.getStyleClass().add("conv-list-cell");
        Label label = new Label(codigo);
        label.getStyleClass().add("item-codigo");
        item.getChildren().add(label);
        return item;
    }

    VBox montarRecursos() {

        VBox painel = new VBox(16);
        painel.getStyleClass().add("card");

        Label titulo = new Label("DISPOSICAO DE RECURSOS");
        titulo.getStyleClass().add("card-title");
        titulo.getStyleClass().add("mono");

        Label labelCanais = new Label("CANAIS DE RADIO ATIVOS");
        labelCanais.getStyleClass().add("section-label");
        VBox canais = new VBox(10);
        canais.getChildren().add(criarLinhaRecurso("R", "A-2"));
        canais.getChildren().add(criarLinhaRecurso("R", "B-1"));
        canais.getChildren().add(criarLinhaRecurso("R", "C-4"));
        canais.getChildren().add(criarLinhaRecurso("R", "F-12"));

        Label labelUnidades = new Label("UNIDADES ALOCADAS");
        labelUnidades.getStyleClass().add("section-label");
        VBox unidades = new VBox(10);
        unidades.getChildren().add(criarLinhaRecurso("V", "ASU-01"));
        unidades.getChildren().add(criarLinhaRecurso("V", "ABTR-02"));
        unidades.getChildren().add(criarLinhaRecurso("V", "ASU-03"));
        unidades.getChildren().add(criarLinhaRecurso("V", "M-04"));

        painel.getChildren().add(titulo);
        painel.getChildren().add(labelCanais);
        painel.getChildren().add(canais);
        painel.getChildren().add(labelUnidades);
        painel.getChildren().add(unidades);

        return painel;
    }

    HBox criarLinhaRecurso(String icone, String codigo) {

        HBox linha = new HBox(12);
        linha.getStyleClass().add("channel-row");
        linha.setAlignment(Pos.CENTER_LEFT);

        Label labelIcone = new Label(icone);
        labelIcone.getStyleClass().add("icon-box-texto");
        StackPane iconBox = new StackPane(labelIcone);
        iconBox.getStyleClass().add("icon-box");

        Label label = new Label(codigo);
        label.getStyleClass().add("item-codigo");

        linha.getChildren().add(iconBox);
        linha.getChildren().add(label);

        return linha;
    }
}
