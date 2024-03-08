package com.example.memory.view.home;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class HomeView extends BorderPane {

    private Text txtTitel;
    private Button btnStartSpel;
    private Button btnHighscores;
    private Button btnHandleiding;

    private Menu menuHulp;
    private MenuItem afsluiten;
    private MenuItem instellingen;

    public HomeView() {
        initialiseNodes();
        layoutNodes();
        this.getStylesheets().add(getClass().getResource("/styleheets/home.css").toExternalForm());
    }

    private void initialiseNodes() {

        Image start = new Image("start.png", 30, 30, true, true);
        Image highscores = new Image("highscores.png", 30, 30, true, true);
        Image help = new Image("help.png", 30, 30, true, true);

        txtTitel = new Text("Memory Homepagina");
        btnStartSpel = new Button("Start Spel", new ImageView(start));
        btnHighscores = new Button("Highscores", new ImageView(highscores));
        btnHandleiding = new Button("Handleiding", new ImageView(help));

        menuHulp = new Menu("Hulp");
        afsluiten = new MenuItem("Afsluiten");
        instellingen = new MenuItem("Instellingen");

    }

    private void layoutNodes() {
        txtTitel.setFont(Font.font("Arial", 24));

        VBox buttonVBox = new VBox();
        buttonVBox.getChildren().add(txtTitel);
        txtTitel.setId("txtTitel");
        buttonVBox.getChildren().add(btnStartSpel);
        buttonVBox.getChildren().add(btnHighscores);
        buttonVBox.getChildren().add(btnHandleiding);

        buttonVBox.setAlignment(Pos.CENTER);
        buttonVBox.setSpacing(10);

        // Optie 1
        buttonVBox.setBackground(new Background(new BackgroundImage(new Image("background.jpg"), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT )));
        // Optie 2
        //buttonVBox.setBackground(new Background(new BackgroundImage(new Image("background2.jpeg"), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT )));

        setCenter(buttonVBox);

        menuHulp.getItems().addAll(afsluiten, instellingen);
        setTop(new MenuBar(menuHulp));

    }


    // Getters
    public Button getBtnStartSpel() {
        return btnStartSpel;
    }

    public Button getBtnHighscores() {
        return btnHighscores;
    }

    public Button getBtnHandleiding() {
        return btnHandleiding;
    }

}