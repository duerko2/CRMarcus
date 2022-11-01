package org.marcus.crm.controller;

import org.marcus.crm.model.CustomerTab;
import org.marcus.crm.model.LeftTab;
import org.marcus.crm.model.LeftTabs;

import java.util.ArrayList;
import java.util.List;

public class CustomerController {
    private AppController appController;
    private LeftTabs customerTabs;
    public CustomerController(AppController appController){
        this.appController=appController;


        List<LeftTab>leftTabs=new ArrayList<>();
        leftTabs.add(new CustomerTab("All Customers"));
        customerTabs = new LeftTabs(leftTabs);

        // Sets the selected tab to the first tab
        setCurrentTab(customerTabs.getTabs().get(0));
    }

    public LeftTabs getCustomerTabs() {
        return customerTabs;
    }

    public void setCurrentTab(LeftTab leftTab) {
        customerTabs.setCurrentTab(leftTab);
    }
}
