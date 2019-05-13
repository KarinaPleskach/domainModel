package by.training.validator.request.impl;

import by.training.validator.request.RequestLineValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FindLineValidator implements RequestLineValidator {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public boolean valid(String line) {
        boolean validatorResult;
        if (!line.matches("( (duration (\\d+.\\d+-\\d+.\\d+|\\d+.\\d+|all)|record (minus|song|ringtone)|timbre (TENOR|BARITONE|BASS|SOPRANO|MEZZO_SOPRANO|CONTRALTO)|style (ROCK|BLUES|POP|RAP|CLASSICAL|COUNTRY|ELECTRONIC|FOLK|METAL|HIP_HOP|JAZZ)))+")) {
            LOGGER.warn("Invalid find request in valid(String line)");
            validatorResult = false;
        } else {
            validatorResult = true;
        }
        return validatorResult;
    }
}
