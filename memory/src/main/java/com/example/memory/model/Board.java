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

    private Cell[] cellen;

    public Board(int lengte, int breedte) {
        setSize(lengte, breedte);
    }

    public void setSize(int lengte, int breedte){
        this.lengte = lengte;
        this.breedte = breedte;

        cellen = new Cell[lengte * breedte];

        for (int i = 0; i < cellen.length; i++)


//        cellen = new Cell[lengte][];
//
//        for (int i = 0; i < lengte; i++) {
//            cellen[i] = new Cell[breedte];
//
//            for (int j = 0; j < breedte; j++) {
//                cellen[i][j] = new Cell(j,i);
//            }
//        }

        shuffleBoard();
    }

    private void shuffleBoard(){


        // Lijsten van alle cellen
        List<Cell> cellenLijst = new ArrayList<>();

//        for (Cell[] rij : cellen)
//            cellenLijst.addAll(Arrays.asList(rij));

        // Shuffelen lijst
        Collections.shuffle(cellenLijst);

        // Totale cellen
        int totaleIds = (lengte * breedte) / 2;

        // 0 1
        // 2 3
        // 4 5

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
