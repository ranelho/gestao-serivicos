package com.rlti.gestaoservicos.ordemservico.application.api.os;

import com.rlti.gestaoservicos.ordemservico.domain.OrdemServico;
import com.rlti.gestaoservicos.ordemservico.domain.Servico;
import com.rlti.gestaoservicos.ordemservico.domain.Situacao;
import com.rlti.gestaoservicos.suporte.application.api.SuporteResponse;
import lombok.Value;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static com.rlti.gestaoservicos.suporte.application.api.SuporteResponse.converte;

@Value
public class OrdemServicoResponse {
    private UUID protocolo;
    private String patrimonio;
    private String setor;
    private List<SuporteResponse> suportes;
    private String descricaoProblema;
    private String observacao;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private String diagnostico;
    private Situacao situacao;
    private List<Servico> servicos;

    public OrdemServicoResponse(OrdemServico ordemServico) {
        this.protocolo = ordemServico.getIdOrdemServico();
        this.patrimonio = (ordemServico.getEquipamento() == null) ? "Os Externa" :
                ordemServico.getEquipamento().getPatrimonio();
        this.setor = (ordemServico.getEquipamento() == null) ? ordemServico.getSetor().getSetor() :
                ordemServico.getEquipamento().getSetor().getSetor();
        this.suportes = converte(ordemServico.getSuportes());
        this.descricaoProblema = ordemServico.getDescricaoProblema();
        this.observacao = ordemServico.getObservacao();
        this.dataFinal = ordemServico.getDataFinal();
        this.situacao = ordemServico.getSituacao();
        this.diagnostico = ordemServico.getDiagnostico();
        this.servicos = ordemServico.getServicos();
        this.dataInicial = ordemServico.getDataInicial();
    }

}
