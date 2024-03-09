package com.example.memory.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Bord {

    private int lengte;

    private Cell[] cellenArray;

    //Board Constructor
    public Bord(int lengte) {
        setSize(lengte);
    }

    //Lengte van Bord aanpassen aan meegegeven lengte
    public void setSize(int lengte) {
        this.lengte = lengte;
        this.cellenArray = new Cell[lengte];
        bordOpvullen();
    }


    private void bordOpvullen() {
        List<Integer> uniekeIDs = new ArrayList<>();

        // Vul de lijst met unieke IDs
        for (int i = 1; i <= lengte / 2; i++) {
            uniekeIDs.add(i);
            uniekeIDs.add(i);
        }

        // Kopieer de unieke IDs naar de cellenArray
        for (int i = 0; i < lengte; i++) {
            int randomIndex = (int) (Math.random() * uniekeIDs.size());
            cellenArray[i] = new Cell(randomIndex);
            uniekeIDs.remove(randomIndex);
        }
        shuffleBord();
    }


    //Volgorde van cellen randomizen adhv Collections.shuffle
    private void shuffleBord() {
        List<Cell> cellenLijst = new ArrayList<>(List.of(cellenArray));
        Collections.shuffle(cellenLijst);
        cellenLijst.toArray(cellenArray);
    }


    public int getLengte() {
        return lengte;
    }



//    public boolean cellsMatch(){
//        return;
//    }
//

//    public boolean cellsMatch(int x1, int y1, int x2, int y2){
//        return;
//    }

//    public int[][] toIds(){
//
//    }
//
//    public boolean[][] toTurned(){
//
//    }


}
