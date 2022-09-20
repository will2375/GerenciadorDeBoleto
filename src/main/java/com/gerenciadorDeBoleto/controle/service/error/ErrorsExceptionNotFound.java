package com.gerenciadorDeBoleto.controle.service.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErrorsExceptionNotFound {

    @Autowired
    MessageSource messageSource;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    List<ErrosExceptionBadRequest.MensagemErro> handle(MethodArgumentNotValidException exception) {

        List<ErrosExceptionBadRequest.MensagemErro> erros = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        fieldErrors.forEach(e -> {
            String msg = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ErrosExceptionBadRequest.MensagemErro erro = new ErrosExceptionBadRequest.MensagemErro(e.getField(), msg);
            erros.add(erro);
        });
        return erros;
    }



    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MensagemErro {
        private String campo;
        private String erro;
    }
}
