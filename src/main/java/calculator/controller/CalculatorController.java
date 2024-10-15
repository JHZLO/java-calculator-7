package calculator.controller;

import calculator.model.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final OutputView outputview;
    private final InputView inputView;

    public CalculatorController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputview = outputView;
    }

    public void run() {
        String expression = inputAddition();
        Calculator calculator = new Calculator(expression);
    }

    private String inputAddition() { // 덧셈 문자열을 입력 받는다.
        return inputView.inputAdditionString();
    }
}
