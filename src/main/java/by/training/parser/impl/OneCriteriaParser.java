package by.training.parser.impl;

import by.training.exception.ParserException;
import by.training.parser.ResourceParser;

import java.util.ArrayList;
import java.util.List;

public class OneCriteriaParser implements ResourceParser<String> {

    private static final String paramDelimiter = " ";

    @Override
    public List<String> parse(String path) throws ParserException {
        String[] wordsInRequest = path.split(paramDelimiter);
        List<String> requests = new ArrayList<>();
        for (String request : wordsInRequest) {
            requests.add(request);
        }
        return requests;
    }
}
