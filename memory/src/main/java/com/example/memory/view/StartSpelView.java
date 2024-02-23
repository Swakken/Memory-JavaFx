package com.example.memory.view;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class StartSpelView extends VBox {
    private Text txtStartSpel;
    private Label lblSpelerNaam;
    private Button btnAnnuleren;
    private Button btnStartSpel;

    private TextField txtfldSpelerNaam;

    public StartSpelView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        txtStartSpel = new Text("Start Spel");
        lblSpelerNaam = new Label("Naam Speler :");
        btnAnnuleren = new Button("Annuleren");
        btnStartSpel = new Button("Start Spel");
        txtfldSpelerNaam = new TextField();
    }

    private void layoutNodes() {
        //Nodes in Panes zetten
        VBox hoofdingVBox = new VBox();
        hoofdingVBox.getChildren().addAll(txtStartSpel);
        hoofdingVBox.setAlignment(Pos.CENTER);
        txtStartSpel.setFont(Font.font("Arial", 30));

        HBox spelerNaamHBox = new HBox(10);
        spelerNaamHBox.getChildren().addAll(lblSpelerNaam, txtfldSpelerNaam);
        spelerNaamHBox.setAlignment(Pos.CENTER);
        lblSpelerNaam.setFont(Font.font("Arial", 15));

        HBox buttonHBox = new HBox(10);
        buttonHBox.getChildren().addAll(btnAnnuleren, btnStartSpel);
        buttonHBox.setAlignment(Pos.CENTER);


        btnAnnuleren.setPrefSize(100, 40);
        btnStartSpel.setPrefSize(100, 40);

        btnAnnuleren.setFont(Font.font("Arial", 13));
        btnAnnuleren.setStyle("-fx-background-color: #E76F51; -fx-text-fill: white;");

        btnStartSpel.setFont(Font.font("Arial", 13));
        btnStartSpel.setStyle("-fx-background-color: #E76F51; -fx-text-fill: white;");

        this.getChildren().addAll(hoofdingVBox, spelerNaamHBox, buttonHBox);
        this.setAlignment(Pos.CENTER);
        this.setScaleX(1.2);
        this.setScaleY(1.2);
        this.setSpacing(20);

        Menu menuAfsluiten = new Menu("Afsluiten");
        Menu menuInstellingen = new Menu("Instellingen");

        MenuBar menuBar = new MenuBar(menuAfsluiten, menuInstellingen);
//        setTop(menuBar);
        


    }





}
