package com.example.memory.model;

import com.example.memory.view.spelscherm.SpelschermView;

import java.util.ArrayList;

public class Spel {
    private ArrayList<Integer> omgedraaideKaarten;

    // Constructor
    public Spel() {
        maakSpel();
        omgedraaideKaarten = new ArrayList<>();
    }

    private Bord bord;




    private void maakSpel() {
        bord = new Bord(16);
    }

    public Cel[] getCellenArray() {
        return bord.getCellenArray();
    }

    public boolean vergelijkKaarten(int id) {
        omgedraaideKaarten.add(id);
        if (omgedraaideKaarten.size() == 2) {
            int eersteId = omgedraaideKaarten.get(0);
            int tweedeId = omgedraaideKaarten.get(1);
            // Logica om te vergelijken
            if (eersteId == tweedeId){
                omgedraaideKaarten.clear();
                return true;
            }
            else {
                omgedraaideKaarten.clear();
                return false;
            }
        }
    }

    ;


//    public int[] getBoardIds(){
//
//    }


//
//    public kanCellenVergelijken(){
//
//    }
//
//    public boolean vergelijkCellen(){
//        return board.cellsMatch();
//    }
//
//    public turnCellMatching(int id){
//        //board.turnMatchingCells(x, y);
//    }
//
//    public int[] getBoardIds(){
//
//    }
//

//    public boolean[] getBoardTurned(){
//
//    }

}
