package com.example.memory.view.home;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class HomeView extends BorderPane {

    private Text txtTitel;
    private Button btnStartSpel;
    private Button btnHighscores;
    private Button btnHandleiding;

    private MenuItem menuAfsluiten;
    private MenuItem menuInstellingen;

    public HomeView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        txtTitel = new Text("Memory Homepagina");
        btnStartSpel = new Button("Start Spel");
        btnHighscores = new Button("Highscores");
        btnHandleiding = new Button("Handleiding");

        btnStartSpel.setStyle("-fx-background-color: green;");

        menuAfsluiten = new MenuItem();
        menuInstellingen = new MenuItem();
    }

    public Button getBtnStartSpel() {
        return btnStartSpel;
    }

    public Button getBtnHighscores() {
        return btnHighscores;
    }

    public Button getBtnHandleiding() {
        return btnHandleiding;
    }

    private void layoutNodes() {
        txtTitel.setFont(Font.font("Arial", 24));
        btnStartSpel.setPrefSize(200, 100);
        btnHighscores.setPrefSize(200, 100);
        btnHandleiding.setPrefSize(200, 100);

        Menu menuAfsluiten = new Menu("Afsluiten");
        Menu menuInstellingen = new Menu("Instellingen");

        MenuBar menuBar = new MenuBar(menuAfsluiten, menuInstellingen);
        setTop(menuBar);

        VBox buttonVBox = new VBox();
        buttonVBox.getChildren().add(txtTitel);
        buttonVBox.getChildren().add(btnStartSpel);
        buttonVBox.getChildren().add(btnHighscores);
        buttonVBox.getChildren().add(btnHandleiding);

        buttonVBox.setAlignment(Pos.CENTER);
        setCenter(buttonVBox);

    }
}
