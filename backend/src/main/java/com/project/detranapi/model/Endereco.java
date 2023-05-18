package com.project.detranapi.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Embeddable
public class Endereco {


    @Column(name = "motorista_cep")
    private String cep;

    @Column(name = "motorista_logradouro")
    private String logradouro;

    @Column(name = "motorista_bairro")
    private String bairro;

    @Column(name = "motorista_complemento")
    private String complemento;

    @Column(name = "motorista_uf")
    private String uf;

    @Column(name = "motorista_localidade")
    private String localidade;

}
