package com.carlsen.math;

import com.carlsen.matrix.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GaussElimination {

    public static Matrix rowReduce(Matrix matrix) {


        return new SparseMatrix
                (
                        scalePivots
                                (
                                        backwardReduce
                                                (
                                                        forwardReduce(matrix)
                                                )
                                )
                );
    }

    public static Matrix forwardReduce(Matrix matrix) {

        int row = 1;
        for (int col = 1; col <= matrix.getWidth(); col++) {

            Matrix view = new SubMatrix(matrix, row - 1, col - 1);
            List<Fraction> elementsOfFirstColumn = getElementsFromColumn(view, 1);

            Optional<Fraction> first = elementsOfFirstColumn.stream()
                    .filter(fraction -> !fraction.equals(Fraction.zero))
                    .findAny();

            if (!first.isPresent()) { // If every entry is zero, move to next column.
                continue;
            }

            if (elementsOfFirstColumn.indexOf(first.get()) != 0) {
                // Swapping must be performed.
                matrix = new RowSwapMatrix(matrix, elementsOfFirstColumn.indexOf(first.get()) + row, row);
                Collections.swap(elementsOfFirstColumn, 0, elementsOfFirstColumn.indexOf(first.get()));
            }
            Matrix id = new IdentityMatrix(matrix.getHeight());
            List<Fraction> coefficients = elementsOfFirstColumn.stream()
                    .skip(1)
                    .map(f -> findNullCoefficient(elementsOfFirstColumn.get(0), f))
                    .collect(Collectors.toList());

            for (int i = 0; i < coefficients.size(); i++) {
                id = new AlteredMatrix(id, row + (i + 1), row, coefficients.get(i));
            }

            matrix = new MultiplicationMatrix(id, matrix);
            row += 1;
        }
        return matrix;
    }

    public static Matrix backwardReduce(Matrix matrix) {

        for (int row = 2; row <= matrix.getWidth(); row++) {
            for (int col = 1; col <= matrix.getWidth(); col++) {

                if (matrix.get(row, col).equals(Fraction.zero)) {
                    continue;
                }
                Fraction pivot = matrix.get(row, col);
                Matrix id = new IdentityMatrix(matrix.getHeight());
                for (int i = 0; i < row - 1; i++) {
                    Fraction above = matrix.get(i + 1, col);
                    id = new AlteredMatrix(id, i + 1, row, findNullCoefficient(pivot, above));
                }

                matrix = new MultiplicationMatrix(id, matrix);
                break;
            }

        }
        return matrix;
    }

    public static Matrix scalePivots(Matrix matrix) {
        Matrix id = new IdentityMatrix(matrix.getHeight());
        for (int row = 1; row <= matrix.getHeight(); row++) {
            for (int col = 1; col <= matrix.getWidth(); col++) {

                if (matrix.get(row, col).equals(Fraction.zero)) {
                    continue;
                }
                id = new AlteredMatrix(id, row, row, FracOps.divide(new Fraction(1), matrix.get(row, col)));
                break;
            }
        }

        return new MultiplicationMatrix(id, matrix);
    }

    public static List<Fraction> getElementsFromColumn(Matrix matrix, int n) {
        return IntStream.range(0, matrix.getHeight())
                .mapToObj(i -> matrix.get(i + 1, n))
                .collect(Collectors.toList());
    }

    public static Fraction findNullCoefficient(Fraction pivot, Fraction other) {
        if (other.equals(Fraction.zero)) {
            return Fraction.zero;
        }

        return FracOps.negate(FracOps.divide(other, pivot));
    }

    public static boolean isInTriangularForm(Matrix matrix) {

        if (matrix.getWidth() == 0 || matrix.getHeight() == 1) {
            return true;
        }

        for (int i = 1; i < matrix.getHeight(); i++) {
            if (!matrix.get(i + 1, 1).equals(Fraction.zero)) {
                return false;
            }
        }

        Fraction topLeft = matrix.get(1, 1);

        if (topLeft.equals(Fraction.zero)) {
            return isInTriangularForm(new SubMatrix(matrix, 0, 1));

        } else {
            return isInTriangularForm(new SubMatrix(matrix, 1, 1));
        }
    }

    public static boolean isInReducedTriangularForm(Matrix matrix) {

        Fraction zero = new Fraction(0);

        int row = 1;

        for (int column = 1; column <= matrix.getWidth(); column++) {

            Fraction current = matrix.get(row, column);
            Fraction[] others;
            int start = 1;
            if (current.compareTo(zero) == 0) {
                others = new Fraction[matrix.getHeight() - (row - 1)];
                start = start + row;

            } else {
                others = new Fraction[matrix.getHeight()];
            }

            for (int k = start; k <= matrix.getHeight(); k++) {
                if (k == row) continue;
                others[k - start] = matrix.get(k, column);
            }

            for (Fraction other : others) {
                if (other == null) continue;
                if (other.compareTo(zero) != 0) {
                    return false;
                }
            }

            if (current.compareTo(zero) != 0) {
                row += 1;
            }

            if (row > matrix.getHeight()) {
                break;
            }
        }
        return true;
    }
}
