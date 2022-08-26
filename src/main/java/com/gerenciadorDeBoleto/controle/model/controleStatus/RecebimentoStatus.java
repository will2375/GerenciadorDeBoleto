package com.gerenciadorDeBoleto.controle.model.controleStatus;

import java.time.LocalDateTime;

public class RecebimentoStatus {

    public LocalDateTime alugueis(String status){
        if (status.equalsIgnoreCase("PAGO")){
            return LocalDateTime.now();
        }else {
            return null;
        }
    }
}
