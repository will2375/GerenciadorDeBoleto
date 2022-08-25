package com.gerenciadorDeBoleto.controle.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExibirDadosBoleto {

    private Long id;
    private String nome;
    private double valor;
    private String status;


    public ExibirDadosBoleto( GerenciadorModel gerenciadorModel) {
        this.id = gerenciadorModel.getId();
        this.nome = gerenciadorModel.getNome();
        this.valor = gerenciadorModel.getValor();
        this.status = gerenciadorModel.getStatus();
    }

    public  static List <ExibirDadosBoleto> convert(List<GerenciadorModel> gerenciadorModel){
        return gerenciadorModel.stream().map(ExibirDadosBoleto::new).collect(Collectors.toList());
    }

}
