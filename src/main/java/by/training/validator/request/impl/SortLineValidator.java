package by.training.validator.request.impl;

import by.training.validator.request.RequestLineValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SortLineValidator implements RequestLineValidator {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public boolean valid(String line) {
        boolean validatorResult;
        if (!line.matches(" (ascending|descending)( (song_name_sort|style_sort))+")) {
            LOGGER.warn("Invalid find request in valid(String line)");
            validatorResult = false;
        } else {
            validatorResult = true;
        }
        return validatorResult;
    }
}
