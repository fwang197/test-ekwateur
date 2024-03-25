package com.ekwateur.test.mappers;

import com.ekwateur.test.dto.ParticulierDto;
import com.ekwateur.test.models.Particulier;
import org.springframework.stereotype.Component;

@Component
public class ParticulierMapper {

    public Particulier mapToParticulier(ParticulierDto particulierDto) {
        return Particulier.builder()
                .refClient(particulierDto.refClient()).build();
    }
}