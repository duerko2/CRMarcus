package org.marcus.crm.model;

import org.marcus.crm.observer.Subject;

import java.util.List;

public class BrandTabs extends Subject {

    private List<BrandTab> brandTabs;
    private BrandTab currentTab;
    private Boolean addTab=false;

    public BrandTabs(List<BrandTab> brandTabs) {
        this.brandTabs = brandTabs;
    }

    public List<BrandTab> getBrandTabs() {
        return brandTabs;
    }


    public BrandTab getCurrentTab() {
        return currentTab;
    }

    public void setCurrentTab(BrandTab currentTab) {
        this.currentTab = currentTab;
        addTab=false;
        notifyChange();
    }
    public void setAddTab(Boolean bool){
        this.addTab=bool;
        notifyChange();
    }
    public Boolean isAddTab(){
        return addTab;
    }
}
