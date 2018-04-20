package com.carlsen.mathTest;

import com.carlsen.math.GaussElimination;
import com.carlsen.matrix.BaseMatrix;
import com.carlsen.matrix.IdentityMatrix;
import com.carlsen.matrix.Matrix;
import org.junit.Assert;
import org.junit.Test;

public class EchelonFormTest {
    Matrix id = new IdentityMatrix(5);

    Matrix longMatrix = new BaseMatrix(6, 3,
            new int[] {
                    1, 0, -2, 3, 0, -24,
                    0, 1, -2, 2, 0, -7,
                    0, 0, 0, 0, 1, 4,
            });

    Matrix notInEchelonForm = new BaseMatrix(5, 4, new int[]
            {
                    0, -3, -6, 4, 9,
                    -1, -2, -1, 3, 1,
                    -2, -3, 0, 3, -1,
                    1, 4, 5, -9, -7,
            });

    Matrix shouldBeInEchelonForm = new BaseMatrix(5, 4, new int[]
            {
                    1,4,5,-9,-7,
                    0,2,4,-6,-6,
                    0,0,0,-5,0,
                    0,0,0,0,0
            });

    Matrix definitelyNotInEchelonForm = new BaseMatrix(5, 4, new int[]
            {
                    1, 4, 5, -9, -7,
                    0, 2, 4,-6,-6,
                    0, 5,10,-15,-15,
                    0,-3,-6,4,9,
            });
    @Test
    public void identityMatrixIsInEchelonForm() {
        Assert.assertTrue(GaussElimination.isInTriangularForm(id));
    }

    @Test
    public void longMatrixShouldBeInEchForm() {
        Assert.assertTrue(GaussElimination.isInTriangularForm(longMatrix));
    }

    @Test
    public void shouldNotBeInEchelonForm() {
        Assert.assertFalse(GaussElimination.isInTriangularForm(notInEchelonForm));
    }

    @Test
    public void thisShouldBeInEchelonForm() {
        Assert.assertTrue(GaussElimination.isInTriangularForm(shouldBeInEchelonForm));
    }

    @Test
    public void ifThisIsInEchelonFormThenItDoesntWork() {
        Assert.assertFalse(GaussElimination.isInTriangularForm(definitelyNotInEchelonForm));
    }
}
