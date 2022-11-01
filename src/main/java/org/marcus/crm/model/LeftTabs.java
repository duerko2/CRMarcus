package org.marcus.crm.model;

import org.marcus.crm.observer.Subject;

import java.util.List;

public class LeftTabs extends Subject {
    private LeftTab currentTab;
    private List<LeftTab> tabs;
    private boolean isAddTab;

    public List<LeftTab> getTabs() {
        return tabs;
    }

    public LeftTabs(List<LeftTab> tabs){
        this.tabs=tabs;
    }

    public void setCurrentTab(LeftTab currentTab) {
        this.currentTab = currentTab;
        notifyChange();
    }

    public LeftTab getCurrentTab() {
        return currentTab;
    }

    public void setAddTab(Boolean bool){
        isAddTab=bool;
        notifyChange();
    }

    public Boolean isAddTab(){
        return isAddTab;
    }

    public void setTabs(List<LeftTab> leftTabs) {
        tabs=leftTabs;
        notifyChange();
    }
}
