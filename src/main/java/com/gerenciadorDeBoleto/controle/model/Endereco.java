package com.gerenciadorDeBoleto.controle.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table
public class Endereco implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column @NotNull @NotBlank
    private String logradouro;
    @Column @NotNull @NotBlank
    private String bairro;
    @Column @NotBlank @NotNull
    private String cep;
    @Column
    private String pontoReferencia;

    @ManyToOne
    @JoinColumn(name = "enderecos_id", referencedColumnName = "id")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Cidade cidade;
}
