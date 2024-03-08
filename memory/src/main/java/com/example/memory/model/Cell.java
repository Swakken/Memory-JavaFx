package com.example.memory.model;

/**
 * Frederic Backeljau
 * 3/8/2024
 */
public class Cell {

    int lengte;
    int breedte;

    int id;


    public Cell(int breedte, int lengte) {
        this.breedte = breedte;
        this.lengte = lengte;
    }

    public void setId(int id) {
        this.id = id;
    }
}
