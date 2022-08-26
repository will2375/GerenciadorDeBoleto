package com.gerenciadorDeBoleto.controle.model.controleTipo;

import com.gerenciadorDeBoleto.controle.model.enuns.TipoRecebimento;

public class ControleRecebimento {

    public TipoRecebimento recebimento(String tipo){
        if (tipo.equalsIgnoreCase("alugueis")){
            return TipoRecebimento.ALUGUEIS;
        } else if (tipo.equalsIgnoreCase("emprego_clt")) {
            return TipoRecebimento.EMPREGO_CLT;
        } else if (tipo.equalsIgnoreCase("freelancer")) {
            return TipoRecebimento.FREELANCER;
        }else {
            return TipoRecebimento.valueOf("OUTROS");
        }
    }
}
