package com.example.memory.view.startspel;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class StartSpelView extends BorderPane {
    private Text txtStartSpel;
    private Label lblSpelerNaam;
    private Button btnAnnuleren;
    private Button btnStartSpel;
    private TextField txtfldSpelerNaam;

    private Menu menuHulp;
    private MenuItem afsluiten;
    private MenuItem instellingen;

    public StartSpelView() {
        initialiseNodes();
        layoutNodes();
        this.getStylesheets().add(getClass().getResource("/styleheets/home.css").toExternalForm());
    }

    private void initialiseNodes() {
        txtStartSpel = new Text("Start Spel");
        lblSpelerNaam = new Label("Naam Speler :");
        btnAnnuleren = new Button("Annuleren");
        btnStartSpel = new Button("Start Spel");
        txtfldSpelerNaam = new TextField();

        menuHulp = new Menu("Hulp");
        afsluiten = new MenuItem("Afsluiten");
        instellingen = new MenuItem("Instellingen");
    }

    public Button getBtnAnnuleren() {
        return btnAnnuleren;
    }

    public MenuItem getAfsluiten() {
        return afsluiten;
    }

    public TextField getTxtfldSpelerNaam() {
        return txtfldSpelerNaam;
    }

    public Label getLblSpelerNaam() {
        return lblSpelerNaam;
    }

    private void layoutNodes() {
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

        VBox MainVBox = new VBox(20);

        MainVBox.getChildren().addAll(hoofdingVBox, spelerNaamHBox, buttonHBox);
        MainVBox.setAlignment(Pos.CENTER);


        MainVBox.setBackground(new Background(new BackgroundImage(new Image("background.jpg"), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT )));

        txtStartSpel.setId("txtTitel");
        setCenter(MainVBox);

        menuHulp.getItems().addAll(afsluiten, instellingen);
        setTop(new MenuBar(menuHulp));

    }

    public Button getBtnStartSpel() {
        return btnStartSpel;
    }
}