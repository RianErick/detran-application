package com.project.detranapi.model;

import com.project.detranapi.model.Enum.CategoriaCNH;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "carteira_habilitacao")
public class CarteiraHabilitacao {

    @Id
    private Integer cnh;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria_cnh")
    private CategoriaCNH categoriaCNH;

    private Integer prontuario;

    @Column(name = "data_emicao")
    private LocalDate dataEmicao;

}
