package com.cad.despacho.telas;

import java.util.Set;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
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
        comboTipo.getItems().addAll("Incendio Comercial", "Incendio Residencial", "Incendio Florestal",
                "Colisao de Veiculos", "Atendimento Clinico");
        comboTipo.setValue("Incendio Comercial");
        comboTipo.setMaxWidth(Double.MAX_VALUE);
        comboTipo.getStyleClass().add("input-field");
        VBox campoTipoBox = Campo.criar("TIPO DE OCORRENCIA", comboTipo, "field-label-muted");
        HBox.setHgrow(campoTipoBox, Priority.ALWAYS);

        ToggleGroup grupoPrioridade = new ToggleGroup();
        ToggleButton btnAlta = Botoes.criarToggle("ALTA", grupoPrioridade, "priority-btn");
        ToggleButton btnMedia = Botoes.criarToggle("MEDIA", grupoPrioridade, "priority-btn");
        ToggleButton btnBaixa = Botoes.criarToggle("BAIXA", grupoPrioridade, "priority-btn");
        btnAlta.setSelected(true);
        HBox boxPrioridade = new HBox(8, btnAlta, btnMedia, btnBaixa);
        VBox campoPrioridadeBox = Campo.criar("PRIORIDADE TATICA", boxPrioridade, "field-label-muted");
        HBox.setHgrow(campoPrioridadeBox, Priority.ALWAYS);

        HBox linha1 = new HBox(16, campoTipoBox, campoPrioridadeBox);

        TextField campoLocal = new TextField();
        campoLocal.getStyleClass().add("input-field");
        campoLocal.setPromptText("Rua, numero - Bairro, Cidade/UF");
        VBox campoLocalBox = Campo.criar("LOCALIZACAO", campoLocal, "field-label-muted");

        TextField campoDataHora = new TextField();
        campoDataHora.getStyleClass().add("input-field");
        campoDataHora.getStyleClass().add("mono");
        campoDataHora.setText("09/05/2026 - 14:15");
        campoDataHora.setEditable(false);
        VBox campoDataBox = Campo.criar("DATA E HORA DO REGISTRO", campoDataHora, "field-label-muted");
        campoDataBox.setPrefWidth(220);

        TextField campoSolicitante = new TextField();
        campoSolicitante.getStyleClass().add("input-field");
        campoSolicitante.setPromptText("Nome (obs) e telefone");
        VBox campoSolicitanteBox = Campo.criar("SOLICITANTE / CONTATO", campoSolicitante, "field-label-muted");
        HBox.setHgrow(campoSolicitanteBox, Priority.ALWAYS);

        HBox linha3 = new HBox(16, campoDataBox, campoSolicitanteBox);

        TextArea campoDescricao = new TextArea();
        campoDescricao.getStyleClass().add("input-field");
        campoDescricao.setPrefRowCount(3);
        campoDescricao.setWrapText(true);
        campoDescricao.setPromptText("Descreve ai o que foi relatado...");
        VBox campoDescricaoBox = Campo.criar("DESCRICAO INICIAL DA OCORRENCIA", campoDescricao, "field-label-muted");

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

    VBox montarRecursos() {

        VBox painel = new VBox(20);
        painel.getStyleClass().add("card");
        painel.setPrefWidth(380);
        painel.setMinWidth(380);

        Label titulo = new Label("VIATURAS DISPONIVEIS");
        titulo.getStyleClass().add("card-title");

        ListView<String> lista = new ListView<>();
        lista.getItems().addAll("ABTR-05", "ASU-12", "AT-03", "UR-03", "ASU-01", "ABTR-02");

        Set<String> indisponiveis = Set.of("ASU-01", "ABTR-02");

        lista.setCellFactory(lv -> criarCelulaViatura(indisponiveis));
        lista.setFixedCellSize(40);
        lista.prefHeightProperty().bind(lista.fixedCellSizeProperty().multiply(lista.getItems().size()).add(2));

        painel.getChildren().add(titulo);
        painel.getChildren().add(lista);
        return painel;
    }

    ListCell<String> criarCelulaViatura(Set<String> indisponiveis) {
        return new ListCell<>() {

            final CheckBox check = new CheckBox();
            final Label label = new Label();
            final HBox linha = new HBox(12, check, label);

            {
                linha.setAlignment(Pos.CENTER_LEFT);
                label.getStyleClass().add("item-codigo");
            }

            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                getStyleClass().remove("suggestion-unavailable");
                if (empty || item == null) {
                    setGraphic(null);
                } else {
                    boolean disponivel = !indisponiveis.contains(item);
                    check.setDisable(!disponivel);
                    label.setText(disponivel ? item : item + "  (indisponivel)");
                    if (!disponivel) {
                        getStyleClass().add("suggestion-unavailable");
                    }
                    setGraphic(linha);
                }
            }
        };
    }
}
