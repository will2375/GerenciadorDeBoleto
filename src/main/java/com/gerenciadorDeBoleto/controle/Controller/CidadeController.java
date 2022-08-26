package com.gerenciadorDeBoleto.controle.Controller;

import com.gerenciadorDeBoleto.controle.model.Cidade;
import com.gerenciadorDeBoleto.controle.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class CidadeController {

    @Autowired
    CidadeService cidadeService;

    @GetMapping(path = "/cidades")
    public List<Cidade> buscarTodos() {
        return cidadeService.buscarTodos();
    }

    @GetMapping(path = "/cidades/{id}")
    public Optional<Cidade> buscarId(@PathVariable Long id) {
        return cidadeService.buscarPorId(id);
    }

    @PostMapping(path = "/cidades")
    public Cidade cadastrarCidade(@RequestBody @Valid Cidade cidade) {
        return cidadeService.cadastrar(cidade);
    }
}
