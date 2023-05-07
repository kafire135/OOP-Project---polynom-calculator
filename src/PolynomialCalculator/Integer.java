package PolynomialCalculator;

public class Integer implements Scalar {

    private int number;

    public Integer(int number) {
        this.number = number;
    }

    @Override
    //Scalar+Scalar
    public Scalar add(Scalar s) {
        return s.addInt(this);
    }

    //Integer+Integer
    public Scalar addInt(Integer num){
        return new Integer(num.number+this.number);
    }

    //Integer+Rational
    public Scalar addRat(Rational num){
        Rational Rnum= new Rational(this.number*num.getDenominator()+num.getNumrator(),num.getDenominator());
        return Rnum.reduce();
    }

    public static Integer convert(String s){
        return new Integer(java.lang.Integer.valueOf(s));
    }

    @Override
    //Scalar*Scalar
    public Scalar mul(Scalar s) {
        return s.mulInt(this);
    }

    //Integer*Integer
    public Scalar mulInt(Integer num){
        return new Integer(num.number*this.number);
    }

    //Integer*Rational
    public Scalar mulRat(Rational num){
        Rational Rnum= new Rational(this.number*num.getNumrator(),num.getDenominator());
        return Rnum.reduce();
    }

    @Override
    public Scalar neg() {
        return new Integer(this.number*(-1));
    }

    @Override
    public Scalar power(int exponent) {
        if (exponent<0){
            Scalar op=new Rational(1,number);
            return op.power(exponent*(-1));
        }
        Scalar output=new Integer(1);
        for (int i=0; i<exponent; i++){
            output=output.mul(this);
        }
        return output;
    }

    @Override
    public int sign() {
        if (number > 0) {
            return 1;
        } else if (number == 0) {
            return 0;
        }
        return -1;
    }

    @Override
    public String toString() {
        return ""+number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Integer)) return false;
        return number == ((Integer) o).number;
    }

}