package com.gerenciadorDeBoleto.controle.repository;

import com.gerenciadorDeBoleto.controle.model.GerenciadorModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GerenciadorRepository extends JpaRepository<GerenciadorModel, Long> {



}
