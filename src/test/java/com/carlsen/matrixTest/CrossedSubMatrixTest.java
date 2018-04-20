package com.carlsen.matrixTest;

import com.carlsen.math.Fraction;
import com.carlsen.matrix.BaseMatrix;
import com.carlsen.matrix.CrossedSubMatrix;
import com.carlsen.matrix.Matrix;
import org.junit.Assert;
import org.junit.Test;

public class CrossedSubMatrixTest {
    Matrix matrix = new BaseMatrix(4, 4, new int[]
            {
                    1,2,3,4,
                    5,6,7,8,
                    9,10,11,12,
                    13,14,15,16,
            });

    Matrix subMatrix = new CrossedSubMatrix(matrix,2, 2);

    int[][] content = new int[][]
            {
                    {1, 3, 4},
                    {9, 11, 12},
                    {13, 15, 16},
            };

    @Test
    public void r1c1() {
        Assert.assertEquals(0, subMatrix.get(1, 1).compareTo(new Fraction(content[0][0])));
    }
    @Test
    public void r1c2() {
        Assert.assertEquals(0, subMatrix.get(1, 2).compareTo(new Fraction(content[0][1])));
    }
    @Test
    public void r1c3() {
        Assert.assertEquals(0, subMatrix.get(1, 3).compareTo(new Fraction(content[0][2])));
    }

    @Test
    public void r2c1() {
        Assert.assertEquals(0, subMatrix.get(2, 1).compareTo(new Fraction(content[1][0])));
    }

    @Test
    public void r2c2() {
        Assert.assertEquals(0, subMatrix.get(2, 2).compareTo(new Fraction(content[1][1])));
    }
    @Test
    public void r2c3() {
        Assert.assertEquals(0, subMatrix.get(2, 3).compareTo(new Fraction(content[1][2])));
    }

    @Test
    public void r3c1() {
        Assert.assertEquals(0, subMatrix.get(3, 1).compareTo(new Fraction(content[2][0])));
    }
    @Test
    public void r3c2() {
        Assert.assertEquals(0, subMatrix.get(3, 2).compareTo(new Fraction(content[2][1])));
    }
    @Test
    public void r3c3() {
        Assert.assertEquals(0, subMatrix.get(3, 3).compareTo(new Fraction(content[2][2])));
    }
    @Test
    public void getValues() {

        for (int i = 0; i < subMatrix.getWidth(); i++) {

            for (int j = 0; j < subMatrix.getHeight(); j++) {
                Fraction entry = new Fraction(content[i][j]);
//                System.out.println("Comparing: " + entry + " to " + subMatrix.get(i+1,j+1));
                Assert.assertEquals(0, subMatrix.get(i+ 1, j+1).compareTo(entry));
            }
        }
    }
}
