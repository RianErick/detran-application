package com.project.detranapi.representation;

import com.project.detranapi.model.CarteiraHabilitacao;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CarteiraDTO {

    private Integer pontuario ;

    public  CarteiraDTO atualizarProntuario(CarteiraHabilitacao carteiraHabilitacao){

         CarteiraDTO carteiraDTO = new CarteiraDTO();

         carteiraDTO.pontuario = carteiraHabilitacao.getProntuario();

         return carteiraDTO;

    }

}
