package org.example;

import javax.sql.RowSet;
import java.util.ArrayList;

public class Game {

    public void initiate_Items() {
        Item Messer = new Item("Messer", "Schatzkammer", 200, false,true);
        Item Rose = new Item("Rose", "hof", 5, false, false);
        Item Krone = new Item("Krone", "Kronsaal", 5000, false, false);
        Item Champagne = new Item("Champagne", "Ballsaal", 1000, false,false);
        Item Suppe = new Item("Suppe", "Kueche", 500, false,false);
        Item Gewand = new Item("Gewand", "Schlafzimmer", 2000, false,false);
    }

    public void initiate_Rooms(){
        Room kapelle = new Room("Kapelle", null, true, false, false);
        Room hof = new Room("Hof", , false, false, false);
        Room ballsaal = new Room("Ballsaal", )

        kapelle.setExits(null, hof, null, null);
        hof.setExits(null, ballsaal, null, kapelle);
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

    private boolean processCommand(Command command){
        if (command.isNotACommand()){
            System.out.println("That is not a command!");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord=="!back"){
            //TODO: go to 'previousLocation'... oder wieauimmer es heisst.
        } else if (commandWord=="!map") {
            //TODO: create a map
        } else if (commandWord=="!inventory") {
            //TODO: List items in inventory
        } else if (commandWord=="!drop") {
            //TODO: Drop mit commmandArgument
        } else if (commandWord=="!items") {
            //TODO: List items in room
        } else if (commandWord=="!pickup") {
            //TODO: Mit commandArgumant
        } else if (commandWord=="!scare") {
            //TODO: If king in room = win
        } else if (commandWord=="!exits") {
            //TODO: show exits
        } else if (commandWord=="!move") {
            //TODO: Go to another room
        } else if (commandWord=="!help") {
            System.out.println("Type '!map' for map of the game.");
            System.out.println("Type '!back' to go to the previous room.");
            System.out.println("Type '!inventory' for a list of all your items.");
            System.out.println("Type '!drop' with an argument.."); //TODO: Ich hen kein bock auf das
            System.out.println("Type '!items' for a list of all items in your location.");
            System.out.println("Type '!pickup' with an argument... "); //TODO: Glich kein bock uf das
            System.out.println("Type '!scare' to kill the king.");
            System.out.println("Type '!exits' to show a list of all exits.");
            System.out.println("Type '!move' with an argument.."); //TODO: Hen au kei bock uf das.
            System.out.println("Type '!help' for this view.");
        }
        return false;
    }
}
