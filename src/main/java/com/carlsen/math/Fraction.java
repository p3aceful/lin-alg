package com.carlsen.math;

public class Fraction implements Comparable<Fraction> {

    public static final Fraction zero = new Fraction(0);

    private int numerator;
    private int denominator;

    public Fraction(int numerator) {

        this.numerator = numerator;
        this.denominator = 1;
    }

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("The denominator is zero");
        }
        if (numerator == 0) {
            this.numerator = 0;
            this.denominator = 1;
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }

        if (denominator < 0) {
            this.numerator = -1 * this.numerator;
            this.denominator = -1 * this.denominator;
        }
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public double getReal() {
        return (double) numerator / denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public int compareTo(Fraction o) {
        int a = getNumerator(),
                b = getDenominator(),
                c = o.getNumerator(),
                d = o.getDenominator();

        if (a * d > b * c) {
            return 1;

        } else if (a * d < b * c) {
            return -1;

        } else {
            return 0;
        }
    }

    public boolean equals(Fraction other) {
        return this.numerator * other.getDenominator() == this.denominator * other.getNumerator();
    }
}