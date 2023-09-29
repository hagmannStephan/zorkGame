package org.example;

import java.util.Arrays;
import java.util.List;

public class CommandWord {
    private List<String> validCommands = Arrays.asList("!back", "!map", "!inventory", "!drop", "!items", "!pickup", "!scare", "!exits", "!move", "!help");

    public boolean isCommand(String validCommandWord){
        return validCommands.stream()
                .filter(c -> c.equals(validCommandWord))
                .count()>0;
    }
}
