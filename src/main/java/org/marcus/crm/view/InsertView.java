package org.marcus.crm.view;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.marcus.crm.controller.InsertController;

import java.io.IOException;
import java.net.ConnectException;
import java.sql.SQLException;

public class InsertView extends VBox {
    private HBox customerHbox = new HBox();
    private HBox countryHbox= new HBox();
    private HBox salesRepHbox= new HBox();

    private Label customerLabel=new Label("Customer Name");
    private Label countryLabel=new Label("Country");
    private Label salesRepLabel=new Label("SalesRep");

    private TextField customerTextField = new TextField();
    private TextField countryTextField = new TextField();
    private TextField salesRepTextField = new TextField();

    private Button submitButton = new Button("Submit new customer");

    public InsertView(InsertController insertController){
        customerHbox.getChildren().add(customerLabel);
        customerHbox.getChildren().add(customerTextField);

        countryHbox.getChildren().add(countryLabel);
        countryHbox.getChildren().add(countryTextField);

        salesRepHbox.getChildren().add(salesRepLabel);
        salesRepHbox.getChildren().add(salesRepTextField);

        submitButton.setOnAction(e-> {
            try {
                insertController.insert(customerTextField.getText(),countryTextField.getText(),salesRepTextField.getText());
                Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                a.setContentText("Customer added");
                a.showAndWait();
                insertController.getAppController().removeInsertView();
            } catch (ConnectException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("Server unavailable");
                ex.printStackTrace();
                a.show();
                return;
            } catch (SQLException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("Cannot add this customer");
                ex.printStackTrace();
                a.show();
                return;
            } catch (IOException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("Input error");
                ex.printStackTrace();
                a.show();
                return;
            } catch (InterruptedException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("Connection timed out.");
                ex.printStackTrace();
                a.show();
            }
        });

        getChildren().add(customerHbox);
        getChildren().add(countryHbox);
        getChildren().add(salesRepHbox);
        getChildren().add(submitButton);

    }
}
