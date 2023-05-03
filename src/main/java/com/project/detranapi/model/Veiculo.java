package com.project.detranapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Veiculo {

    @Id
    private String renavan;

    private String modelo;

    private String crlv;

    private String crv;

    private String cor;

    private String placa;

    @OneToOne
    private Motorista cpf_motorista;


}
