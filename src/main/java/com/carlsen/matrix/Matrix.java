package com.carlsen.matrix;

import com.carlsen.math.Fraction;

public interface Matrix {
    int getWidth();
    int getHeight();
    Fraction get(int i, int j);
}
