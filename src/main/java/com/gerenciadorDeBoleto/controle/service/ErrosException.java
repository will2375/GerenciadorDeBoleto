package com.gerenciadorDeBoleto.controle.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrosException extends ResponseEntityExceptionHandler {

    @Autowired
    MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String menssagemUser = messageSource.getMessage("campo.invalido", null, null);
        String mesnsagemDev = ex.getCause().toString();
        return handleExceptionInternal(ex, new MensagemErro(menssagemUser, mesnsagemDev), headers, HttpStatus.BAD_REQUEST, request);
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public  static class MensagemErro{
        private String usuario;
        private String dev;
    }
}
