package com.carlsen.matrixTest;

import com.carlsen.matrix.AdditionMatrix;
import com.carlsen.matrix.BaseMatrix;
import com.carlsen.matrix.Matrix;
import org.junit.Test;

public class AdditionMatrixTest {
    Matrix singular1 = new BaseMatrix(1, 1, new int[]{9});
    Matrix singular2 = new BaseMatrix(1, 1, new int[]{9});

    Matrix singular1PlusSingular2 = new BaseMatrix(1, 1, new int[]{18});

    @Test
    public void singularMatrixWorks() {
        Matrix add = new AdditionMatrix(singular1, singular2);

    }
}
