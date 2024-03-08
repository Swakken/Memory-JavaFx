package com.example.memory.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Frederic Backeljau
 * 3/8/2024
 */
public class Board {

    private int lengte;

    private int breedte;

    private Cell[] cellenArray;

    public Board(int lengte, int breedte) {
        setSize(lengte, breedte);
    }

    public void setSize(int lengte, int breedte){
        this.lengte = lengte;
        this.breedte = breedte;

        cellenArray = new Cell[lengte * breedte];

        for (int i = 0; i < cellenArray.length; i++)
            cellenArray = new Cell[i];

        shuffleBoard();
    }

    private void shuffleBoard(){
        // Lijsten van alle cellen
        List<Cell> cellenLijst = new ArrayList<>();

        for (Cell rij : cellenArray)
            cellenLijst.addAll(Arrays.asList(rij));

        // Shuffelen lijst
        Collections.shuffle(cellenLijst);

        // Totale cellen
        int totaleIds = (lengte * breedte) / 2;

        // Assign id's
        for (int i = 0; i < totaleIds; i++) {

            // Get two cells
            Cell first = cellenLijst.get(i * 2);
            Cell second = cellenLijst.get((i * 2) + 1);

            first.setId(i);
            second.setId(i);
        }
    }



    public int getLengte() {
        return lengte;
    }

    public int getBreedte() {
        return breedte;
    }

//    public boolean cellsMatch(){
//        return;
//    }
//
//    public int[][] toIds(){
//
//    }
//
//    public boolean[][] toTurned(){
//
//    }


}
