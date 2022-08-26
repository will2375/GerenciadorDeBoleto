package com.gerenciadorDeBoleto.controle.model.calculoAluguel;

import java.math.BigDecimal;

public interface CalculoAluguel {

    BigDecimal calculoAluguel(BigDecimal valor);
}
