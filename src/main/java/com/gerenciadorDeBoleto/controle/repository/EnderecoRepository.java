package com.gerenciadorDeBoleto.controle.repository;

import com.gerenciadorDeBoleto.controle.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
