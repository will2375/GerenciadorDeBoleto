package com.gerenciadorDeBoleto.controle.model.controleStatus;

import java.time.LocalDate;

public class BoletoStatus {
    public String decidirBoleto(LocalDate dataValidade) {
        LocalDate dataHoje = LocalDate.now();
        if (dataValidade.isBefore(dataHoje)){
            return "atrasado";
        } else if (dataValidade.isAfter(dataHoje)) {
            return "aguaradando";
        }
        return null;
    }
}
