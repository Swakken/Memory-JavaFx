package com.example.memory.view.home;

import com.example.memory.view.base.BaseView;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class HomeView extends BaseView {

    private Text txtTitel;
    private Button btnStartSpel;
    private Button btnHighscores;
    private Button btnHandleiding;

    public HomeView() {
        super();
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

        buttonVBox.setBackground(new Background(new BackgroundImage(
                new Image("background.jpg"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(100, 100, true, true, false, true)
        )));

        setCenter(buttonVBox);
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