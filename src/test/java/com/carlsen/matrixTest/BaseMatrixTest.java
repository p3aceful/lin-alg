package com.carlsen.matrixTest;

import com.carlsen.math.Fraction;
import com.carlsen.matrix.BaseMatrix;
import com.carlsen.matrix.Matrix;
import org.junit.Assert;
import org.junit.Test;


import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.Is.is;

public class BaseMatrixTest {

    Matrix matrix = new BaseMatrix(3, 2, new int[]{1,2,3,4,5,6});

    Matrix empty = new BaseMatrix(0, 0, new int[]{});

    int[][] content = new int[][]
            {
                    {1, 2, 3},
                    {4, 5, 6}
            };

    @Test
    public void getValues() {
        for (int i = 0; i < content.length; i++) {

            for (int j = 0; j < content[i].length; j++) {
                Fraction a = new Fraction(content[i][j]);
                Assert.assertEquals(0, a.compareTo(matrix.get(i+1,j+1)));
            }
        }
    }

    @Test
    public void emptyMatrix() {

        Assert.assertEquals(0, empty.getWidth());
        Assert.assertEquals(0, empty.getHeight());
    }

    @Test
    public void baseMatrixCreation() {
        int[] content = {1};
        Matrix base = new BaseMatrix(1, 1, content);

        Assert.assertThat(base.getWidth(), is(equalTo(1)));
        Assert.assertThat(base.getHeight(), is(equalTo(1)));
        Assert.assertTrue(base.get(1, 1).equals(new Fraction(1)));
    }

}
