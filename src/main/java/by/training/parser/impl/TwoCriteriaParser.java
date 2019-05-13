package by.training.parser.impl;

import by.training.exception.ParserException;
import by.training.parser.ResourceParser;

import java.util.ArrayList;
import java.util.List;

public class TwoCriteriaParser implements ResourceParser<String> {

    private static final String paramDelimiter = " ";

    @Override
    public List<String> parse(String path) throws ParserException {
        String[] wordsInRequest = path.split(paramDelimiter);
        List<String> requests = new ArrayList<>();
        for (int i = 0; i < wordsInRequest.length; i += 2) {
            requests.add(wordsInRequest[i] + " " + wordsInRequest[i + 1]);
        }
        return requests;
    }
}
