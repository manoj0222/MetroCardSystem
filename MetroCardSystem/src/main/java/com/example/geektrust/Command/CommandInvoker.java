package com.example.geektrust.Command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.geektrust.Exception.NoSuchCommandException;

public class CommandInvoker {

	private static final Map<String, ICommand> commandMap = new HashMap<>();

    // Register the command into the HashMap
    public void register(String commandName, ICommand command) {
        commandMap.put(commandName, command);
    }

    // Get the registered Command
    private ICommand get(String commandName) {
        return commandMap.get(commandName);
    }

    public void executeCommand(String commandName, List<String> tokens) throws NoSuchCommandException {
        ICommand command = get(commandName);
        if(command == null){
            // Handle Exception
            throw new NoSuchCommandException();
        }
        command.execute(tokens);
    }


}
