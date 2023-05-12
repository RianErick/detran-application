package com.project.detranapi.model;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Motorista {

    @Id
    @CPF
    private String cpf;

    private String nome;

    private String rg;

    @Embedded
    private Endereco endereco;

    @JoinColumn(name = "numero_cnh")
    @OneToOne
    private CarteiraHabilitacao carteira ;

}
