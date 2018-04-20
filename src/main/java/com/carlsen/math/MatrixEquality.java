package com.carlsen.math;

import com.carlsen.matrix.Matrix;

public class MatrixEquality {

    public static boolean isEqual(Matrix a, Matrix b) {

        if (a.getHeight() != b.getHeight() || a.getWidth() != b.getWidth()) {
            return false;
        }

        for (int i = 0; i < a.getHeight(); i++) {

            for (int j = 0; j < a.getWidth(); j++) {

                if (a.get(i + 1, j + 1).compareTo(b.get(i + 1, j + 1)) != 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
