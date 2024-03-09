package com.example.memory.view.spelscherm;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SpelschermView extends BorderPane {

    private Button btnMenu;
    private Text txtScore;
    private GridPane gpSpelBord;

    private Menu menuHulp;
    private MenuItem afsluiten;
    private MenuItem instellingen;
    private Button[][] buttons;

    private String[][] dierId;

    private Image imgCardBackground;

    private Text txtSpelerNaam;


    //private ImageView imgvwCardBackground;

    public SpelschermView() {

        initialseNodes();
        layoutNodes();
        createGrid();
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
        dierId = new String[][]{
                {"papegaai", "papegaai", "mandrill", "mandrill"},
                {"toekan", "toekan", "koala", "koala"},
                {"panter", "panter", "chimpansee", "chimpansee"},
                {"kikker", "kikker", "kameleon", "kameleon"}
        };
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
        this.setBackground(new Background(new BackgroundImage(new Image("background.jpg"), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        this.setBottom(BottomHBox);

        gpSpelBord.setAlignment(Pos.CENTER);
        gpSpelBord.setHgap(10);
        gpSpelBord.setVgap(10);
        this.setCenter(gpSpelBord);
        this.setLeft(txtScore);
    }


    public String[][] getDierId() {
        return dierId;
    }

    public GridPane getGpSpelBord() {
        return gpSpelBord;
    }

    public Button getBtnMenu() {
        return btnMenu;
    }

    public MenuItem getAfsluiten() {
        return afsluiten;
    }


    private void createGrid() {

        int numRows = 4;
        int numCols = 4;

        // Create new buttons
        buttons = new Button[numRows][];

        for (int row = 0; row < numRows; row++) {

            buttons[row] = new Button[numCols];

            for (int col = 0; col < numCols; col++) {
                Button cardButton = new Button();


                cardButton.setId(row + "-" + col);


                cardButton.setPrefSize(100, 100);
                cardButton.setFont(Font.font("Arial", 13));
                cardButton.setStyle("-fx-background-color: #ff8e00; -fx-text-fill: white;");

                buttons[row][col] = cardButton;

//                imgvwCardBackground = new ImageView(imgCardBackground);
//                imgvwCardBackground.setFitHeight(cardButton.getPrefHeight());
//                imgvwCardBackground.setFitWidth(cardButton.getPrefWidth());

                //Elke knop een dier toewijzen:
                //String dierenId = dierId[col][row];
                //cardButton.setUserData(dierenId);

                //cardButton.setGraphic(imgvwCardBackground);

                gpSpelBord.add(cardButton, row, col);


                // Add to buttonsArrayList
//                buttons.add(cardButton);

            }
        }
    }

    public List<Button> getButtons() {

        List<Button> lst = new ArrayList<>();

        for (Button[] button : buttons)
            lst.addAll(Arrays.asList(button));

        return lst;
    }

//    private String idToImage(){
//
//    }

    public void updateTile(int row, int col, int id) {

//        idToImage();

        //buttons[row][col];

    }

    public void setSpelerNaam(String naam) {
        if (txtSpelerNaam != null) {
            txtSpelerNaam.setText("Spelernaam: " + naam);
        } else {
            System.out.println("txtSpelerNaam is null. Kan naam niet instellen.");
        }
    }


}