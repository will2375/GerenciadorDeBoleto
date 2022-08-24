package com.gerenciadorDeBoleto.controle.model.controleStatus;

import java.time.LocalDateTime;

public class BoletoPago {
    public LocalDateTime pagarBoleto(String status ) {
        if (status.equalsIgnoreCase("PAGO")) {
            return LocalDateTime.now();
        } else {
            return null;
        }
    }
}