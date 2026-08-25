package com.cad.despacho;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaLogin {

    public StackPane criar(Stage janela) {

        StackPane raiz = new StackPane();
        raiz.setPrefSize(1200, 750);

        VBox card = new VBox();

        VBox topo = new VBox();
        StackPane badge = new StackPane();
        Label glifo = new Label("CAD");
        badge.getChildren().add(glifo);
        Label titulo = new Label("SISTEMA CAD");
        Label subtitulo = new Label("Corpo de Bombeiros");
        topo.getChildren().add(badge);
        topo.getChildren().add(titulo);
        topo.getChildren().add(subtitulo);

        Label labelUsuario = new Label("REGISTRO GERAL / CPF");
        Label labelSenha = new Label("SENHA DE ACESSO TATICO");

        Label labelPerfil = new Label("PERFIL DE OPERACAO");
        Button botaoDespachante = new Button("Despachante");
        Button botaoSupervisor = new Button("Supervisor");
        HBox boxRoles = new HBox(botaoDespachante, botaoSupervisor);

        VBox formulario = new VBox();
        formulario.getChildren().add(labelUsuario);
        formulario.getChildren().add(labelSenha);
        formulario.getChildren().add(labelPerfil);
        formulario.getChildren().add(boxRoles);

        Button botaoEntrar = new Button("AUTENTICAR NO CONSOLE");
        botaoEntrar.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent evento) {
                TelaPrincipal telaPrincipal = new TelaPrincipal();
                Scene cena = new Scene(telaPrincipal.criar(), 1200, 750);
                janela.setScene(cena);
            }
        });

        card.getChildren().add(topo);
        card.getChildren().add(formulario);
        card.getChildren().add(botaoEntrar);

        raiz.getChildren().add(card);

        return raiz;
    }
}
