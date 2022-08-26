package com.gerenciadorDeBoleto.controle.model.calculoAluguel;

import java.math.BigDecimal;

public class AluguelAdiantado implements CalculoAluguel{
    @Override
    public BigDecimal calculoAluguel(BigDecimal valor) {
        BigDecimal resultadoDesconto = valor.multiply(new BigDecimal(0.5/100));
        return valor.subtract(resultadoDesconto);
    }
}
