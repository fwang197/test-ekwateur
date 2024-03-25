package com.ekwateur.test.models;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public abstract sealed class Client permits Professionnel, Particulier {

    private final String refClient;


}
