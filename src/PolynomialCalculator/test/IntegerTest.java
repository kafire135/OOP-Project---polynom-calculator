package PolynomialCalculator.test;

import PolynomialCalculator.Rational;
import PolynomialCalculator.Integer;
import PolynomialCalculator.Scalar;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntegerTest {

    private Integer number4;
    private Integer number2;
    private Integer numberNeg;
    private Integer numberZ;
    private Rational number12;
    private Rational number23;

    @Before
    public void setUp()  {
        number4=new Integer(4);
        number2=new Integer(2);
        numberNeg=new Integer(-3);
        numberZ=new Integer(0);
        number12=new Rational(1,2);
        number23=new Rational(-2,3);
    }

    @Test
    public void add() {
        Scalar ans=number4.add(number2);
        assertEquals(new Integer(6), ans);
        ans=number2.add(numberNeg);
        assertEquals(new Integer(-1), ans);
        ans=number2.add(number12);
        assertEquals(new Rational(5,2), ans);
        ans=number2.add(number23);
        assertEquals(new Rational(4,3), ans);
    }

    @Test
    public void mul() {
        Scalar ans=number4.mul(number2);
        assertEquals(new Integer(8), ans);
        ans=number2.mul(numberNeg);
        assertEquals(new Integer(-6), ans);
        ans=numberZ.mul(numberNeg);
        assertEquals(new Integer(0), ans);
        ans=number2.mul(number12);
        assertEquals(new Rational(1,1), ans);
        ans=number2.mul(number23);
        assertEquals(new Rational(-4,3), ans);
    }

    @Test
    public void neg() {
        Scalar ans=number4.neg();
        assertEquals(new Integer(-4), ans);
        ans=numberNeg.neg();
        assertEquals(new Integer(3), ans);
        ans=numberZ.neg();
        assertEquals(new Integer(0), ans);
    }

    @Test
    public void power() {
        Scalar ans=number2.power(5);
        assertEquals(new Integer(32), ans);
        ans=number2.power(0);
        assertEquals(new Integer(1), ans);
        ans=numberZ.power(352);
        assertEquals(new Integer(0), ans);
        ans=numberNeg.power(4);
        assertEquals(new Integer(81), ans);
        ans=numberNeg.power(3);
        assertEquals(new Integer(-27), ans);
    }

    @Test
    public void sign() {
        int ans=number2.sign();
        assertEquals(1,ans);
        ans=numberZ.sign();
        assertEquals(0,ans);
        ans=numberNeg.sign();
        assertEquals(-1,ans);
    }

    @Test
    public void testToString() {
        String ans=number2.toString();
        assertEquals("2",ans);
        ans=numberZ.toString();
        assertEquals("0",ans);
        ans=numberNeg.toString();
        assertEquals("-3",ans);
    }
}