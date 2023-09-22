package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class Room {
    private String name;
    private ArrayList<Item> itemInRoom;
    private HashMap<String, Room> exits;
    private boolean containsPlayer;
    private boolean containsKing;
    private boolean previousRoom;

    public boolean isPreviousRoom() {
        return previousRoom;
    }

    public void setPreviousRoom(boolean previousRoom) {
        this.previousRoom = previousRoom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Item> getItemInRoom() {
        return itemInRoom;
    }

    public void setItemInRoom(ArrayList<Item> itemInRoom) {
        this.itemInRoom = itemInRoom;
    }

    public HashMap<String, Room> getExits() {
        return exits;
    }

    public void setExits(HashMap<String, Room> exits) {
        this.exits = exits;
    }

    public boolean isContainsPlayer() {
        return containsPlayer;
    }

    public void setContainsPlayer(boolean containsPlayer) {
        this.containsPlayer = containsPlayer;
    }

    public boolean isContainsKing() {
        return containsKing;
    }

    public void setContainsKing(boolean containsKing) {
        this.containsKing = containsKing;
    }

    public Room(String name,ArrayList<Item> itemInRoom,HashMap<String, Room>exits, boolean containsPlayer, boolean containsKing, boolean previousRoom){
        this.name = name;
        this.itemInRoom = itemInRoom;
        this.exits = exits;
        this.containsPlayer = containsPlayer;
        this.containsKing = containsKing;
        this.previousRoom = previousRoom;
    }
    public void setExits(Room north, Room east, Room south, Room west) {
        exits.put("north", north);
        exits.put("east", east);
        exits.put("south", south);
        exits.put("west", west);
    }
}
