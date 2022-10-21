package org.marcus.crm.controller;

import org.marcus.crm.CRM;
import org.marcus.crm.model.Tab;
import org.marcus.crm.model.Tabs;

public class AppController {
    private CRM crm;
    private InsertController insertController;

    private Tabs tabs;

    public AppController(CRM crm){
        this.crm=crm;
        insertController= new InsertController(this);
        this.tabs = new Tabs();
        tabs.setCurrentTab(Tab.HOME);
    }

    public void exit(){
        System.exit(0);
    }

    public InsertController getInsertController() {
        return insertController;
    }

    public void addCustomer() {
        crm.createInsertView();
    }

    public void seeCustomers() {
        tabs.setCurrentTab(Tab.CUSTOMERS);
    }

    public void removeInsertView() {
        crm.removeInsertView();
    }

    public void seeOrders() {
        tabs.setCurrentTab(Tab.ORDERS);
    }

    public void seeBrands() {
        tabs.setCurrentTab(Tab.BRANDS);
    }

    public void home() {
        tabs.setCurrentTab(Tab.HOME);
    }

    public Tabs getTabs() {
        return tabs;
    }
}
