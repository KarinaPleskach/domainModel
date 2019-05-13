package by.training.parser.fabric;

import by.training.exception.ParserException;
import by.training.parser.ResourceParser;
import by.training.parser.impl.OneCriteriaParser;
import by.training.parser.impl.TwoCriteriaParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class RequestParserFabric {
    private static final Logger LOGGER = LogManager.getLogger();

    private enum WordsInREquest {
        ONE, TWO
    }

    private final Map<WordsInREquest, ResourceParser<String>> repository = new HashMap();

    private RequestParserFabric() {
        repository.put(WordsInREquest.TWO, new TwoCriteriaParser());
        repository.put(WordsInREquest.ONE, new OneCriteriaParser());
    }

    public static RequestParserFabric getInstance() {
        return FabricHolder.INSTANCE;
    }
    private static class FabricHolder {
        private static final RequestParserFabric INSTANCE = new RequestParserFabric();
    }

    public ResourceParser<String> getRequestParser(String name) throws ParserException {
        ResourceParser<String> parser;
        try {
            parser = repository.get(WordsInREquest.valueOf(name.toUpperCase()));
        } catch (IllegalArgumentException ex) {
            LOGGER.warn("Illegal request in getRequestParser(String name)");
            throw new ParserException();
        }
        return parser;
    }
}
