package org.marcus.crm;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.marcus.crm.model.Customer;
import org.marcus.crm.view.CustomersView;
import org.marcus.crm.view.InsertView;
import org.marcus.crm.client.HTTPRequest;
import org.marcus.crm.controller.AppController;
import org.marcus.crm.view.BasicView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class CRM extends Application{
    private static final int MIN_APP_WIDTH = 1000;
    private static final int MIN_APP_HEIGHT = 800;


    private Stage stage;
    private BorderPane viewRoot;
    private AppController appController;


    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;

        appController = new AppController(this);

        // create the primary scene with the a menu bar and a pane for
        // the board view (which initially is empty); it will be filled
        // when the user creates a new game or loads a game
        BasicView basicView = new BasicView(appController);
        appController.home();
        viewRoot = new BorderPane();
        VBox vbox = new VBox(basicView, viewRoot);
        vbox.setMinWidth(MIN_APP_WIDTH);
        vbox.setMinHeight(MIN_APP_HEIGHT);
        Scene primaryScene = new Scene(vbox);

        stage.setScene(primaryScene);
        stage.setTitle("CRMarcus");
        stage.setOnCloseRequest(
                e -> {
                    e.consume();
                    appController.exit();} );
        stage.setResizable(false);
        stage.sizeToScene();
        stage.show();
    }

    public void createInsertView(){
        viewRoot.getChildren().clear();
        InsertView insertView = new InsertView(appController.getInsertController());
        viewRoot.setCenter(insertView);
        stage.sizeToScene();
    }

    public void removeInsertView() {
        viewRoot.getChildren().clear();
        stage.sizeToScene();
    }



    public static void main(String[] args){
        launch(args);
    }



}
