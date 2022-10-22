package org.marcus.crm.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import org.marcus.crm.client.HTTPRequest;
import org.marcus.crm.controller.AppController;
import org.marcus.crm.observer.Observer;
import org.marcus.crm.observer.Subject;

import java.io.IOException;
import java.sql.SQLException;

public class MiddleView extends VBox implements ViewObserver {
    AppController appController;
    public MiddleView(AppController appController) {
        this.appController=appController;
        appController.getTabs().attach(this);
    }

    @Override
    public void updateView(Subject subject) {
        this.getChildren().clear();
        switch(appController.getTabs().getCurrentTab()){
            case HOME -> {
                getChildren().add(new DashBoard());
                break;
            }
            case BRANDS -> {
                BrandView brandView = new BrandView();
                brandView.alignmentProperty().set(Pos.CENTER);
                getChildren().add(brandView);
                break;
            }
            case ORDERS -> {
                try {
                    getChildren().add(new OrderView(HTTPRequest.getOrders()));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
            case CUSTOMERS -> {
                try {
                    getChildren().add(new CustomersView(HTTPRequest.getCustomers(),appController.getCustomerContoller()));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            }


        }
    }
}
