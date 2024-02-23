package com.example.memory.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class HandleidingView extends VBox {
    private Text txtTitel;
    private Button terugButton;
    private Text intro;
    private Text spelregelsTitel;
    private Text spelregels;
    private Text bedieningTitel;
    private Text bediening;


public HandleidingView() {
    initialiseNodes();
    layoutNodes();
}

private void initialiseNodes(){
    txtTitel = new Text("Memory Spel Handleiding");
    terugButton = new Button("Terug naar Home");
    intro = new Text("Welkom bij het Memory Spel!");
    spelregelsTitel = new Text("Spelregels:");
    spelregels = new Text(
            "1. Alle kaarten liggen omgekeerd.\n" +
                    "2. Elke beurt mag je twee kaarten omdraaien.\n" +
                    "3. Als de kaarten overeenkomen, blijven ze omgedraaid.\n" +
                    "4. Het doel is om alle paren te vinden binnen de opgegeven tijd.\n" +
                    "5. Het spel eindigt als alle kaarten zijn omgedraaid of als de tijd verstreken is."
    );
    bedieningTitel = new Text("Bediening:");
    bediening = new Text(
            "- Gebruik de muis om kaarten te selecteren.\n" +
                    "- ESC toets om het spel te pauzeren."
    );


}

private void layoutNodes(){
    txtTitel.setFont(Font.font("Arial", 24));
    terugButton.setFont(Font.font("Arial", 14));
    terugButton.setStyle("-fx-background-color: #E76F51; -fx-text-fill: white;");
    this.getChildren().addAll(txtTitel, intro, spelregelsTitel, spelregels, bedieningTitel, bediening, terugButton);
    this.setAlignment(Pos.CENTER);
    this.setSpacing(10);



}
}
