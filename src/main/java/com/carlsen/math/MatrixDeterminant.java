package com.carlsen.math;

import com.carlsen.matrix.CrossedSubMatrix;
import com.carlsen.matrix.Matrix;

public class MatrixDeterminant {

    public static Fraction getDeterminant(Matrix matrix) {

        if (matrix.getHeight() != matrix.getWidth()) {
            throw new RuntimeException("Not a square matrix exception, lol");
        }

        return calculate(matrix);
    }

    private static Fraction calculate(Matrix matrix) {

        if (matrix.getWidth() == 2) {
            return FracOps.subtract(FracOps.multiply(matrix.get(1, 1), matrix.get(2, 2)), FracOps.multiply(matrix.get(1, 2), matrix.get(2, 1)));
        }

        Fraction sum = new Fraction(0);

        for (int i = 0; i < matrix.getWidth(); i++) {

            if (matrix.get(1, i + 1).getNumerator() == 0) {
                continue;
            }

            sum = FracOps.add(sum, FracOps.multiply(new Fraction(i % 2 == 0 ? 1 : -1), FracOps.multiply(matrix.get(1, i + 1), calculate(new CrossedSubMatrix(matrix, 1, i + 1)))));
        }

        return sum;
    }
}
