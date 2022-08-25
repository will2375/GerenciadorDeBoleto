package com.gerenciadorDeBoleto.controle.service;

import com.gerenciadorDeBoleto.controle.model.GerenciadorModel;
import com.gerenciadorDeBoleto.controle.model.controleStatus.BoletoPago;
import com.gerenciadorDeBoleto.controle.model.controleStatus.BoletoStatus;
import com.gerenciadorDeBoleto.controle.model.controleTipo.ControleTipo;
import com.gerenciadorDeBoleto.controle.repository.GerenciadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class GerenciadorService {

    @Autowired
    private GerenciadorRepository gerenciadorRepository;

    public List<GerenciadorModel> buscarBoletos(){return gerenciadorRepository.findAll();}

    public Optional<GerenciadorModel> buscarId(Long id){ return gerenciadorRepository.findById(id);}


    public GerenciadorModel cadastrarBoleto(GerenciadorModel gerenciadorModel, BoletoStatus boletoStatus, ControleTipo controleTipo){
        Enum data = boletoStatus.decidirBoleto(gerenciadorModel.getDataDeVencimento());
        Enum tipo= controleTipo.decidirTipo(gerenciadorModel.getTipo());
        gerenciadorModel.getId();
        gerenciadorModel.getNome();
        gerenciadorModel.setStatus(String.valueOf(data));
        gerenciadorModel.getEscolherTipo();
        gerenciadorModel.setTipo(String.valueOf(tipo));
        gerenciadorModel.getDataDeVencimento();
        gerenciadorModel.getValor();
        gerenciadorModel.getDataDePagamento();
        return gerenciadorRepository.save(gerenciadorModel);
    }
    public GerenciadorModel alterarStatus(Long id, GerenciadorModel gerenciadorModel, BoletoPago boletoPago){
        LocalDateTime pagamento = boletoPago.pagarBoleto(gerenciadorModel.getStatus());
        gerenciadorModel.getId();
        gerenciadorModel.getNome();
        gerenciadorModel.getStatus();
        gerenciadorModel.getTipo();
        gerenciadorModel.getDataDeVencimento();
        gerenciadorModel.getValor();
        gerenciadorModel.setDataDePagamento(pagamento);
        return gerenciadorRepository.save(gerenciadorModel);
    }
}
