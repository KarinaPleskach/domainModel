package by.training.validator.record.impl;

import by.training.validator.ValidatorResult;
import by.training.validator.record.RecordLineValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RingtoneLineValidator implements RecordLineValidator {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public ValidatorResult valid(String line) {
        ValidatorResult validatorResult;
        if (!line.matches("Ringtone \\w+ \\d+ \\d+")) {
            LOGGER.warn("Invalid Minus line in valid(String line)");
            validatorResult = new ValidatorResult(false, "Invalid Minus Record");
        } else {
            validatorResult = new ValidatorResult(true);
        }
        return validatorResult;
    }
}
