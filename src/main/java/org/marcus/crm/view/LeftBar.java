package org.marcus.crm.view;

import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import org.marcus.crm.controller.AppController;
import org.marcus.crm.model.*;
import org.marcus.crm.observer.Observer;
import org.marcus.crm.observer.Subject;

public class LeftBar extends TabPane implements ViewObserver {
    private AppController appController;
    private Tabs tabs;
    private CustomerTabs customerTabs;
    private BrandTabs brandTabs;

    public LeftBar(AppController appController) {
        this.appController=appController;
        this.tabs= appController.getTabs();
        this.customerTabs=appController.getCustomerContoller().getCustomerTabs();
        this.brandTabs=appController.getBrandController().getBrandTabs();
        setSide(Side.LEFT);
        tabs.attach(this);
    }

    @Override
    public void updateView(Subject subject) {
        switch(appController.getTabs().getCurrentTab()){
            case CUSTOMERS -> customerView();
            case ORDERS -> orderView();
            case BRANDS -> brandView();
            case HOME -> homeView();
        }

    }
    private void customerView(){
        getTabs().clear();
        Tab customers = new Tab("All Customers");
        customers.closableProperty().set(false);
        customers.onSelectionChangedProperty().set(event -> appController.getCustomerContoller().getCustomerTabs().setCurrentTab(CustomerTab.ALLCUSTOMERS));
        Tab byCountry = new Tab("Add Customer");
        byCountry.closableProperty().set(false);
        byCountry.onSelectionChangedProperty().set(event -> appController.getCustomerContoller().getCustomerTabs().setCurrentTab(CustomerTab.ADDCUSTOMER));
        Tab byBrand = new Tab("By Brand");
        byBrand.closableProperty().set(false);
        byBrand.onSelectionChangedProperty().set(event -> appController.getCustomerContoller().getCustomerTabs().setCurrentTab(CustomerTab.BYBRAND));
        Tab byOrders = new Tab("By Orders");
        byOrders.closableProperty().set(false);
        byOrders.onSelectionChangedProperty().set(event -> appController.getCustomerContoller().getCustomerTabs().setCurrentTab(CustomerTab.BYORDERS));


        getTabs().add(customers);
        getTabs().add(byCountry);
        getTabs().add(byBrand);
        getTabs().add(byOrders);
    }
    private void brandView(){
        getTabs().clear();
        for(BrandTab tab : brandTabs.getBrandTabs() ){
            Tab newTab = new Tab(tab.getBrandName());
            newTab.closableProperty().set(false);
            newTab.onSelectionChangedProperty().set(e->brandTabs.setCurrentTab(tab));
            getTabs().add(newTab);
            System.out.println(tab.getBrandName());
        }
        Tab addTab = new Tab("Add Brand");
        addTab.closableProperty().set(false);
        addTab.onSelectionChangedProperty().set(event -> appController.getBrandController().addBrand());
        getTabs().add(addTab);

    }
    private void homeView(){
        getTabs().clear();
    }
    private void orderView(){
        getTabs().clear();
    }
}
