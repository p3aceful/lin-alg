package com.carlsen.mathTest;

import com.carlsen.math.MatrixEquality;
import com.carlsen.matrix.BaseMatrix;
import com.carlsen.matrix.Matrix;
import org.junit.Assert;
import org.junit.Test;

public class MatrixEqualityTest {
    Matrix a = new BaseMatrix(2, 2, new int[]{5,1,3,-2});
    Matrix b = new BaseMatrix(2, 2, new int[]{2, 0, 4, 3});

    @Test
    public void aMatrixMustBeEqualToItself() {
        Assert.assertTrue(MatrixEquality.isEqual(a, a));
        Assert.assertTrue(MatrixEquality.isEqual(b, b));
    }

    @Test
    public void aMatrixIsNotEqualADifferentMatrix() {
        Assert.assertFalse(MatrixEquality.isEqual(a, b));
        Assert.assertFalse(MatrixEquality.isEqual(b, a));
    }
}
