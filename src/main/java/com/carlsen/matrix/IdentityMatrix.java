package com.carlsen.matrix;

import com.carlsen.math.Fraction;

public class IdentityMatrix implements Matrix {

    private int n;

    public IdentityMatrix(int n) {
        this.n = n;
    }

    @Override
    public int getWidth() {
        return n;
    }

    @Override
    public int getHeight() {
        return n;
    }

    @Override
    public Fraction get(int i, int j) {

        return i == j ? new Fraction(1) : Fraction.zero;
    }
}
