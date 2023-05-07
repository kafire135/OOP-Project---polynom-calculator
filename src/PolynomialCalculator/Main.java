package PolynomialCalculator;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main (String [] args){
        Polynomial p1= Polynomial.build("1 3 0 5 1 9 9 9");
        Polynomial p2= Polynomial.build("2 7 0 6 0 0 9 7");
        Polynomial p3= Polynomial.build("-1/5 3 0 0 -21 20/8");
        Polynomial ans = p1.add(p2);
        System.out.println(p2.derivative());
        System.out.println(p3.derivative());
        Polynomial p5=Polynomial.build("3 1");
        Polynomial p6=Polynomial.build("-3 1");
        System.out.println(p6.mul(p6));
    }

}
