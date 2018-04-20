package com.carlsen.matrix;

import com.carlsen.math.Fraction;

public class BaseMatrix implements Matrix {

    private Fraction[] content;
    private int width;
    private int height;

    public BaseMatrix(int width, int height, int[] content) {
        this.width = width;
        this.height = height;

        this.content = new Fraction[this.width * this.height];
        for (int i = 0; i < content.length; i++) {
            this.content[i] = new Fraction(content[i]);
        }
    }

    public BaseMatrix(int width, int height, Fraction[] content) {
        this.width = width;
        this.height = height;
        this.content = content;
    }

    public BaseMatrix(Matrix matrix) {
        this.width = matrix.getWidth();
        this.height = matrix.getHeight();

        this.content = new Fraction[matrix.getWidth() * matrix.getHeight()];
        for (int i = 0; i < matrix.getHeight() * matrix.getWidth(); i++) {
            int row = (i / getWidth()) + 1;
            int column = (i % getWidth()) + 1;
            content[i] = matrix.get(row, column);
        }
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public Fraction get(int i, int j) {
        return content[(i - 1) * width + (j - 1)];
    }
}
