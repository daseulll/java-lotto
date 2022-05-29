package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StringCalculator {
    private static List<String> arithmeticOperator = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));
    private Stack<Integer> operands = new Stack<>();
    private Stack<String> operators = new Stack<>();


    public Integer run(List<String> strings) {


        for (String string : strings) {
            if (isNumeric(string)) {
                operands.push(Integer.parseInt(string));
            }

            if (arithmeticOperator.contains(string)) {
                operators.push(string);
            };
        }
        calculate();
        return operands.pop();
    }

    private void calculate() {
        if (operators.size() == 0) {
            return;
        }

        String operator = operators.pop();
        if (operator.equals("+")) {
            operands.push(plus(operands.pop(), operands.pop()));
            calculate();
        }

        if (operator.equals("-")) {
            operands.push(minus(operands.pop(), operands.pop()));
            calculate();
        }

        if (operator.equals("*")) {
            operands.push(multiply(operands.pop(), operands.pop()));
            calculate();
        }

        if (operator.equals("/")) {
            operands.push(divide(operands.pop(), operands.pop()));
            calculate();
        }
    }

    private static int plus(int leftOperand, int rightOperand) {
        return leftOperand + rightOperand;
    }

    private static int minus(int leftOperand, int rightOperand){
        return rightOperand - leftOperand;
    }

    private static int multiply(int leftOperand, int rightOperand){
        return  leftOperand * rightOperand;
    }

    private static int divide(int leftOperand, int rightOperand){
        return  rightOperand / leftOperand;
    }

    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }

        try{
            Double.parseDouble(strNum);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
