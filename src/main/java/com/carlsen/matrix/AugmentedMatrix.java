package com.carlsen.matrix;

import com.carlsen.math.Fraction;

public class AugmentedMatrix implements Matrix {

    private Matrix left, right;

    public AugmentedMatrix(Matrix left, Matrix right) {
        if (left.getHeight() != right.getHeight()) {
            throw new RuntimeException("Augmented matrix with two different heights is not allowed.");
        }
        this.left = left;
        this.right = right;
    }

    @Override
    public int getWidth() {
        return left.getWidth() + right.getWidth();
    }

    @Override
    public int getHeight() {
        return left.getHeight();
    }

    @Override
    public Fraction get(int i, int j) {
        if (left.getWidth() < j) {
            return right.get(i, j - left.getWidth());
        }
        return left.get(i, j);
    }
}
