package com.carlsen.matrixTest;

import com.carlsen.math.MatrixEquality;
import com.carlsen.matrix.BaseMatrix;
import com.carlsen.matrix.Matrix;
import com.carlsen.matrix.SubMatrix;
import org.junit.Assert;
import org.junit.Test;

public class SubMatrixTest {
    Matrix first = new BaseMatrix(5, 3, new int[] {
            4, 5, 6, 7, 8,
            12, 13, 14,15,17,
            21,22,23,24,25,
    });

    Matrix firstOneOneSubMatrixExpected = new BaseMatrix(4, 2, new int[] {
            13,14,15,17,
            22,23,24,25,
    });

    Matrix firstOneFourSubMatrixExpected = new BaseMatrix(1, 2, new int[] {
            17
            ,25
    });
    @Test
    public void first() {
        Matrix sub = new SubMatrix(first, 1, 1);
        Assert.assertEquals(sub.getWidth(), firstOneOneSubMatrixExpected.getWidth());
        Assert.assertEquals(sub.getHeight(), firstOneOneSubMatrixExpected.getHeight());
        Assert.assertTrue(equals(sub, firstOneOneSubMatrixExpected));
    }

    @Test
    public void second() {
        Matrix sub = new SubMatrix(first, 1, 4);
        Assert.assertEquals(sub.getWidth(), firstOneFourSubMatrixExpected.getWidth());
        Assert.assertEquals(sub.getHeight(), firstOneFourSubMatrixExpected.getHeight());
        Assert.assertTrue(equals(sub, firstOneFourSubMatrixExpected));
    }

    public boolean equals(Matrix a, Matrix b) {
        return MatrixEquality.isEqual(a, b);
    }
}
