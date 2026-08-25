package com.cad.despacho;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class TelaConsultarOcorrencias {

    public VBox criar() {

        VBox raiz = new VBox(24);
        raiz.getChildren().add(new Label("CONSULTA DE OCORRENCIAS"));

        VBox tabela = new VBox();
        VBox.setVgrow(tabela, Priority.ALWAYS);

        HBox cabecalho = new HBox();
        Label colId = new Label("ID");
        colId.setPrefWidth(100);
        Label colTipo = new Label("TIPO DE OCORRENCIA");
        colTipo.setPrefWidth(190);
        Label colLocal = new Label("LOCAL");
        colLocal.setPrefWidth(210);
        Label colData = new Label("DATA/HORA");
        colData.setPrefWidth(120);
        Label colPrioridade = new Label("PRIORIDADE");
        colPrioridade.setPrefWidth(110);
        Label colStatus = new Label("STATUS");
        colStatus.setPrefWidth(140);
        Label colViaturas = new Label("VIATURAS");
        colViaturas.setPrefWidth(160);
        cabecalho.getChildren().add(colId);
        cabecalho.getChildren().add(colTipo);
        cabecalho.getChildren().add(colLocal);
        cabecalho.getChildren().add(colData);
        cabecalho.getChildren().add(colPrioridade);
        cabecalho.getChildren().add(colStatus);
        cabecalho.getChildren().add(colViaturas);

        HBox linha1 = new HBox();
        linha1.setAlignment(Pos.CENTER_LEFT);
        Label l1a = new Label("#2026-0312");
        l1a.setPrefWidth(100);
        Label l1b = new Label("Incendio Florestal");
        l1b.setPrefWidth(190);
        Label l1c = new Label("Av. Santos Dumont, Km 4");
        l1c.setPrefWidth(210);
        Label l1d = new Label("09/05 - 14:15");
        l1d.setPrefWidth(120);
        Label l1e = new Label("ALTA");
        l1e.setPrefWidth(110);
        Label l1f = new Label("EM ATENDIMENTO");
        l1f.setPrefWidth(140);
        Label l1g = new Label("ABTR-05, ASU-12");
        l1g.setPrefWidth(160);
        linha1.getChildren().add(l1a);
        linha1.getChildren().add(l1b);
        linha1.getChildren().add(l1c);
        linha1.getChildren().add(l1d);
        linha1.getChildren().add(l1e);
        linha1.getChildren().add(l1f);
        linha1.getChildren().add(l1g);

        HBox linha2 = new HBox();
        linha2.setAlignment(Pos.CENTER_LEFT);
        Label l2a = new Label("#2026-0311");
        l2a.setPrefWidth(100);
        Label l2b = new Label("Colisao de Veiculos");
        l2b.setPrefWidth(190);
        Label l2c = new Label("Rua Blumenau, 482");
        l2c.setPrefWidth(210);
        Label l2d = new Label("09/05 - 13:58");
        l2d.setPrefWidth(120);
        Label l2e = new Label("MEDIA");
        l2e.setPrefWidth(110);
        Label l2f = new Label("EM ATENDIMENTO");
        l2f.setPrefWidth(140);
        Label l2g = new Label("UR-03, ASU-03");
        l2g.setPrefWidth(160);
        linha2.getChildren().add(l2a);
        linha2.getChildren().add(l2b);
        linha2.getChildren().add(l2c);
        linha2.getChildren().add(l2d);
        linha2.getChildren().add(l2e);
        linha2.getChildren().add(l2f);
        linha2.getChildren().add(l2g);

        HBox linha3 = new HBox();
        linha3.setAlignment(Pos.CENTER_LEFT);
        Label l3a = new Label("#2026-0310");
        l3a.setPrefWidth(100);
        Label l3b = new Label("Atendimento Clinico");
        l3b.setPrefWidth(190);
        Label l3c = new Label("Rua Copacabana, 12");
        l3c.setPrefWidth(210);
        Label l3d = new Label("09/05 - 13:40");
        l3d.setPrefWidth(120);
        Label l3e = new Label("MEDIA");
        l3e.setPrefWidth(110);
        Label l3f = new Label("CONCLUIDA");
        l3f.setPrefWidth(140);
        Label l3g = new Label("ASU-01");
        l3g.setPrefWidth(160);
        linha3.getChildren().add(l3a);
        linha3.getChildren().add(l3b);
        linha3.getChildren().add(l3c);
        linha3.getChildren().add(l3d);
        linha3.getChildren().add(l3e);
        linha3.getChildren().add(l3f);
        linha3.getChildren().add(l3g);

        HBox linha4 = new HBox();
        linha4.setAlignment(Pos.CENTER_LEFT);
        Label l4a = new Label("#2026-0309");
        l4a.setPrefWidth(100);
        Label l4b = new Label("Incendio Residencial");
        l4b.setPrefWidth(190);
        Label l4c = new Label("Rua XV de Novembro, 1024");
        l4c.setPrefWidth(210);
        Label l4d = new Label("09/05 - 13:12");
        l4d.setPrefWidth(120);
        Label l4e = new Label("ALTA");
        l4e.setPrefWidth(110);
        Label l4f = new Label("CONCLUIDA");
        l4f.setPrefWidth(140);
        Label l4g = new Label("ABTR-05, ABTR-02");
        l4g.setPrefWidth(160);
        linha4.getChildren().add(l4a);
        linha4.getChildren().add(l4b);
        linha4.getChildren().add(l4c);
        linha4.getChildren().add(l4d);
        linha4.getChildren().add(l4e);
        linha4.getChildren().add(l4f);
        linha4.getChildren().add(l4g);

        HBox linha5 = new HBox();
        linha5.setAlignment(Pos.CENTER_LEFT);
        Label l5a = new Label("#2026-0308");
        l5a.setPrefWidth(100);
        Label l5b = new Label("Resgate de Animal");
        l5b.setPrefWidth(190);
        Label l5c = new Label("Parque da Cidade");
        l5c.setPrefWidth(210);
        Label l5d = new Label("09/05 - 12:45");
        l5d.setPrefWidth(120);
        Label l5e = new Label("BAIXA");
        l5e.setPrefWidth(110);
        Label l5f = new Label("CONCLUIDA");
        l5f.setPrefWidth(140);
        Label l5g = new Label("M-04");
        l5g.setPrefWidth(160);
        linha5.getChildren().add(l5a);
        linha5.getChildren().add(l5b);
        linha5.getChildren().add(l5c);
        linha5.getChildren().add(l5d);
        linha5.getChildren().add(l5e);
        linha5.getChildren().add(l5f);
        linha5.getChildren().add(l5g);

        tabela.getChildren().add(cabecalho);
        tabela.getChildren().add(linha1);
        tabela.getChildren().add(linha2);
        tabela.getChildren().add(linha3);
        tabela.getChildren().add(linha4);
        tabela.getChildren().add(linha5);

        raiz.getChildren().add(tabela);

        return raiz;
    }
}
