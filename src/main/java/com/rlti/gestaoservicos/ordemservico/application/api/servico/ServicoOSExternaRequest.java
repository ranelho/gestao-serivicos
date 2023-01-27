package com.rlti.gestaoservicos.ordemservico.application.api.servico;

import com.rlti.gestaoservicos.ordemservicoexterna.domain.OrdemServicoExterna;
import lombok.Value;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Value
public class ServicoOSExternaRequest {
    private OrdemServicoExterna ordemServicoExterna;
    @NotNull
    private LocalDate dataServico;
    @NotNull
    @Size(message = "Campo serviço não pode estar vazio", min = 3, max = 255)
    private String descricaoServico;
}
