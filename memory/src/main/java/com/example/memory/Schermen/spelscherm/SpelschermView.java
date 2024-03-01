package com.example.memory.Schermen.spelscherm;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class SpelschermView extends BorderPane {

    private Button btnMenu;
    private Text txtScore;



    public SpelschermView(){
        initialseNodes();
        layoutNodes();
    }

    private void initialseNodes() {
        btnMenu = new Button("Menu");
        txtScore = new Text("Score: ");
    }

    private void layoutNodes() {
        btnMenu.setPrefSize(100,40);
        btnMenu.setFont(Font.font("Arial", 13));
        btnMenu.setStyle("-fx-background-color: #E76F51; -fx-text-fill: white;");
        txtScore.setFont(Font.font("Arial", 13));


        HBox BottomHBox = new HBox();
        BottomHBox.setAlignment(Pos.BASELINE_RIGHT);
        BottomHBox.getChildren().addAll(btnMenu);
        this.setBottom(BottomHBox);


        GridPane gpSpelBord = new GridPane();
        this.setCenter(gpSpelBord);
        this.setLeft(txtScore);

        Menu menuAfsluiten = new Menu("Afsluiten");
        Menu menuInstellingen = new Menu("Instellingen");


        MenuBar menuBar = new MenuBar(menuAfsluiten, menuInstellingen);
        setTop(menuBar);
    }

}
