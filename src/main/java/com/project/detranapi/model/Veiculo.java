package com.project.detranapi.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Veiculo {

    @Id
    @Column(name = "renavam")
    private String renavam;

    @NotBlank(message = "Modelo is Empty" )
    private String modelo;

    private String crlv;

    private String crv;

    private String cor;

    private String placa;

    @Transient //ignorar
    @OneToOne
    private Motorista cpf_motorista;

}
