package PolynomialCalculator;

public class Monomial {

    private int exponent;
    private Scalar coefficient;

    public Monomial(int exponent, Scalar coefficient){
        this.exponent=exponent;
        this.coefficient=coefficient;
    }

    public int getExponent() {
        return exponent;
    }

    public Scalar getCoefficient() {
        return coefficient;
    }

    public Monomial add (Monomial m){
        if(this.exponent!=m.exponent){
            return null;
        }
        return new Monomial(exponent,coefficient.add(m.coefficient));
    }

    public Monomial mul (Monomial m){
        return new Monomial(this.exponent+ m.exponent,this.coefficient.mul(m.coefficient));
    }

    public Scalar evaluate (Scalar s){
        return (s.power(this.exponent)).mul(this.coefficient);
    }

    public Monomial derivative (){
        Integer IntExp = new Integer(exponent);
        return new Monomial(Math.max(0,exponent-1),IntExp.mul(coefficient));
    }

    public int sign (){
        return coefficient.sign();
    }

    public String toString (){
        if(coefficient.toString().equals("0")){
            return "0";
        }
        else if (exponent==0){
            return coefficient.toString();
        }
        else if (exponent==1 & coefficient.toString().equals("1")) {
            return "x";
        }
        else if (exponent==1 & coefficient.toString().equals("-1")) {
            return "-x";
        }
        else if (exponent==1){
            return coefficient.toString()+ 'x';
        }
        else if (coefficient.toString().equals("1")){
            return "x^"+exponent;
        }
        else if (coefficient.toString().equals("-1")){
            return "-x^"+exponent;
        }
        return coefficient.toString()+"x^"+exponent;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Monomial)) return false;
        return (coefficient.equals(((Monomial) o).coefficient)) & (exponent == ((Monomial) o).exponent);
    }

}
