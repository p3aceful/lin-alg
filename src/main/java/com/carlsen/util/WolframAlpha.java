package com.carlsen.util;

import com.carlsen.math.Fraction;
import com.carlsen.matrix.Matrix;

public class WolframAlpha {

    public static String help(Matrix matrix) {

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < matrix.getHeight(); i++) {
            sb.append("{");
            for (int j = 0; j < matrix.getWidth(); j++) {
                Fraction frac = matrix.get(i + 1, j + 1);

                sb.append(frac.getDenominator() == 1 ? frac.getNumerator() : frac.toString());
                if (j+1 < matrix.getWidth()) {
                    sb.append(",");
                }
            }
            sb.append("}");
            if (i+1 < matrix.getHeight()) {
                sb.append(",");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
