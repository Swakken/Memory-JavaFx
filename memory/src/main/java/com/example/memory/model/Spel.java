package com.example.memory.model;

import com.example.memory.view.spelscherm.SpelschermView;

import java.util.ArrayList;

public class Spel {

    private ArrayList<Integer> omgedraaideKaarten;
    private int eersteId;
    private int tweedeId;
    private Bord bord;

    // Constructor
    public Spel() {
        maakSpel();
        omgedraaideKaarten = new ArrayList<>();
    }

    public boolean vergelijkKaarten(int id) {
        omgedraaideKaarten.add(id);
        boolean match = false;
        if (omgedraaideKaarten.size() == 2) {
            eersteId = omgedraaideKaarten.get(0);
            tweedeId = omgedraaideKaarten.get(1);
            // Logica om te vergelijken
            match = (eersteId == tweedeId);
            omgedraaideKaarten.clear();
        }
        return match;
    }

    private void maakSpel() {
        bord = new Bord(16);
    }

    public Cel[] getCellenArray() {
        return bord.getCellenArray();
    }
    public int getEersteId() {
        return eersteId;
    }
    public int getTweedeId() {
        return tweedeId;
    }
}
