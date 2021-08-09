package com.epam.tc;

import com.epam.tat.module4.Calculator;

public class Operations {

    Calculator calculator = new Calculator();

    public double sum(double num1, double num2) {
        return calculator.sum(num1, num2);
    }

    public double sub(double num1, double num2) {

        return calculator.sub(num1, num2);
    }

    public double mult(double num1, double num2) {
        return calculator.mult(num1, num2);
    }

    public double div(double num1, double num2) {
        return calculator.div(num1, num2);
    }
}
