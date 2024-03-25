package com.ekwateur.test.calculator;


import com.ekwateur.test.enums.Consommation;
import com.ekwateur.test.models.Client;

public sealed interface Calculator permits ParticulierCalculator, ProfessionnelCalculator {

    /**
     * Calcul le total en euro de la consommation du client via sa valeur KWH.
     *
     * @param client        particulier ou professionnel
     * @param consommation  Gaz ou Electricité
     * @param kwh           total kwh du consommateur
     * @return
     */
    double calculate(Client client, Consommation consommation, double kwh);

}
