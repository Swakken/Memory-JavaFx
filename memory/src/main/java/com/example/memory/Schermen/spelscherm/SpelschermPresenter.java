package com.example.memory.Schermen.spelscherm;

import com.example.memory.Schermen.home.HomePresenter;
import com.example.memory.Schermen.home.HomeView;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpelschermPresenter {

    private SpelschermView view;
    private Map<Button, String> cardValuesMap;

    public SpelschermPresenter(SpelschermView view) {
        this.view = view;
        this.cardValuesMap = new HashMap<>();
        addEventListenerMenu();
        initializeMemoryCards();
    }

    private void addEventListenerMenu() {
        this.view.getBtnMenu().addEventHandler(ActionEvent.ACTION, (actionEvent) -> {
            HomeView mijnHomeView = new HomeView();
            HomePresenter mijnHomePresenter = new HomePresenter(mijnHomeView);
            this.view.getScene().setRoot(mijnHomeView);
        });
    }

    private void initializeMemoryCards() {
        cardValuesMap.clear();
        view.getGpSpelBord().getChildren().clear();

        List<String> cardValues = createCardValues();
        Collections.shuffle(cardValues);

        int numRows = 4;
        int numCols = 4;

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                Button cardButton = new Button();
                cardButton.setPrefSize(100, 100);
                cardButton.setFont(Font.font("Arial", 13));
                cardButton.setStyle("-fx-background-color: #3498db; -fx-text-fill: white;");
                cardButton.setOnAction(this::handleCardButtonClick);

                String cardValue = cardValues.remove(0);
                cardButton.setText(cardValue);

                cardValuesMap.put(cardButton, cardValue);
                view.getGpSpelBord().add(cardButton, col, row);
            }
        }
    }

    private List<String> createCardValues() {
        List<String> cardValues = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            cardValues.add(String.valueOf(i));
            cardValues.add(String.valueOf(i));
        }

        return cardValues;
    }

    private void handleCardButtonClick(ActionEvent event) {
        Button clickedCard = (Button) event.getSource();
        String cardValue = cardValuesMap.get(clickedCard);

        System.out.println("Card Clicked: " + cardValue);
    }
}
