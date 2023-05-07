package PolynomialCalculator.test;

import org.junit.Before;
import org.junit.Test;
import PolynomialCalculator.Rational;
import PolynomialCalculator.Integer;
import PolynomialCalculator.Scalar;
import static org.junit.Assert.*;

public class RationalTest {

    Rational num12;
    Rational num17;
    Rational numZ;
    Rational numNeg;
    Rational numBig;
    Integer numI;
    Rational numI1;

    @Before
    public void setUp() throws Exception {
        num12=new Rational(1,2);
        num17=new Rational(5,35);
        numZ=new Rational(0,4);
        numNeg=new Rational(-2,3);
        numBig=new Rational(16,6);
        numI=new Integer(2);
        numI1=new Rational(15,3);
    }

    @Test
    public void add() {
        Scalar ans=num12.add(num17);
        assertEquals(new Rational(9,14), ans);
        ans=num12.add(numZ);
        assertEquals(new Rational(1,2), ans);
        ans=num12.add(numNeg);
        assertEquals(new Rational(-1,6), ans);
        ans=num12.add(numI);
        assertEquals(new Rational(5,2), ans);
    }

    @Test
    public void mul() {
        Scalar ans=num12.mul(num17);
        assertEquals(new Rational(1,14), ans);
        ans=num12.mul(numZ);
        assertEquals(new Rational(0,1), ans);
        ans=num12.mul(numNeg);
        assertEquals(new Rational(-1,3), ans);
        ans=num12.mul(numI);
        assertEquals(new Rational(1,1), ans);
    }

    @Test
    public void neg() {
        Scalar ans=num12.neg();
        assertEquals(new Rational(-1,2), ans);
        ans=numNeg.neg();
        assertEquals(new Rational(2,3), ans);
        ans=numZ.neg();
        assertEquals(new Rational(0,1), ans);
    }

    @Test
    public void power() {
        Scalar ans=num12.power(5);
        assertEquals(new Rational(1,32), ans);
        ans=numNeg.power(3);
        assertEquals(new Rational(-8,27), ans);
        ans=numNeg.power(2);
        assertEquals(new Rational(4,9), ans);
        ans=numZ.power(546346);
        assertEquals(new Rational(0,1), ans);
    }

    @Test
    public void sign() {
        int ans=num12.sign();
        assertEquals(1,ans);
        ans=numZ.sign();
        assertEquals(0,ans);
        ans=numNeg.sign();
        assertEquals(-1,ans);
    }

    @Test
    public void reduce() {
        Scalar ans=num17.reduce();
        assertEquals(new Rational(1,7), ans);
        ans=numBig.reduce();
        assertEquals(new Rational(8,3), ans);
    }

    @Test
    public void testToString() {
        String ans=num17.toString();
        assertEquals("1/7", ans);
        ans=numNeg.toString();
        assertEquals("-2/3", ans);
        ans=numZ.toString();
        assertEquals("0", ans);
        ans=numI1.toString();
        assertEquals("5", ans);
    }
}