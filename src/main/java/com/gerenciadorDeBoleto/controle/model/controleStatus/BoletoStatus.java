package com.gerenciadorDeBoleto.controle.model.controleStatus;

import com.gerenciadorDeBoleto.controle.model.enuns.EnumStatus;

import java.time.LocalDate;

public class BoletoStatus {
    public EnumStatus decidirBoleto(LocalDate dataValidade) {
        LocalDate dataHoje = LocalDate.now();
        if (dataValidade.isBefore(dataHoje)){
            return EnumStatus.ATRASADO;
        } else if (dataValidade.isAfter(dataHoje)) {
            return EnumStatus.AGUARDANDO;
        }
        return null;
    }
}
