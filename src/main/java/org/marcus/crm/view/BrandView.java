package org.marcus.crm.view;

import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import org.marcus.crm.client.HTTPRequest;
import org.marcus.crm.controller.BrandController;
import org.marcus.crm.observer.Subject;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BrandView extends VBox implements ViewObserver{
    TabPane areaTabs;
    BrandController brandController;

    public BrandView(BrandController brandController){
        this.brandController=brandController;
        areaTabs=new TabPane();
        brandController.getBrandTabs().attach(this);
    }

    @Override
    public void updateView(Subject subject) {
        getChildren().clear();
        if(!brandController.getBrandTabs().isAddTab()) {
            areaTabs.getTabs().clear();
            String currentBrand = brandController.getBrandTabs().getCurrentTab().getBrandName();

            List<String> areaNames = new ArrayList<>();

            try {
                areaNames = HTTPRequest.getAreaNamesByBrand(currentBrand);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            for (String s : areaNames) {
                Tab newTab = new Tab(s);
                newTab.closableProperty().set(false);
                //newTab.onSelectionChangedProperty().set(e->appController.getBrandController().getBrandTabs().setCurrentTab(tab));
                areaTabs.getTabs().add(newTab);
            }
            getChildren().add(areaTabs);
        }

    }
}
