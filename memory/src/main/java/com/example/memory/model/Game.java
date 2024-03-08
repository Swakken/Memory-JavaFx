package com.example.memory.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

    private Board board;

    private int cell1id;
    private int cell2id;

    //    public int[][] getBoard(){
////        return this.board;
//    }




    private void createGame() {

        cell1id=-1;
        cell2id=-1;

        board = new Board(4, 4);




    }

    public void selecteerCell(int id){
        if
    }

    public kanCellenVergelijken(){

    }

    public boolean vergelijkCellen(){
        return board.cellsMatch();
    }

    public turnCellMatching(int id){
        //board.turnMatchingCells(x, y);
    }

    public int[] getBoardIds(){

    }

    public boolean[] getBoardTurned(){

    }

}
