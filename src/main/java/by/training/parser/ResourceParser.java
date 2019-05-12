package by.training.parser;

import by.training.exception.ParserException;

import java.nio.file.Path;
import java.util.List;

public interface ResourceParser {
    List<String> parse(Path path) throws ParserException;
}
