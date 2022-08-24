package com.gerenciadorDeBoleto.controle.service;

import com.gerenciadorDeBoleto.controle.model.GerenciadorModel;
import com.gerenciadorDeBoleto.controle.model.controleStatus.BoletoPago;
import com.gerenciadorDeBoleto.controle.model.controleStatus.BoletoStatus;
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


    public GerenciadorModel cadastrarBoleto(GerenciadorModel gerenciadorModel, BoletoStatus boletoStatus){
        String data = boletoStatus.decidirBoleto(gerenciadorModel.getDataDeVencimento());
        gerenciadorModel.getId();
        gerenciadorModel.getNome();
        gerenciadorModel.setStatus(String.valueOf(data));
        gerenciadorModel.getTipo();
        gerenciadorModel.getDataDeVencimento();
        gerenciadorModel.getValor();
        gerenciadorModel.setDataDePagamento(null);
        return gerenciadorRepository.save(gerenciadorModel);
    }
    public GerenciadorModel alterarStatus(GerenciadorModel gerenciadorModel, BoletoPago boletoPago){
        LocalDateTime pagamento = boletoPago.pagarBoleto(gerenciadorModel.getStatus());
        gerenciadorModel.getId();
        gerenciadorModel.getStatus();
        gerenciadorModel.setDataDePagamento(pagamento);
        return gerenciadorRepository.save(gerenciadorModel);
    }
}
