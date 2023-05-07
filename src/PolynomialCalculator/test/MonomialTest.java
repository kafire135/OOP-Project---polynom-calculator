package PolynomialCalculator.test;

import org.junit.Before;
import org.junit.Test;
import PolynomialCalculator.Rational;
import PolynomialCalculator.Integer;
import PolynomialCalculator.Scalar;
import PolynomialCalculator.Monomial;

import static org.junit.Assert.*;

public class MonomialTest {

    Monomial m0;
    Monomial m1;
    Monomial m2;
    Monomial m3;
    Monomial mZ;
    Monomial mNeg;

    @Before
    public void setUp() throws Exception {
        m0=new Monomial(0,new Integer(5));
        m1=new Monomial(1,new Rational(1,2));
        m2=new Monomial(2,new Integer(3));
        m3=new Monomial(3,new Rational(6,8));
        mZ=new Monomial(4,new Integer(0));
        mNeg=new Monomial(5,new Rational(-2,3));
    }

    @Test
    public void add() {
        Monomial ans=m0.add(m0);
        assertEquals(new Monomial(0,new Integer(10)),ans);
        ans=m1.add(m1);
        assertEquals(new Monomial(1,new Rational(1,1)),ans);
        assertNull(m3.add(m2));
        ans=m3.add(m3);
        assertEquals(new Monomial(3,new Rational(3,2)),ans);
        ans=mNeg.add(mNeg);
        assertEquals(new Monomial(5,new Rational(-4,3)),ans);
    }

    @Test
    public void mul() {
        Monomial ans=m0.mul(m1);
        assertEquals(new Monomial(1,new Rational(5,2)),ans);
        ans=m0.mul(mZ);
        assertEquals(new Monomial(4,new Integer(0)),ans);
        ans=m1.mul(m3);
        assertEquals(new Monomial(4,new Rational(3,8)),ans);
        ans=mNeg.mul(m2);
        assertEquals(new Monomial(7,new Rational(-2,1)),ans);
    }

    @Test
    public void evaluate() {
        Scalar ans=m0.evaluate(new Integer(2));
        assertEquals(new Integer(5),ans);
        ans=m1.evaluate(new Integer(2));
        assertEquals(new Rational(1,1),ans);
        ans=m2.evaluate(new Integer(2));
        assertEquals(new Integer(12),ans);
        ans=m3.evaluate(new Integer(2));
        assertEquals(new Rational(6,1),ans);
        ans=mZ.evaluate(new Integer(2));
        assertEquals(new Integer(0),ans);
        ans=mNeg.evaluate(new Integer(2));
        assertEquals(new Rational(-64,3),ans);
    }

    @Test
    public void derivative() {
        Monomial ans=m0.derivative();
        assertEquals(new Monomial(0,new Integer(0)),ans);
        ans=m1.derivative();
        assertEquals(new Monomial(0,new Rational(1,2)),ans);
        ans=m2.derivative();
        assertEquals(new Monomial(1,new Integer(6)),ans);
        ans=m3.derivative();
        assertEquals(new Monomial(2,new Rational(9,4)),ans);
        ans=mZ.derivative();
        assertEquals(new Monomial(3,new Integer(0)),ans);
        ans=mNeg.derivative();
        assertEquals(new Monomial(4,new Rational(-10,3)),ans);
    }

    @Test
    public void sign() {
        int ans=m0.sign();
        assertEquals(1,ans);
        ans=mZ.sign();
        assertEquals(0,ans);
        ans=mNeg.sign();
        assertEquals(-1,ans);
    }

    @Test
    public void testToString() {
        String ans=m0.toString();
        assertEquals("5",ans);
        ans=m1.toString();
        assertEquals("1/2x",ans);
        ans=m2.toString();
        assertEquals("3x^2",ans);
        ans=m3.toString();
        assertEquals("3/4x^3",ans);
        ans=mZ.toString();
        assertEquals("0",ans);
        ans=mNeg.toString();
        assertEquals("-2/3x^5",ans);
    }
}