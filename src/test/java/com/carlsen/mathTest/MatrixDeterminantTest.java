package com.carlsen.mathTest;

import com.carlsen.math.Fraction;
import com.carlsen.math.MatrixDeterminant;
import com.carlsen.matrix.BaseMatrix;
import com.carlsen.matrix.Matrix;
import org.junit.Assert;
import org.junit.Test;

public class MatrixDeterminantTest {
    Matrix matrix = new BaseMatrix(3, 3, new int[]
            {
                    1,5,0,
                    2,4,-1,
                    0,-2,0
            }); // Det -2

    Matrix big = new BaseMatrix(5, 5, new int[]
            {
                    3,-7,8,9,-6,
                    0,2,-5,7,3,
                    0,0,1,5,0,
                    0,0,2,4,-1,
                    0,0,0,-2,0
            }); // Det -12

    Matrix medium = new BaseMatrix(4, 4, new int[]
            {
                    5,-7,2,2,
                    0,3,0,-4,
                    -5,-8,0,3,
                    0,5,0,-6
            });

    @Test
    public void smoleMatrixTest() {
        System.out.println(MatrixDeterminant.getDeterminant(matrix));
        Assert.assertEquals(0, new Fraction(-2).compareTo(MatrixDeterminant.getDeterminant(matrix)));
    }

    @Test
    public void bigMatrixTest() {
        System.out.println(MatrixDeterminant.getDeterminant(big));
        Assert.assertEquals(0, new Fraction(-12).compareTo(MatrixDeterminant.getDeterminant(big)));
    }

    @Test
    public void mediumMatrixTest() {
        System.out.println(MatrixDeterminant.getDeterminant(medium));
        Assert.assertEquals(0, new Fraction(20).compareTo(MatrixDeterminant.getDeterminant(medium)));
    }
}
