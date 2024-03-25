package com.ekwateur.test;

import com.ekwateur.test.calculator.ParticulierCalculator;
import com.ekwateur.test.enums.Civilite;
import com.ekwateur.test.enums.Consommation;
import com.ekwateur.test.models.Particulier;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ParticulierCalculator.class})
public class ParticulierFactoryTests {

    @Autowired
    private ParticulierCalculator particulierCalculator;

    @Test
    public void testClientTotalGaz() {
        // Given
        Particulier particulier = Particulier.builder()
                .refClient("EKW1")
                .nom("Poirot")
                .prenom("Hercule")
                .civilite(Civilite.M)
                .build();

        // When
        double actual = particulierCalculator.calculate(particulier, Consommation.GAZ, 3.5);

        // Then
        assertEquals(0.4025, actual);
    }

    @Test
    public void testClientTotalElectricite() {
        // Given
        Particulier particulier = Particulier.builder()
                .refClient("EKW1")
                .nom("Poirot")
                .prenom("Hercule")
                .civilite(Civilite.M)
                .build();

        // When
        double actual = particulierCalculator.calculate(particulier, Consommation.ELECTRICITE, 3.5);

        // Then
        assertEquals(0.4235, actual);
    }
}
