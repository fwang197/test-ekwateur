package com.ekwateur.test.calculator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class CalculatorFactory {

    private final Map<String, Calculator> calculatorMap;

    public Calculator getCalculator(String calculator) {
        return calculatorMap.get(calculator);
    }
}
