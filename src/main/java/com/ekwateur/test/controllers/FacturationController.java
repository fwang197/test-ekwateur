package com.ekwateur.test.controllers;


import com.ekwateur.test.calculator.CalculatorFactory;
import com.ekwateur.test.calculator.ParticulierCalculator;
import com.ekwateur.test.calculator.ProfessionnelCalculator;
import com.ekwateur.test.dto.FactureDto;
import com.ekwateur.test.dto.ParticulierDto;
import com.ekwateur.test.dto.ProfessionnelDto;
import com.ekwateur.test.enums.Consommation;
import com.ekwateur.test.enums.TypeClient;
import com.ekwateur.test.mappers.ParticulierMapper;
import com.ekwateur.test.mappers.ProfessionnelMapper;
import com.ekwateur.test.models.Client;
import com.ekwateur.test.models.Particulier;
import com.ekwateur.test.models.Professionnel;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@Slf4j
@AllArgsConstructor
@RequestMapping("/facture")
public class FacturationController {

    private final CalculatorFactory calculatorFactory;
    private final ParticulierMapper particulierMapper;
    private final ProfessionnelMapper professionnelMapper;

    @PostMapping("/particulier")
    public ResponseEntity postParticulier(@Valid @RequestBody ParticulierDto particulierDto) {
        Particulier particulier = particulierMapper.mapToParticulier(particulierDto);
        FactureDto facture = new FactureDto(particulier.getRefClient(), montantTotal(particulierDto.consommations(), particulier, particulierDto.kwh(), TypeClient.PART));
        return ResponseEntity.ok(facture);
    }

    @PostMapping("/professionnel")
    public ResponseEntity postProfessionnel(@Valid @RequestBody ProfessionnelDto professionnelDto) {
        Professionnel professionnel = professionnelMapper.mapToProfessionnel(professionnelDto);
        FactureDto facture = new FactureDto(professionnel.getRefClient(), montantTotal(professionnelDto.consommations(), professionnel, professionnelDto.kwh(), TypeClient.PRO));
        return ResponseEntity.ok(facture);
    }

    private double montantTotal(List<Consommation> consommations, Client client, double kwh, TypeClient typeClient) {
        String factoryId = switch (typeClient) {
            case PART -> ParticulierCalculator.BEAN_ID;
            case PRO -> ProfessionnelCalculator.BEAN_ID;
        };
        return consommations.stream()
                .mapToDouble(consommation -> calculatorFactory.getCalculator(factoryId).calculate(client, consommation, kwh))
                .sum();
    }
}
