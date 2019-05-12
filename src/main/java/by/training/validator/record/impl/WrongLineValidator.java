package by.training.validator.record.impl;

import by.training.validator.ValidatorResult;
import by.training.validator.record.RecordLineValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WrongLineValidator implements RecordLineValidator {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public ValidatorResult valid(String line) {
        LOGGER.warn("Invalid type in valid(String line)");
        ValidatorResult validatorResult = new ValidatorResult(false, "Invalid type of record");
        return validatorResult;
    }
}