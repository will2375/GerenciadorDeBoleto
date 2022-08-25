package com.gerenciadorDeBoleto.controle.Controller;

import com.gerenciadorDeBoleto.controle.model.ExibirDadosBoleto;
import com.gerenciadorDeBoleto.controle.model.GerenciadorModel;
import com.gerenciadorDeBoleto.controle.model.controleStatus.BoletoPago;
import com.gerenciadorDeBoleto.controle.model.controleStatus.BoletoStatus;
import com.gerenciadorDeBoleto.controle.model.controleTipo.ControleTipo;
import com.gerenciadorDeBoleto.controle.service.GerenciadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class GerenciadorController {

    @Autowired
    GerenciadorService gerenciadorService;


    @GetMapping(path = "/contas")
    public ResponseEntity<List<ExibirDadosBoleto>> mostrarBoletos(){return ResponseEntity.ok(gerenciadorService.listaBoletos());}

    @GetMapping(path = "/contas/{id}")
    public Optional<GerenciadorModel> buscarId(@PathVariable Long id){ return gerenciadorService.buscarId(id);}

    @GetMapping(path = "/contas/status{status}")
    public List<GerenciadorModel> buscarstatus(@PathVariable String status){ return gerenciadorService.buscarStatus(status);}

    @PostMapping(path = "/contas")
    public ResponseEntity<GerenciadorModel> cadastrarConta(@RequestBody @Valid GerenciadorModel gerenciadorModel, BoletoStatus boletoStatus, ControleTipo controleTipo){
        GerenciadorModel contas=gerenciadorService.cadastrarBoleto(gerenciadorModel, boletoStatus, controleTipo);
        return new ResponseEntity<>(contas, HttpStatus.CREATED);
    }

    @PutMapping(path = "/contas/{id}")
    public ResponseEntity<GerenciadorModel> aletrarStatus(@PathVariable long id, @RequestBody GerenciadorModel gerenciadorModel, BoletoPago boletoPago) {
        return  ResponseEntity.ok(gerenciadorService.alterarStatus(id, gerenciadorModel, boletoPago));
    }

}
