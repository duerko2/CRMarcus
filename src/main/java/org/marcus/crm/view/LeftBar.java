package org.marcus.crm.view;

import javafx.event.Event;
import javafx.event.EventHandler;
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

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class LeftBar extends TabPane implements ViewObserver {
    private AppController appController;
    private Tabs tabs;
    public LeftBar(AppController appController) {
        this.appController=appController;
        this.tabs= appController.getTabs();
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

        for(LeftTab tab : appController.getCustomerContoller().getCustomerTabs().getTabs() ){
            Tab newTab = new Tab(tab.getTabName());
            newTab.closableProperty().set(false);
            newTab.onSelectionChangedProperty().set(event -> {
                if(newTab.isSelected()){
                    appController.getCustomerContoller().getCustomerTabs().setCurrentTab(tab);
                }
            });
            getTabs().add(newTab);
        }
        appController.getCustomerContoller().setCurrentTab(appController.getCustomerContoller().getCustomerTabs().getTabs().get(0));

    }

    private void brandView(){
        getTabs().clear();
        for(LeftTab tab : appController.getBrandController().getBrandTabs().getTabs() ){
            Tab newTab = new Tab(tab.getTabName());
            newTab.closableProperty().set(false);
            newTab.onSelectionChangedProperty().set(event -> {
                if(newTab.isSelected()){
                    appController.getBrandController().setCurrentTab(tab);
                }
            });
            getTabs().add(newTab);
        }
        Tab addTab = new Tab("Add Brand");
        addTab.closableProperty().set(false);
        addTab.onSelectionChangedProperty().set(event -> {
            if(addTab.isSelected()){
                appController.getBrandController().addBrand();
            }
        });

        // Sets the first tab
        appController.getBrandController().setCurrentTab(appController.getBrandController().getBrandTabs().getTabs().get(0));
        getTabs().add(addTab);
  }
    private void homeView(){
        getTabs().clear();
    }
    private void orderView(){
        getTabs().clear();
    }
}
