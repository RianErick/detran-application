package com.project.detranapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;

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

    @JoinColumn(name = "carteira_habilitacao")
    @OneToOne
    private CarteiraHabilitacao id_carteiraHabilitacao;

}
