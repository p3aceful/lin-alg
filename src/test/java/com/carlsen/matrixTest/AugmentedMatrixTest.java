package com.carlsen.matrixTest;

import com.carlsen.math.MatrixEquality;
import com.carlsen.matrix.AugmentedMatrix;
import com.carlsen.matrix.BaseMatrix;
import com.carlsen.matrix.Matrix;
import org.junit.Assert;
import org.junit.Test;

public class AugmentedMatrixTest {
    Matrix firstLeft = new BaseMatrix(2, 2, new int[]
            {
                    1, 2,
                    5, 6,
            });
    Matrix firstRight = new BaseMatrix(2, 2, new int[]
            {
                    3, 4,
                    7, 8,
            });

    Matrix expectedFirst = new BaseMatrix(4, 2, new int[]
            {
                    1,2,3,4,
                    5,6,7,8,
            });

    Matrix expectedFirstFlip = new BaseMatrix(4, 2, new int[]
            {
                    3,4,1,2,
                    7,8,5,6,
            });

    Matrix secondLeft = new BaseMatrix(3, 3, new int[] {
            1,2,3, // 4, 5, 6, 7, 8,
            9, 10, 11, // 12, 13, 14,15,17
            18, 19, 20 // 21,22,23,24,25,
    });

    Matrix secondRight = new BaseMatrix(5, 3, new int[] {
            4, 5, 6, 7, 8,
            12, 13, 14,15,17,
            21,22,23,24,25,
    });

    Matrix expectedSecond = new BaseMatrix(8, 3, new int[] {
            1,  2,  3,  4,  5,  6,  7,  8,
            9, 10, 11, 12, 13, 14, 15, 17,
            18, 19, 20, 21, 22, 23, 24, 25,
    });
    Matrix expectedSecondFlip = new BaseMatrix(8, 3, new int[] {
            4,  5,  6,  7,  8,1,  2,  3,
            12, 13, 14, 15, 17, 9, 10, 11,
            21, 22, 23, 24, 25, 18, 19, 20,
    });

    @Test
    public void first() {
        Assert.assertTrue(isEqual(new AugmentedMatrix(firstLeft, firstRight), expectedFirst));
    }

    @Test
    public void firstFlipped() {
        Assert.assertTrue(isEqual(new AugmentedMatrix(firstRight, firstLeft), expectedFirstFlip));
    }

    @Test
    public void second() {
        Assert.assertTrue(isEqual(new AugmentedMatrix(secondLeft, secondRight), expectedSecond));
    }
    @Test
    public void secondFlipped() {
        Assert.assertTrue(isEqual(new AugmentedMatrix(secondRight, secondLeft), expectedSecondFlip));
    }

    public boolean isEqual(Matrix a, Matrix b) {
        return MatrixEquality.isEqual(a, b);
    }
}
