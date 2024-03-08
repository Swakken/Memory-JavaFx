package com.example.memory;

import com.example.memory.Schermen.home.HomePresenter;
import com.example.memory.Schermen.home.HomeView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        HomeView view = new HomeView();
        HomePresenter presenter = new HomePresenter(view);

        Scene scene = new Scene(view);
        primaryStage.setScene(scene);




        primaryStage.setTitle("Memory");
//        primaryStage.setFullScreen(true);
        primaryStage.setMinHeight(600);
        primaryStage.setMinWidth(650);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}