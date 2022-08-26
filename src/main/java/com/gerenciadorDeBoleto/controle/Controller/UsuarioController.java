package com.gerenciadorDeBoleto.controle.Controller;

import com.gerenciadorDeBoleto.controle.model.Usuario;
import com.gerenciadorDeBoleto.controle.model.UsuarioDto;
import com.gerenciadorDeBoleto.controle.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;
    @GetMapping(path = "/usuario")
    public List<UsuarioDto>mostrarTodos(){return usuarioService.listaUsuarios();}
    @GetMapping(path = "/usuario/{id}")
    public Optional<Usuario>buscarPorId(@PathVariable  Long id){ return usuarioService.buscarId(id);}
    @PostMapping(path = "/usuario")
    public Usuario cadastrarnovoUsuario(@RequestBody @Valid Usuario usuario){return usuarioService.cadastrar(usuario);}
}
