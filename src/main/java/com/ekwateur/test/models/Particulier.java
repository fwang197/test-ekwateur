package com.ekwateur.test.models;

import com.ekwateur.test.enums.Civilite;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public final class Particulier extends Client {

    private final String nom;
    private final String prenom;
    private final Civilite civilite;

}
