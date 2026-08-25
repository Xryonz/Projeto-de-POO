package com.cad.despacho;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaLogin {

    public StackPane criar(Stage janela) {

        StackPane raiz = new StackPane();
        raiz.setPrefSize(1200, 750);

        VBox card = new VBox(24);
        card.setAlignment(Pos.TOP_CENTER);

        VBox topo = new VBox(16);
        topo.setAlignment(Pos.CENTER);
        StackPane badge = new StackPane();
        Label glifo = new Label("CAD");
        badge.getChildren().add(glifo);
        Label titulo = new Label("SISTEMA CAD");
        Label subtitulo = new Label("Corpo de Bombeiros");
        topo.getChildren().add(badge);
        topo.getChildren().add(titulo);
        topo.getChildren().add(subtitulo);

        Label labelUsuario = new Label("REGISTRO GERAL / CPF");
        TextField campoRgCpf = new TextField();
        campoRgCpf.setPromptText("123.456.789-10");
        VBox boxUsuario = new VBox(8);
        boxUsuario.getChildren().add(labelUsuario);
        boxUsuario.getChildren().add(campoRgCpf);

        Label labelSenha = new Label("SENHA DE ACESSO TATICO");
        PasswordField campoSenha = new PasswordField();
        campoSenha.setPromptText("****************");
        VBox boxSenha = new VBox(8);
        boxSenha.getChildren().add(labelSenha);
        boxSenha.getChildren().add(campoSenha);

        Label labelPerfil = new Label("PERFIL DE OPERACAO");
        ToggleGroup grupoPerfil = new ToggleGroup();
        ToggleButton botaoDespachante = new ToggleButton("Despachante");
        botaoDespachante.setToggleGroup(grupoPerfil);
        botaoDespachante.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(botaoDespachante, Priority.ALWAYS);
        botaoDespachante.setSelected(true);
        ToggleButton botaoSupervisor = new ToggleButton("Supervisor");
        botaoSupervisor.setToggleGroup(grupoPerfil);
        botaoSupervisor.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(botaoSupervisor, Priority.ALWAYS);
        HBox boxRoles = new HBox(botaoDespachante, botaoSupervisor);
        VBox boxPerfil = new VBox(8);
        boxPerfil.getChildren().add(labelPerfil);
        boxPerfil.getChildren().add(boxRoles);

        VBox formulario = new VBox(20);
        formulario.getChildren().add(boxUsuario);
        formulario.getChildren().add(boxSenha);
        formulario.getChildren().add(boxPerfil);

        Button botaoEntrar = new Button("AUTENTICAR NO CONSOLE");
        botaoEntrar.setMaxWidth(Double.MAX_VALUE);
        botaoEntrar.setDefaultButton(true);
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
