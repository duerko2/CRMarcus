package org.marcus.crm.model;

import org.marcus.crm.observer.Subject;

import java.util.ArrayList;
import java.util.List;

public class AreaTabs extends Subject {
    private AreaTab currentTab;
    private List<AreaTab> tabs;

    public AreaTabs(){
        tabs=new ArrayList<>();
    }


    public List<AreaTab> getTabs() {
        return tabs;
    }

    public void setCurrentTab(AreaTab currentTab) {
        this.currentTab = currentTab;
        notifyChange();
    }

    public AreaTab getCurrentTab() {
        return currentTab;
    }


    public void setTabs(List<AreaTab> leftTabs) {
        tabs=leftTabs;
        notifyChange();
    }
}
