package com.carlsen.matrix;

import com.carlsen.math.Fraction;

public class AlteredMatrix implements Matrix {

    private Matrix parent;
    private int row;
    private int column;
    private Fraction alteredValue;

    public AlteredMatrix(Matrix parent, int row, int column, Fraction alteredValue) {
        this.parent = parent;
        this.row = row;
        this.column = column;
        this.alteredValue = alteredValue;
    }

    @Override
    public int getWidth() {
        return parent.getWidth();
    }

    @Override
    public int getHeight() {
        return parent.getHeight();
    }

    @Override
    public Fraction get(int i, int j) {
        if (i == row && j == column) {
            return alteredValue;
        }
        return parent.get(i, j);
    }
}