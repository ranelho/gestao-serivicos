package com.rlti.gestaoservicos.ordemservico.application.repository.os;

import com.rlti.gestaoservicos.ordemservico.domain.OrdemServico;

import java.util.List;
import java.util.Optional;

public interface OrdemServicoRepository {
    OrdemServico salva(OrdemServico ordemServico);
    OrdemServico findOSById(Long idOrdemServico);
    Optional<OrdemServico> getOSByIdEquipamento(Long idEquipamento);
    List<OrdemServico> getAtendimentos();
    List<OrdemServico> getAllOS();
    void deleta(Long idOrdemServico);
}