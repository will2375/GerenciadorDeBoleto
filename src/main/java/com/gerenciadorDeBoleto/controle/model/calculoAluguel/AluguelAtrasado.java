package com.gerenciadorDeBoleto.controle.model.calculoAluguel;

import java.math.BigDecimal;

public class AluguelAtrasado implements CalculoAluguel{
    @Override
    public BigDecimal calculoAluguel(BigDecimal valor) {
        BigDecimal resultadoMulta = valor.multiply(new BigDecimal(3.5/100));
        return valor.add(resultadoMulta);
    }
}
