package com.carlsen.util;

import com.carlsen.math.FracOps;
import com.carlsen.math.Fraction;
import com.carlsen.matrix.Matrix;

public class MatrixPrinter {

    public static String toString(Matrix matrix) {
        StringBuilder sb = new StringBuilder();

        sb.append("  ");
        for (int i = 0; i < matrix.getWidth(); i++) {
            sb.append("-----");
        }
        sb.append("\n");

        for (int i = 0; i < matrix.getHeight(); i++) {
            sb.append("|");
            for (int j = 0; j < matrix.getWidth(); j++) {
                Fraction current = matrix.get(i+1, j+1);
                String negBuffer = (current.getNumerator() < 0 ? " " : "  ");

                current = FracOps.simplify(current);
                String print;
                if (current.getDenominator() == 1 || current.getNumerator() == 0) {
                    print = " " + current.getNumerator() + " ";
                } else {
                    print = current.toString();
                }

                sb.append(negBuffer + print);
            }
            sb.append(" |");
            sb.append("\n");

        }

        sb.append("  ");
        for (int i = 0; i < matrix.getWidth(); i++) {
            sb.append("-----");
        }
        sb.append("\n");
        return sb.toString();
    }

    public static void out(Matrix matrix) {
        System.out.println(toString(matrix));
    }
}
