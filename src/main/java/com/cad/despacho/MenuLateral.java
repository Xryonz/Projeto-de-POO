package com.cad.despacho;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MenuLateral {

    public VBox criar(TelaPrincipal pai) {

        VBox raiz = new VBox(24);
        raiz.setPadding(new Insets(20, 16, 20, 16));

        VBox marca = new VBox(2);
        Label titulo = new Label("SISTEMA CAD");
        Label subtitulo = new Label("CORPO DE BOMBEIROS");
        marca.getChildren().add(titulo);
        marca.getChildren().add(subtitulo);

        VBox listaNav = new VBox(6);

        Button itemNovaOcorrencia = new Button("+  Nova Ocorrencia");
        itemNovaOcorrencia.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent evento) {
                pai.navegar("nova");
            }
        });

        Button itemConsultar = new Button("=  Consultar Ocorrencias");
        itemConsultar.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent evento) {
                pai.navegar("consultar");
            }
        });

        Button itemComunicacao = new Button("))  Comunicacao");
        itemComunicacao.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent evento) {
                pai.navegar("comunicacao");
            }
        });

        listaNav.getChildren().add(itemNovaOcorrencia);
        listaNav.getChildren().add(itemConsultar);
        listaNav.getChildren().add(itemComunicacao);

        raiz.getChildren().add(marca);
        raiz.getChildren().add(listaNav);

        return raiz;
    }
}
