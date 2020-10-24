package com.zhursin.operations;

import com.zhursin.operations.Operation;

public class Substraction implements Operation {
    @Override
    public int calculateResult(int left, int right) {
        return left - right;
    }
}
