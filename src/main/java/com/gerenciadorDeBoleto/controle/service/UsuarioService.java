package com.gerenciadorDeBoleto.controle.service;

import com.gerenciadorDeBoleto.controle.model.GerenciadorModel;
import com.gerenciadorDeBoleto.controle.model.Usuario;
import com.gerenciadorDeBoleto.controle.model.UsuarioDto;
import com.gerenciadorDeBoleto.controle.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<UsuarioDto>listaUsuarios() {
        List<Usuario> buscarTodos = usuarioRepository.findAll();
        return UsuarioDto.convert(buscarTodos);
    }
    public Optional<Usuario> buscarId(Long id){ return usuarioRepository.findById(id);}

    public Usuario cadastrar(Usuario usuario){
        usuario.getId();
        usuario.getNomeUsuario();
        usuario.getDataNascimento();
        usuario.getEmail();
        usuario.getCpf();
        return usuarioRepository.save(usuario);
    }
}
