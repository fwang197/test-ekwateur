package com.ekwateur.test.calculator;

import com.ekwateur.test.enums.Consommation;
import com.ekwateur.test.models.Client;
import com.ekwateur.test.models.Professionnel;
import org.springframework.stereotype.Service;

@Service(ProfessionnelCalculator.BEAN_ID)
public final class ProfessionnelCalculator implements Calculator {

    public static final String BEAN_ID = "ProfessionnelCalculator";
    private final static double LEVEL = 1000000d;

    @Override
    public double calculate(Client client, Consommation consommation, double kwh) {
        Professionnel professionnel = (Professionnel) client;
        return switch (consommation) {
            case GAZ -> kwh * getGazPrice(professionnel.getCa());
            case ELECTRICITE -> kwh * getElectricitePrice(professionnel.getCa());
        };
    }

    private double getGazPrice(double ca) {
        // FIXME où mettre le = 1000000
        if (ca > LEVEL)
            return 0.111;
        else
            return 0.113;
    }

    private double getElectricitePrice(double ca) {
        // FIXME où mettre le = 1000000
        if (ca > LEVEL)
            return 0.114;
        else
            return 0.118;
    }
}
