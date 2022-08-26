package com.gerenciadorDeBoleto.controle.service;

import com.gerenciadorDeBoleto.controle.model.Cidade;
import com.gerenciadorDeBoleto.controle.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    @Autowired
    CidadeRepository cidadeRepository;


    public List<Cidade>buscarTodos(){return cidadeRepository.findAll();}

    public Optional<Cidade>buscarPorId(Long id){return cidadeRepository.findById(id);}

    public Cidade cadastrar(Cidade cidade){
        cidade.getId();
        cidade.getNomeCidade();
        return cidadeRepository.save(cidade);
    }
}
