package com.carlsen.matrixTest;

import com.carlsen.math.Fraction;
import com.carlsen.math.MatrixEquality;
import com.carlsen.matrix.*;
import org.junit.Assert;
import org.junit.Test;

public class MultiplicationMatrixTest {
    Matrix a = new BaseMatrix(2, 2, new int[]
            {
                    5,1,
                    3,-2
            });

    Matrix b = new BaseMatrix(2, 2, new int[]
            {
                    2, 0,
                    4, 3
            });

    Matrix expectedResultOfAtimesB = new BaseMatrix(2, 2, new int[]
            {
                    14,3,
                    -2,-6
            });

    Matrix twoxtwo = new BaseMatrix(2, 2, new int[]{2,3,1,-5});
    Matrix threextwo = new BaseMatrix(3, 2, new int[]{4,3,6,1,-2,3});
    Matrix expectedResult = new BaseMatrix(3,2, new int[]{11,0,21,-1,13,-9});


    Matrix alteredIDMatrix = new BaseMatrix(4, 4, new Fraction[] {
            new Fraction(1),new Fraction(0),new Fraction(0),new Fraction(0),
            new Fraction(0),new Fraction(1),new Fraction(0),new Fraction(0),
            new Fraction(0),new Fraction(-2,5),new Fraction(1),new Fraction(0),
            new Fraction(0),new Fraction(3, 5),new Fraction(0),new Fraction(1),
    });

    Matrix multiplywithalteredmatrix = new BaseMatrix(5, 4, new int[] {
            1,4,5,-9,-7,
            0,5,10,-15,-15,
            0,2,4,-6,-6,
            0,-3,-6,4,9,
    });

    // HOly heck some serious wrong is now here
    Matrix seriousId = new AlteredMatrix(new IdentityMatrix(3), 3, 2, new Fraction(2,3));
    Matrix seriousOg = new BaseMatrix(6, 3, new int[]
            {
                    3, -7, 8, -5, 8, 9,
                    0, 3, -6, 6, 4, -5,
                    0, -2, 4, -4, -2, 6,
            });

    Matrix seriousExpected = new BaseMatrix(6, 3, new int[]
            {
                    3, -7, 8, -5, 8, 9,
                    0, 3, -6, 6, 4, -5,
                    0, 0, 0, 0, 0, 0,
            });

    Matrix holy = new AlteredMatrix(new AlteredMatrix(seriousExpected, 3, 5, new Fraction(2,3)), 3, 6, new Fraction(8,3));

    @Test
    public void theSeriousestTest() {
        Assert.assertTrue(MatrixEquality.isEqual(new MultiplicationMatrix(seriousId, seriousOg), holy));
    }

    @Test
    public void seriousGetTest() {
        Assert.assertTrue(new MultiplicationMatrix(seriousId, seriousOg).get(3, 5).compareTo(seriousId.get(3, 2)) == 0);
    }

    @Test
    public void abtest() {
        Assert.assertTrue(MatrixEquality.isEqual(new MultiplicationMatrix(a, b), expectedResultOfAtimesB));
    }

    @Test
    public void ebububutest() {
        Assert.assertTrue(MatrixEquality.isEqual(new MultiplicationMatrix(twoxtwo, threextwo), expectedResult));
    }

    @Test
    public void thisFailedOnce() {

        Matrix expected = new BaseMatrix(5, 4, new int[] {
                1,4,5,-9,-7,
                0,5,10,-15,-15,
                0,0,0,0,0,
                0,0,0,-5,0,
        });

        Assert.assertTrue(MatrixEquality.isEqual(new MultiplicationMatrix(alteredIDMatrix, multiplywithalteredmatrix), expected));
    }
}
