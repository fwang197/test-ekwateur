package com.ekwateur.test.calculator;


import com.ekwateur.test.enums.Consommation;
import com.ekwateur.test.models.Client;

public sealed interface Calculator permits ParticulierCalculator, ProfessionnelCalculator {

    double calculate(Client client, Consommation consommation, double kwh);

}
