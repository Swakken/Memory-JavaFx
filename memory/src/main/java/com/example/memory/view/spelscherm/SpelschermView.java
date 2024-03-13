package com.example.memory.view.spelscherm;

import com.example.memory.model.Cel;
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

    private SpelschermPresenter presenter;

    private Text txtSpelerNaam;


    //private ImageView imgvwCardBackground;

    public SpelschermView() {
        initialseNodes();
        layoutNodes();
        initialiseerAfbeeldingen();
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

//    public void setDierenAfbeeldingen() {
//        for (int row = 0; row < buttons.length; row++) {
//            for (int col = 0; col < buttons[row].length; col++) {
//                Button cardButton = buttons[row][col];
//                String dierenId = dierId[col][row];
//                Image afbeelding = afbeeldingenMap.get(dierenId);
//                imgCardBackground = new Image("defaultCardBackground.png");
//                ImageView afbeeldingView = new ImageView(imgCardBackground);
//                afbeeldingView.setFitHeight(100);
//                afbeeldingView.setFitWidth(100);
//                cardButton.setGraphic(afbeeldingView);
//            }
//        }
//    }

//    private class KaartClickHandler implements EventHandler<ActionEvent> {
//        private final Button kaartButton;
//
//        public KaartClickHandler(Button kaartButton) {
//            this.kaartButton = kaartButton;
//        }
//
//        @Override
//        public void handle(ActionEvent event) {
//            String dierenId = (String) kaartButton.getUserData();
//            Image afbeelding = afbeeldingenMap.get(dierenId);
//            ImageView afbeeldingView = new ImageView(afbeelding);
//            afbeeldingView.setFitHeight(100);
//            afbeeldingView.setFitWidth(100);
//            kaartButton.setGraphic(afbeeldingView);
//        }
//    }



//    private void createGrid() {
//
//        int numRows = 4;
//        int numCols = 4;
//
//        buttons = new Button[numRows][numCols];
//
//
//        for (int row = 0; row < numRows; row++) {
//            for (int col = 0; col < numCols; col++) {
//                Button cardButton = new Button();
//
//                cardButton.setId(row + "-" + col);
//                String dierenId = dierId[col][row];
//                cardButton.setUserData(dierenId);
//
//                // Achtergrond kleur wordt hier aangepast naar het dierenId & de dierenImage
//                Image afbeelding = afbeeldingenMap.get(dierenId);
//                ImageView afbeeldingView = new ImageView(imgCardBackground);
//                afbeeldingView.setFitHeight(100);
//                afbeeldingView.setFitWidth(100);
//
//                cardButton.setGraphic(afbeeldingView);
//
//                cardButton.setPrefSize(100, 100);
//                cardButton.setFont(Font.font("Arial", 13));
//                cardButton.setStyle("-fx-background-color: #ff8e00; -fx-text-fill: white;");
//
//                // Voeg de EventHandler toe aan de knop
//                cardButton.setOnAction(new KaartClickHandler(cardButton));
//
//                buttons[row][col] = cardButton;
//                gpSpelBord.add(cardButton, row, col);
//            }
//        }
//        setDierenAfbeeldingen();
//    }


    public void vulGridPane(Cel[] bordCellen){
        int gridGrootte = 4;

        for (int i = 0; i < bordCellen.length; i++) {
            Button kaartButton = new Button();
            kaartButton.setPrefSize(100,100);
            kaartButton.setUserData(bordCellen[i].getId());

            // knop toevoegen aan gridPane
            int kolom = i / gridGrootte;
            int rij = i % gridGrootte;
            gpSpelBord.add(kaartButton, rij, kolom);

            ImageView imgvwAchtergrond = new ImageView(imgCardBackground);
            kaartButton.setGraphic(imgvwAchtergrond);


            kaartButton.setOnAction(event -> draaiKaart(kaartButton));
        }
    }

    public void draaiKaart(Button button){
        int kaartId = (int)button.getUserData();
        String afbeeldingsNaam = kaartId + ".png";
        ImageView imgvwAfbeelding = new ImageView(new Image(afbeeldingsNaam));
        imgvwAfbeelding.setFitWidth(100);
        imgvwAfbeelding.setFitHeight(100);



        button.setGraphic(imgvwAfbeelding);

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