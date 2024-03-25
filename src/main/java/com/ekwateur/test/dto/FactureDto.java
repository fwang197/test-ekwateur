package com.ekwateur.test.dto;

import com.ekwateur.test.enums.Consommation;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.List;

public record FactureDto(
        @NotNull String refClient,
        @NotNull double total) {
}
