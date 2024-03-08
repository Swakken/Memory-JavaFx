package com.example.memory.Schermen.spelscherm;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;


public class SpelschermView extends BorderPane {

    private Button btnMenu;
    private Text txtScore;
    private GridPane gpSpelBord;

    private Menu menuHulp;
    private MenuItem afsluiten;
    private MenuItem instellingen;

    private List<Button> buttons;

    private String [][] dierId;

    public SpelschermView() {

        // Init list
        buttons = new ArrayList<>();

        initialseNodes();
        layoutNodes();
        createGrid();
    }

    private void initialseNodes() {

        btnMenu = new Button("Menu");
        txtScore = new Text("Score: ");
        gpSpelBord = new GridPane();

        menuHulp = new Menu("Hulp");
        afsluiten = new MenuItem("Afsluiten");
        instellingen = new MenuItem("Instellingen");
//        dierId = new String[][]= {};
    }

    private void layoutNodes() {
        btnMenu.setPrefSize(100, 40);
        btnMenu.setFont(Font.font("Arial", 13));
        btnMenu.setStyle("-fx-background-color: #E76F51; -fx-text-fill: white;");
        txtScore.setFont(Font.font("Arial", 13));


        HBox BottomHBox = new HBox();
        BottomHBox.setAlignment(Pos.BASELINE_RIGHT);
        BottomHBox.getChildren().addAll(btnMenu);
        this.setBottom(BottomHBox);

        gpSpelBord.setAlignment(Pos.CENTER);
        gpSpelBord.setHgap(10);
        gpSpelBord.setVgap(10);
        this.setCenter(gpSpelBord);
        this.setLeft(txtScore);

        menuHulp.getItems().addAll(afsluiten, instellingen);
        setTop(new MenuBar(menuHulp));
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

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                Button cardButton = new Button();
                cardButton.setId(row + "-" + col);
                cardButton.setPrefSize(100, 100);
                cardButton.setFont(Font.font("Arial", 13));
                cardButton.setStyle("-fx-background-color: #3498db; -fx-text-fill: white;");

                gpSpelBord.add(cardButton, row, col);

                // Add to buttonsArrayList
                buttons.add(cardButton);
            }
        }
    }

    public List<Button> getButtons() {
        return buttons;
    }
}