package com.project.detranapi.representation;

import com.project.detranapi.model.Veiculo;
import lombok.Data;

@Data
public class VeiculoDTO {

    private String renavan;

    private String modelo;

    private String crlv;

    private String crv;

    private String cor;

    private String placa;

    public static VeiculoDTO converterParaDTo (Veiculo veiculo){

        VeiculoDTO veiculoDTO = new VeiculoDTO();

        veiculoDTO.setRenavan(veiculo.getRenavam());
        veiculoDTO.setPlaca(veiculo.getPlaca());
        veiculoDTO.setModelo(veiculo.getModelo());
        veiculoDTO.setCrlv(veiculo.getCrlv());
        veiculoDTO.setCrv(veiculo.getCrv());
        veiculoDTO.setCor(veiculo.getCor());

        return veiculoDTO;
    }


}
