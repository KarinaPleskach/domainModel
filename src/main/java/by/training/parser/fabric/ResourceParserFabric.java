package by.training.parser;

public class ResourceParserFabric {
    private static ResourceParser parser = new FileParser();
    private ResourceParserFabric() {}
    public static ResourceParser getParser() {
        return  parser;
    }
}
