package org.example;

public class Item {
    public String name;
    public String location;
    public int weight;
    public boolean isPickedUp;
    public boolean ableToKillKing;

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
    }
}
