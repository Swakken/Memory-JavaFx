package com.example.memory;

import com.example.memory.view.home.HomeView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        HomeView view = new HomeView();
        Scene scene = new Scene(view);
        primaryStage.setScene(scene);
        scene.getStylesheets().add("/stylesheets/home.css");

        primaryStage.setTitle("Memory");
//        primaryStage.setFullScreen(true);
        primaryStage.setMinHeight(500);
        primaryStage.setMinWidth(500);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}



