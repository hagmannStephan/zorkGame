package org.example;

public class Command {
    private String commandWord;
    private String commandArgument;

    public Command(String commandWord, String commandArgument) {
        this.commandWord = commandWord;
        this.commandArgument = commandArgument;
    }
    public Command(String commandWord){
        this(commandWord, null);
    }

    public String getCommandWord() {
        return commandWord;
    }

    public String getCommandArgument() {
        return commandArgument;
    }

    public boolean isNotACommand(){
        return (commandWord==null);
    }

    public boolean hasAnArgument(){
        return (commandArgument!=null);
    }
}
