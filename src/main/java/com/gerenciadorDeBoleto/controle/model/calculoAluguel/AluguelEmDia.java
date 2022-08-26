package com.gerenciadorDeBoleto.controle.model.calculoAluguel;

import java.math.BigDecimal;

public class AluguelEmDia implements CalculoAluguel{
    @Override
    public BigDecimal calculoAluguel(BigDecimal valor) {
        return valor;
    }
}
