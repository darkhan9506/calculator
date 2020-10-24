package com.zhursin.operations;

import com.zhursin.operations.Operation;

import java.util.InputMismatchException;

public class NoOperationFound implements Operation {
    private String sign;
    public NoOperationFound(String sign) {
        this.sign = sign;
    }
    @Override
    public int calculateResult(int left, int right) {
        throw new InputMismatchException("Неправильный знак: " + sign);
    }
}
