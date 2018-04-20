package com.carlsen.matrix;

import com.carlsen.math.Fraction;

public class CrossedSubMatrix implements Matrix {

    private int eliminatedRow;
    private int eliminatedColumn;
    private Matrix parent;

    public CrossedSubMatrix(Matrix parent, int eliminatedRow, int eliminatedColumn) {
        this.parent = parent;
        this.eliminatedColumn = eliminatedColumn;
        this.eliminatedRow = eliminatedRow;
    }

    @Override
    public int getWidth() {
        return parent.getWidth() - (eliminatedColumn == 0 ? 0 : 1);
    }

    @Override
    public int getHeight() {
        return parent.getHeight() - (eliminatedRow == 0 ? 0 : 1);
    }

    @Override
    public Fraction get(int i, int j) {

        if (i >= eliminatedRow && eliminatedRow != 0) {
            i++;
        }
        if (j >= eliminatedColumn && eliminatedColumn != 0) {
            j++;
        }
        return parent.get(i, j);
    }
}
