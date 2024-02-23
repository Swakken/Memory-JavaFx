//package com.example.memory;
//
//import javafx.application.Application;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.layout.VBox;
//import javafx.scene.text.Font;
//import javafx.scene.text.Text;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//
//public class Handleiding extends Application {
//
//    public void start(Stage mijnHandleidingStage) throws IOException {
//        // Handleiding titel
//        Text txtTitel = new Text("Memory Spel Handleiding");
//        txtTitel.setFont(Font.font("Arial", 24));
//
//        Button terugButton = new Button("Terug naar Home");
//        terugButton.setFont(Font.font("Arial", 14));
//        terugButton.setStyle("-fx-background-color: #E76F51; -fx-text-fill: white;");
//
//        // Handleiding inhoud
//        Text intro = new Text("Welkom bij het Memory Spel!");
//        Text spelregelsTitel = new Text("Spelregels:");
//        Text spelregels = new Text(
//                "1. Alle kaarten liggen omgekeerd.\n" +
//                        "2. Elke beurt mag je twee kaarten omdraaien.\n" +
//                        "3. Als de kaarten overeenkomen, blijven ze omgedraaid.\n" +
//                        "4. Het doel is om alle paren te vinden binnen de opgegeven tijd.\n" +
//                        "5. Het spel eindigt als alle kaarten zijn omgedraaid of als de tijd verstreken is."
//        );
//        Text bedieningTitel = new Text("Bediening:");
//        Text bediening = new Text(
//                "- Gebruik de muis om kaarten te selecteren.\n" +
//                        "- ESC toets om het spel te pauzeren."
//        );
//
//        // Layout met VBox
//        VBox handleidingVBox = new VBox();
//        handleidingVBox.getChildren().addAll(txtTitel, intro, spelregelsTitel, spelregels, bedieningTitel, bediening, terugButton);
//
//        handleidingVBox.setAlignment(Pos.CENTER);
//        handleidingVBox.setSpacing(10);
//
//        // FullScreen instellingen
//        mijnHandleidingStage.setFullScreenExitHint("Druk op ESC om te sluiten");
//        mijnHandleidingStage.setFullScreen(true);
//
//        // Scene en Stage instellingen
//        Scene sceneHandleiding = new Scene(handleidingVBox);
//        mijnHandleidingStage.setScene(sceneHandleiding);
//        mijnHandleidingStage.show();
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}
