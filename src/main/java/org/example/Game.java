package org.example;

import java.util.ArrayList;

public class Game {

    public Items Messer, Rose, Krone, Champagne, Suppe, Gewand;

    public void ItemList() {
        Messer = new Items("Messer", "Schatzkammer", 200, false, false, true);
        Rose = new Items("Rose", "hof", 5, false, false, false);
        Krone = new Items("Krone", "Kronsaal", 5000, false, false, false);
        Champagne = new Items("Champagne", "Ballsaal", 1000, false,false,false);
        Suppe = new Items("Suppe", "Kueche", 500, false,false,false);
        Gewand = new Items("Gewand", "Schlafzimmer", 2000, false,false,false);
    }
}
