package com.project.detranapi.representation;

import com.project.detranapi.model.Endereco;
import com.project.detranapi.model.Motorista;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class MotoristaDTO {

    private String cpf;

    private String nome;

    private String rg;

    private Endereco endereco;

    public MotoristaDTO (Motorista motorista){

        this.cpf = motorista.getCpf();
        this.nome = motorista.getNome();
        this.rg = motorista.getRg();

        this.endereco.setComplemento(endereco.getComplemento());
        this.endereco.setBairro(endereco.getBairro());
        this.endereco.setLocalidade(endereco.getLocalidade());
        this.endereco.setLogradouro(endereco.getLogradouro());
        this.endereco.setUf(endereco.getUf());

    }

    public List<MotoristaDTO> converterListaParaDTO(List<Motorista> motoristas){

        return motoristas
                .stream()
                .map(MotoristaDTO::new)
                .collect(Collectors.toList());
    }


}
