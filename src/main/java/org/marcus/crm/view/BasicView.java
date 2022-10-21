package org.marcus.crm.view;

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
    private Pane filler;
    private TabPane topBar;
    private VBox leftBar;
    private VBox middleView;

    public BasicView(AppController appController) {
        this.appController=appController;



        filler = new Pane();
        filler.setMinWidth(100);


        topBar = new TopBar(appController);
        topBar.setMinWidth(500);





        leftBar = new LeftBar(appController);
        leftBar.setPrefWidth(100);
        leftBar.setMaxWidth(100);


        middleView = new MiddleView(appController);



        HBox left = new HBox();

        left.getChildren().add(leftBar);

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
