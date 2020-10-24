package com.zhursin.operations;

public class Addition implements Operation {
    @Override
    public int calculateResult(int left, int right) {
        return left + right;
    }
}
