package com.carlsen.mathTest;

import com.carlsen.math.Fraction;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.*;

public class FractionTest {

    Fraction whole = new Fraction(5);
    Fraction fraction = new Fraction(2, 37);

    double wholeReal = 5.0;
    double fractionReal = 0.05405405405405406;

    @Test
    public void getNumeratorTest() {
        Assert.assertEquals(5, whole.getNumerator());
        Assert.assertEquals(2, fraction.getNumerator());
    }

    @Test
    public void getDenominatorTest() {
        Assert.assertEquals(1, whole.getDenominator());
        Assert.assertEquals(37, fraction.getDenominator());
    }

    @Test
    public void getRealNumberTest() {
        Assert.assertEquals(wholeReal, whole.getReal(), 0.00005);
        Assert.assertEquals(fractionReal, fraction.getReal(), 0.00005);
    }

    @Test
    public void compareFractions() {
        Fraction a = new Fraction(5);
        Fraction b = new Fraction(7);

        Fraction c = new Fraction(2, 3);
        Fraction d = new Fraction(4, 6);

        Assert.assertEquals(-1, a.compareTo(b));
        Assert.assertEquals(1, b.compareTo(a));
        Assert.assertEquals(0, a.compareTo(a));
        Assert.assertEquals(0, b.compareTo(b));

        Assert.assertEquals(0, c.compareTo(d));
    }

    @Test
    public void equalityTest() {
        Fraction a = new Fraction(3, 4);
        Fraction b = new Fraction(9, 12);
        Assert.assertTrue(a.equals(b));
    }

    @Test
    public void creationTest() {
        Fraction a = new Fraction(69);
        Fraction a1 = new Fraction(-69);
        Fraction b = new Fraction(69, 420);
        Fraction b2 = new Fraction(69, -420);
        Fraction b3 = new Fraction(-69, 420);
        Fraction b4 = new Fraction(-69, -420);

        Assert.assertThat(a.getNumerator(), is(equalTo(69)));
        Assert.assertThat(a1.getNumerator(), is(equalTo(-69)));

        Assert.assertThat(a.getDenominator(), is(1));

        Assert.assertThat(b.getNumerator(), is(equalTo(69)));
        Assert.assertThat(b.getDenominator(), is(equalTo(420)));

        Assert.assertThat(b.getNumerator(), is(greaterThan(0)));
        Assert.assertThat(b2.getNumerator(), is(not(greaterThan(0))));
        Assert.assertThat(b3.getNumerator(), is(not(greaterThan(0))));
        Assert.assertThat(b4.getNumerator(), is(greaterThan(0)));

    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentException() {
        Fraction oops = new Fraction(1, 0);
    }
}
