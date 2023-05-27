package com.project.detranapi.model;


import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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
    @NotBlank(message = "Campo Nome Nao Pode Ser Vazio")
    private String renavam;

    @NotBlank(message = "Campo Modelo Nao Pode Ser Vazio" )
    private String modelo;

    @NotBlank(message = "Campo Crlv Nao Pode Ser Vazio" )
    private String crlv;

    @NotBlank(message = "Campo Crv Nao Pode Ser Vazio" )
    private String crv;

    @NotBlank(message = "Campo Cor Nao Pode Ser Vazio" )
    private String cor;

    @NotBlank(message = "Campo Placa Nao Pode Ser Vazio" )
    private String placa;

    @JoinColumn(name = "cpf_motorista")
    @ManyToOne
    private Motorista cpfMotorista;



}
