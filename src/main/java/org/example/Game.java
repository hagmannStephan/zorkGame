package org.example;

public class Game {
    public void initiate_Items() {
        Item Messer = new Item("Messer", "Schatzkammer", 200, false,true);
        Item Rose = new Item("Rose", "hof", 5, false, false);
        Item Krone = new Item("Krone", "Kronsaal", 5000, false, false);
        Item Champagne = new Item("Champagne", "Ballsaal", 1000, false,false);
        Item Suppe = new Item("Suppe", "Kueche", 500, false,false);
        Item Gewand = new Item("Gewand", "Schlafzimmer", 2000, false,false);
    }
}
