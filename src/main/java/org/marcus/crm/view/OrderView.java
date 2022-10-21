package org.marcus.crm.view;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import org.marcus.crm.model.Customer;
import org.marcus.crm.model.Order;

import java.util.List;

public class OrderView extends VBox {

    private TableView table = new TableView();
    private final ObservableList<Order> data = FXCollections.observableArrayList();
        private Label label = new Label("All Orders");


        public OrderView(List<Order> orderList){

            for(int i=0;i<orderList.size();i++){
                data.add(orderList.get(i));
            }


            table.setEditable(true);

            TableColumn numCol = new TableColumn("Order Number");
            numCol.setMinWidth(100);
            numCol.setCellValueFactory(
                    new PropertyValueFactory<Order, Integer>("orderNum"));

            TableColumn nameCol = new TableColumn("Customer Name");
            nameCol.setMinWidth(100);
            nameCol.setCellValueFactory(new PropertyValueFactory("customer"));


            TableColumn countryCol = new TableColumn("Amount");
            countryCol.setMinWidth(100);
            countryCol.setCellValueFactory(
                    new PropertyValueFactory<Order, Integer>("amount"));

            TableColumn salesRepCol = new TableColumn("Currency");
            salesRepCol.setMinWidth(100);
            salesRepCol.setCellValueFactory(
                    new PropertyValueFactory<Order, String>("currencyName"));



            table.setItems(data);
            table.getColumns().addAll(numCol, nameCol, countryCol,salesRepCol);


            table.setOnMouseClicked(mouseEvent -> {
                if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                    if(mouseEvent.getClickCount() == 2){
                        Customer selectedCustomer = (Customer)table.getSelectionModel().getSelectedItem();
                        //TODO: When double clicked should open window showing details about customer... prev order etc.
                        System.out.println("Double clicked"+selectedCustomer.getAccountName());
                    }
                }
            });

            getChildren().addAll(label,table);


        }
}
