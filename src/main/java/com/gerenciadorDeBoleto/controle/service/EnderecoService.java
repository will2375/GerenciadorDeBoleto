package com.gerenciadorDeBoleto.controle.service;

import com.gerenciadorDeBoleto.controle.model.Endereco;
import com.gerenciadorDeBoleto.controle.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    public List<Endereco>buscarTodos(){return enderecoRepository.findAll();}

    public Optional<Endereco>buscarPorId(Long id){return enderecoRepository.findById(id);}

    public Endereco cadastrar(Endereco endereco){
        endereco.getId();
        endereco.getLogradouro();
        endereco.getBairro();
        endereco.getCep();
        endereco.getPontoReferencia();
        return enderecoRepository.save(endereco);
    }
}
