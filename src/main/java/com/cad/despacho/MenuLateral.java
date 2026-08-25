package com.cad.despacho;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class MenuLateral {

    public VBox criar(TelaPrincipal pai) {

        VBox raiz = new VBox(24);
        raiz.setPadding(new Insets(20, 16, 20, 16));
        raiz.setPrefWidth(250);
        raiz.setMinWidth(250);

        VBox marca = new VBox(2);
        Label titulo = new Label("SISTEMA CAD");
        Label subtitulo = new Label("CORPO DE BOMBEIROS");
        marca.getChildren().add(titulo);
        marca.getChildren().add(subtitulo);

        VBox listaNav = new VBox(6);

        Button itemNovaOcorrencia = new Button("+  Nova Ocorrencia");
        itemNovaOcorrencia.setMaxWidth(Double.MAX_VALUE);
        itemNovaOcorrencia.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent evento) {
                pai.navegar(Tela.NOVA_OCORRENCIA);
            }
        });

        Button itemConsultar = new Button("=  Consultar Ocorrencias");
        itemConsultar.setMaxWidth(Double.MAX_VALUE);
        itemConsultar.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent evento) {
                pai.navegar(Tela.CONSULTAR);
            }
        });

        Button itemComunicacao = new Button("))  Comunicacao");
        itemComunicacao.setMaxWidth(Double.MAX_VALUE);
        itemComunicacao.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent evento) {
                pai.navegar(Tela.COMUNICACAO);
            }
        });

        listaNav.getChildren().add(itemNovaOcorrencia);
        listaNav.getChildren().add(itemConsultar);
        listaNav.getChildren().add(itemComunicacao);

        Region espaco = new Region();
        VBox.setVgrow(espaco, Priority.ALWAYS);

        raiz.getChildren().add(marca);
        raiz.getChildren().add(listaNav);
        raiz.getChildren().add(espaco);

        return raiz;
    }
}
