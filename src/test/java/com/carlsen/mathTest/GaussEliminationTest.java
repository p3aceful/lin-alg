package com.carlsen.mathTest;

import com.carlsen.math.Fraction;
import com.carlsen.math.GaussElimination;
import com.carlsen.math.MatrixEquality;
import com.carlsen.matrix.BaseMatrix;
import com.carlsen.matrix.Matrix;
import com.carlsen.util.MatrixPrinter;
import com.carlsen.util.WolframAlpha;
import org.junit.Assert;
import org.junit.Test;

public class GaussEliminationTest {
    Matrix first = new BaseMatrix(5, 4, new int[]{
            0,-3,-6, 4, 9,
            -1,-2,-1, 3, 1,
            -2,-3,-0, 3,-1,
            1, 4, 5,-9,-7,
    });

    Matrix expectedFirstResult = new BaseMatrix(5, 4, new int []
            {
                    1, 0, -3, 0, 5,
                    0, 1, 2, 0, -3,
                    0, 0, 0, 1, 0,
                    0, 0, 0, 0, 0
            });

    Matrix second = new BaseMatrix(6, 3, new int[]
            {
                    0, 3, -6, 6, 4, -5,
                    3, -7, 8, -5, 8, 9,
                    3, -9, 12, -9, 6,15,
            });

    Matrix expectedSecondResult = new BaseMatrix(6, 3, new int []
            {
                    1, 0, -2, 3, 0, -24,
                    0, 1, -2, 2, 0, -7,
                    0, 0, 0, 0, 1, 4
            });

    Matrix third = new BaseMatrix(5, 3, new int[]
            {
                    1,-2,-1,3,0,
                    -2,4,5,-5,3,
                    3,-6,-6,8,2,
            });
    Matrix expectedThirdResult = new BaseMatrix(5, 3, new Fraction[]
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
    Matrix expectedFourthResult = new BaseMatrix(3, 3, new int[]
            {
                    1, 0, 3,
                    0, 1, 2,
                    0, 0, 0,
            });

    Matrix fifth = new BaseMatrix(6, 3, new int[]
            {
                    0,1,2,1,0,0,
                    1,0,3,0,1,0,
                    4,-3,8,0,0,1,
            });

    Matrix expectedFifthResult = new BaseMatrix(6, 3, new Fraction[]
            {
                    new Fraction(1), new Fraction(0), new Fraction(0), new Fraction(-9,2), new Fraction(7),new Fraction(-3,2),
                    new Fraction(0), new Fraction(1), new Fraction(0), new Fraction(-2), new Fraction(4),new Fraction(-1),
                    new Fraction(0), new Fraction(0), new Fraction(1), new Fraction(3,2), new Fraction(-2),new Fraction(1,2),
            });

    Matrix sixth = new BaseMatrix(2, 5, new int[]
            {
                    6,4,
                    -2,1,
                    -3,7,
                    -1,3,
                    5,2,
            });
    Matrix expectedSixthResult = new BaseMatrix(2, 5, new int[]
            {
                    1,0,
                    0,1,
                    0,0,
                    0,0,
                    0,0,
            });

    Matrix seventh = new BaseMatrix(3, 3, new int[]
            {
                    3,-1,3,
                    6,0,12,
                    2,1,7,
            });
    Matrix expectedSeventhResult = new BaseMatrix(3, 3, new int[]
            {
                    1, 0, 2,
                    0, 1, 3,
                    0, 0, 0,
            });
    @Test
    public void first() {
//        System.out.println("start: " + MatrixPrinter.toString(first));
//        System.out.println("expected: " + MatrixPrinter.toString(expectedFirstResult));
//        System.out.println("actual: " + MatrixPrinter.toString(GaussElimination.rowReduce(first)));
        Assert.assertTrue(MatrixEquality.isEqual(expectedFirstResult, GaussElimination.rowReduce(first)));
    }

    @Test
    public void second() {
//        System.out.println("start: " + MatrixPrinter.toString(second));
//        System.out.println("expected: " + MatrixPrinter.toString(expectedSecondResult));
//        System.out.println("actual: " + MatrixPrinter.toString(GaussElimination.rowReduce(second)));
        Assert.assertTrue(MatrixEquality.isEqual(expectedSecondResult, GaussElimination.rowReduce(second)));
    }

    @Test
    public void third() {
//        System.out.println(WolframAlpha.help(third));
//        System.out.println("start: " + MatrixPrinter.toString(third));
//        System.out.println("expected: " + MatrixPrinter.toString(expectedThirdResult));
//        System.out.println("actual: " + MatrixPrinter.toString(GaussElimination.rowReduce(third)));
        Assert.assertTrue(MatrixEquality.isEqual(expectedThirdResult, GaussElimination.rowReduce(third)));
    }

    @Test
    public void fourth() {
//        System.out.println(WolframAlpha.help(third));
//        System.out.println("start: " + MatrixPrinter.toString(fourth));
//        System.out.println("expected: " + MatrixPrinter.toString(expectedFourthResult));
//        System.out.println("actual: " + MatrixPrinter.toString(GaussElimination.rowReduce(fourth)));
        Assert.assertTrue(MatrixEquality.isEqual(expectedFourthResult, GaussElimination.rowReduce(fourth)));
    }

    @Test
    public void fifth() {
//        System.out.println(WolframAlpha.help(fifth));
//        System.out.println("start: " + MatrixPrinter.toString(fifth));
//        System.out.println("expected: " + MatrixPrinter.toString(expectedFifthResult));
//        System.out.println("actual: " + MatrixPrinter.toString(GaussElimination.rowReduce(fifth)));
        Assert.assertTrue(MatrixEquality.isEqual(expectedFifthResult, GaussElimination.rowReduce(fifth)));
    }

    @Test
    public void sixth() {
//        System.out.println(WolframAlpha.help(sixth));
//        System.out.println("start: " + MatrixPrinter.toString(sixth));
//        System.out.println("expected: " + MatrixPrinter.toString(expectedSixthResult));
//        System.out.println("actual: " + MatrixPrinter.toString(GaussElimination.rowReduce(sixth)));
        Assert.assertTrue(MatrixEquality.isEqual(expectedSixthResult, GaussElimination.rowReduce(sixth)));
    }

    @Test
    public void seventh() {
//        System.out.println(WolframAlpha.help(seventh));
//        System.out.println("start: " + MatrixPrinter.toString(seventh));
//        System.out.println("expected: " + MatrixPrinter.toString(expectedSeventhResult));
//        System.out.println("actual: " + MatrixPrinter.toString(GaussElimination.rowReduce(seventh)));
        Assert.assertTrue(MatrixEquality.isEqual(expectedSeventhResult, GaussElimination.rowReduce(seventh)));
    }
}
