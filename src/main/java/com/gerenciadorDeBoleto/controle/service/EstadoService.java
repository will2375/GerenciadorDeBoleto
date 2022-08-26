package com.gerenciadorDeBoleto.controle.service;

import com.gerenciadorDeBoleto.controle.model.Estado;
import com.gerenciadorDeBoleto.controle.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

    @Autowired
    EstadoRepository estadoRepository;

    public List<Estado>buscarTodos(){return estadoRepository.findAll();}

    public Optional<Estado>buscarPorId(Long id){return estadoRepository.findById(id);}

    public Estado cadastrar(Estado estado){
        estado.getId();
        estado.getUf();
        estado.getNomeEstado();
        return estadoRepository.save(estado);
    }
}
