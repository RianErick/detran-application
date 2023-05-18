package com.project.detranapi.model;


import com.project.detranapi.model.Enum.Grau;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;


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
