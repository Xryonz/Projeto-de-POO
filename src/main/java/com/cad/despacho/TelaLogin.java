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
        card.setMaxWidth(420);
        card.setMaxHeight(Region.USE_PREF_SIZE);

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

        Label lblUsuario = new Label("REGISTRO GERAL / CPF");
        TextField campoRgCpf = new TextField();
        campoRgCpf.setPromptText("123.456.789-10");
        VBox boxUsuario = new VBox(8);
        boxUsuario.getChildren().add(lblUsuario);
        boxUsuario.getChildren().add(campoRgCpf);

        Label lblSenha = new Label("SENHA DE ACESSO TATICO");
        PasswordField campoSenha = new PasswordField();
        campoSenha.setPromptText("****************");
        VBox boxSenha = new VBox(8);
        boxSenha.getChildren().add(lblSenha);
        boxSenha.getChildren().add(campoSenha);

        Label lblPerfil = new Label("PERFIL DE OPERACAO");
        ToggleGroup grupoPerfil = new ToggleGroup();
        ToggleButton btnDespachante = new ToggleButton("Despachante");
        btnDespachante.setToggleGroup(grupoPerfil);
        btnDespachante.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(btnDespachante, Priority.ALWAYS);
        btnDespachante.setSelected(true);
        ToggleButton btnSupervisor = new ToggleButton("Supervisor");
        btnSupervisor.setToggleGroup(grupoPerfil);
        btnSupervisor.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(btnSupervisor, Priority.ALWAYS);
        HBox boxRoles = new HBox(btnDespachante, btnSupervisor);
        VBox boxPerfil = new VBox(8);
        boxPerfil.getChildren().add(lblPerfil);
        boxPerfil.getChildren().add(boxRoles);

        VBox formulario = new VBox(20);
        formulario.getChildren().add(boxUsuario);
        formulario.getChildren().add(boxSenha);
        formulario.getChildren().add(boxPerfil);

        Button btnEntrar = new Button("AUTENTICAR NO CONSOLE");
        btnEntrar.setMaxWidth(Double.MAX_VALUE);
        btnEntrar.setDefaultButton(true);
        btnEntrar.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent evento) {
                TelaPrincipal telaPrincipal = new TelaPrincipal();
                Scene cena = new Scene(telaPrincipal.criar(), 1200, 750);
                janela.setScene(cena);
            }
        });

        card.getChildren().add(topo);
        card.getChildren().add(formulario);
        card.getChildren().add(btnEntrar);

        raiz.getChildren().add(card);

        return raiz;
    }
}
