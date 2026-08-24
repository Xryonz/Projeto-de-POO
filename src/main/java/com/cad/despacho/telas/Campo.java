package com.cad.despacho.telas;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Campo {

    public static VBox criar(String rotulo, Node controle) {

        Label label = new Label(rotulo);

        VBox box = new VBox(8);
        box.getChildren().add(label);
        box.getChildren().add(controle);

        return box;
    }
}
