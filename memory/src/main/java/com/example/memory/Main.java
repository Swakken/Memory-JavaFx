package com.example.memory;

import com.example.memory.view.HomeView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        HomeView view = new HomeView();

        Scene scene = new Scene(view);
        primaryStage.setScene(scene);

        primaryStage.setTitle("Memory");
//        primaryStage.setFullScreen(true);
        primaryStage.setMinHeight(400);
        primaryStage.setMinWidth(400);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}



