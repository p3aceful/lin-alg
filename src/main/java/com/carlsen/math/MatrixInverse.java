package com.carlsen.math;

import com.carlsen.matrix.*;

public class MatrixInverse {

    public static Matrix getInverse(Matrix matrix) {

        if (matrix.getWidth() != matrix.getHeight()) {
            throw new RuntimeException("Non square matrix. Not invertible");
        }

        if (MatrixDeterminant.getDeterminant(matrix).getNumerator() == 0) {
            throw new RuntimeException("Matrix is singular. Not invertible.");
        }

        int width = matrix.getWidth();
        Matrix id = new IdentityMatrix(matrix.getHeight());
        Matrix augmented = new AugmentedMatrix(matrix, id);

        Matrix reduced = GaussElimination.rowReduce(augmented);


        return new SparseMatrix(new SubMatrix(reduced, 0, width));
    }
}
