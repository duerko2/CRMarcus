package org.marcus.crm.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.VBox;
import org.marcus.crm.controller.CustomerController;
import org.marcus.crm.model.Customer;
import org.marcus.crm.observer.Subject;

import java.util.List;

public class CustomersView extends VBox implements ViewObserver{
    private TableView table = new TableView();
    private final ObservableList<Customer> data = FXCollections.observableArrayList();
    private Label label = new Label("All Customers");
    private CustomerController customerController;


    public CustomersView(List<Customer> customerList, CustomerController customerController){
        this.customerController=customerController;

        for(int i=0;i<customerList.size();i++){
            data.add(customerList.get(i));
        }


        table.setEditable(true);

        TableColumn numCol = new TableColumn("Customer Number");
        numCol.setMinWidth(100);
        numCol.setCellValueFactory(
                new PropertyValueFactory<Customer, Integer>("accountNo"));

        TableColumn nameCol = new TableColumn("Customer Name");
        nameCol.setMinWidth(100);
        nameCol.setCellValueFactory(
                new PropertyValueFactory<Customer, String>("accountName"));

        TableColumn countryCol = new TableColumn("Country");
        countryCol.setMinWidth(100);
        countryCol.setCellValueFactory(
                new PropertyValueFactory<Customer, String>("country"));

        TableColumn salesRepCol = new TableColumn("Sales Rep Number");
        salesRepCol.setMinWidth(100);
        salesRepCol.setCellValueFactory(
                new PropertyValueFactory<Customer, Integer>("salesRepId"));



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

        customerController.getCustomerTabs().attach(this);
    }

    @Override
    public void updateView(Subject subject) {

    }
}
