package by.training.controller.comand.impl;

import by.training.controller.comand.Command;
import by.training.entity.Record;
import by.training.exception.ControllerException;
import by.training.exception.ServiceException;
import by.training.service.DiskService;
import by.training.service.fabric.ServiceFabric;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Show implements Command {

    private static final Logger LOGGER = LogManager.getLogger();

    public String execute(String request) throws ControllerException {
        LOGGER.info("task: " + request);

        DiskService service = ServiceFabric.getService();
        List<Record> recordList = null;
        String response = "empty";
        try {
            recordList = service.show();
            response = recordList.toString();
        } catch (ServiceException e) {
            LOGGER.warn("unuseful result from service");
        }
        return response;
    }
}
