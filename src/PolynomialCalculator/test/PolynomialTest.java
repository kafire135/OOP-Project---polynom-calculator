package PolynomialCalculator.test;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import PolynomialCalculator.Rational;
import PolynomialCalculator.Integer;
import PolynomialCalculator.Scalar;
import PolynomialCalculator.Monomial;
import PolynomialCalculator.Polynomial;

public class PolynomialTest {

    Polynomial p1;
    Polynomial p2;
    Polynomial p3;

    @Before
    public void setUp() throws Exception {
        p1=Polynomial.build("1 3 0 5 1 9 9 8");
        p2=Polynomial.build("2 7 0 6 0 0 9 7");
        p3=Polynomial.build("-1/5 3 0 0 -21 20/8");
    }

    @Test
    public void build() {
        Polynomial ans=p1;
        assertEquals(Polynomial.build("1 3 0 5 1 9 9 8"),ans);
        ans=p2;
        assertEquals(Polynomial.build("2 7 0 6 0 0 9 7"),ans);
        ans=p3;
        assertEquals(Polynomial.build("-1/5 3 0 0 -21 20/8"),ans);
    }

    @Test
    public void add() {
        Polynomial ans=p1.add(p2);
        assertEquals(Polynomial.build("3 10 0 11 1 9 18 15"),ans);
        ans=p2.add(p3);
        assertEquals(Polynomial.build("9/5 10 0 6 -21 5/2 9 7"),ans);
        ans=p3.add(p1);
        assertEquals(Polynomial.build("4/5 6 0 5 -20 23/2 9 8"),ans);
    }

    @Test
    public void mul() {
        Polynomial ans=p1.mul(p2);
        assertEquals(Polynomial.build("2 13 21 16 55 25 120 119 131 99 92 88 144 135 56"),ans);
        ans=p2.mul(p3);
        assertEquals(Polynomial.build("-2/5 23/5 21 -6/5 -24 -142/1 157/10 -502/5 36/1 0 -189 -249/2 35/2"),ans);
        ans=p3.mul(p1);
        assertEquals(Polynomial.build("-1/5 12/5 9 -1/1 -31/5 -593/10 327/10 -398/5 31/2 -373/2 -333/2 -291/2 20/1"),ans);
    }

    @Test
    public void evaluate() {
        Scalar ans= p1.evaluate(new Integer(2));
        assertEquals(new Integer(1951),ans);
        ans= p2.evaluate(new Integer(2));
        assertEquals(new Integer(1536),ans);
        ans= p3.evaluate(new Integer(2));
        assertEquals(new Rational(-1251,5),ans);

        ans= p1.evaluate(new Rational(4,2));
        assertEquals(new Rational(1951,1),ans);
        ans= p2.evaluate(new Rational(4,2));
        assertEquals(new Rational(1536,1),ans);
        ans= p3.evaluate(new Rational(4,2));
        assertEquals(new Rational(-1251,5),ans);

        ans= p1.evaluate(new Rational(-1,2));
        assertEquals(new Rational(-81,64),ans);
        ans= p2.evaluate(new Rational(-1,2));
        assertEquals(new Rational(-277,128),ans);
        ans= p3.evaluate(new Rational(-1,2));
        assertEquals(new Rational(-989,320),ans);
    }

    @Test
    public void derivative() {
        Polynomial ans=p1.derivative();
        assertEquals(Polynomial.build("3 0 15 4 45 54 56"),ans);
        ans=p2.derivative();
        assertEquals(Polynomial.build("7 0 18 0 0 54 49"),ans);
        ans=p3.derivative();
        assertEquals(Polynomial.build("3 0 0 -84 25/2"),ans);
    }

    @Test
    public void testToString() {
        String ans=p1.toString();
        assertEquals("1 + 3x + 5x^3 + x^4 + 9x^5 + 9x^6 + 8x^7",ans);
        ans=p2.toString();
        assertEquals("2 + 7x + 6x^3 + 9x^6 + 7x^7",ans);
        ans=p3.toString();
        assertEquals("-1/5 + 3x -21x^4 + 5/2x^5",ans);
    }
}