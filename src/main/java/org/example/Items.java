package org.example;

public class Items {
    public String name;
    public String location;
    public int weight;
    public boolean ableToBePickedUp;
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

    public boolean isAbleToBePickedUp() {
        return ableToBePickedUp;
    }

    public void setAbleToBePickedUp(boolean ableToBePickedUp) {
        this.ableToBePickedUp = ableToBePickedUp;
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

    public Items(String name, String location, int weight, boolean ableToBePickedUp, boolean isPickedUp, boolean ableToKillKing){
        this.name = name;
        this.location = location;
        this.weight = weight;
        this.ableToBePickedUp = ableToBePickedUp;
        this.isPickedUp = isPickedUp;
        this.ableToKillKing = ableToKillKing;
    }
}
