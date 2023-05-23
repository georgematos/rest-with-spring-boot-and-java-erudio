package br.com.erudio.restwithspringbootandjavaerudio.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.restwithspringbootandjavaerudio.exceptions.UnsupportedMathOperationException;
import br.com.erudio.restwithspringbootandjavaerudio.utils.NumberConvertions;
import br.com.erudio.restwithspringbootandjavaerudio.utils.NumberValidation;

@RestController
public class MathController {

    private final AtomicLong conter = new AtomicLong();

    @GetMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
        if(!NumberValidation.isNumeric(numberOne) || !NumberValidation.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return NumberConvertions.convertToDouble(numberOne) + NumberConvertions.convertToDouble(numberTwo);
    }

    @GetMapping("/sub/{numberOne}/{numberTwo}")
    public Double sub(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
        if(!NumberValidation.isNumeric(numberOne) || !NumberValidation.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return NumberConvertions.convertToDouble(numberOne) - NumberConvertions.convertToDouble(numberTwo);
    }

    @GetMapping("/mult/{numberOne}/{numberTwo}")
    public Double mult(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
        if(!NumberValidation.isNumeric(numberOne) || !NumberValidation.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return NumberConvertions.convertToDouble(numberOne) * NumberConvertions.convertToDouble(numberTwo);
    }

    @GetMapping("/div/{numberOne}/{numberTwo}")
    public Double div(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
        if(!NumberValidation.isNumeric(numberOne) || !NumberValidation.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return NumberConvertions.convertToDouble(numberOne) / NumberConvertions.convertToDouble(numberTwo);
    }

    @GetMapping("/squareRoot/{number}")
    public Double div(@PathVariable String number) throws Exception {
        if(!NumberValidation.isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return Math.sqrt(NumberConvertions.convertToDouble(number));
    }
}