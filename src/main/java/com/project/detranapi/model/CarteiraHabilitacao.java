package com.project.detranapi.model;

import com.project.detranapi.model.Enum.CategoriaCNH;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CarteiraHabilitacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer numeroCNH;

    private CategoriaCNH categoriaCNH;

    private Integer prontuario;

    private LocalDate data_emicao;

}
