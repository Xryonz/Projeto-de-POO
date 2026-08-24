package com.cad.despacho.telas;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
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

        ListView<String> lista = new ListView<>();
        lista.getItems().addAll("ABTR-05", "ASU-12", "UR-03");
        lista.setCellFactory(lv -> criarCelulaCodigo());
        lista.setFixedCellSize(38);
        lista.prefHeightProperty().bind(lista.fixedCellSizeProperty().multiply(lista.getItems().size()).add(2));

        painel.getChildren().add(titulo);
        painel.getChildren().add(lista);
        return painel;
    }

    ListCell<String> criarCelulaCodigo() {
        return new ListCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                getStyleClass().remove("item-codigo");
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item);
                    getStyleClass().add("item-codigo");
                }
            }
        };
    }

    VBox montarRecursos() {

        VBox painel = new VBox(16);
        painel.getStyleClass().add("card");

        Label titulo = new Label("DISPOSICAO DE RECURSOS");
        titulo.getStyleClass().add("card-title");
        titulo.getStyleClass().add("mono");

        TreeItem<String> raizArvore = new TreeItem<>("");
        raizArvore.getChildren().add(criarCategoria("CANAIS DE RADIO ATIVOS", "A-2", "B-1", "C-4", "F-12"));
        raizArvore.getChildren().add(criarCategoria("UNIDADES ALOCADAS", "ASU-01", "ABTR-02", "ASU-03", "M-04"));

        TreeView<String> arvore = new TreeView<>(raizArvore);
        arvore.setShowRoot(false);
        arvore.setCellFactory(tv -> criarCelulaArvore());
        arvore.setFixedCellSize(32);
        arvore.prefHeightProperty().bind(arvore.fixedCellSizeProperty().multiply(arvore.expandedItemCountProperty()).add(2));

        painel.getChildren().add(titulo);
        painel.getChildren().add(arvore);

        return painel;
    }

    TreeItem<String> criarCategoria(String nome, String... itens) {
        TreeItem<String> categoria = new TreeItem<>(nome);
        categoria.setExpanded(true);
        for (String item : itens) {
            categoria.getChildren().add(new TreeItem<>(item));
        }
        return categoria;
    }

    TreeCell<String> criarCelulaArvore() {
        return new TreeCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                getStyleClass().removeAll("arvore-categoria", "arvore-item");
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item);
                    if (getTreeItem() != null && !getTreeItem().isLeaf()) {
                        getStyleClass().add("arvore-categoria");
                    } else {
                        getStyleClass().add("arvore-item");
                    }
                }
            }
        };
    }
}
