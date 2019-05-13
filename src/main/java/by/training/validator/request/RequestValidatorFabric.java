package by.training.validator.request;

import by.training.exception.ValidatorException;
import by.training.validator.request.impl.FindLineValidator;
import by.training.validator.request.impl.SortLineValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class RequestValidatorFabric {
    private static final Logger LOGGER = LogManager.getLogger();

    private final Map<RequestName, RequestLineValidator> repository = new HashMap();

    private RequestValidatorFabric() {
        repository.put(RequestName.SORT,new SortLineValidator());
        repository.put(RequestName.FIND, new FindLineValidator());
    }

    public static RequestValidatorFabric getInstance() {
        return FabricHolder.INSTANCE;
    }
    private static class FabricHolder {
        private static final RequestValidatorFabric INSTANCE = new RequestValidatorFabric();
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
