package com.project.detranapi.representation;

import com.project.detranapi.model.Enum.Grau;
import com.project.detranapi.model.Multa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MultaDTO {

    private Long id;

    private BigDecimal valor;

    private String motivo;

    private LocalDate dataVencimento;

    private Grau grau;

    private Integer pontosRemovidos;

    public MultaDTO(Multa multa) {

     this.id = multa.getId();
     this.grau = multa.getGrau();
     this.dataVencimento = multa.getDataVencimento();
     this.pontosRemovidos = multa.getPontosRemovidos();
     this.motivo = multa.getMotivo();
     this.valor = multa.getValor();
    }


    public MultaDTO converterMulta (Multa multa){

     MultaDTO multaDto = new MultaDTO();

        multaDto.setGrau(multa.getGrau());
        multaDto.setMotivo(multa.getMotivo());
        multaDto.setDataVencimento(multa.getDataVencimento());
        multaDto.setPontosRemovidos(multa.getPontosRemovidos());
        multaDto.setId(multa.getId());
        multaDto.setValor(multa.getValor());

        return multaDto;
    }


    public List<MultaDTO> converterLista(List<Multa> multas){
         return multas.stream().map(MultaDTO::new).
                 collect(Collectors.toList());
    }
}
