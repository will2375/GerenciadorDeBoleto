package com.gerenciadorDeBoleto.controle.Controller;

import com.gerenciadorDeBoleto.controle.model.Endereco;
import com.gerenciadorDeBoleto.controle.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class EnderecoController {

    @Autowired
    EnderecoService enderecoService;

    @GetMapping(path = "/enderecos")
    public List<Endereco> buscarTodos() {
        return enderecoService.buscarTodos();
    }

    @GetMapping(path = "/enderecos/{id}")
    public Optional<Endereco> buscarPorId(@PathVariable Long id) {
        return enderecoService.buscarPorId(id);
    }

    @PostMapping(path = "/enderecos")
    public Endereco cadastrarEndereco(@RequestBody @Valid Endereco endereco) {
        return enderecoService.cadastrar(endereco);
    }
}
