package com.example.memory.model;

import java.util.*;


public class Bord {

    private int lengte;

    private Cel[] cellenArray;

    //Board Constructor
    public Bord(int lengte) {
        setSize(lengte);
    }

    //Lengte van Bord aanpassen aan meegegeven lengte
    public void setSize(int lengte) {
        this.lengte = lengte;
        this.cellenArray = new Cel[lengte];
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
            cellenArray[i] = new Cel(randomIndex);
            uniekeIDs.remove(randomIndex);
        }
        shuffleBord();
    }


    // Volgorde van cellen randomizen
    private void shuffleBord() {
        Random random = new Random();
        // Start bij de laatste cel in de array
        for (int i = cellenArray.length; i > 0; i--){
            // Getal genereren tussen 0 en "i"
            int j = random.nextInt(i + 1);

            Cel tijdenlijk = cellenArray[i];
            cellenArray[i] = cellenArray[j];
            cellenArray[j] = tijdenlijk;
        }
    }


    public int getLengte() {
        return lengte;
    }

    public Cel[] getCellenArray(){
        return cellenArray;
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
