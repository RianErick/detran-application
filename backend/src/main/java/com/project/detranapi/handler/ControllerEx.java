package com.project.detranapi.handler;
import com.project.detranapi.handler.exception.MotoristaException;
import com.project.detranapi.handler.exception.VeiculoException;
import com.project.detranapi.handler.modelo.MotoristaEx;
import com.project.detranapi.handler.modelo.VeiculoEx;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class ControllerEx {


    @ExceptionHandler(VeiculoException.class)
    public VeiculoEx Ex(VeiculoException ex) {

        String mensagemErro = ex.getMessage();

        return new VeiculoEx(mensagemErro);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MotoristaException.class)
    public MotoristaEx Ex (MotoristaException ex){

        String erro = ex.getMessage();

        return new MotoristaEx(erro);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult()
                .getAllErrors()
                .forEach((error) -> {

            String fieldName = ((FieldError) error).getField();

            String errorMessage = error.getDefaultMessage();

            errors.put(fieldName, errorMessage);

        });

        return errors;
    }

}
