package com.project.detranapi.model;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Motorista {

    @Id
    @CPF
    @NotBlank(message = "Campo Cpf Nao Pode Ser Vazio")
    private String cpf;

    @NotBlank(message = "Campo Nome Nao Pode Ser Vazio")
    private String nome;

    @NotBlank(message = "Campo Rg Nao Pode Ser Vazio")
    private String rg;

    @Embedded
    private Endereco endereco;

    @JoinColumn(name = "numero_cnh")
    @OneToOne
    private CarteiraHabilitacao carteira ;

}
