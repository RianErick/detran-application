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

public class Motorista {

    @Id
    private String cpf;

    private String nome;

    private String rg;

    @Embedded
    private Endereco endereco;

    @JoinColumn(name = "numero_cnh")
    @OneToOne
    private CarteiraHabilitacao numero_cnh;

}
