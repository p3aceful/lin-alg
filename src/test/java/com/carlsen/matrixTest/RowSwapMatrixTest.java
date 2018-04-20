package com.carlsen.matrixTest;

import com.carlsen.math.MatrixEquality;
import com.carlsen.matrix.BaseMatrix;
import com.carlsen.matrix.Matrix;
import com.carlsen.matrix.RowSwapMatrix;
import org.junit.Assert;
import org.junit.Test;

public class RowSwapMatrixTest {
    Matrix original = new BaseMatrix(5, 4, new int[]
            {
                    1,4,5,-9,-7,
                    0,2,4,-6,-6,
                    0,0,0,-5,0,
                    0,0,0,0,0
            });

    Matrix expectedSwapped13 = new BaseMatrix(5, 4, new int[]
            {

                    0,0,0,-5,0,
                    0,2,4,-6,-6,
                    1,4,5,-9,-7,
                    0,0,0,0,0
            });

    Matrix expectedSwapped24= new BaseMatrix(5, 4, new int[]
            {

                    1,4,5,-9,-7,
                    0,0,0,0,0,
                    0,0,0,-5,0,
                    0,2,4,-6,-6,
            });

    @Test
    public void itWorksLeProperly13() {
        Matrix actualSwapped13 = new RowSwapMatrix(original, 1, 3);

        Assert.assertTrue(MatrixEquality.isEqual(actualSwapped13, expectedSwapped13));
    }

    @Test
    public void itWorksLeProperly24() {
        Matrix actualSwapped24 = new RowSwapMatrix(original, 2, 4);

        Assert.assertTrue(MatrixEquality.isEqual(actualSwapped24, expectedSwapped24));
    }

    @Test
    public void SwappedTwiceEqualsOriginal() {
        Matrix first = new RowSwapMatrix(original, 2, 4);
        Matrix second = new RowSwapMatrix(first, 2, 4);

        Assert.assertTrue(MatrixEquality.isEqual(second, original));
    }
}
