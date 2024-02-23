package com.example.memory.view;

import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class HomeView extends BorderPane {

    private Text txtTitel;
    private Button btnStartSpel;
    private Button btnHighscores;
    private Button btnHandleiding;


    private void initialiseNodes() {
        txtTitel = new Text("Memory Homepagina");
        btnStartSpel = new Button("Start Spel");
        btnHighscores = new Button("Highscores");
        btnHandleiding = new Button("Handleiding");
//        Button btnInstellingen = new Button("Instellingen");
//        Button btnAfsluiten = new Button("Afsluiten");
    }

    private void layoutNodes() {
        txtTitel.setFont(Font.font("Arial", 24));
        btnStartSpel.setPrefSize(200,100);
        btnHighscores.setPrefSize(200,100);
        btnHandleiding.setPrefSize(200,100);

//        btnInstellingen.setPrefSize(200,100);
//        btnAfsluiten.setPrefSize(200,100);


    }
}
