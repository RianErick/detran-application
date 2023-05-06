package com.project.detranapi.model;

import com.project.detranapi.model.Enum.Grau;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Multa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valor;

    private String motivo;

    @Column(name = "data_vencimento_multa")
    private LocalDate dataVencimento;

    @Enumerated(EnumType.STRING)
    private Grau grau;

    @JoinColumn(name = "renavam_multa")
    @ManyToOne
    private Veiculo renavamVeiculo;


}
