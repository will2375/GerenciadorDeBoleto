package com.gerenciadorDeBoleto.controle.Controller;

import com.gerenciadorDeBoleto.controle.model.Estado;
import com.gerenciadorDeBoleto.controle.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class EstadoController {

    @Autowired
    EstadoService estadoService;

    @GetMapping(path = "/estados")
    public List<Estado> mostrarTodos() {
        return estadoService.buscarTodos();
    }

    @GetMapping(path = "/estados/{id}")
    public Optional<Estado> mostrarPorId(@PathVariable Long id) {
        return estadoService.buscarPorId(id);
    }

    @PostMapping(path = "/estados")
    public Estado cadastrarEstado(@RequestBody @Valid Estado estado) {
        return estadoService.cadastrar(estado);
    }
}
