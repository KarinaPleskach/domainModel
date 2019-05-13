package by.training.controller.comand.impl;

import by.training.controller.comand.Command;
import by.training.entity.Record;
import by.training.exception.ServiceException;
import by.training.service.DiskService;
import by.training.service.fabric.ServiceFabric;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Sort implements Command {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public String execute(String request) {
        LOGGER.info("task: " + request);

        DiskService service = ServiceFabric.getService();
        String response = "Error with sorting in execute(String request)";

        request = request.substring(4);
        try {
            service.sort(request);
            response = "Sorted";
        } catch (ServiceException e) {
            LOGGER.warn("warn from Service");
        }
        return response;
    }
}
