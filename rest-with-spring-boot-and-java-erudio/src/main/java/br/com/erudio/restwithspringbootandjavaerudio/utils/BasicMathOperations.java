package br.com.erudio.restwithspringbootandjavaerudio.utils;

import br.com.erudio.restwithspringbootandjavaerudio.exceptions.UnsupportedMathOperationException;

public class BasicMathOperations {
    public static Double sum(String numberOne, String numberTwo) {
        if (!NumberValidation.isNumeric(numberOne) || !NumberValidation.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return NumberConvertions.convertToDouble(numberOne) + NumberConvertions.convertToDouble(numberTwo);
    }

    public static Double sub(String numberOne, String numberTwo) {
        if (!NumberValidation.isNumeric(numberOne) || !NumberValidation.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return NumberConvertions.convertToDouble(numberOne) - NumberConvertions.convertToDouble(numberTwo);
    }

    public static Double div(String numberOne, String numberTwo) {
        if (!NumberValidation.isNumeric(numberOne) || !NumberValidation.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return NumberConvertions.convertToDouble(numberOne) / NumberConvertions.convertToDouble(numberTwo);
    }

    public static Double mult(String numberOne, String numberTwo) {
        if (!NumberValidation.isNumeric(numberOne) || !NumberValidation.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return NumberConvertions.convertToDouble(numberOne) * NumberConvertions.convertToDouble(numberTwo);
    }

    public static Double sqrt(String number) {
        if(!NumberValidation.isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return Math.sqrt(NumberConvertions.convertToDouble(number));
    }
}
