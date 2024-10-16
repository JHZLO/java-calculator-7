package calculator.model;

public class Expression {
    private final String expression;

    public Expression(String expression){
        validateExpression(expression);
        this.expression = expression;
    }

    public String extractSeparator(){
        String separator = ",:";
        if(hasCustomSeparator(expression)){
            String customSeparator = extractCustomSeparator(expression);
            separator += customSeparator;
        }
        return separator;
    }

    public String extractActualExpression() {
        if (hasCustomSeparator(expression)) {
            return extractActualExpression(expression);
        }
        return expression;
    }
    private void validateExpression(String expression) {
        if (hasCustomSeparator(expression)) {
            validateCustomExpression(expression);
            return;
        }
        validateNotCustomExpression(expression);
    }

    private boolean hasCustomSeparator(String expression) {
        return expression.startsWith("//") && expression.contains("\\n");
    }

    private void validateCustomExpression(String expression) {
        if (hasInvalidCustomInput(expression)) {
            throw new IllegalArgumentException("유효하지 않은 문자열이 포함되어 있습니다.");
        }
    }

    private boolean hasInvalidCustomInput(String expression) {
        String customSeparator = extractCustomSeparator(expression);
        String actualExpression = extractActualExpression(expression);
        String regex = "[0-9,: " + customSeparator + "]*";
        return !actualExpression.matches(regex);
    }

    public String extractCustomSeparator(String expression) {
        int start = expression.indexOf("//") + 2;
        int end = expression.indexOf("\\n");
        return expression.substring(start, end);
    }

    private String extractActualExpression(String expression) {
        int start = expression.indexOf("\\n") + 2;
        return expression.substring(start);
    }

    private void validateNotCustomExpression(String expression) {
        if (hasInvalidinput(expression)) {
            throw new IllegalArgumentException("유효하지 않은 문자가 포함되어 있습니다.");
        }
    }

    private boolean hasInvalidinput(String expression) {
        String regex = "[0-9,:]*";
        return !expression.matches(regex);
    }

}
