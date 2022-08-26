package com.gerenciadorDeBoleto.controle.model.calculoAluguel;

public class CalculoTipoRecebimento {

    public CalculoAluguel valorFinal(String aluguel, String recebimento) {
        if (aluguel.equalsIgnoreCase("ALUGUEIS")) {
            if (recebimento.equalsIgnoreCase("ADIANTADO")) {
                return new AluguelAdiantado();
            } else if (recebimento.equalsIgnoreCase("EM_ATRASO")) {
                {
                    return new AluguelAtrasado();
                }
            } else if (recebimento.equalsIgnoreCase("EM_DIA")) {
                return new AluguelEmDia();
            }

        }else {
            return new AluguelEmDia();
        }
        return null;
    }
}
