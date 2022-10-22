package org.marcus.crm.controller;

import org.marcus.crm.model.CustomerTab;
import org.marcus.crm.model.CustomerTabs;

public class CustomerController {
    private AppController appController;
    private CustomerTabs customerTabs;
    public CustomerController(AppController appController){
        this.appController=appController;
        customerTabs = new CustomerTabs();
        customerTabs.setCurrentTab(CustomerTab.ALLCUSTOMERS);
    }

    public CustomerTabs getCustomerTabs() {
        return customerTabs;
    }
}
