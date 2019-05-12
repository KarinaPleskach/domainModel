package by.training.controller.comand.impl;

import by.training.controller.comand.Command;
import by.training.exception.ServiceException;
import by.training.service.DiskService;
import by.training.service.fabric.ServiceFabric;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class OpenDisk implements Command {

    private static final Logger LOGGER = LogManager.getLogger();

    private static final char paramDelimiter = ' ';

    public String execute(String request) {
        LOGGER.info("task: " + request);

        String url;
        String response;
        url = request.substring(request.indexOf(paramDelimiter) + 1);
        url = url.substring(0, (url.indexOf(paramDelimiter) != -1) ? url.indexOf(paramDelimiter) : url.length());
        response = "Error during opening disk..";

        Path path;
        try {
            path = Paths.get(url);
        } catch (InvalidPathException ex) {
            LOGGER.error("Error during opening disk in execute(String request)");
            return response;
        }

        if (Files.exists(path) && Files.isRegularFile(path)) {
            try {
                DiskService service = ServiceFabric.getService();
                service.update(path);
                response = "Welcome!";
            } catch (ServiceException e) {
                LOGGER.error("Error during opening disk in execute(String request)");
            }
        } else {
            LOGGER.error("Error during opening disk in execute(String request)");
        }

        return response;
    }
}
