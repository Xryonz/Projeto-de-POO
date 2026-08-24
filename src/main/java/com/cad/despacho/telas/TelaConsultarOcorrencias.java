package com.cad.despacho.telas;

import java.util.List;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class TelaConsultarOcorrencias {

    record Ocorrencia(String id, String tipo, String local, String data, String prioridadeTexto,
                       String prioridadeClasse, String statusTexto, String statusClasse, String viaturas) {
    }

    static final List<Ocorrencia> OCORRENCIAS = List.of(
            new Ocorrencia("#2026-0312", "Incendio Florestal", "Av. Santos Dumont, Km 4", "09/05 - 14:15",
                    "ALTA", "badge-alta", "EM ATENDIMENTO", "badge-atendimento", "ABTR-05, ASU-12"),
            new Ocorrencia("#2026-0311", "Colisao de Veiculos", "Rua Blumenau, 482", "09/05 - 13:58",
                    "MEDIA", "badge-media", "EM ATENDIMENTO", "badge-atendimento", "UR-03, ASU-03"),
            new Ocorrencia("#2026-0310", "Atendimento Clinico", "Rua Copacabana, 12", "09/05 - 13:40",
                    "MEDIA", "badge-media", "CONCLUIDA", "badge-concluida", "ASU-01"),
            new Ocorrencia("#2026-0309", "Incendio Residencial", "Rua XV de Novembro, 1024", "09/05 - 13:12",
                    "ALTA", "badge-alta", "CONCLUIDA", "badge-concluida", "ABTR-05, ABTR-02"),
            new Ocorrencia("#2026-0308", "Resgate de Animal", "Parque da Cidade", "09/05 - 12:45",
                    "BAIXA", "badge-baixa", "CONCLUIDA", "badge-concluida", "M-04")
    );

    public VBox criar() {

        VBox raiz = new VBox(24);
        raiz.getChildren().add(Cabecalho.criar("CONSULTA DE OCORRENCIAS"));

        VBox tabela = new VBox();
        tabela.getStyleClass().add("tabela");
        VBox.setVgrow(tabela, Priority.ALWAYS);

        tabela.getChildren().add(criarCabecalho());
        for (Ocorrencia ocorrencia : OCORRENCIAS) {
            tabela.getChildren().add(criarLinha(ocorrencia));
        }

        raiz.getChildren().add(tabela);

        return raiz;
    }

    HBox criarCabecalho() {
        HBox linha = new HBox();
        linha.getStyleClass().add("tabela-cabecalho");
        linha.getChildren().add(colunaTexto("ID", 100, true));
        linha.getChildren().add(colunaTexto("TIPO DE OCORRENCIA", 190, true));
        linha.getChildren().add(colunaTexto("LOCAL", 210, true));
        linha.getChildren().add(colunaTexto("DATA/HORA", 120, true));
        linha.getChildren().add(colunaTexto("PRIORIDADE", 110, true));
        linha.getChildren().add(colunaTexto("STATUS", 140, true));
        linha.getChildren().add(colunaTexto("VIATURAS", 160, true));
        return linha;
    }

    HBox criarLinha(Ocorrencia ocorrencia) {

        HBox linha = new HBox();
        linha.getStyleClass().add("tabela-linha");
        linha.setAlignment(Pos.CENTER_LEFT);

        linha.getChildren().add(colunaTexto(ocorrencia.id(), 100, false));
        linha.getChildren().add(colunaTexto(ocorrencia.tipo(), 190, false));
        linha.getChildren().add(colunaTexto(ocorrencia.local(), 210, false));
        linha.getChildren().add(colunaTexto(ocorrencia.data(), 120, false));

        HBox colPrioridade = new HBox(criarBadge(ocorrencia.prioridadeTexto(), ocorrencia.prioridadeClasse()));
        colPrioridade.setPrefWidth(110);
        linha.getChildren().add(colPrioridade);

        HBox colStatus = new HBox(criarBadge(ocorrencia.statusTexto(), ocorrencia.statusClasse()));
        colStatus.setPrefWidth(140);
        linha.getChildren().add(colStatus);

        linha.getChildren().add(colunaTexto(ocorrencia.viaturas(), 160, false));

        return linha;
    }

    Label colunaTexto(String texto, double largura, boolean cabecalho) {
        Label label = new Label(texto);
        label.setPrefWidth(largura);
        label.getStyleClass().add(cabecalho ? "col-cabecalho" : "col-celula");
        return label;
    }

    Label criarBadge(String texto, String classeCss) {
        Label badge = new Label(texto);
        badge.getStyleClass().add("badge");
        badge.getStyleClass().add(classeCss);
        return badge;
    }
}
