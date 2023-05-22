package br.com.erudio.restwithspringbootandjavaerudio.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.restwithspringbootandjavaerudio.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {

    private final AtomicLong conter = new AtomicLong();

    @GetMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    @GetMapping("/sub/{numberOne}/{numberTwo}")
    public Double sub(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    @GetMapping("/mult/{numberOne}/{numberTwo}")
    public Double mult(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    @GetMapping("/div/{numberOne}/{numberTwo}")
    public Double div(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    @GetMapping("/squareRoot/{number}")
    public Double div(@PathVariable String number) throws Exception {
        if(!isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return Math.sqrt(convertToDouble(number));
    }

    public Double convertToDouble(String strNumber) {
        if(strNumber == null) return 0D;
        String number  = strNumber.replaceAll(",", ".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    public boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        String number  = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

}