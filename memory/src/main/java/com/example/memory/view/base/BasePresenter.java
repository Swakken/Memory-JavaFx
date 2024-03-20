package com.example.memory.view.base;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public abstract class BasePresenter<ViewType extends BaseView> {
    protected ViewType view;

    public BasePresenter(ViewType view) {
        this.view = view;
        addEventListeners();
    }

    protected void addEventListeners() {
        addEventListenersAfsluiten();
    }

    private void addEventListenersAfsluiten() {
        this.view.getAfsluiten().addEventHandler(ActionEvent.ACTION, actionEvent -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Afsluiten");
            alert.setHeaderText("Weet je zeker dat je dit scherm wilt afsluiten?");

            ButtonType jaButton = new ButtonType("Ja");
            ButtonType cancelButton = new ButtonType("Annuleren", ButtonBar.ButtonData.CANCEL_CLOSE);
            alert.getButtonTypes().setAll(jaButton, cancelButton);

            alert.getDialogPane().getStylesheets().add(getClass().getResource("/styleheets/alert.css").toExternalForm());

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == jaButton) {
                // Als de gebruiker op "Ja" klikt, sluit het scherm af
                System.exit(0);
            }
        });
    }

}