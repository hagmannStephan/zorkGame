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

    public void play(){
        welcome();

        boolean finished = false;
        while(!finished){

        }
        System.out.println("Thank you for playing!");
    }
    private void welcome(){
        System.out.println("---------------------------------------------------------------");
        System.out.println("Welcome to Kill The King!");
        System.out.println("The goal of this game, is to chase the King out of the castle.");
        System.out.println("type 'help', if you need help.");
        System.out.println("---------------------------------------------------------------");
    }
}
