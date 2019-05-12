package by.training.validator.request;

import by.training.exception.ValidatorException;
import by.training.validator.request.impl.FindLineValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class RequestValidatorFabric {
    private static final Logger LOGGER = LogManager.getLogger();

    private final Map<RequestName, RequestLineValidator> repository = new HashMap();

    public RequestValidatorFabric() {
        repository.put(RequestName.FIND, new FindLineValidator());
    }

    public RequestLineValidator getRequestValidator(String name) throws ValidatorException {
        RequestLineValidator validator;
        try {
            validator = repository.get(RequestName.valueOf(name.toUpperCase()));
        } catch (IllegalArgumentException ex) {
            LOGGER.warn("Illegal request in getRequestValidator(String name)");
            throw new ValidatorException();
        }
        return validator;
    }
}
