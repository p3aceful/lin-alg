package com.carlsen.math;

public class FracOps {

    public static Fraction multiply(Fraction a, Fraction b) {
        return simplify(new Fraction(a.getNumerator() * b.getNumerator(), a.getDenominator() * b.getDenominator()));
    }

    public static Fraction subtract(Fraction a, Fraction b) {
        Fraction a1 = scale(b.getDenominator(), a);
        Fraction b1 = scale(a.getDenominator(), b);
        return simplify(new Fraction(a1.getNumerator() - b1.getNumerator(), a1.getDenominator()));
    }

    public static Fraction divide(Fraction a, Fraction b) {
        return simplify(new Fraction(a.getNumerator() * b.getDenominator(), a.getDenominator() * b.getNumerator()));
    }

    public static Fraction add(Fraction a, Fraction b) {

        if (a.getNumerator() == 0 && b.getNumerator() == 0) {
            return new Fraction(0);
        }

        if (a.getNumerator() == 0) {
            return b;
        } else if (b.getNumerator() == 0) {
            return a;
        }

        Fraction a1 = scale(b.getDenominator(), a);
        Fraction b1 = scale(a.getDenominator(), b);

        return simplify(new Fraction(a1.getNumerator() + b1.getNumerator(), a1.getDenominator()));
    }

    public static Fraction scale(int scalar, Fraction f) {
        return new Fraction(f.getNumerator() * scalar, f.getDenominator() * scalar);
    }

    public static Fraction simplify(Fraction f) {

        if (f.getNumerator() == 0 || f.getDenominator() == 0) {
            return f;
        }

        if (f.getNumerator() == 1 || f.getDenominator() == 1) {
            return f;
        }

        int gcf = greatestCommonFactor(f.getNumerator(), f.getDenominator());

        return new Fraction(f.getNumerator() / gcf, f.getDenominator() / gcf);
    }

    public static Fraction negate(Fraction f) {
        return multiply(new Fraction(-1), f);
    }

    public static int greatestCommonFactor(int a, int b) {
        int min = Math.abs(Math.min(a, b));
        int max = Math.abs(Math.max(a, b));

        int diff = max - min;

        if (diff == 0) {
            return min;
        }

        return greatestCommonFactor(diff, min);
    }
}
