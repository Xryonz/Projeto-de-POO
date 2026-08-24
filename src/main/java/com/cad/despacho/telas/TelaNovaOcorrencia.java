package com.cad.despacho.telas;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class TelaNovaOcorrencia {

    public VBox criar(TelaPrincipal pai) {

        VBox raiz = new VBox(24);
        raiz.getChildren().add(Cabecalho.criar("REGISTRAR NOVA OCORRENCIA"));

        HBox conteudo = new HBox(24);
        VBox.setVgrow(conteudo, Priority.ALWAYS);

        VBox formulario = montarFormulario();
        HBox.setHgrow(formulario, Priority.ALWAYS);

        VBox recursos = montarRecursos();

        conteudo.getChildren().add(formulario);
        conteudo.getChildren().add(recursos);

        raiz.getChildren().add(conteudo);

        return raiz;
    }

    VBox montarFormulario() {

        VBox card = new VBox(20);
        card.getStyleClass().add("card");

        Label tituloCard = new Label("DADOS DO EVENTO / SINISTRO");
        tituloCard.getStyleClass().add("card-title");

        ComboBox<String> comboTipo = new ComboBox<>();
        comboTipo.getItems().add("Incendio Comercial");
        comboTipo.getItems().add("Incendio Residencial");
        comboTipo.getItems().add("Incendio Florestal");
        comboTipo.getItems().add("Colisao de Veiculos");
        comboTipo.getItems().add("Atendimento Clinico");
        comboTipo.setValue("Incendio Comercial");
        comboTipo.setMaxWidth(Double.MAX_VALUE);
        comboTipo.getStyleClass().add("input-field");
        VBox campoTipoBox = criarCampo("TIPO DE OCORRENCIA", comboTipo);
        HBox.setHgrow(campoTipoBox, Priority.ALWAYS);

        ToggleGroup grupoPrioridade = new ToggleGroup();
        ToggleButton btnAlta = new ToggleButton("ALTA");
        ToggleButton btnMedia = new ToggleButton("MEDIA");
        ToggleButton btnBaixa = new ToggleButton("BAIXA");
        btnAlta.getStyleClass().add("priority-btn");
        btnMedia.getStyleClass().add("priority-btn");
        btnBaixa.getStyleClass().add("priority-btn");
        btnAlta.setToggleGroup(grupoPrioridade);
        btnMedia.setToggleGroup(grupoPrioridade);
        btnBaixa.setToggleGroup(grupoPrioridade);
        btnAlta.setMaxWidth(Double.MAX_VALUE);
        btnMedia.setMaxWidth(Double.MAX_VALUE);
        btnBaixa.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(btnAlta, Priority.ALWAYS);
        HBox.setHgrow(btnMedia, Priority.ALWAYS);
        HBox.setHgrow(btnBaixa, Priority.ALWAYS);
        btnAlta.setSelected(true);
        HBox boxPrioridade = new HBox(8, btnAlta, btnMedia, btnBaixa);
        VBox campoPrioridadeBox = criarCampo("PRIORIDADE TATICA", boxPrioridade);
        HBox.setHgrow(campoPrioridadeBox, Priority.ALWAYS);

        HBox linha1 = new HBox(16, campoTipoBox, campoPrioridadeBox);

        TextField campoLocal = new TextField();
        campoLocal.getStyleClass().add("input-field");
        campoLocal.setPromptText("Rua, numero - Bairro, Cidade/UF");
        VBox campoLocalBox = criarCampo("LOCALIZACAO", campoLocal);

        TextField campoDataHora = new TextField();
        campoDataHora.getStyleClass().add("input-field");
        campoDataHora.getStyleClass().add("mono");
        campoDataHora.setText("09/05/2026 - 14:15");
        campoDataHora.setEditable(false);
        VBox campoDataBox = criarCampo("DATA E HORA DO REGISTRO", campoDataHora);
        campoDataBox.setPrefWidth(220);

        TextField campoSolicitante = new TextField();
        campoSolicitante.getStyleClass().add("input-field");
        campoSolicitante.setPromptText("Nome (obs) e telefone");
        VBox campoSolicitanteBox = criarCampo("SOLICITANTE / CONTATO", campoSolicitante);
        HBox.setHgrow(campoSolicitanteBox, Priority.ALWAYS);

        HBox linha3 = new HBox(16, campoDataBox, campoSolicitanteBox);

        TextArea campoDescricao = new TextArea();
        campoDescricao.getStyleClass().add("input-field");
        campoDescricao.setPrefRowCount(3);
        campoDescricao.setWrapText(true);
        campoDescricao.setPromptText("Descreve ai o que foi relatado...");
        VBox campoDescricaoBox = criarCampo("DESCRICAO INICIAL DA OCORRENCIA", campoDescricao);

        card.getChildren().add(tituloCard);
        card.getChildren().add(linha1);
        card.getChildren().add(campoLocalBox);
        card.getChildren().add(linha3);
        card.getChildren().add(campoDescricaoBox);

        HBox linhaBotao = new HBox();
        linhaBotao.setAlignment(Pos.CENTER_RIGHT);
        Button btnRegistrar = new Button("Registrar e Despachar");
        btnRegistrar.getStyleClass().add("btn-primary");
        linhaBotao.getChildren().add(btnRegistrar);

        VBox formularioCompleto = new VBox(24);
        formularioCompleto.getChildren().add(card);
        formularioCompleto.getChildren().add(linhaBotao);
        return formularioCompleto;
    }

    VBox criarCampo(String texto, Node campo) {
        Label label = new Label(texto);
        label.getStyleClass().add("field-label-muted");
        VBox box = new VBox(8);
        box.getChildren().add(label);
        box.getChildren().add(campo);
        return box;
    }

    VBox montarRecursos() {

        VBox painel = new VBox(20);
        painel.getStyleClass().add("card");
        painel.setPrefWidth(380);
        painel.setMinWidth(380);

        Label titulo = new Label("VIATURAS DISPONIVEIS");
        titulo.getStyleClass().add("card-title");

        VBox lista = new VBox(12);
        lista.getChildren().add(criarLinhaViatura("ABTR-05", true));
        lista.getChildren().add(criarLinhaViatura("ASU-12", true));
        lista.getChildren().add(criarLinhaViatura("AT-03", true));
        lista.getChildren().add(criarLinhaViatura("UR-03", true));
        lista.getChildren().add(criarLinhaViatura("ASU-01", false));
        lista.getChildren().add(criarLinhaViatura("ABTR-02", false));

        painel.getChildren().add(titulo);
        painel.getChildren().add(lista);
        return painel;
    }

    HBox criarLinhaViatura(String codigo, boolean disponivel) {

        HBox linha = new HBox(12);
        linha.getStyleClass().add("suggestion-card");
        linha.setAlignment(Pos.CENTER_LEFT);

        CheckBox check = new CheckBox();
        if (disponivel == false) {
            check.setDisable(true);
        }

        String texto = codigo;
        if (disponivel == false) {
            texto = texto + "  (indisponivel)";
        }
        Label label = new Label(texto);
        label.getStyleClass().add("suggestion-code");
        label.getStyleClass().add("mono");

        linha.getChildren().add(check);
        linha.getChildren().add(label);

        if (disponivel == false) {
            linha.getStyleClass().add("suggestion-unavailable");
        }

        return linha;
    }
}
