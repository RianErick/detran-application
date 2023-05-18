package com.project.detranapi.representation;

import com.project.detranapi.model.Veiculo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class VeiculoDTO {

    private String renavan;

    private String modelo;

    private String crlv;

    private String crv;

    private String cor;

    private String placa;

    public VeiculoDTO (Veiculo veiculo){

        this.renavan = veiculo.getRenavam();
        this.cor = veiculo.getCor();
        this.crv = veiculo.getCrv();
        this.placa = veiculo.getPlaca();
        this.crlv = veiculo.getCrlv();
        this.modelo = veiculo.getModelo();


    }

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

    public static List<VeiculoDTO> converterListaDTo (List <Veiculo> veiculos){
               return veiculos.stream()
                       .map(VeiculoDTO::new)
                       .collect(Collectors.toList());
    }


}
