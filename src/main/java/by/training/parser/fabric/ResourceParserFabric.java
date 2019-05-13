package by.training.parser.fabric;

import by.training.parser.ResourceParser;
import by.training.parser.impl.FileParser;

import java.nio.file.Path;

public class ResourceParserFabric {
    private static ResourceParser<Path> parser = new FileParser();
    private ResourceParserFabric() {}
    public static ResourceParser<Path> getParser() {
        return  parser;
    }
}
