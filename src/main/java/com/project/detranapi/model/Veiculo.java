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
    @Column(name = "renavam")
    private String renavam;

    private String modelo;

    private String crlv;

    private String crv;

    private String cor;

    private String placa;

    @Transient //ignorar
    @OneToOne
    private Motorista cpf_motorista;

}
