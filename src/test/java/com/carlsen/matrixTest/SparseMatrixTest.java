package com.carlsen.matrixTest;

import com.carlsen.math.Fraction;
import com.carlsen.math.MatrixEquality;
import com.carlsen.matrix.BaseMatrix;
import com.carlsen.matrix.Matrix;
import com.carlsen.matrix.SparseMatrix;
import org.junit.Test;

public class SparseMatrixTest {
    Matrix longMatrix = new BaseMatrix(2, 5, new int[]
            {
                    1,0,
                    0,1,
                    0,0,
                    0,0,
                    0,0,
            });
    Matrix second = new BaseMatrix(5, 3, new int[]
            {
                    1,-2,-1,3,0,
                    -2,4,5,-5,3,
                    3,-6,-6,8,2,
            });

    Matrix third = new BaseMatrix(5, 3, new Fraction[]
            {
                    new Fraction(1), new Fraction(-2), new Fraction(0), new Fraction(10,3), new Fraction(0),
                    new Fraction(0), new Fraction(0), new Fraction(1), new Fraction(1,3), new Fraction(0),
                    new Fraction(0), new Fraction(0), new Fraction(0), new Fraction(0), new Fraction(1),

            });

    Matrix fourth = new BaseMatrix(3, 3, new int[]
            {
                    1,2,7,
                    -2,5,4,
                    -5,6,-3,
            });
    @Test
    public void sparseMatrixIsSameAsBaseMatrix() {

        SparseMatrix sparse = new SparseMatrix(longMatrix);

        isEqual(sparse, longMatrix);
    }

    @Test
    public void sparseMatrixTestTwo() {
        SparseMatrix sparse = new SparseMatrix(second);
        isEqual(sparse, second);

    }
    @Test
    public void thirdTest() {
        SparseMatrix sparse = new SparseMatrix(third);
        isEqual(sparse, third);
    }
    @Test
    public void fourthTest() {
        SparseMatrix sparse = new SparseMatrix(fourth);
        isEqual(sparse, fourth);
    }

    public boolean isEqual(Matrix a, Matrix b) {
        return MatrixEquality.isEqual(a, b);
    }
}
