package com.zhursin;

import com.zhursin.Roman.RomanNumerals;
import com.zhursin.operations.*;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

public class Calculator {
    private Map<String, Operation> operationMap = new HashMap<>();
    Calculator() {
        operationMap.put("+", new Addition());
        operationMap.put("-", new Substraction());
        operationMap.put("*", new Multiplication());
        operationMap.put("/", new Division());
    }
    public int calculateArabic(String operand1, String operation, String operand2) {
        int leftInt, rightInt;
        boolean numValid = true;
        int result = 0;

        leftInt = Integer.parseInt(operand1);
        rightInt = Integer.parseInt(operand2);

        try {
            if (leftInt < 1 || leftInt > 10) {
                numValid = false;
                throw new Exception("Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более.");
            }

            if (rightInt < 1 || rightInt > 10) {
                numValid = false;
                throw new Exception("Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более.");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


        if (numValid == true) {
            Operation operationMapValue = operationMap.getOrDefault(operation, new NoOperationFound(operation));
            result = operationMapValue.calculateResult(leftInt, rightInt);
        }
        return result;
    }
    public void calculateRomans(String leftNumber, String operation, String rightNumber) {
        boolean numValid = true;
        int leftInt, rightInt;
        int resultInt = 0;

        leftInt = RomanNumerals.parse(leftNumber.toUpperCase());
        rightInt = RomanNumerals.parse(rightNumber.toUpperCase());

        if (leftInt == -1) {
            numValid = false;
            throw new InputMismatchException("Неправильное число: " + leftNumber);
            //System.out.println("Неправильное число: " + leftNumber);
        }
        if (rightInt == -1) {
            numValid = false;
            throw new InputMismatchException("Неправильное число: " + rightNumber);
            //System.out.println("Неправильное число: " + rightNumber);
        }

        try {
            if (leftInt < 1 || leftInt > 10) {
                numValid = false;
                throw new Exception("Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более.");
            }

            if (rightInt < 1 || rightInt > 10) {
                numValid = false;
                throw new Exception("Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более.");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        if (numValid == true) {
            Operation operationMapValue = operationMap.getOrDefault(operation, new NoOperationFound(operation));
            resultInt = operationMapValue.calculateResult(leftInt, rightInt);
            System.out.println(RomanNumerals.format(resultInt));
        }
    }
}
