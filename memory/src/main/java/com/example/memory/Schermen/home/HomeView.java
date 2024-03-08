package com.example.memory.Schermen.home;

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
    private Image start;
    private Button btnHighscores;
    private Button btnHandleiding;
    private Image help;

    private Menu menuHulp;
    private MenuItem afsluiten;
    private MenuItem instellingen;

    public HomeView() {
        initialiseNodes();
        layoutNodes();
        this.getStylesheets().add(getClass().getResource("/styleheets/home.css").toExternalForm());
        this.setCustomBackground();

    }

    private void initialiseNodes() {

        start = new Image("start.png", 30, 30, true, true);
        help = new Image("help.png", 30, 30, true, true);

        txtTitel = new Text("Memory Homepagina");
        btnStartSpel = new Button("Start Spel", new ImageView(start));
        btnHighscores = new Button("Highscores");
        btnHandleiding = new Button("Handleiding", new ImageView(help));

        menuHulp = new Menu("Hulp");
        afsluiten = new MenuItem("Afsluiten");
        instellingen = new MenuItem("Instellingen");
    }

    private void layoutNodes() {
        txtTitel.setFont(Font.font("Arial", 24));

        menuHulp.getItems().addAll(afsluiten, instellingen);
        setTop(new MenuBar(menuHulp));

        VBox buttonVBox = new VBox();
        buttonVBox.getChildren().add(txtTitel);
        buttonVBox.getChildren().add(btnStartSpel);
        buttonVBox.getChildren().add(btnHighscores);
        buttonVBox.getChildren().add(btnHandleiding);

        buttonVBox.setAlignment(Pos.CENTER);
        setCenter(buttonVBox);

    }

    private void setCustomBackground(){
        BackgroundImage backgroundImage = new BackgroundImage(new Image("/background.png"),
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        setBackground(background);

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

    public MenuItem getAfsluiten() {
        return afsluiten;
    }

    public Menu getMenuHulp() {
        return menuHulp;
    }

    public MenuItem getInstellingen() {
        return instellingen;
    }

}