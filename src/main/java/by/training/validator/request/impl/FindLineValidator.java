package by.training.validator.request.impl;

import by.training.validator.request.RequestLineValidator;
import org.apache.logging.log4j.LogManager;

public class FindLineValidator implements RequestLineValidator {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public boolean valid(String line) {
        boolean validatorResult;
        if (!line.matches("")) {
            LOGGER.warn("Invalid Minus line in valid(String line)");
            validatorResult = new ValidatorResult(false, "Invalid Minus Record");
        } else {
            validatorResult = new ValidatorResult(true);
        }
        return validatorResult;
    }
}
