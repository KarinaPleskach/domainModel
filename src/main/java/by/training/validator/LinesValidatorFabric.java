package by.training.validator;

public class LinesValidatorFabric {
    private static LinesValidator validator = new RecordLinesValidator();
    private LinesValidatorFabric() {}
    public static LinesValidator getValidator() {
        return  validator;
    }
}
