package org.marcus.crm.model;

public class Customer {
    int accountNo;
    String accountName;
    String country;
    int salesRepId;

    public Customer(int accountNo,
                    String accountName,
                    String country,
                    int salesRepId){
        this.accountName=accountName;
        this.accountNo=accountNo;
        this.salesRepId=salesRepId;
        this.country=country;
    }

    public Customer(String accountName,
                    String country,
                    int salesRepId){
        this.accountName=accountName;
        this.salesRepId=salesRepId;
        this.country=country;
    }

    public String getAccountName() {
        return accountName;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public int getSalesRepId() {
        return salesRepId;
    }

    public String getCountry() {
        return country;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setSalesRepId(int salesRepId) {
        this.salesRepId = salesRepId;
    }

    @Override
    public String toString() {
        return accountName;
    }
}
