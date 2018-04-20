package com.carlsen.matrix;

import com.carlsen.math.Fraction;

public class RowSwapMatrix implements Matrix {

    private int swappedRow1;
    private int swappedRow2;
    private Matrix parent;

    public RowSwapMatrix(Matrix parent, int swappedRow1, int swappedRow2) {
        this.parent = parent;
        this.swappedRow1 = swappedRow1;
        this.swappedRow2 = swappedRow2;
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

        if (i == swappedRow1) {
            i = swappedRow2;
        }
        else if (i == swappedRow2) {
            i = swappedRow1;
        }
        return parent.get(i, j);
    }
}
