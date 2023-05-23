package br.com.erudio.restwithspringbootandjavaerudio.utils;

public class NumberConvertions {
    public static Double convertToDouble(String strNumber) {
        if(strNumber == null) return 0D;
        String number  = strNumber.replaceAll(",", ".");
        if (NumberValidation.isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }
}
