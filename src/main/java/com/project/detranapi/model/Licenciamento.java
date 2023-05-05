package com.project.detranapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Licenciamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valor;

    @Column(name = "data_vencimento_licenciamento")
    private LocalDate data;

    @JoinColumn(name = "renavem_veiculo")
    @OneToOne
    private Veiculo renavamVeiculo;

}
