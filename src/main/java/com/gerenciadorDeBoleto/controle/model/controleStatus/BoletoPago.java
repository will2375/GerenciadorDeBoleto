package com.gerenciadorDeBoleto.controle.model.controleStatus;

import com.gerenciadorDeBoleto.controle.model.enuns.EnumStatus;

import java.time.LocalDateTime;

public class BoletoPago {
    public LocalDateTime pagarBoleto(String status ) {
        if (status.equalsIgnoreCase(String.valueOf(EnumStatus.PAGO))) {
            return LocalDateTime.now();
        } else {
            return null;
        }
    }
}