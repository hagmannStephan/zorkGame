package org.example;

public class Zork2Game {
    public static void main(String[] args) {
        Game zorkgame = new Game();

        zorkgame.initiate_game();
        System.out.println("Game initiated successfully");

        zorkgame.play();
    }
}
