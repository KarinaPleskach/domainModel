package by.training.validator;

import by.training.validator.record.RecordLineValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

class RecordLinesValidator implements LinesValidator {

    private static final Logger LOGGER = LogManager.getLogger();

    private static final char paramDelimiter = ' ';
    private final ValidatorProvider provider = new ValidatorProvider();

    @Override
    public ValidatorResult valid(List<String> lines) {
        ValidatorResult validatorResult = null;
        int i = 1;
        for (String line : lines) {
            String type = line.substring(0, (line.indexOf(paramDelimiter) != -1) ? line.indexOf(paramDelimiter) : line.length());
            type = type.toUpperCase();

            RecordLineValidator validator;
            validator = provider.getValidator(type);
            validatorResult = validator.valid(line);

            if (validatorResult.isValid() == false) {
                LOGGER.warn("Invalid lines in valid(String line)");
                validatorResult.setFirstInvalidLine(i);
                break;
            }
            ++i;
        }
        return validatorResult;
    }
}