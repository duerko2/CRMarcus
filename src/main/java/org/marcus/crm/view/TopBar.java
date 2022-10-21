package org.marcus.crm.view;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import org.marcus.crm.controller.AppController;

public class TopBar extends TabPane {
    private AppController appController;
    private Tab home;
    private Tab customers;
    private Tab orders;
    private Tab brands;

    TopBar(AppController appController){
        this.appController=appController;

        home = new Tab("Home");
        home.closableProperty().set(false);
        home.onSelectionChangedProperty().set(e->
                appController.home()
        );


        customers = new Tab("Customers");
        customers.closableProperty().set(false);
        customers.onSelectionChangedProperty().set(e->
                appController.seeCustomers()
        );


        orders = new Tab("Orders");
        orders.closableProperty().set(false);
        orders.onSelectionChangedProperty().set(e->
                appController.seeOrders()
        );


        brands = new Tab("Brands");
        brands.closableProperty().set(false);
        brands.onSelectionChangedProperty().set(e->
                appController.seeBrands()
        );

        this.getTabs().add(home);
        this.getTabs().add(customers);
        this.getTabs().add(orders);
        this.getTabs().add(brands);

    }

}
