package com.example.memory;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Spelscherm extends Application {

    public void start(Stage mijnSpelschermStage) throws IOException {
        //Nodes aanmaken
        GridPane gpSpelScherm = new GridPane();


        //Pane op een Scene zetten
        Scene SpelScene = new Scene(gpSpelScherm);

        mijnSpelschermStage.setScene(SpelScene);
        mijnSpelschermStage.show();




    }

}
