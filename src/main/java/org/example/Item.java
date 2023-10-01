package org.example;

import java.util.ArrayList;

public class Item {
    private String name;
    private String location;
    private int weight;
    private boolean isPickedUp;
    private boolean ableToKillKing;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isPickedUp() {
        return isPickedUp;
    }

    public void setPickedUp(boolean pickedUp) {
        isPickedUp = pickedUp;
    }

    public boolean isAbleToKillKing() {
        return ableToKillKing;
    }

    public void setAbleToKillKing(boolean ableToKillKing) {
        this.ableToKillKing = ableToKillKing;
    }

    public Item(String name, String location, int weight, boolean isPickedUp, boolean ableToKillKing){
        this.name = name;
        this.location = location;
        this.weight = weight;
        this.isPickedUp = isPickedUp;
        this.ableToKillKing = ableToKillKing;

        // TODO: Place the Item in the correct location, this also has to be true if it is dropped again
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", weight=" + weight +
                ", isPickedUp=" + isPickedUp +
                ", ableToKillKing=" + ableToKillKing +
                '}';
    }

    public static ArrayList<Item> getInventory (ArrayList<Item> items){
        ArrayList<Item> inventory = new ArrayList<Item>();
        for (Item item : items) {
            if(item.isPickedUp) {
                inventory.add(item);
            }
        }
        return inventory;
    }
}
