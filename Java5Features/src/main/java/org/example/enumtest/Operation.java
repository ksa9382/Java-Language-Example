package org.example.enumtest;

/**
 * Enum 클래스의 상수별 메소드 구현
 */
public enum Operation {
    PLUS { public double apply(double x, double y) { return x + y; }},
    MINUS { public double apply(double x, double y) { return x - y; }},
    MULTIPLY { public double apply(double x, double y) { return x * y; }},
    DIVIDE { public double apply(double x, double y) throws ArithmeticException { return x / y; }};

    public abstract double apply(double x, double y);
}
