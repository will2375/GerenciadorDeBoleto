package com.gerenciadorDeBoleto.controle.Controller;

import com.gerenciadorDeBoleto.controle.model.GerenciadorModel;
import com.gerenciadorDeBoleto.controle.model.controleStatus.BoletoPago;
import com.gerenciadorDeBoleto.controle.model.controleStatus.BoletoStatus;
import com.gerenciadorDeBoleto.controle.service.GerenciadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GerenciadorController {

    @Autowired
    GerenciadorService gerenciadorService;

    @GetMapping(path = "/contas")
    public ResponseEntity<List<GerenciadorModel>> buscarBoletos(){return ResponseEntity.ok(gerenciadorService.buscarBoletos());}

    @GetMapping(path = "/contas/{id}")
    public Optional<GerenciadorModel> buscarId(@PathVariable Long id){ return gerenciadorService.buscarId(id);}

    @PostMapping(path = "/contas")
    public ResponseEntity<GerenciadorModel> cadastrarConta(@RequestBody GerenciadorModel gerenciadorModel, BoletoStatus boletoStatus){
        GerenciadorModel contas=gerenciadorService.cadastrarBoleto(gerenciadorModel, boletoStatus);
        return new ResponseEntity<>(contas, HttpStatus.CREATED);
    }

    @PutMapping(path = "/contas/{id})")
    public ResponseEntity<GerenciadorModel> aletrarStatus(@RequestBody GerenciadorModel gerenciadorModel, BoletoPago boletoPago) {
        return ResponseEntity.ok(gerenciadorService.alterarStatus(gerenciadorModel, boletoPago));
    }

}
