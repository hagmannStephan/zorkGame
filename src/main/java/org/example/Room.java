package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Room {
    private String name;
    private ArrayList<Item> itemsInRoom;
    private boolean containsPlayer;
    private boolean containsKing;
    private boolean previousRoom;
    private HashMap<String, Room> exits;

    public boolean isPreviousRoom() {
        return previousRoom;
    }

    public boolean isContainsPlayer() {
        return containsPlayer;
    }

    public boolean isContainsKing() {
        return containsKing;
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

    public void setItemsInRoom(ArrayList<Item> itemsInRoom) {
        this.itemsInRoom = itemsInRoom;
    }

    public void setContainsPlayer(boolean containsPlayer) {
        this.containsPlayer = containsPlayer;
    }

    public void setContainsKing(boolean containsKing) {
        this.containsKing = containsKing;
    }

    public HashMap<String, Room> getExits() {
        return exits;
    }

    public Room(String name,ArrayList<Item> itemInRoom, boolean containsPlayer, boolean containsKing, boolean previousRoom){
        this.name = name;
        this.itemsInRoom = itemInRoom;
        this.containsPlayer = containsPlayer;
        this.containsKing = containsKing;
        this.previousRoom = previousRoom;
        this.exits = new HashMap<>();
    }

    public void setExits(Room north, Room east, Room south, Room west) {
        exits.put("north", north);
        exits.put("east", east);
        exits.put("south", south);
        exits.put("west", west);
    }

    public static void movePlayer(ArrayList<Room> roomList, String direction) {
        Room currentRoom = null;
        for (Room room : roomList) {
            if (room.isContainsPlayer()) {
                currentRoom = room;
                room.setContainsPlayer(false);
                break;
            }
        }

        if (currentRoom != null) {
            Room nextRoom = currentRoom.getExits().get(direction);
            if (nextRoom != null) {
                nextRoom.setContainsPlayer(true);
            } else {
                currentRoom.setContainsPlayer(true);
                System.out.println("There is no room in the " + direction + " direction.");
            }
        } else {
            System.out.println("Player not found in any room.");
        }
    }

    public static void displayExits(ArrayList<Room> rooms) {
        for (Room room : rooms) {
            if (room.containsPlayer) {
                System.out.println("Exits for the room with player:");
                HashMap<String, Room> roomExits = room.getExits();
                for (String exitDirection : roomExits.keySet()) {
                    System.out.println(exitDirection + ": " + roomExits.get(exitDirection));
                }
                return; // Stop searching after finding the room with the player
            }
        }
        System.out.println("No room with player found.");
    }

    public ArrayList<Item> getItemsInRoom() {
        return this.itemsInRoom;
    }

    public static Room getItemsInRoom(ArrayList<Room> rooms) {
        for (Room room : rooms) {
            if(room.containsPlayer) {
                return room;
            }
        }
        return new Room("", new ArrayList<Item>(), false, false, false);
    }

    public static Boolean playerSameRoomKing(ArrayList<Room> rooms){
        for (Room room : rooms){
            if(room.containsPlayer && room.containsKing){
                return true;
            }
        }
        return false;
    }

}
