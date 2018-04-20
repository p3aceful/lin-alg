package com.carlsen.matrix;

import com.carlsen.math.Fraction;

public class SubMatrix implements Matrix {

    private Matrix parent;
    private int top;
    private int left;

    public SubMatrix(Matrix matrix, int top, int left) {
        this.parent = matrix;
        this.top = top;
        this.left = left;
    }

    @Override
    public int getWidth() {
        return parent.getWidth() - left;
    }

    @Override
    public int getHeight() {
        return parent.getHeight() - top;
    }

    @Override
    public Fraction get(int i, int j) {
        return parent.get(i + top, j + left);
    }
}

