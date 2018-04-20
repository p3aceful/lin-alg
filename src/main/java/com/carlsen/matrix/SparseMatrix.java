package com.carlsen.matrix;

import com.carlsen.math.Fraction;

import java.util.HashMap;
import java.util.Map;

public class SparseMatrix implements Matrix {

    private int height, width;
    private Map<Integer, Fraction> content = new HashMap<>();

    public SparseMatrix(Matrix other) {
        this.height = other.getHeight();
        this.width = other.getWidth();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Fraction value = other.get(i + 1, j + 1);

                if (value.getNumerator() != 0) {
                    content.put((i) * width + (j), value);
                }
            }
        }
    }


    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public Fraction get(int i, int j) {
        if (content.containsKey((i - 1) * width + (j - 1))) {
            return content.get((i - 1) * width + (j - 1));
        }
        return new Fraction(0);
    }
}
