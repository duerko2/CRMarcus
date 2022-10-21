package org.marcus.crm.view;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class DashBoard extends VBox {

    public DashBoard(){

        Button button = new Button("DASHBOARD");
        getChildren().add(button);

    }
}
