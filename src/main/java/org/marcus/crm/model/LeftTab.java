package org.marcus.crm.model;

public abstract class LeftTab {
    String tabName;

    public LeftTab(String tabName){
        this.tabName=tabName;
    }
    public abstract String getTabName();

    public abstract void  setTabName(String tabName);

}
