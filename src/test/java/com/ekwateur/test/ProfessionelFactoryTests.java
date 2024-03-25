package com.ekwateur.test;

import com.ekwateur.test.calculator.ProfessionnelCalculator;
import com.ekwateur.test.enums.Consommation;
import com.ekwateur.test.models.Professionnel;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ProfessionnelCalculator.class})
public class ProfessionelFactoryTests {

    @Autowired
    private ProfessionnelCalculator particulierCalculator;

    @ParameterizedTest
    @MethodSource("caToTotalGaz")
    void testClientTotalGaz(double ca, double expectedTotal) {

        // Given
        Professionnel professionnel = Professionnel.builder()
                .refClient("EKW1")
                .raisonSociale("IKEA")
                .siret("35174572400200")
                .ca(ca)
                .build();

        // When
        double actual = particulierCalculator.calculate(professionnel, Consommation.GAZ, 3.5);

        // Then
        assertEquals(expectedTotal, actual);
    }

    private static Stream<Arguments> caToTotalGaz() {
        return Stream.of(
                arguments(0.0, 0.3955),
                arguments(999999.0, 0.3955),
                arguments(1000000.0, 0.3955),
                arguments(1000001.0, 0.3885),
                arguments(2000000.0, 0.3885)
        );
    }

    @ParameterizedTest
    @MethodSource("caToTotalElectricite")
    void testClientTotalElectricite(double ca, double expectedTotal) {

        // Given
        Professionnel professionnel = Professionnel.builder()
                .refClient("EKW1")
                .raisonSociale("IKEA")
                .siret("35174572400200")
                .ca(ca)
                .build();

        // When
        double actual = particulierCalculator.calculate(professionnel, Consommation.ELECTRICITE, 3.5);

        // Then
        assertEquals(expectedTotal, expectedTotal);
    }

    private static Stream<Arguments> caToTotalElectricite() {
        return Stream.of(
                arguments(0.0, 0.413),
                arguments(999999.0, 0.413),
                arguments(1000000.0, 0.413),
                arguments(1000001.0, 0.399),
                arguments(2000000.0, 0.399)
        );
    }
}