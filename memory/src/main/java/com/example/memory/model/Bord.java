package com.example.memory.model;

import java.util.*;


public class Bord {

    private int lengte;

    private Cel[] cellenArray;

    //Bord Constructor
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


        for (int i = 1; i <= lengte / 2; i++) {
            uniekeIDs.add(i);
            uniekeIDs.add(i);
        }

        List<Integer> uniekeIDsCopy = new ArrayList<>(uniekeIDs);


        for (int i = 0; i < lengte; i++) {
            int randomIndex = (int) (Math.random() * uniekeIDsCopy.size());
            cellenArray[i] = new Cel(uniekeIDsCopy.get(randomIndex));
            uniekeIDsCopy.remove(randomIndex);
        }
        shuffleBord();
    }


    // Volgorde van cellen randomizen
    private void shuffleBord() {
        Random random = new Random();
        // Start bij de laatste cel in de array
        for (int i = cellenArray.length - 1; i > 0; i--){
            // Getal genereren tussen 0 en "i"
            int j = random.nextInt(i + 1);

            Cel tijdelijk = cellenArray[i];
            cellenArray[i] = cellenArray[j];
            cellenArray[j] = tijdelijk;
        }
    }


    public int getLengte() {
        return lengte;
    }

    public Cel[] getCellenArray(){
        return cellenArray;
    }

}