package com.carlsen.mathTest;

import com.carlsen.math.GaussElimination;
import com.carlsen.matrix.BaseMatrix;
import com.carlsen.matrix.Matrix;
import org.junit.Assert;
import org.junit.Test;

public class GaussEliminationTriangularTest {
    private Matrix singleton = new BaseMatrix(1, 1, new int[]{1});
    private Matrix singleton2 = new BaseMatrix(1, 1, new int[]{0});

    // Reduced triangular form matrices
    private Matrix redTriangular1 = new BaseMatrix(6, 3,
            new int[] {
                    1, 0, -2, 3, 0, -24,
                    0, 1, -2, 2, 0, -7,
                    0, 0, 0, 0, 1, 4,
            });

    private Matrix redTriangular2 = new BaseMatrix(4, 4, new int[]{
            1, 0, 0, 0,
            0, 1, 0, 0,
            0, 0, 1, 0,
            0, 0, 0, 1,
    });

    // Non triangular form matrices
    private Matrix nonTriangular1 = new BaseMatrix(5, 4, new int[]
            {
                    0, -3, -6, 4, 9,
                    -1, -2, -1, 3, 1,
                    -2, -3, 0, 3, -1,
                    1, 4, 5, -9, -7,
            });
    private Matrix nonTriangular2 = new BaseMatrix(5, 4, new int[]
            {
                    1, 4, 5, -9, -7,
                    0, 2, 4,-6,-6,
                    0, 5,10,-15,-15,
                    0,-3,-6,4,9,
            });
    private Matrix nonTriangular3 = new BaseMatrix(4, 4, new int[]
            {
                    5,-7,2,2,
                    0,3,0,-4,
                    -5,-8,0,3,
                    0,5,0,-6
            });
    private Matrix nonTriangular4 = new BaseMatrix(3, 3, new int[]
            {
                    1,5,0,
                    2,4,-1,
                    0,-2,0
            }); // Det -2
    private Matrix nonTriangular5 = new BaseMatrix(4, 4, new int[]{
            1, 0, 0, 0,
            0, 0, 0, 1,
            0, 0, 1, 0,
            0, 1, 0, 0,
    });


    // Triangular form matrices
    private Matrix triangular1 = new BaseMatrix(5, 4, new int[]
            {
                    1,4,5,-9,-7,
                    0,2,4,-6,-6,
                    0,0,0,-5,0,
                    0,0,0,0,0
            });

    private Matrix triangular2 = new BaseMatrix(5, 5, new int[]
            {
                    3,-7,8,9,-6,
                    0,2,-5,7,3,
                    0,0,1,5,0,
                    0,0,2,4,-1,
                    0,0,0,-2,0
            }); // Det -12

    private Matrix triangular3 = new BaseMatrix(2, 5, new int[] {
            6,4,
            0,9,
            0,0,
            0,0,
            0,0,
    });

    @Test
    public void shouldAllBeInReducedTriangularForm() {
        System.out.println("oh no");
        Assert.assertTrue(GaussElimination.isInReducedTriangularForm(redTriangular1));
        System.out.println(":o");
        Assert.assertTrue(GaussElimination.isInReducedTriangularForm(redTriangular2));

//        Assert.assertTrue(MatrixEquality.isEqual(GaussElimination.rowReduce(aa), ae));
    }


    @Test
    public void triangularButNotReduced() {
        Assert.assertFalse(GaussElimination.isInReducedTriangularForm(triangular1));
        Assert.assertFalse(GaussElimination.isInReducedTriangularForm(triangular2));
        Assert.assertTrue(GaussElimination.isInTriangularForm(triangular3));
    }

    @Test
    public void nonTriangularNonReduced() {
        Assert.assertFalse(GaussElimination.isInReducedTriangularForm(nonTriangular1));
        Assert.assertFalse(GaussElimination.isInReducedTriangularForm(nonTriangular2));
        Assert.assertFalse(GaussElimination.isInReducedTriangularForm(nonTriangular3));
        Assert.assertFalse(GaussElimination.isInReducedTriangularForm(nonTriangular4));
        Assert.assertFalse(GaussElimination.isInReducedTriangularForm(nonTriangular5));
    }

    @Test
    public void singletonMatrix() {
        Assert.assertTrue(GaussElimination.isInReducedTriangularForm(singleton));
        Assert.assertTrue(GaussElimination.isInReducedTriangularForm(singleton2));
    }
}
