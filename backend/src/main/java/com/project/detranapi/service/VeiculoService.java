package com.project.detranapi.service;

import com.project.detranapi.model.Veiculo;
import org.springframework.http.ResponseEntity;

public interface VeiculoService {

  Veiculo salvarVeiculo(Veiculo data);
  Veiculo buscarVeiculoPeloRenavam(String renavam );

  ResponseEntity <Veiculo> editarVeiculo(String renavam , Veiculo veiculo);
  ResponseEntity<Void> deletarVeiculo(String renavam);

}
