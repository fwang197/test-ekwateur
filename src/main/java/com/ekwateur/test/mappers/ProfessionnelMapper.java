package com.ekwateur.test.mappers;

import com.ekwateur.test.dto.ParticulierDto;
import com.ekwateur.test.dto.ProfessionnelDto;
import com.ekwateur.test.enums.Consommation;
import com.ekwateur.test.models.Particulier;
import com.ekwateur.test.models.Professionnel;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProfessionnelMapper {

    public Professionnel mapToProfessionnel(ProfessionnelDto professionnelDto) {
        return Professionnel.builder()
                .refClient(professionnelDto.refClient())
                .ca(professionnelDto.ca()).build();
    }
}