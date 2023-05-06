package com.project.detranapi.handler.modelo;

import lombok.Getter;


import java.util.Arrays;
import java.util.List;


public class VeiculoEx {

    @Getter
    public List<String> erro;

    public VeiculoEx(String menssagemErro) {

        this.erro = Arrays.asList(menssagemErro);

    }
}
