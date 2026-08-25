package com.cad.despacho;

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
        raiz.getChildren().add(new Label("REGISTRAR NOVA OCORRENCIA"));

        VBox card = new VBox(20);

        Label tituloCard = new Label("DADOS DO EVENTO / SINISTRO");

        Label lblTipo = new Label("TIPO DE OCORRENCIA");
        ComboBox<String> comboTipo = new ComboBox<>();
        comboTipo.getItems().addAll("Incendio Comercial", "Incendio Residencial", "Incendio Florestal",
                "Colisao de Veiculos", "Atendimento Clinico");
        comboTipo.setValue("Incendio Comercial");
        comboTipo.setMaxWidth(Double.MAX_VALUE);
        VBox campoTipoBox = new VBox(8);
        campoTipoBox.getChildren().add(lblTipo);
        campoTipoBox.getChildren().add(comboTipo);
        HBox.setHgrow(campoTipoBox, Priority.ALWAYS);

        Label lblPrioridade = new Label("PRIORIDADE TATICA");
        ToggleGroup grupoPrioridade = new ToggleGroup();
        ToggleButton btnAlta = new ToggleButton("ALTA");
        btnAlta.setToggleGroup(grupoPrioridade);
        btnAlta.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(btnAlta, Priority.ALWAYS);
        btnAlta.setSelected(true);
        ToggleButton btnMedia = new ToggleButton("MEDIA");
        btnMedia.setToggleGroup(grupoPrioridade);
        btnMedia.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(btnMedia, Priority.ALWAYS);
        ToggleButton btnBaixa = new ToggleButton("BAIXA");
        btnBaixa.setToggleGroup(grupoPrioridade);
        btnBaixa.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(btnBaixa, Priority.ALWAYS);
        HBox boxPrioridade = new HBox(8, btnAlta, btnMedia, btnBaixa);
        VBox campoPrioridadeBox = new VBox(8);
        campoPrioridadeBox.getChildren().add(lblPrioridade);
        campoPrioridadeBox.getChildren().add(boxPrioridade);
        HBox.setHgrow(campoPrioridadeBox, Priority.ALWAYS);

        HBox linha1 = new HBox(16, campoTipoBox, campoPrioridadeBox);

        Label lblLocal = new Label("LOCALIZACAO");
        TextField campoLocal = new TextField();
        campoLocal.setPromptText("Rua, numero - Bairro, Cidade/UF");
        VBox campoLocalBox = new VBox(8);
        campoLocalBox.getChildren().add(lblLocal);
        campoLocalBox.getChildren().add(campoLocal);

        Label lblData = new Label("DATA E HORA DO REGISTRO");
        TextField campoDataHora = new TextField();
        campoDataHora.setText("09/05/2026 - 14:15");
        campoDataHora.setEditable(false);
        VBox campoDataBox = new VBox(8);
        campoDataBox.getChildren().add(lblData);
        campoDataBox.getChildren().add(campoDataHora);
        campoDataBox.setPrefWidth(220);

        Label lblSolicitante = new Label("SOLICITANTE / CONTATO");
        TextField campoSolicitante = new TextField();
        campoSolicitante.setPromptText("Nome (obs) e telefone");
        VBox campoSolicitanteBox = new VBox(8);
        campoSolicitanteBox.getChildren().add(lblSolicitante);
        campoSolicitanteBox.getChildren().add(campoSolicitante);
        HBox.setHgrow(campoSolicitanteBox, Priority.ALWAYS);

        HBox linha3 = new HBox(16, campoDataBox, campoSolicitanteBox);

        Label lblDescricao = new Label("DESCRICAO INICIAL DA OCORRENCIA");
        TextArea campoDescricao = new TextArea();
        campoDescricao.setPrefRowCount(3);
        campoDescricao.setWrapText(true);
        campoDescricao.setPromptText("Descreve ai o que foi relatado...");
        VBox campoDescricaoBox = new VBox(8);
        campoDescricaoBox.getChildren().add(lblDescricao);
        campoDescricaoBox.getChildren().add(campoDescricao);

        card.getChildren().add(tituloCard);
        card.getChildren().add(linha1);
        card.getChildren().add(campoLocalBox);
        card.getChildren().add(linha3);
        card.getChildren().add(campoDescricaoBox);

        HBox linhaBotao = new HBox();
        linhaBotao.setAlignment(Pos.CENTER_RIGHT);
        Button btnRegistrar = new Button("Registrar e Despachar");
        linhaBotao.getChildren().add(btnRegistrar);

        VBox formulario = new VBox(24);
        formulario.getChildren().add(card);
        formulario.getChildren().add(linhaBotao);
        HBox.setHgrow(formulario, Priority.ALWAYS);

        VBox painel = new VBox(20);
        painel.setPrefWidth(380);
        painel.setMinWidth(380);

        Label tituloViaturas = new Label("VIATURAS DISPONIVEIS");

        Set<String> indisponiveis = Set.of("ASU-01", "ABTR-02");

        ListView<String> lista = new ListView<>();
        lista.getItems().addAll("ABTR-05", "ASU-12", "AT-03", "UR-03", "ASU-01", "ABTR-02");
        lista.setCellFactory(lv -> new ListCell<String>() {

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
        });
        lista.setFixedCellSize(32);
        lista.prefHeightProperty().bind(lista.fixedCellSizeProperty().multiply(lista.getItems().size()).add(2));

        painel.getChildren().add(tituloViaturas);
        painel.getChildren().add(lista);

        HBox conteudo = new HBox(24, formulario, painel);
        VBox.setVgrow(conteudo, Priority.ALWAYS);

        raiz.getChildren().add(conteudo);

        return raiz;
    }
}
