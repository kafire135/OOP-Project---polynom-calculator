package PolynomialCalculator;

public interface Scalar {
    public Scalar add(Scalar s);
    public Scalar mul(Scalar s);
    public Scalar neg();
    public Scalar power(int exponent);
    public int sign();
    public Scalar addInt(Integer i);
    public Scalar addRat(Rational r);
    public Scalar mulInt(Integer i);
    public Scalar mulRat(Rational r);
}
