package br.com.erudio.restwithspringbootandjavaerudio.math;

public class SimpleMath {

    public static Double sum(Double numberOne, Double numberTwo) {
        return numberOne + numberTwo;
    }

    public static Double sub(Double numberOne, Double numberTwo) {
        return numberOne - numberTwo;
    }

    public static Double mult(Double numberOne, Double numberTwo) {
        return numberOne * numberTwo;
    }

    public static Double div(Double numberOne, Double numberTwo) {
        return numberOne / numberTwo;
    }

    public static Double sqrt(Double number) {
        return Math.sqrt(number);
    }
}
