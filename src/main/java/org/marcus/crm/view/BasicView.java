package org.marcus.crm.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import org.marcus.crm.controller.AppController;
import org.marcus.crm.observer.Observer;
import org.marcus.crm.observer.Subject;

public class BasicView extends HBox implements ViewObserver {
    private AppController appController;

    private Button addCustomer;
    private Button seeCustomers;
    private VBox filler;
    private TabPane topBar;
    private TabPane leftBar;
    private VBox middleView;

    public BasicView(AppController appController) {
        this.appController=appController;



        // Little blank box in top right corner
        filler = new VBox();
        filler.setPrefHeight(30);


        // Bar containing the tabs in the top of window
        topBar = new TopBar(appController);
        topBar.setMinWidth(500);

        // Bar containing the different options for each topbar tab. Placed on the left-most side of the window
        leftBar = new LeftBar(appController);
        leftBar.setPrefWidth(30);
        leftBar.setPrefHeight(800);


        // Main view in the middle of the window. Contains different views depending on the top tab and left option.
        middleView = new MiddleView(appController);
        middleView.setPadding(new Insets(10));
        middleView.setPrefWidth(1000);
        middleView.setPrefHeight(800);



        VBox left = new VBox();

        left.getChildren().add(filler);
        left.getChildren().add(leftBar);
        left.setPrefHeight(800);

        VBox right = new VBox();

        right.getChildren().add(topBar);
        right.getChildren().add(middleView);

        this.getChildren().addAll(left,right);
        appController.getTabs().attach(this);

    }

    @Override
    public void updateView(Subject subject) {

    }
}
