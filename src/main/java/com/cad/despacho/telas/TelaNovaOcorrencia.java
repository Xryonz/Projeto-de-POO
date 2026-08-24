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

        Label tituloCard = new Label("DADOS DO EVENTO / SINISTRO");

        ComboBox<String> comboTipo = new ComboBox<>();
        comboTipo.getItems().addAll("Incendio Comercial", "Incendio Residencial", "Incendio Florestal",
                "Colisao de Veiculos", "Atendimento Clinico");
        comboTipo.setValue("Incendio Comercial");
        comboTipo.setMaxWidth(Double.MAX_VALUE);
        VBox campoTipoBox = Campo.criar("TIPO DE OCORRENCIA", comboTipo);
        HBox.setHgrow(campoTipoBox, Priority.ALWAYS);

        ToggleGroup grupoPrioridade = new ToggleGroup();
        ToggleButton btnAlta = Botoes.criarToggle("ALTA", grupoPrioridade);
        ToggleButton btnMedia = Botoes.criarToggle("MEDIA", grupoPrioridade);
        ToggleButton btnBaixa = Botoes.criarToggle("BAIXA", grupoPrioridade);
        btnAlta.setSelected(true);
        HBox boxPrioridade = new HBox(8, btnAlta, btnMedia, btnBaixa);
        VBox campoPrioridadeBox = Campo.criar("PRIORIDADE TATICA", boxPrioridade);
        HBox.setHgrow(campoPrioridadeBox, Priority.ALWAYS);

        HBox linha1 = new HBox(16, campoTipoBox, campoPrioridadeBox);

        TextField campoLocal = new TextField();
        campoLocal.setPromptText("Rua, numero - Bairro, Cidade/UF");
        VBox campoLocalBox = Campo.criar("LOCALIZACAO", campoLocal);

        TextField campoDataHora = new TextField();
        campoDataHora.setText("09/05/2026 - 14:15");
        campoDataHora.setEditable(false);
        VBox campoDataBox = Campo.criar("DATA E HORA DO REGISTRO", campoDataHora);
        campoDataBox.setPrefWidth(220);

        TextField campoSolicitante = new TextField();
        campoSolicitante.setPromptText("Nome (obs) e telefone");
        VBox campoSolicitanteBox = Campo.criar("SOLICITANTE / CONTATO", campoSolicitante);
        HBox.setHgrow(campoSolicitanteBox, Priority.ALWAYS);

        HBox linha3 = new HBox(16, campoDataBox, campoSolicitanteBox);

        TextArea campoDescricao = new TextArea();
        campoDescricao.setPrefRowCount(3);
        campoDescricao.setWrapText(true);
        campoDescricao.setPromptText("Descreve ai o que foi relatado...");
        VBox campoDescricaoBox = Campo.criar("DESCRICAO INICIAL DA OCORRENCIA", campoDescricao);

        card.getChildren().add(tituloCard);
        card.getChildren().add(linha1);
        card.getChildren().add(campoLocalBox);
        card.getChildren().add(linha3);
        card.getChildren().add(campoDescricaoBox);

        HBox linhaBotao = new HBox();
        linhaBotao.setAlignment(Pos.CENTER_RIGHT);
        Button btnRegistrar = new Button("Registrar e Despachar");
        linhaBotao.getChildren().add(btnRegistrar);

        VBox formularioCompleto = new VBox(24);
        formularioCompleto.getChildren().add(card);
        formularioCompleto.getChildren().add(linhaBotao);
        return formularioCompleto;
    }

    VBox montarRecursos() {

        VBox painel = new VBox(20);
        painel.setPrefWidth(380);
        painel.setMinWidth(380);

        Label titulo = new Label("VIATURAS DISPONIVEIS");

        ListView<String> lista = new ListView<>();
        lista.getItems().addAll("ABTR-05", "ASU-12", "AT-03", "UR-03", "ASU-01", "ABTR-02");

        Set<String> indisponiveis = Set.of("ASU-01", "ABTR-02");

        lista.setCellFactory(lv -> criarCelulaViatura(indisponiveis));
        lista.setFixedCellSize(32);
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
            }

            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setGraphic(null);
                } else {
                    boolean disponivel = !indisponiveis.contains(item);
                    check.setDisable(!disponivel);
                    label.setText(disponivel ? item : item + "  (indisponivel)");
                    setGraphic(linha);
                }
            }
        };
    }
}
