package PolynomialCalculator;

import java.util.HashMap;
import java.util.Map;

public class Polynomial {

    private HashMap<java.lang.Integer, Scalar> monomials;

    public Polynomial(HashMap monomial){
        this.monomials=monomial;
    }

    public static Polynomial build(String input){
        HashMap<java.lang.Integer, Scalar> output=new HashMap<>();
        String [] arr = input.split(" ");
        for (int i=0; i< arr.length; i++){
            if(arr[i].charAt(0)!='0') {
                if (arr[i].indexOf('/') != -1) {
                    Rational coeff = Rational.convert(arr[i]);
                    output.put(i, coeff);
                } else {
                    Integer coeff = Integer.convert(arr[i]);
                    output.put(i, coeff);
                }
            }
        }
        return new Polynomial(output);
    }

    public Polynomial add (Polynomial p){
        HashMap<java.lang.Integer, Scalar> output1=new HashMap<>();
        for (Map.Entry<java.lang.Integer, Scalar> entry : this.monomials.entrySet()){
            output1.put(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<java.lang.Integer, Scalar> entry : p.monomials.entrySet()){
            if (output1.containsKey(entry.getKey())){
                output1.put(entry.getKey(),output1.get(entry.getKey()).add(entry.getValue()));
            }
          else {
              output1.put(entry.getKey(), entry.getValue());
            }
        }
        HashMap<java.lang.Integer, Scalar> output2=new HashMap<>();
        for (Map.Entry<java.lang.Integer, Scalar> entry : output1.entrySet()){
            if (!(entry.getValue().equals(new Integer(0)) | entry.getValue().equals(new Rational(0,1)))){
                output2.put(entry.getKey(), entry.getValue());
            }
        }
        return new Polynomial(output2);
    }

    public Polynomial mul(Polynomial p){
        HashMap<java.lang.Integer, Scalar> output=new HashMap<>();
        for (Map.Entry<java.lang.Integer, Scalar> mon1 : this.monomials.entrySet()){
            for (Map.Entry<java.lang.Integer, Scalar> mon2 : p.monomials.entrySet()){
                Scalar newMon=mon1.getValue().mul(mon2.getValue());
                int key=mon1.getKey()+mon2.getKey();
                if (output.containsKey(key)){
                    output.put(key,output.get(key).add(newMon));
                }
                else{
                    output.put(key,newMon);
                }
            }
        }
        return new Polynomial(output);
    }

    public Scalar evaluate(Scalar s){
        Scalar output = new Integer(0);
        for (Map.Entry<java.lang.Integer, Scalar> mon : this.monomials.entrySet()){
            Monomial temp=new Monomial(mon.getKey(),mon.getValue());
            output=output.add(temp.evaluate(s));
        }
        return output;
    }

    public Polynomial derivative (){
        HashMap<java.lang.Integer, Scalar> output=new HashMap<>();
        for (Map.Entry<java.lang.Integer, Scalar> mon1 : this.monomials.entrySet()){
            Monomial temp=new Monomial(mon1.getKey(),mon1.getValue());
            Monomial newMon = temp.derivative();
            if (!(newMon.getCoefficient().equals(new Integer(0)) | newMon.getCoefficient().equals(new Rational(0,1)))) {
                int key = newMon.getExponent();
                output.put(key, newMon.getCoefficient());
            }
        }
        return new Polynomial(output);
    }

    public String toString(){
        String output="";
        for (Map.Entry<java.lang.Integer, Scalar> entry : this.monomials.entrySet()){
            Monomial temp= new Monomial(entry.getKey(),entry.getValue());
            String value= temp.toString();
            if(!value.equals("0")) {
                if (value.charAt(0) == '-') {
                    output = output + value + " ";
                } else {
                    output = output + '+' + " " + value + " ";
                }
            }
        }
        if (output.length()>0 && output.charAt(0)=='+'){
            output=output.substring(2);
        }
        return output.substring(0,output.length()-1);
    }

    public boolean equals(Object o) {
        if (!(o instanceof Polynomial)) return false;
        return (monomials.equals(((Polynomial) o).monomials));
    }

    public HashMap<java.lang.Integer, Scalar> getMonomials() {
        return monomials;
    }
}
