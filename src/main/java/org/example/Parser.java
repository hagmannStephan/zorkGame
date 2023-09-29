package org.example;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Parser {

    private CommandWord validCommandWords;
    private InputStream inputStream;

    public Parser(InputStream inputStream) {
        this.inputStream = inputStream;
        this.validCommandWords = new CommandWord();
    }

    public Command getCommand() {
        String inputLine;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.inputStream));
        try {
            inputLine = bufferedReader.readLine();
            String[] tokens = inputLine.split(" ");
            if (tokens.length == 2) {
                if (validCommandWords.isCommand(tokens[0])) {
                    return new Command(tokens[0], tokens[1]);
                } else {
                    return new Command(null, tokens[1]);
                }
            } else if (tokens.length == 1) {
                if (validCommandWords.isCommand(tokens[0])) {
                    return new Command(tokens[0]);
                } else {
                    return new Command(null);
                }
            }
        } catch (java.io.IOException exc) {
            System.out.println("There was an error during reading: " + exc.getMessage());
        }
        return new Command(null);
    }

    public String showCommands() {
        return validCommandWords.showAll();
    }
}
