package by.training.validator.record;

import by.training.validator.ValidatorResult;

public interface RecordLineValidator {
    ValidatorResult valid(String line);
}
