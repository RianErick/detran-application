package com.project.detranapi.model;


import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Veiculo {

    @Id
    @Column(name = "renavam" )
    @NotNull
    private String renavam;

    @NotEmpty(message = "Modelo is Empty" )
    private String modelo;

    private String crlv;

    private String crv;

    private String cor;

    private String placa;

    @JoinColumn(name = "cpf_motorista")
    @ManyToOne
    private Motorista cpfMotorista;



}
