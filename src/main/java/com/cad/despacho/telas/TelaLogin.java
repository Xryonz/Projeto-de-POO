package com.cad.despacho.telas;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaLogin {

    public StackPane criar(Stage janela) {

        StackPane raiz = new StackPane();
        raiz.getStyleClass().add("login-bg");
        raiz.setPrefSize(1440, 900);

        VBox card = new VBox(24);
        card.getStyleClass().add("login-card");
        card.setAlignment(Pos.TOP_CENTER);
        card.setMaxWidth(420);
        card.setMaxHeight(Region.USE_PREF_SIZE);

        VBox topo = new VBox(16);
        topo.setAlignment(Pos.CENTER);
        StackPane badge = new StackPane();
        badge.getStyleClass().add("brand-badge");
        Label glifo = new Label("CAD");
        glifo.getStyleClass().add("brand-badge-glyph");
        badge.getChildren().add(glifo);
        Label titulo = new Label("SISTEMA CAD");
        titulo.getStyleClass().add("brand-title");
        Label subtitulo = new Label("Corpo de Bombeiros");
        subtitulo.getStyleClass().add("brand-subtitle");
        topo.getChildren().add(badge);
        topo.getChildren().add(titulo);
        topo.getChildren().add(subtitulo);

        Region linha = new Region();
        linha.getStyleClass().add("divisor");
        linha.setPrefWidth(340);

        TextField campoRgCpf = new TextField();
        campoRgCpf.getStyleClass().add("input-field");
        campoRgCpf.getStyleClass().add("mono");
        campoRgCpf.setPromptText("123.456.789-10");
        VBox boxUsuario = Campo.criar("REGISTRO GERAL / CPF", campoRgCpf, "field-label");

        PasswordField campoSenha = new PasswordField();
        campoSenha.getStyleClass().add("input-field");
        campoSenha.getStyleClass().add("mono");
        campoSenha.setPromptText("****************");
        VBox boxSenha = Campo.criar("SENHA DE ACESSO TATICO", campoSenha, "field-label");

        ToggleGroup grupoPerfil = new ToggleGroup();
        ToggleButton btnDespachante = Botoes.criarToggle("Despachante", grupoPerfil, "role-toggle");
        ToggleButton btnSupervisor = Botoes.criarToggle("Supervisor", grupoPerfil, "role-toggle");
        btnDespachante.setSelected(true);
        HBox boxRoles = new HBox(btnDespachante, btnSupervisor);
        VBox boxPerfil = Campo.criar("PERFIL DE OPERACAO", boxRoles, "field-label");

        VBox formulario = new VBox(20);
        formulario.getChildren().add(boxUsuario);
        formulario.getChildren().add(boxSenha);
        formulario.getChildren().add(boxPerfil);

        Button btnEntrar = new Button("AUTENTICAR NO CONSOLE");
        btnEntrar.getStyleClass().add("btn-primary");
        btnEntrar.setMaxWidth(Double.MAX_VALUE);
        btnEntrar.setDefaultButton(true);
        btnEntrar.setOnAction(e -> {
            TelaPrincipal telaPrincipal = new TelaPrincipal();
            Scene cena = new Scene(telaPrincipal.criar(), 1440, 900);
            cena.getStylesheets().add(getClass().getResource("/com/cad/despacho/estilo.css").toExternalForm());
            janela.setScene(cena);
        });

        card.getChildren().add(topo);
        card.getChildren().add(linha);
        card.getChildren().add(formulario);
        card.getChildren().add(btnEntrar);

        raiz.getChildren().add(card);

        return raiz;
    }
}
