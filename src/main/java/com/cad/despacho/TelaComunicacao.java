package com.cad.despacho;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class TelaComunicacao {

    public VBox criar() {

        VBox raiz = new VBox(24);
        raiz.getChildren().add(new Label("CENTRAL DE RADIO E TEXTO COBOM"));

        VBox painelViaturas = new VBox(16);
        painelViaturas.setPrefWidth(280);
        painelViaturas.setMinWidth(280);

        Label tituloViaturas = new Label("VIATURAS ATIVAS");
        ListView<String> listaViaturas = new ListView<>();
        listaViaturas.getItems().addAll("ABTR-05", "ASU-12", "UR-03");
        listaViaturas.setFixedCellSize(28);
        listaViaturas.prefHeightProperty().bind(
                listaViaturas.fixedCellSizeProperty().multiply(listaViaturas.getItems().size()).add(2));

        painelViaturas.getChildren().add(tituloViaturas);
        painelViaturas.getChildren().add(listaViaturas);

        VBox painelRecursos = new VBox(16);

        Label tituloRecursos = new Label("DISPOSICAO DE RECURSOS");

        TreeItem<String> canais = new TreeItem<>("CANAIS DE RADIO ATIVOS");
        canais.setExpanded(true);
        canais.getChildren().add(new TreeItem<>("A-2"));
        canais.getChildren().add(new TreeItem<>("B-1"));
        canais.getChildren().add(new TreeItem<>("C-4"));
        canais.getChildren().add(new TreeItem<>("F-12"));

        TreeItem<String> unidades = new TreeItem<>("UNIDADES ALOCADAS");
        unidades.setExpanded(true);
        unidades.getChildren().add(new TreeItem<>("ASU-01"));
        unidades.getChildren().add(new TreeItem<>("ABTR-02"));
        unidades.getChildren().add(new TreeItem<>("ASU-03"));
        unidades.getChildren().add(new TreeItem<>("M-04"));

        TreeItem<String> raizArvore = new TreeItem<>("");
        raizArvore.getChildren().add(canais);
        raizArvore.getChildren().add(unidades);

        TreeView<String> arvore = new TreeView<>(raizArvore);
        arvore.setShowRoot(false);
        arvore.setFixedCellSize(28);
        arvore.prefHeightProperty().bind(
                arvore.fixedCellSizeProperty().multiply(arvore.expandedItemCountProperty()).add(2));

        painelRecursos.getChildren().add(tituloRecursos);
        painelRecursos.getChildren().add(arvore);
        HBox.setHgrow(painelRecursos, Priority.ALWAYS);

        HBox area = new HBox(24, painelViaturas, painelRecursos);
        VBox.setVgrow(area, Priority.ALWAYS);

        raiz.getChildren().add(area);

        return raiz;
    }
}
