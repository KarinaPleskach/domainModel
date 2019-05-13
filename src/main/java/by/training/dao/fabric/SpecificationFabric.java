package by.training.dao.fabric;

import by.training.dao.Specification;
import by.training.dao.specification.*;
import by.training.entity.Record;
import by.training.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class SpecificationFabric {

    private enum Fields {
        DURATION, RECORD, TIMBRE, STYLE, SONG_NAME, PERFORMER, BAND, SOLO_ARTIST
    }

    public static final Logger LOGGER = LogManager.getLogger();

    private final Map<Fields, Specification<Record>> repository = new HashMap();

    public SpecificationFabric(String searchValue) {
        repository.put(Fields.DURATION, new ByDurationSpecification(searchValue));
        repository.put(Fields.RECORD, new ByRecord(searchValue));
        repository.put(Fields.TIMBRE, new ByTimbre(searchValue));
        repository.put(Fields.STYLE, new ByStyle(searchValue));
        repository.put(Fields.SONG_NAME, new BySongName(searchValue));
        repository.put(Fields.PERFORMER, new ByPerformer(searchValue));
        repository.put(Fields.BAND, new ByBand(searchValue));
        repository.put(Fields.SOLO_ARTIST, new BySoloArtist(searchValue));
    }

    public Specification<Record> getSpecification(String name) throws DAOException {
        try {
            Specification<Record> searchSpecification = repository.get(Fields.valueOf(name.toUpperCase()));
            return searchSpecification;
        } catch (IllegalArgumentException e) {
            LOGGER.warn("Illegal request in getSpecification(String name)");
            throw new DAOException();
        }
    }
}
