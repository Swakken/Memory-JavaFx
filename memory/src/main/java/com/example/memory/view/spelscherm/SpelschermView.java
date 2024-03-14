package com.example.memory.view.spelscherm;

import com.example.memory.model.Cel;
import javafx.application.Platform;
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

import java.util.*;


public class SpelschermView extends BorderPane {

    private Button btnMenu;
    private Text txtScore;
    private GridPane gpSpelBord;

    private Menu menuHulp;
    private MenuItem afsluiten;
    private MenuItem instellingen;
    private Map<String, Image> afbeeldingenMap;
    private Image imgCardBackground;

    private Text txtSpelerNaam;

    // Toont het aantal geselecteerde kaarten
    private List<Button> geselecteerdeKaarten;

    // Toont de score bij juist omgedraaide kaarten
    private int score;


    public SpelschermView() {
        initialseNodes();
        layoutNodes();
        initialiseerAfbeeldingen();
        geselecteerdeKaarten = new ArrayList<>();
        score = 0;
    }

    private void initialseNodes() {

        btnMenu = new Button("Menu");
        txtScore = new Text("Score: ");
        gpSpelBord = new GridPane();

        txtSpelerNaam = new Text("Speler: ");

        menuHulp = new Menu("Hulp");
        afsluiten = new MenuItem("Afsluiten");
        instellingen = new MenuItem("Instellingen");
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

        // Aangemaakte MenuBar
        MenuBar menuBar = new MenuBar();
        menuHulp.getItems().addAll(afsluiten, instellingen);
        menuBar.getMenus().add(menuHulp);

        // VBox voor de MenuBar en de spelerNaam
        VBox topVBox = new VBox(menuBar, topHBox);
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

    public MenuItem getAfsluiten() {
        return afsluiten;
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

            kaartButton.setOnAction(event -> draaiKaart(kaartButton));
        }
    }

    // Functie wanneer de kaarten worden omgeraaid
    public void draaiKaart(Button geselecteerdeKaartbutton) {
        if (geselecteerdeKaarten.size() < 2) {
            // Kaart wordt toegevoegd aan de lijst met geselecteerde kaarten
            geselecteerdeKaarten.add(geselecteerdeKaartbutton);

            int kaartId = (int) geselecteerdeKaartbutton.getUserData();
            String afbeeldingsNaam = kaartId + ".png";
            ImageView imgvwAfbeelding = new ImageView(new Image(afbeeldingsNaam));
            imgvwAfbeelding.setFitWidth(100);
            imgvwAfbeelding.setFitHeight(100);

            geselecteerdeKaartbutton.setGraphic(imgvwAfbeelding);

            // Kijk of 2 kaarten hetzelfde zijn, als ze zijn omgedraaid
            if (geselecteerdeKaarten.size() == 2) {
                Button eersteKaart = geselecteerdeKaarten.get(0);
                Button tweedeKaart = geselecteerdeKaarten.get(1);

                if (eersteKaart.getUserData().equals(tweedeKaart.getUserData())) {
                    // De kaarten zijn hetzelfde, laat ze omgedraaid liggen
                    // Verhoog de score met 1
                    score++;
                    txtScore.setText("Score: " + score);
                    // Wis de lijst met geselecteerde kaarten
                    geselecteerdeKaarten.clear();
                } else {
                    // De kaarten zijn niet hetzelfde, draai ze na 1 seconde terug om
                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            Platform.runLater(() -> {
                                for (Button kaart : geselecteerdeKaarten) {
                                    ImageView achtergrond = new ImageView(imgCardBackground);
                                    achtergrond.setFitWidth(100);
                                    achtergrond.setFitHeight(100);
                                    kaart.setGraphic(achtergrond);
                                }
                                // Wis de lijst met geselecteerde kaarten
                                geselecteerdeKaarten.clear();
                            });
                        }
                    }, 1000); // 1000 milliseconds = 1 seconde
//
                }
            }
        }
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