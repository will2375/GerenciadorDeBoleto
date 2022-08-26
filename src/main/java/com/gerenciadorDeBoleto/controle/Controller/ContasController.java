package com.gerenciadorDeBoleto.controle.Controller;

import com.gerenciadorDeBoleto.controle.model.ContasReceber;
import com.gerenciadorDeBoleto.controle.model.GerenciadorModel;
import com.gerenciadorDeBoleto.controle.model.calculoAluguel.CalculoTipoRecebimento;
import com.gerenciadorDeBoleto.controle.model.controleStatus.ControleAlugueis;
import com.gerenciadorDeBoleto.controle.model.controleStatus.RecebimentoStatus;
import com.gerenciadorDeBoleto.controle.model.controleTipo.ControleRecebimento;
import com.gerenciadorDeBoleto.controle.service.ContasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class ContasController {

    @Autowired
    ContasService contasService;

    @GetMapping(path = "/contasReceber")
    public List<ContasReceber>buscarTodos(){return contasService.buscarTodos();}

    @GetMapping(path = "/contasReceber/{id}")
    public Optional<ContasReceber>buscarId(@PathVariable Long id){return contasService.buscarId(id);}

    @GetMapping(path = "/contasReceber/status/{status}")
    public List<ContasReceber> buscarPorStatus(@PathVariable String status){ return contasService.buscarStatus(status);}

    @GetMapping(path = "/contasReceber/tipo/{tipoRecebimento}")
    public List<ContasReceber> buscarPorTipoRecebimento(@PathVariable String tipoRecebimento){ return contasService.buscarTiporecebimento(tipoRecebimento);}

    @GetMapping(path = "/contasReceber/data/{dataDeVencimento}")
    public List<ContasReceber> buscarPordataDeVencimento(@PathVariable LocalDate dataDeVencimento){ return contasService.buscarDataDeVencimento(dataDeVencimento);}

    @PostMapping(path = "/contasReceber")
    public ContasReceber cadastrar(@RequestBody @Valid ContasReceber contasReceber, ControleRecebimento controleRecebimento, ControleAlugueis controleAlugueis, CalculoTipoRecebimento calculoTipoRecebimento)
    {return contasService.cadastrar(contasReceber, controleRecebimento, controleAlugueis, calculoTipoRecebimento);}

    @PutMapping(path = "/contasReceber/{id}")
    public ContasReceber alterar(@PathVariable Long id, @RequestBody ContasReceber contasReceber, RecebimentoStatus recebimentoStatus){return contasService.alterar(id, contasReceber, recebimentoStatus);}

    @DeleteMapping(path = "/contasReceber/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarConta(@PathVariable Long id) {contasService.deletar(id);}
}
