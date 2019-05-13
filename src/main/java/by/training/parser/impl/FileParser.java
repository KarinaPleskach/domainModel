package by.training.parser.impl;

import by.training.exception.ParserException;
import by.training.parser.ResourceParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileParser implements ResourceParser<Path> {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public List<String> parse(Path path) throws ParserException {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            LOGGER.fatal("Can not parse file in parse(Path path)");
            throw new ParserException();
        }
        if (lines.size() == 0) {
            LOGGER.error("file is empty in parse(Path path)");
            throw new ParserException();
        }
        return lines;
    }
}
