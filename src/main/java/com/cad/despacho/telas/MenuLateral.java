package com.cad.despacho.telas;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
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

        Label itemNovaOcorrencia = new Label("+  Nova Ocorrencia");
        itemNovaOcorrencia.setMaxWidth(Double.MAX_VALUE);
        itemNovaOcorrencia.setOnMouseClicked(e -> pai.navegar(Tela.NOVA_OCORRENCIA));

        Label itemConsultar = new Label("=  Consultar Ocorrencias");
        itemConsultar.setMaxWidth(Double.MAX_VALUE);
        itemConsultar.setOnMouseClicked(e -> pai.navegar(Tela.CONSULTAR));

        Label itemComunicacao = new Label("))  Comunicacao");
        itemComunicacao.setMaxWidth(Double.MAX_VALUE);
        itemComunicacao.setOnMouseClicked(e -> pai.navegar(Tela.COMUNICACAO));

        listaNav.getChildren().add(itemNovaOcorrencia);
        listaNav.getChildren().add(itemConsultar);
        listaNav.getChildren().add(itemComunicacao);

        Region espaco = new Region();
        VBox.setVgrow(espaco, Priority.ALWAYS);

        HBox linhaOperador = new HBox(10);
        linhaOperador.setAlignment(Pos.CENTER_LEFT);
        Label avatarIniciais = new Label("RS");
        VBox textoOperador = new VBox(0);
        Label nome = new Label("Sgt. Renato Silva");
        Label matricula = new Label("OPERADOR #042");
        textoOperador.getChildren().add(nome);
        textoOperador.getChildren().add(matricula);
        linhaOperador.getChildren().add(avatarIniciais);
        linhaOperador.getChildren().add(textoOperador);

        raiz.getChildren().add(marca);
        raiz.getChildren().add(listaNav);
        raiz.getChildren().add(espaco);
        raiz.getChildren().add(linhaOperador);

        return raiz;
    }
}
