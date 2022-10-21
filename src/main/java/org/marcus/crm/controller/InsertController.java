package org.marcus.crm.controller;

import org.marcus.crm.model.Customer;
import org.marcus.crm.client.HTTPRequest;

import java.io.IOException;
import java.sql.SQLException;

public class InsertController {
    private AppController appController;
    public InsertController(AppController appController){
        this.appController=appController;
    }

    public void insert(String customerName, String country, String salesRep) throws SQLException, IOException, InterruptedException {
        // Check if values are allowed
        // TODO: Add custom excetions to throw. Ex. customer name too long exception and country doesn't exist exception
        if(customerName.length()<100&&!customerName.isEmpty()&&!customerName.isBlank()&&country.length()<100&&!country.isEmpty()&&!country.isBlank()&&salesRep.length()<100&&!salesRep.isEmpty()&&!salesRep.isBlank()){


            HTTPRequest.postCustomer(new Customer(customerName,country,Integer.parseInt(salesRep)));
        }
    }

    public AppController getAppController() {
        return appController;
    }
}
