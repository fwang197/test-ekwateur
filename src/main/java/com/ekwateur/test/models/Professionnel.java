package com.ekwateur.test.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public final class Professionnel extends Client {

    private final String siret;
    private final String raisonSociale;
    private final double ca;

}