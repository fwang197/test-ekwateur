package com.ekwateur.test.dto;

import com.ekwateur.test.enums.Consommation;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.List;

public record ParticulierDto(
        @NotNull @Pattern(regexp = "^EKW(\\d){8}$") String refClient,
        @NotNull List<Consommation> consommations,
        @NotNull Double kwh) {
}
