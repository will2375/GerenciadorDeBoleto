package com.gerenciadorDeBoleto.controle.service;

import com.gerenciadorDeBoleto.controle.model.ContasReceber;
import com.gerenciadorDeBoleto.controle.model.controleStatus.ControleAlugueis;
import com.gerenciadorDeBoleto.controle.model.calculoAluguel.CalculoTipoRecebimento;
import com.gerenciadorDeBoleto.controle.model.controleStatus.RecebimentoStatus;
import com.gerenciadorDeBoleto.controle.model.controleTipo.ControleRecebimento;
import com.gerenciadorDeBoleto.controle.repository.ContasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ContasService {

    @Autowired
    ContasRepository contasRepository;

    public List<ContasReceber> buscarTodos() {
        return contasRepository.findAll();
    }

    public Optional<ContasReceber> buscarId(Long id) {
        return contasRepository.findById(id);
    }

    public List<ContasReceber> buscarStatus(String status){return contasRepository.findByStatus(status);}

    public List<ContasReceber> buscarTiporecebimento(String tipoRecebimento){return contasRepository.findByTipoRecebimento(tipoRecebimento);}

    public List<ContasReceber>buscarDataDeVencimento(LocalDate dataDeVencimento){return contasRepository.findByDataDeVencimento(dataDeVencimento);}

    public ContasReceber cadastrar(ContasReceber contasReceber, ControleRecebimento controleRecebimento, ControleAlugueis controleAlugueis, CalculoTipoRecebimento calculoTipoRecebimento){
        Enum tipo = controleRecebimento.recebimento(contasReceber.getTipoRecebimento());
        String vencimento = String.valueOf(controleAlugueis.status(contasReceber.getDataDeVencimento()));
        BigDecimal resultado = (BigDecimal) calculoTipoRecebimento.valorFinal(String.valueOf(tipo), vencimento).calculoAluguel(contasReceber.getValorRecebimento());
        contasReceber.getId();
        contasReceber.getRecebimento();
        contasReceber.setValorRecebimento(resultado);
        contasReceber.setTipoRecebimento(String.valueOf(tipo));
        contasReceber.getDataDeVencimento();
        contasReceber.setRecebimentoAlugueis(vencimento);
        contasReceber.setDataDeRecebimento(null);
        contasReceber.setStatus("pendente");
        return contasRepository.save(contasReceber);
    }

    public ContasReceber alterar(Long id, ContasReceber contasReceber, RecebimentoStatus recebimentoStatus){
        LocalDateTime pagamento = recebimentoStatus.alugueis(contasReceber.getStatus());
        contasReceber.getId();
        contasReceber.getRecebimento();
        contasReceber.getValorRecebimento();
        contasReceber.getTipoRecebimento();
        contasReceber.getDataDeVencimento();
        contasReceber.getRecebimentoAlugueis();
        contasReceber.setDataDeRecebimento(pagamento);
        contasReceber.getStatus();
        return contasRepository.save(contasReceber);
    }

    public void deletar(Long id) {
        contasRepository.deleteById(id);
    }
}