package com.project.detranapi.service;

import com.project.detranapi.model.Veiculo;

public interface VeiculoService {

  Veiculo salvarVeiculo(Veiculo data);
  Veiculo buscarVeiculoPeloRenavam(String renavam);

}
