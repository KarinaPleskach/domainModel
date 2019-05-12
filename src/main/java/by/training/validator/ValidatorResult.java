package by.training.validator;

public class ValidatorResult {
    private boolean isValid;
    private int firstInvalidLine = 0;
    private String problem;

    public ValidatorResult(boolean isValid) {
        this.isValid = isValid;
    }

    public ValidatorResult(boolean isValid, String problem) {
        this.isValid = isValid;
        this.firstInvalidLine = firstInvalidLine;
        this.problem = problem;
    }

    public ValidatorResult() {
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public int getFirstInvalidLine() {
        return firstInvalidLine;
    }

    public void setFirstInvalidLine(int firstInvalidLine) {
        this.firstInvalidLine = firstInvalidLine;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }
}
