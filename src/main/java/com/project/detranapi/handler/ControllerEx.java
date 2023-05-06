package com.project.detranapi.handler;
import com.project.detranapi.handler.exception.VeiculoException;
import com.project.detranapi.handler.modelo.VeiculoEx;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ControllerEx {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(VeiculoException.class)
    public VeiculoEx Ex(VeiculoException ex) {

        String mensagemErro = ex.getMessage();

        return new VeiculoEx(mensagemErro);
    }

}
