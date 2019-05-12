package by.training.controller;

import by.training.controller.comand.Command;
import by.training.exception.ControllerException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

final class DiskController implements Controller {

    private static final Logger LOGGER = LogManager.getLogger();

    private final CommandProvider provider = new CommandProvider();
    private static final char paramDelimiter = ' ';

    public String executeTask(String request) {
        String commandName;
        Command executionCommand;
        commandName = request.substring(0, (request.indexOf(paramDelimiter) != -1) ? request.indexOf(paramDelimiter) : request.length());
        executionCommand = provider.getCommand(commandName);
        String response = "empty";
        try {
            response = executionCommand.execute(request);
        } catch (ControllerException e) {
            LOGGER.error("exception in method");
        }
        return response;
    }
}
