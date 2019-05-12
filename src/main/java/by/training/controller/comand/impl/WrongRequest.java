package by.training.controller.comand.impl;

import by.training.controller.comand.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WrongRequest implements Command {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public String execute(String request) {
        LOGGER.warn("Illegal request in execute(String request)");
        String response = "Illegal request";
        return response;
    }
}
