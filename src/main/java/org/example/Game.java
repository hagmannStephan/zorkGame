package org.example;

import javax.sql.RowSet;
import java.util.ArrayList;

public class Game {
    private Parser parser;
    private ArrayList<Room> rooms;
    private ArrayList<Item> items;
    private Boolean hasWon;

    public void initiate_game() {

        parser = new Parser(System.in);

        Item Messer = new Item("Messer", "Schatzkammer", 200, false,true);
        Item Rose = new Item("Rose", "hof", 5, false, false);
        Item Krone = new Item("Krone", "Kronsaal", 5000, false, false);
        Item Champagne = new Item("Champagne", "Ballsaal", 1000, false,false);
        Item Suppe = new Item("Suppe", "Kueche", 500, false,false);
        Item Gewand = new Item("Gewand", "Schlafzimmer", 2000, false,false);

        ArrayList<Item> items = new ArrayList<Item>() {{
            add(Messer);
            add(Rose);
            add(Krone);
            add(Champagne);
            add(Suppe);
            add(Gewand);
        }};

        this.items = items;

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

        hasWon = false;
        while(!hasWon){
            Command command = parser.getCommand();
            hasWon = processCommand(command);
        }
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
            Room.movePlayerBack(this.rooms);
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
            System.out.println(Item.getInventory(this.items));
        } else if (commandWord.equals("!drop")) {
            Item.dropItem(this.items, command.getCommandArgument(), this.rooms);
        } else if (commandWord.equals("!items")) {
            System.out.println(Room.getItemsInRoom(this.rooms).getItemsInRoom());
        } else if (commandWord.equals("!pickup")) {
            if(!command.hasAnArgument()) {
                System.out.println("Command requires argument");
            } else {
                for (Item item : Room.getItemsInRoom(this.rooms).getItemsInRoom()) {
                    ArrayList<Item> inventoryItems = Item.getInventory(this.items);
                    int weight = 0;
                    for(Item InventoryItem : inventoryItems){
                        int currentWeight = InventoryItem.getWeight();
                        weight += currentWeight;
                    }
                    if (weight > 5000) {
                        System.out.println("You carry too many items. Consider dropping some of them");
                    } else{
                        if(item.getName().equals(command.getCommandArgument())) {
                            item.setPickedUp(true);
                        }
                    }
                }
            }
        } else if (commandWord.equals("!scare")) {
            // Wenn Spieler in Raum mit König und Spieler besitzt Item Messer, dann gewinnen
            if (Room.playerSameRoomKing(this.rooms) && Item.canKillKing(this.items)){
                hasWon = true;
                System.out.println("You scared the King away! You finished the game!");
            } else {
                System.out.println("Can't do this quite yet.");
            }
        } else if (commandWord.equals("!exits")) {
            Room.displayExits(this.rooms);
        } else if (commandWord.equals("!move")) {
            if(!command.hasAnArgument()){
                System.out.println("Command requires argument");
            } else {
                Room.movePlayer(this.rooms, command.getCommandArgument());
            }
        } else if (commandWord.equals("!help")) {
            System.out.println("Type '!map' for map of the game.");
            System.out.println("Type '!back' to go to the previous room.");
            System.out.println("Type '!inventory' for a list of all your items.");
            System.out.println("Type '!drop' with an argument..");
            System.out.println("Type '!items' for a list of all items in your location.");
            System.out.println("Type '!pickup' with an argument... ");
            System.out.println("Type '!scare' to kill the king.");
            System.out.println("Type '!exits' to show a list of all exits.");
            System.out.println("Type '!move' with an argument. (north, east, south, west");
            System.out.println("Type '!help' for this view.");
        }
        return false;
    }
}
