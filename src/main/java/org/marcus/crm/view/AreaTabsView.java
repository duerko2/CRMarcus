package org.marcus.crm.view;

import javafx.scene.control.Alert;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import org.marcus.crm.client.HTTPRequest;
import org.marcus.crm.controller.BrandController;
import org.marcus.crm.model.AreaTab;
import org.marcus.crm.observer.Subject;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AreaTabsView extends TabPane implements ViewObserver{
    BrandController brandController;

    public AreaTabsView(BrandController brandController) {
        this.brandController = brandController;
        brandController.getBrandTabs().attach(this);
    }

    @Override
    public void updateView(Subject subject) {
        getTabs().clear();
        if(!brandController.getBrandTabs().isAddTab()) {
            for (AreaTab areaTab : brandController.getAreaTabs().getTabs()) {
                Tab newTab = new Tab(areaTab.getTabName());
                newTab.closableProperty().set(false);
                newTab.onSelectionChangedProperty().set(e->{if(newTab.isSelected()) brandController.setCurrentArea(areaTab);});
                getTabs().add(newTab);
            }
        }


    }
}

