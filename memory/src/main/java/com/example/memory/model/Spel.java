package com.example.memory.model;

import com.example.memory.view.spelscherm.SpelschermView;

public class Spel {

    // Constructor
    public Spel(){maakSpel();}

    private Bord bord;



    private void maakSpel() {

        bord = new Bord(16);
    }

    public Cel[] getCellenArray(){
        return bord.getCellenArray();
    }




//

    public void turnCellMatching(int id){
        //board.turnMatchingCells(x, y);
    }

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
