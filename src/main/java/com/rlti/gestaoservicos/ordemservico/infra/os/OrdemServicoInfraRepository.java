package com.rlti.gestaoservicos.ordemservico.infra.os;

import com.rlti.gestaoservicos.handler.APIException;
import com.rlti.gestaoservicos.ordemservico.application.repository.os.OrdemServicoRepository;
import com.rlti.gestaoservicos.ordemservico.domain.OrdemServico;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Log4j2
@RequiredArgsConstructor
public class OrdemServicoInfraRepository implements OrdemServicoRepository {
    private final OrdemServicoSpringaDataJPARespository ordemServicoSpringaDataJPARespository;
    @Override
    public OrdemServico salva(OrdemServico ordemServico) {
        log.info("[inicia] OrdemServicoInfraRepository - salva");
        ordemServicoSpringaDataJPARespository.save(ordemServico);
        log.info("[finaliza] OrdemServicoInfraRepository - salva");
        return ordemServico;
    }

    @Override
    public OrdemServico findOSById(Long idOrdemServico) {
        log.info("[inicia] OrdemServicoInfraRepository - buscaOSPorId");
        Optional<OrdemServico> optionalOrdemServico = ordemServicoSpringaDataJPARespository.findById(idOrdemServico);
        OrdemServico ordemServico = optionalOrdemServico
                .orElseThrow(() ->  {
                            throw APIException.build(HttpStatus.NOT_FOUND, "Ordem de Serviço não encontrada");
                        }
                );
        log.info("[finzalia] OrdemServicoInfraRepository - buscaOSPorId");
        return ordemServico;
    }

    @Override
    public OrdemServico getOSByIdEquipmento(Long idEquipamento) {
        log.info("[inicia] OrdemServicoInfraRepository - buscaOSPorId");
        OrdemServico ordemServico = ordemServicoSpringaDataJPARespository.findByIdEquipamento(idEquipamento);
        log.info("[finzalia] OrdemServicoInfraRepository - buscaOSPorId");
        return ordemServico;
    }

    @Override
    public List<OrdemServico> getTodosOS() {
        log.info("[inicia] OrdemServicoInfraRepository - getTodosOS");
        List<OrdemServico> listOrdemServico = ordemServicoSpringaDataJPARespository.findAll();
        log.info("[inicia] OrdemServicoInfraRepository - getTodosOS");
        return listOrdemServico;
    }

    @Override
    public void deleta(Long idOrdemServico) {
        log.info("[inicia] OrdemServicoInfraRepository - deleta");
        ordemServicoSpringaDataJPARespository.deleteById(idOrdemServico);
        log.info("[finaliza] OrdemServicoInfraRepository - deleta");
    }

    @Override
    public List<OrdemServico> getAtendimentos() {
        log.info("[inicia] OrdemServicoInfraRepository - getAtendimentos");
        List<OrdemServico> listOrdemServico = ordemServicoSpringaDataJPARespository.findAllAtendimentos();
        log.info("[inicia] OrdemServicoInfraRepository - getAtendimentos");
        return listOrdemServico;
    }
}