package com.gerenciadorDeBoleto.controle.model.controleStatus;

import com.gerenciadorDeBoleto.controle.model.enuns.RecebimentosAlugueis;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

public class ControleAlugueis {

    public RecebimentosAlugueis status( LocalDate vencimento){
        LocalDate hoje = LocalDate.now();
        if (hoje.isBefore(vencimento)){
            return RecebimentosAlugueis.ADIANTADO;
        } else if (hoje.isAfter(vencimento)) {
            return RecebimentosAlugueis.EM_ATRASO;
        }else {
            return RecebimentosAlugueis.EM_DIA;
        }
    }
}
