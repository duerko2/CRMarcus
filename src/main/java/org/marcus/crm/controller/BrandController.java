package org.marcus.crm.controller;

import org.marcus.crm.client.HTTPRequest;
import org.marcus.crm.model.BrandTab;
import org.marcus.crm.model.BrandTabs;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class BrandController {
    private AppController appController;
    private BrandTabs brandTabs;


    public AppController getAppController() {
        return appController;
    }

    public void setAppController(AppController appController) {
        this.appController = appController;
    }

    public BrandTabs getBrandTabs() {
        return brandTabs;
    }

    public void setBrandTabs(BrandTabs brandTabs) {
        this.brandTabs = brandTabs;
    }

    public BrandController(AppController appController){
        this.appController=appController;
        try {

            // Gets all the brands.
            brandTabs=new BrandTabs(HTTPRequest.getUniqueBrandNames());

            // Sets current tab to first on the tabs list.
            //brandTabs.setCurrentTab(brandTabs.getBrandTabs().get(0));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addBrand() {
        brandTabs.setAddTab(true);
    }

    public void chooseBrand(String brandName) {
    }
}
