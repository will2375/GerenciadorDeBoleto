package com.gerenciadorDeBoleto.controle;

import com.gerenciadorDeBoleto.controle.model.ContasReceber;
import com.gerenciadorDeBoleto.controle.model.calculoAluguel.AluguelAtrasado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class AluguelAtrasadoTeste {

    @Test
    void calculoAtrasoTeste(){
        ContasReceber contasReceber = new ContasReceber();
        contasReceber.setValorRecebimento(new BigDecimal("500"));

        BigDecimal atraso = contasReceber.getValorRecebimento().multiply(new BigDecimal("0.035"));
        BigDecimal atraso1 = contasReceber.getValorRecebimento().add(atraso);
        Assertions.assertEquals(new BigDecimal("517.500"), atraso1);
        }

        @Test
    void  calculoAtrasoTesteFactory(){
            ContasReceber contasReceber = new ContasReceber();
            contasReceber.setValorRecebimento(new BigDecimal("500"));

            AluguelAtrasado aluguelAtrasado = new AluguelAtrasado();
            BigDecimal atraso = aluguelAtrasado.calculoAluguel(contasReceber.getValorRecebimento());

            Assertions.assertEquals(new BigDecimal("517.500"), atraso);
        }
    }

