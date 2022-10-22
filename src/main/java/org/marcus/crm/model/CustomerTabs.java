package org.marcus.crm.model;

import org.marcus.crm.observer.Subject;

public class CustomerTabs extends Subject {

    private CustomerTab currentTab;

    public CustomerTabs(){
    }

    public void setCurrentTab(CustomerTab currentTab) {
        this.currentTab = currentTab;
        notifyChange();
    }

    public CustomerTab getCurrentTab() {
        return currentTab;
    }
}
