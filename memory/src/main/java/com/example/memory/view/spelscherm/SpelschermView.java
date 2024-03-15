package com.example.memory.view.spelscherm;

import com.example.memory.view.base.BaseView;
import com.example.memory.model.Cel;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.*;


public class SpelschermView extends BaseView {

    private Button btnMenu;
    private Text txtScore;
    private GridPane gpSpelBord;

    private Map<String, Image> afbeeldingenMap;
    private Image imgCardBackground;

    private Text txtSpelerNaam;

    // Alle kaart knoppen
    private List<Button> alleKaartKnoppen;

    // Toont de score bij juist omgedraaide kaarten
    private int score;


    public SpelschermView() {
        super();
        initialseNodes();
        layoutNodes();
        initialiseerAfbeeldingen();
        alleKaartKnoppen = new ArrayList<>();
        score = 0;
    }

    private void initialseNodes() {

        btnMenu = new Button("Menu");
        txtScore = new Text("Score: ");
        gpSpelBord = new GridPane();

        txtSpelerNaam = new Text("Speler: ");

        imgCardBackground = new Image("defaultCardBackground.png");
    }

    private void layoutNodes() {
        btnMenu.setPrefSize(100, 40);
        btnMenu.setFont(Font.font("Arial", 13));
        btnMenu.setStyle("-fx-background-color: #E76F51; -fx-text-fill: white;");
        txtScore.setFont(Font.font("Arial", 13));

        // HBox voor de spelerNaam
        HBox topHBox = new HBox();
        topHBox.setAlignment(Pos.CENTER);
        topHBox.setSpacing(10);
        txtSpelerNaam.setFont(Font.font("Arial", 16));
        txtSpelerNaam.setStyle("-fx-font-weight: bold;");
        topHBox.getChildren().add(txtSpelerNaam);

        // VBox voor de MenuBar en de spelerNaam
        VBox topVBox = new VBox(topHBox);
        topVBox.setAlignment(Pos.TOP_CENTER);
        this.setTop(topVBox);

        HBox BottomHBox = new HBox();
        BottomHBox.setAlignment(Pos.BASELINE_RIGHT);
        BottomHBox.getChildren().addAll(btnMenu);

        // Background
        this.setBackground(new Background(new BackgroundImage(
                new Image("background.jpg"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(100, 100, true, true, false, true)
        )));
        this.setBottom(BottomHBox);

        gpSpelBord.setAlignment(Pos.CENTER);
        gpSpelBord.setHgap(10);
        gpSpelBord.setVgap(10);
        this.setCenter(gpSpelBord);
        this.setLeft(txtScore);
    }

    // Getters
    public GridPane getGpSpelBord() {
        return gpSpelBord;
    }

    public Button getBtnMenu() {
        return btnMenu;
    }

    // Afbeeldingen van de dieren gelinkt aan de dierId's
    private void initialiseerAfbeeldingen() {
        afbeeldingenMap = new HashMap<>();
        afbeeldingenMap.put("papegaai", new Image("6.png"));
        afbeeldingenMap.put("toekan", new Image("7.png"));
        afbeeldingenMap.put("mandrill", new Image("5.png"));
        afbeeldingenMap.put("koala", new Image("4.png"));
        afbeeldingenMap.put("panter", new Image("8.png"));
        afbeeldingenMap.put("chimpansee", new Image("1.png"));
        afbeeldingenMap.put("kikker", new Image("3.png"));
        afbeeldingenMap.put("kameleon", new Image("2.png"));
    }

    // Zorgt voor een gevulde Gridpane
    public void vulGridPane(Cel[] bordCellen) {
        int gridGrootte = 4;

        for (int i = 0; i < bordCellen.length; i++) {
            Button kaartButton = new Button();
            kaartButton.setPrefSize(100, 100);
            kaartButton.setUserData(bordCellen[i].getId());

            int kolom = i / gridGrootte;
            int rij = i % gridGrootte;
            gpSpelBord.add(kaartButton, rij, kolom);

            ImageView imgvwAchtergrond = new ImageView(imgCardBackground);
            kaartButton.setGraphic(imgvwAchtergrond);

            // Toevoegen aan lijst
            alleKaartKnoppen.add(kaartButton);
            //kaartButton.setOnAction();

//            kaartButton.setOnAction(event -> draaiKaart(kaartButton));
        }
    }

    public List<Button> getKaartKnoppen() {
        return alleKaartKnoppen;
    }

    public void draaiKaart(Button button) {
        int kaartId = (int) button.getUserData();
        String afbeeldingsNaam = kaartId + ".png";
        ImageView imgvwAfbeelding = new ImageView(new Image(afbeeldingsNaam));
        imgvwAfbeelding.setFitWidth(100);
        imgvwAfbeelding.setFitHeight(100);
        button.setGraphic(imgvwAfbeelding);
    }

    public void verwijderMatch(int id) {
        List<Button> teVerwijderenKnoppen = new ArrayList<>();

        // Zoek naar de knoppen die overeenkomen met het opgegeven ID
        for (Button knop : alleKaartKnoppen) {
            int buttonId = (int) knop.getUserData();
            if (buttonId == id) {
                draaiKaart(knop);
                teVerwijderenKnoppen.add(knop);
            }
        }

        // Wacht 0.5 seconden voordat de kaarten worden verwijderd
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), event -> {
            for (Button knop : teVerwijderenKnoppen) {
                gpSpelBord.getChildren().remove(knop);
                alleKaartKnoppen.remove(knop);
            }
            // Punt geven voor de match
            score++;
            // Weergave van de score updaten
            txtScore.setText("Score: " + score);
        }));
        timeline.play();
    }

    public void draaiTerugOm(int eersteId, int tweedeId) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), e -> {
            for (Node node : gpSpelBord.getChildren()) {
                Button button = (Button) node;
                int buttonId = (int) button.getUserData();
                if (buttonId == eersteId || buttonId == tweedeId) {
                    ImageView imgvwAchtergrond = new ImageView(imgCardBackground);
                    imgvwAchtergrond.setFitWidth(100);
                    imgvwAchtergrond.setFitHeight(100);
                    button.setGraphic(imgvwAchtergrond);
                }
            }
        }));
        timeline.play();
    }


    // Check if spelerNaam is ingevuld
    public void setSpelerNaam(String naam) {
        if (txtSpelerNaam != null) {
            txtSpelerNaam.setText("Spelernaam: " + naam);
        } else {
            System.out.println("txtSpelerNaam is null. Kan naam niet instellen.");
        }
    }
}