package by.training.controller;

import by.training.controller.comand.Command;
import by.training.controller.comand.CommandName;
import by.training.controller.comand.impl.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

class CommandProvider {

    private static final Logger LOGGER = LogManager.getLogger();

    private final Map<CommandName, Command> repository = new HashMap();

    CommandProvider() {
        repository.put(CommandName.OPEN_DISK, new OpenDisk());
        repository.put(CommandName.DELETE, new Delete());
        repository.put(CommandName.FIND, new Find());
        repository.put(CommandName.SHOW, new Show());
        repository.put(CommandName.SORT, new Sort());
        repository.put(CommandName.SUM, new Sum());
        repository.put(CommandName.ADD, new Add());
        repository.put(CommandName.SAVE, new Save());
        repository.put(CommandName.WRONG_REQUEST,new WrongRequest());
    }

    Command getCommand(String name){
        Command command;
        try{
            command = repository.get(CommandName.valueOf(name.toUpperCase()));
        }catch(IllegalArgumentException ex){
            LOGGER.warn("Illegal request in getCommand(String name)");
            command = repository.get(CommandName.WRONG_REQUEST);
        }
        return command;
    }
}
