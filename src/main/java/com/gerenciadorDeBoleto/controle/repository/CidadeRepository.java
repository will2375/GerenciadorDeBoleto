package com.gerenciadorDeBoleto.controle.repository;

import com.gerenciadorDeBoleto.controle.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
