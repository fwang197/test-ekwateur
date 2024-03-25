package com.ekwateur.test.calculator;

import com.ekwateur.test.enums.Consommation;
import com.ekwateur.test.models.Client;
import org.springframework.stereotype.Service;

@Service
public final class ParticulierCalculator implements Calculator {

    public static final String BEAN_ID = "ParticulierCalculator";

    @Override
    public double calculate(Client client, Consommation consommation, double kwh) {
        return switch (consommation) {
            case GAZ -> kwh * 0.115;
            case ELECTRICITE -> kwh * 0.121;
        };
    }
}
