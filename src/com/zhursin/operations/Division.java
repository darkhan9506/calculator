package com.zhursin.operations;

import com.zhursin.operations.Operation;

public class Division implements Operation {
    @Override
    public int calculateResult(int left, int right) {
        if(right == 0) {
            throw new ArithmeticException("на 0 делить нелья!");
        }
        return left/right;
    }
}
