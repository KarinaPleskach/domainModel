package by.training.validator.record.impl;

import by.training.validator.ValidatorResult;
import by.training.validator.record.RecordLineValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MinusLineValidator implements RecordLineValidator {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public ValidatorResult valid(String line) {
        ValidatorResult validatorResult;
        if (!line.matches("Minus \\w+ \\d+ \\d+ (Band|SoloArtist) [A-Za-z_0-9]+ (ROCK|BLUES|POP|RAP|CLASSICAL|COUNTRY|ELECTRONIC|FOLK|METAL|HIP_HOP|JAZZ)")) {
            LOGGER.warn("Invalid Minus line in valid(String line)");
            validatorResult = new ValidatorResult(false, "Invalid Minus Record");
        } else {
            validatorResult = new ValidatorResult(true);
        }
        return validatorResult;
    }
}
