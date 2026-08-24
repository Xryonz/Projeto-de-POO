package com.cad.despacho.telas;

import java.util.List;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class TelaConsultarOcorrencias {

    record Ocorrencia(String id, String tipo, String local, String data, String prioridade, String status,
                       String viaturas) {
    }

    static final List<Ocorrencia> OCORRENCIAS = List.of(
            new Ocorrencia("#2026-0312", "Incendio Florestal", "Av. Santos Dumont, Km 4", "09/05 - 14:15",
                    "ALTA", "EM ATENDIMENTO", "ABTR-05, ASU-12"),
            new Ocorrencia("#2026-0311", "Colisao de Veiculos", "Rua Blumenau, 482", "09/05 - 13:58",
                    "MEDIA", "EM ATENDIMENTO", "UR-03, ASU-03"),
            new Ocorrencia("#2026-0310", "Atendimento Clinico", "Rua Copacabana, 12", "09/05 - 13:40",
                    "MEDIA", "CONCLUIDA", "ASU-01"),
            new Ocorrencia("#2026-0309", "Incendio Residencial", "Rua XV de Novembro, 1024", "09/05 - 13:12",
                    "ALTA", "CONCLUIDA", "ABTR-05, ABTR-02"),
            new Ocorrencia("#2026-0308", "Resgate de Animal", "Parque da Cidade", "09/05 - 12:45",
                    "BAIXA", "CONCLUIDA", "M-04")
    );

    public VBox criar() {

        VBox raiz = new VBox(24);
        raiz.getChildren().add(Cabecalho.criar("CONSULTA DE OCORRENCIAS"));

        VBox tabela = new VBox();
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
        linha.getChildren().add(colunaTexto("ID", 100));
        linha.getChildren().add(colunaTexto("TIPO DE OCORRENCIA", 190));
        linha.getChildren().add(colunaTexto("LOCAL", 210));
        linha.getChildren().add(colunaTexto("DATA/HORA", 120));
        linha.getChildren().add(colunaTexto("PRIORIDADE", 110));
        linha.getChildren().add(colunaTexto("STATUS", 140));
        linha.getChildren().add(colunaTexto("VIATURAS", 160));
        return linha;
    }

    HBox criarLinha(Ocorrencia ocorrencia) {

        HBox linha = new HBox();
        linha.setAlignment(Pos.CENTER_LEFT);

        linha.getChildren().add(colunaTexto(ocorrencia.id(), 100));
        linha.getChildren().add(colunaTexto(ocorrencia.tipo(), 190));
        linha.getChildren().add(colunaTexto(ocorrencia.local(), 210));
        linha.getChildren().add(colunaTexto(ocorrencia.data(), 120));
        linha.getChildren().add(colunaTexto(ocorrencia.prioridade(), 110));
        linha.getChildren().add(colunaTexto(ocorrencia.status(), 140));
        linha.getChildren().add(colunaTexto(ocorrencia.viaturas(), 160));

        return linha;
    }

    Label colunaTexto(String texto, double largura) {
        Label label = new Label(texto);
        label.setPrefWidth(largura);
        return label;
    }
}
