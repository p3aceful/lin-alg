package com.carlsen.matrix;

import com.carlsen.math.Fraction;

public class TransposedMatrix implements Matrix {

    private Matrix parent;

    public TransposedMatrix(Matrix matrix) {
        this.parent = matrix;
    }

    @Override
    public int getWidth() {
        return parent.getHeight();
    }

    @Override
    public int getHeight() {
        return parent.getWidth();
    }

    @Override
    public Fraction get(int i, int j) {

        return parent.get(j, i);
    }
}
