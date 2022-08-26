package com.gerenciadorDeBoleto.controle.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {

    private Long id;
    private String nomeUsuario;
    private LocalDate dataNascimento;
    private String email;

    public UsuarioDto(Usuario usuario){
        this.id = usuario.getId();
        this.nomeUsuario = usuario.getNomeUsuario();
        this.dataNascimento = usuario.getDataNascimento();
        this.email = usuario.getEmail();
    }

    public static List<UsuarioDto> convert(List<Usuario> usuarios){
        return usuarios.stream().map(UsuarioDto::new).collect(Collectors.toList());
    }
}
