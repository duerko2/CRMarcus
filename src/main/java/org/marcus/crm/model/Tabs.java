package org.marcus.crm.model;

import org.marcus.crm.observer.Subject;

public class Tabs extends Subject {
    private Tab currentTab;

    public Tabs(){
    }

    public void setCurrentTab(Tab currentTab) {
        this.currentTab = currentTab;
        notifyChange();
    }

    public Tab getCurrentTab() {
        return currentTab;
    }
}
