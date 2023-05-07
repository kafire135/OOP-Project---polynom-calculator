package PolynomialCalculator;

public class Rational implements Scalar {

    private int numrator;
    private int denominator;

    public Rational(int a, int b){
        if (b==0){
            throw new IllegalArgumentException("denominator can't be 0");
        }
        else if (b<0){
            numrator=(-1)*a;
            denominator=(-1)*b;
        }
        else {
            numrator = a;
            denominator = b;
        }
    }

    public int getDenominator() {
        return denominator;
    }

    public int getNumrator() {
        return numrator;
    }

    @Override
    public Scalar add(Scalar s) {
        return s.addRat(this);
    }

    public Scalar addRat(Rational r){
        Rational output = new Rational(this.numrator*r.denominator+r.numrator*this.denominator, this.denominator*r.denominator);
        return output.reduce();
    }

    //Integer+Rational
    public Scalar addInt(Integer i){
        Rational Rnum= new Rational(i.getNumber()*denominator+numrator,denominator);
        return Rnum.reduce();
    }

    @Override
    //Scalar*Scalar
    public Scalar mul(Scalar s) {
        return s.mulRat(this);
    }

    //Rational*Rational
    public Scalar mulRat (Rational num){
        Rational output = new Rational(this.numrator*num.numrator,this.denominator*num.denominator);
        return output.reduce();
    }

    //Rational*Integer
    public Scalar mulInt(Integer num){
        Rational Rnum= new Rational(num.getNumber()*numrator,denominator);
        return Rnum.reduce();
    }

    public static Rational convert (String s){
        String [] rat=s.split("/");
        java.lang.Integer mon= java.lang.Integer.valueOf(rat[0]);
        java.lang.Integer den= java.lang.Integer.valueOf(rat[1]);
        return new Rational(mon,den);
    }

    @Override
    public Scalar neg() {
        return new Rational((-1)*numrator,denominator).reduce();
    }

    @Override
    public Scalar power(int exponent) {
        if(exponent<0){
            Scalar output=new Rational(denominator,numrator);
            return output.power((-1)*exponent);
        }
        Scalar output=new Rational(1,1);
        for (int i=0; i<exponent; i++){
            output=output.mul(this);
        }
        return output;
    }

    @Override
    public int sign() {
        if (numrator > 0) {
            return 1;
        } else if (numrator == 0) {
            return 0;
        }
        return -1;
    }

    private int gcd (int m, int n){
        int output;
        if (m%n==0){
            output=n;
        }
        else{
            output=gcd(n,m%n);
        }
        return output;
    }

    public Rational reduce(){
        return new Rational((numrator/gcd(numrator,denominator)),(denominator/(gcd(numrator,denominator))));
    }

    @Override
    public String toString() {
        String output="";
        Rational number=this.reduce();
        if(number.getDenominator()==1){
            output=output+number.getNumrator();
        }
        else{
            output=output+number.getNumrator()+'/'+number.getDenominator();
        }
        return output;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Rational)) return false;
        Rational our = this.reduce();
        Rational other = ((Rational) o).reduce();
        return (our.numrator== other.numrator) & (our.denominator== other.denominator);
    }

}
