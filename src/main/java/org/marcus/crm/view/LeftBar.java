package org.marcus.crm.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import org.marcus.crm.controller.AppController;
import org.marcus.crm.observer.Observer;
import org.marcus.crm.observer.Subject;

public class LeftBar extends VBox implements ViewObserver {
    private AppController appController;
    private Button customers;
    private Button orders;
    private Button brands;
    public LeftBar(AppController appController) {
        this.appController=appController;

        customers = new Button("Customers");
        customers.setOnAction(values->{
            appController.seeCustomers();
        });

        orders = new Button("Orders");
        orders.setOnAction(values->{
            appController.seeOrders();
        });

        brands = new Button("Brands");
        brands.setOnAction(values->{
            appController.seeBrands();
        });

        this.getChildren().add(customers);
        this.getChildren().add(orders);
        this.getChildren().add(brands);
        this.setAlignment(Pos.TOP_CENTER);
        appController.getTabs().attach(this);
    }

    @Override
    public void updateView(Subject subject) {

    }
}
