package org.marcus.crm.controller;

import org.marcus.crm.client.HTTPRequest;
import org.marcus.crm.model.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class BrandController {
    private AppController appController;
    private LeftTabs brandTabs;



    private AreaTabs areaTabs;


    public AppController getAppController() {
        return appController;
    }

    public void setAppController(AppController appController) {
        this.appController = appController;
    }

    public LeftTabs getBrandTabs() {
        return brandTabs;
    }

    public BrandController(AppController appController){
        this.appController=appController;
        areaTabs=new AreaTabs();
        try {

            // Gets all the brands.
            brandTabs=new LeftTabs(HTTPRequest.getUniqueBrandNames());

            // Sets current tab to first on the tabs list.
            //brandTabs.setCurrentTab(brandTabs.getBrandTabs().get(0));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        brandTabs.setCurrentTab(brandTabs.getTabs().get(0));
    }

    public void addBrand() {
        brandTabs.setAddTab(true);
    }


    public void setCurrentTab(LeftTab tab) {
        // Areas are updated to the current brand.
        List<String> areaNames;
        try {
            areaNames = HTTPRequest.getAreaNamesByBrand(tab.getTabName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // Empty area tab list
        areaTabs.getTabs().clear();
        // Add areas
        for(String name : areaNames){
            areaTabs.getTabs().add(new AreaTab(name));
        }

        // Sets the first tab to current tab. Will also update the view.
        areaTabs.setCurrentTab(areaTabs.getTabs().get(0));

        // Current tab is set. View will be updated.
        brandTabs.setCurrentTab(tab);
    }

    public void setCurrentArea(AreaTab currentArea) {
         areaTabs.setCurrentTab(currentArea);
    }
    public AreaTabs getAreaTabs() {
        return areaTabs;
    }

    public void setAreaTabs(AreaTabs areaTabs) {
        this.areaTabs = areaTabs;
    }
}
