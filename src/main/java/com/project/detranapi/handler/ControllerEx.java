package com.project.detranapi.handler;
import com.project.detranapi.handler.exception.MotoristaException;
import com.project.detranapi.handler.exception.VeiculoException;
import com.project.detranapi.handler.modelo.MotoristaEx;
import com.project.detranapi.handler.modelo.VeiculoEx;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


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

}
