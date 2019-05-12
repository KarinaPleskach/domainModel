package by.training.validator;

import by.training.validator.record.*;
import by.training.validator.record.impl.MinusLineValidator;
import by.training.validator.record.RecordName;
import by.training.validator.record.impl.RingtoneLineValidator;
import by.training.validator.record.impl.SongLineValidator;
import by.training.validator.record.impl.WrongLineValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class ValidatorProvider {

    private static final Logger LOGGER = LogManager.getLogger();

    private final Map<RecordName, RecordLineValidator> repository = new HashMap();

    ValidatorProvider() {
        repository.put(RecordName.MINUS, new MinusLineValidator());
        repository.put(RecordName.RINGTONE, new RingtoneLineValidator());
        repository.put(RecordName.SONG, new SongLineValidator());
        repository.put(RecordName.WRONG, new WrongLineValidator());
    }

    RecordLineValidator getValidator(String name){
        RecordLineValidator validator;
        try {
            validator = repository.get(RecordName.valueOf(name));
        } catch (IllegalArgumentException ex) {
            LOGGER.info("Illegal request in getValidator(String name)");
            validator = repository.get(RecordName.WRONG);
        }
        return validator;
    }
}
