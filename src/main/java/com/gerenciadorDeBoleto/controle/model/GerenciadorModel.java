package com.gerenciadorDeBoleto.controle.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "controle_boleto")
public class GerenciadorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String nome;
    @Column(length = 50)
    private String status;
    @Column(length = 50)
    private String tipo;
    @Column(length = 50)
    private double valor;
    @Column(length = 50)
    private LocalDate dataDeVencimento;
    @Column(length = 50)
    private LocalDateTime dataDePagamento;
    }
