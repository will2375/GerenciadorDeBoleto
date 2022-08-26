package com.gerenciadorDeBoleto.controle.repository;

import com.gerenciadorDeBoleto.controle.model.ContasReceber;
import com.gerenciadorDeBoleto.controle.model.GerenciadorModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ContasRepository extends JpaRepository<ContasReceber, Long> {

    List<ContasReceber> findByStatus (String status);

    List<ContasReceber> findByTipoRecebimento (String tipoRecebimento);

    List<ContasReceber> findByDataDeVencimento (LocalDate dataDeVencimento);
}
