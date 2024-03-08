package com.example.memory;

import com.example.memory.view.home.HomePresenter;
import com.example.memory.view.home.HomeView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
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

        // Iets Groter scherm
//        primaryStage.setMinHeight(750);
//        primaryStage.setMinWidth(1200);

        Image icon = new Image("icon.jpg");
        primaryStage.getIcons().add(icon);

        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}