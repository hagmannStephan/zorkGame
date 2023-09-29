package org.example;

import javax.sql.RowSet;
import java.util.ArrayList;

public class Game {
    private Parser parser;
    private ArrayList<Room> rooms;
    private Room currentRoom;

    public void initiate_game() {

        parser = new Parser(System.in);

        Item Messer = new Item("Messer", "Schatzkammer", 200, false,true);
        Item Rose = new Item("Rose", "hof", 5, false, false);
        Item Krone = new Item("Krone", "Kronsaal", 5000, false, false);
        Item Champagne = new Item("Champagne", "Ballsaal", 1000, false,false);
        Item Suppe = new Item("Suppe", "Kueche", 500, false,false);
        Item Gewand = new Item("Gewand", "Schlafzimmer", 2000, false,false);

        ArrayList<Item> hofItems = new ArrayList<>();
        ArrayList<Item> ballsaalItems = new ArrayList<>();
        ArrayList<Item> kronsaalItems = new ArrayList<>();
        ArrayList<Item> kuecheItems = new ArrayList<>();
        ArrayList<Item> schlafzimmerItems = new ArrayList<>();
        ArrayList<Item> schatzkammerItems = new ArrayList<>();

        hofItems.add(Rose);
        ballsaalItems.add(Champagne);
        kronsaalItems.add(Krone);
        kuecheItems.add(Suppe);
        schlafzimmerItems.add(Gewand);
        schatzkammerItems.add(Messer);

        Room kapelle = new Room("Kapelle", null, true, false, false);
        Room hof = new Room("Hof", hofItems, false, false, false);
        Room ballsaal = new Room("Ballsaal", ballsaalItems, false, false, false);
        Room kronsaal = new Room("Kronsaal", kronsaalItems, false, true, false);
        Room kueche = new Room("Küche", kuecheItems, false, false, false);
        Room schlafzimmer = new Room("Schlafzimmer", schlafzimmerItems, false, false, false);
        Room schatzkammer = new Room("Schatzkammer", schatzkammerItems, false, false, false);

        ArrayList<Room> rooms = new ArrayList<Room>() {{
            add(kapelle);
            add(hof);
            add(ballsaal);
            add(kronsaal);
            add(kueche);
            add(schlafzimmer);
            add(schatzkammer);
        }};

        this.rooms = rooms;

        kapelle.setExits(null, hof, null, null);
        hof.setExits(null, ballsaal, null, kapelle);
        ballsaal.setExits(kronsaal, schlafzimmer, kueche, hof);
        kronsaal.setExits(null, null, ballsaal, null);
        kueche.setExits(ballsaal, null, null, null);
        schlafzimmer.setExits(schatzkammer, null, null, ballsaal);
        schatzkammer.setExits(null, null, schlafzimmer, null);
    }

    public void play(){
        welcome();

        boolean finished = false;
        while(!finished){
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing!");
    }
    private void welcome(){
        System.out.println("---------------------------------------------------------------");
        System.out.println("Welcome to Kill The King!");
        System.out.println("The goal of this game, is to chase the King out of the castle.");
        System.out.println("type '!help', if you need help.");
        System.out.println("---------------------------------------------------------------");
    }

    private boolean processCommand(Command command){
        if (command.isNotACommand()){
            System.out.println("That is not a command!");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("!back")){
            //TODO: go to 'previousLocation'... oder wieauimmer es heisst.
        } else if (commandWord.equals("!map")) {
            System.out.println("                                  |----------|     |-------------|");
            System.out.println("                                  | Kronsaal |     | Schatzkammer|");
            System.out.println("                                  |----------|     |-------------|");
            System.out.println("                                        ∧                 ∧");
            System.out.println("|----------|     |----------|     |----------|     |-------------|");
            System.out.println("| Kapelle  | <-> | Hof      | <-> | Ballsaal | <-> | Schlafzimmer|");
            System.out.println("|----------|     |----------|     |----------|     |-------------|");
            System.out.println("                                        v");
            System.out.println("                                  |----------|");
            System.out.println("                                  | Küche    |");
            System.out.println("                                  |----------|");
        } else if (commandWord.equals("!inventory")) {
            //TODO: List items in inventory
        } else if (commandWord.equals("!drop")) {
            //TODO: Drop mit commmandArgument
        } else if (commandWord.equals("!items")) {
            //TODO: List items in room
        } else if (commandWord.equals("!pickup")) {
            //TODO: Mit commandArgumant
        } else if (commandWord.equals("!scare")) {
            //TODO: If king in room = win
        } else if (commandWord.equals("!exits")) {
            //TODO: show exits
        } else if (commandWord.equals("!move")) {
            //Add function that returns direction to move to
            String direction = "east";
            Room.movePlayer(this.rooms, direction);

            goRoom(command);
        } else if (commandWord.equals("!help")) {
            System.out.println("Type '!map' for map of the game.");
            System.out.println("Type '!back' to go to the previous room.");
            System.out.println("Type '!inventory' for a list of all your items.");
            System.out.println("Type '!drop' with an argument.."); //TODO: Ich hen kein bock auf das
            System.out.println("Type '!items' for a list of all items in your location.");
            System.out.println("Type '!pickup' with an argument... "); //TODO: Glich kein bock uf das
            System.out.println("Type '!scare' to kill the king.");
            System.out.println("Type '!exits' to show a list of all exits.");
            System.out.println("Type '!move' with an argument. (north, east, south, west");
            System.out.println("Type '!help' for this view.");
        }
        return false;
    }

    private void goRoom(Command command) {
        if (!command.hasAnArgument()) {
            System.out.println("Go where?");
        } else {
            String name = command.getCommandArgument();

            // Try to leave the current room.
            currentRoom.setContainsPlayer(false); // Set containsPlayer to false in the current room

            Room nextRoom = currentRoom.nextRoom(name);

            if (nextRoom == null)
                System.out.println("There is no door!");
            else {
                nextRoom.setContainsPlayer(true); // Set containsPlayer to true in the next room
                currentRoom = nextRoom;
                System.out.println(currentRoom.whereName());
            }
        }
    }

}
