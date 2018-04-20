package com.carlsen.mathTest;

import com.carlsen.math.Fraction;
import com.carlsen.math.GaussElimination;
import org.junit.Assert;
import org.junit.Test;

public class FindNullCoefficientTest {
    @Test
    public void plusplus() {
        Fraction pivot = new Fraction(5);
        Fraction rekt = new Fraction(2);

        Fraction expected = new Fraction(-2, 5);
        Assert.assertEquals(0, GaussElimination.findNullCoefficient(pivot, rekt).compareTo(expected));
    }

    @Test
    public void plusminus() {
        Fraction pivot = new Fraction(5);
        Fraction rekt = new Fraction(-2);

        Fraction expected = new Fraction(2, 5);
        Assert.assertEquals(0, GaussElimination.findNullCoefficient(pivot, rekt).compareTo(expected));
    }

    @Test
    public void minusplus() {
        Fraction pivot = new Fraction(-5);
        Fraction rekt = new Fraction(2);

        Fraction expected = new Fraction(2, 5);
        Assert.assertEquals(0, GaussElimination.findNullCoefficient(pivot, rekt).compareTo(expected));
    }
}
