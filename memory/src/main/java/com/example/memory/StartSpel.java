package com.example.memory;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class StartSpel extends Application {


    public void start(Stage mijnStartSpelStage) throws IOException {
        //Nodes aanmaken
        Text txtStartSpel = new Text("Start Spel");
        txtStartSpel.setFont(Font.font("Arial", 30));

        Label lblSpelerNaam = new Label("Naam Speler :");
        TextField txtfldSpelerNaam = new TextField("");
        lblSpelerNaam.setFont(Font.font("Arial", 15));

        Button btnAnnuleren = new Button("Annuleren");
        Button btnStartSpel = new Button("Start Spel");

        //Layout Buttons

        btnAnnuleren.setPrefSize(100, 40);
        btnStartSpel.setPrefSize(100, 40);

        btnAnnuleren.setFont(Font.font("Arial", 13));
        btnAnnuleren.setStyle("-fx-background-color: #E76F51; -fx-text-fill: white;");

        btnStartSpel.setFont(Font.font("Arial", 13));
        btnStartSpel.setStyle("-fx-background-color: #E76F51; -fx-text-fill: white;");

        //Nodes in Panes zetten
        VBox HoofdingVBox = new VBox();
        HoofdingVBox.getChildren().addAll(txtStartSpel);
        HoofdingVBox.setAlignment(Pos.CENTER);

        HBox SpelerNaamHBox = new HBox(10);
        SpelerNaamHBox.getChildren().addAll(lblSpelerNaam, txtfldSpelerNaam);
        SpelerNaamHBox.setAlignment(Pos.CENTER);

        HBox buttonHBox = new HBox(10);
        buttonHBox.getChildren().addAll(btnAnnuleren, btnStartSpel);
        buttonHBox.setAlignment(Pos.CENTER);

        //Alle content in een Main Pane zetten
        VBox MainVBox = new VBox(20);
        MainVBox.getChildren().addAll(HoofdingVBox, SpelerNaamHBox, buttonHBox);
        MainVBox.setScaleX(1.2);
        MainVBox.setScaleY(1.2);
        MainVBox.setAlignment(Pos.CENTER);

        //MainVbox op Scene zetten
        Scene sceneStartSpel = new Scene(MainVBox);


        //Scene op Stage zetten
        mijnStartSpelStage.setScene(sceneStartSpel);
        mijnStartSpelStage.setFullScreen(true);
        mijnStartSpelStage.show();


    }


}
