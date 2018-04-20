package com.carlsen.start;

import com.carlsen.math.GaussElimination;
import com.carlsen.math.MatrixDeterminant;
import com.carlsen.math.MatrixInverse;
import com.carlsen.matrix.AugmentedMatrix;
import com.carlsen.matrix.BaseMatrix;
import com.carlsen.matrix.Matrix;
import com.carlsen.matrix.MultiplicationMatrix;

import static com.carlsen.util.MatrixPrinter.out;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello douchebags!");

        Matrix test = new BaseMatrix(5, 4, new int[]{
                0,-3,-6, 4, 9,
                -1,-2,-1, 3, 1,
                -2,-3,-0, 3,-1,
                1, 4, 5,-9,-7,
        });

        out(GaussElimination.rowReduce(test));

        Matrix a = new BaseMatrix(3, 3, new int[]{-2, 4, 1, 4, -4, 5, -2, 1, -3});


        out(MatrixInverse.getInverse(a));

        Matrix b = new BaseMatrix(2, 2, new int[]{0, 4, 5, -5});
        out(new MultiplicationMatrix(new MultiplicationMatrix(b, new BaseMatrix(2, 2, new int[]{81, 0, 0, 16})), MatrixInverse.getInverse(b)));

        out(MatrixInverse.getInverse(new BaseMatrix(3,3,new int[]{0,0,0,1})));
    }

}
