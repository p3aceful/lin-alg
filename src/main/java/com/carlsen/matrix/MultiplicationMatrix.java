package com.carlsen.matrix;

import com.carlsen.math.FracOps;
import com.carlsen.math.Fraction;

public class MultiplicationMatrix implements Matrix {

    private Matrix factor1;
    private Matrix factor2;

    public MultiplicationMatrix(Matrix factor1, Matrix factor2) {

        if (factor1.getWidth() != factor2.getHeight()) {
            throw new RuntimeException("Incompatible matrix multiplication, lol");
        }
        this.factor1 = factor1;
        this.factor2 = factor2;
    }

    @Override
    public int getWidth() {
        return factor2.getWidth();
    }

    @Override
    public int getHeight() {
        return factor1.getHeight();
    }

    @Override
    public Fraction get(int i, int j) {
        Fraction sum = new Fraction(0);

        for (int k = 0; k < factor1.getWidth(); k++) {

            Fraction a = factor1.get(i, k + 1);
            Fraction b = factor2.get(k + 1, j);
            sum = FracOps.add(sum, FracOps.multiply(a, b));

        }
        return sum;
    }
}
