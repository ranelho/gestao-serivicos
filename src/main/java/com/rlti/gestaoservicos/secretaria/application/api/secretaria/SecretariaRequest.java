package com.rlti.gestaoservicos.secretaria.application.api.secretaria;

import com.rlti.gestaoservicos.secretaria.domain.Setor;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Value
public class SecretariaRequest {
    @NotBlank
    @Size(min = 3, max = 255)
    private String secretaria;
    private String secretario;
}
