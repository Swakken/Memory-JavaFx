package com.example.memory;

import com.example.memory.Schermen.home.HomePresenter;
import com.example.memory.Schermen.home.HomeView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        HomeView view = new HomeView();
        HomePresenter presenter = new HomePresenter(view);
//        primaryStage.getIcons().add(new Image(this.getClass().getResourceAsStream("/icon.png")));


//        primaryStage.getIcons().add(new Image("/icon.png"));
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/icon.png")));
        primaryStage.getIcons().add(icon);


//        primaryStage.getIcons().add(
//                new Image(Main.class.getResourceAsStream( "/icon.png" )));

        //   primaryStage.getIcons().add(new Image("file:icon.png"));

        Scene scene = new Scene(view);
        primaryStage.setScene(scene);

//        scene.getStylesheets().add(getClass().getResource("/styleheets/home.css").toExternalForm());

        //scene.getStylesheets().add("home.css");

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



