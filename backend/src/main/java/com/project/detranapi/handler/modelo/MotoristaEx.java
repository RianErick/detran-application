package com.project.detranapi.handler.modelo;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class MotoristaEx {
    @Getter
    public List<String> erro ;

    public MotoristaEx (String mensagem){
        this.erro = Arrays.asList(mensagem);
    }

}
