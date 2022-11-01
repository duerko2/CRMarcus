package org.marcus.crm.model;

public class CustomerTab extends LeftTab{
    public CustomerTab(String tabName) {
        super(tabName);
    }

    @Override
    public String getTabName() {
        return this.tabName;
    }

    @Override
    public void setTabName(String tabName) {
        this.tabName=tabName;
    }

}
